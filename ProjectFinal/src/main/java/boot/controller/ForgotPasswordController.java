package boot.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import boot.dto.Utility;
import boot.entity.User;
import boot.service.UserService;
import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/forgot_password")
	public String showForgotPasswordForm() {
		return "forgot_password_form";
	}
	
	@PostMapping("/forgot_password")
	public String proccessForgotPassword(HttpServletRequest request, Model model)  throws UnsupportedEncodingException,MessagingException{
		String email = request.getParameter("email");
		String token = RandomString.make(30);
		
		try {
			userService.updateResetPasswordToken(token, email);
			String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
			sendMail(email,resetPasswordLink);
			model.addAttribute("message", "Chúng tôi đã gửi cho bạn đường link để đổi mật khẩu ở email của bạn. Vui lòng mở mail để kiểm tra.");
		}catch(Exception ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "forgot_password_form";
	}
	
	public void sendMail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException  {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("tranquagminh1720@gmail.com","Cửa hàng mỹ phẩm");
		helper.setTo(recipientEmail);
		
		String subject = "Đây là đường link để đổi mật khẩu";
		
		String context = "<p>Xin chào,</p>"
				+ "<p>Bạn có yêu cầu được thay đổi mật khẩu.</p>"
				+ "<p>Hãy nhấn vào đường link bên dưới:</p>"
				+ "<p><a href=\"" + link + "\">Thay đổi mật khẩu</a></p>"
				+ "<br>"
				+ "<p>Vui lòng bỏ qua email này nếu bạn nhớ được mật khẩu, "
				+ "hoặc bạn không gửi yêu cầu đổi mật khẩu.</p>";
		helper.setSubject(subject);
		
		helper.setText(context,true);
		
		mailSender.send(message);
	}
	
	@GetMapping("/reset_password")
	public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
		User user = userService.getByResetPasswordToken(token);
		model.addAttribute("token", token);
		
		if(user == null) {
			model.addAttribute("message", "Invalid Token");
			return "message";
		}
		return "reset_password_form";
	}
	
	@PostMapping("/reset_password")
	public String processResetpassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");
		
		User user = userService.getByResetPasswordToken(token);
		model.addAttribute("title", "Reset your password");
		
		if(user == null) {
			model.addAttribute("message", "Invalid Token");
			return "message";
		}else {
			userService.updatePassword(user, password);
			
			model.addAttribute("message", "You have successfully changed your password.");
		}
		return "message";
	}
}
