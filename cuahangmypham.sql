-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2022 at 04:36 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cuahangmypham`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'Son'),
(2, 'Kem dưỡng/ Dầu dưỡng'),
(3, 'Sữa rửa mặt'),
(5, 'Serum trị mụn'),
(6, 'Phấn trang điểm'),
(7, 'Thực phẩm chức năng ');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` float DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT 0,
  `pic` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `name`, `price`, `category_id`, `brand`, `supplier`, `amount`, `pic`, `description`) VALUES
(1, 'Son Lì Shu Uemura Matte OR570 Màu Đỏ Cam 3g', 575000, 1, 'Shu Uemura Matte', 'Mars, Incorporated', 72, '/images/SonMoi_1.jpg', 'Từ thương hiệu Shu Uemura của Nhật Bản là dòng son trang điểm môi cao cấp với sự kết hợp hoàn mỹ giữa chất son lì thượng hạng và kết cấu mịn nhẹ như nhung, cho sắc son được bền màu mà vẫn duy trì cảm giác thoải mái, nhẹ nhàng suốt ngày dài. Đặc biệt, công'),
(2, 'Son Thỏi Lì 3CE Vỏ Trong Suốt Red Muse - Màu Đỏ 3.5g', 295000, 1, '3CE', 'ITC Limited', 75, '/images/SonMoi_2.jpg', 'Từ thương hiệu mỹ phẩm 3CE của Hàn Quốc, kết cấu son mềm mại và nhẹ môi cùng sắc tố cao giúp lên màu chuẩn sắc ngay từ lần đầu tiên. Sản phẩm với thiết kế vỏ trong suốt độc đáo, lạ mắt và ấn tượng giúp bạn quan sát được màu son bên trong.'),
(3, 'Son Môi Miracle Apo x Ofélia #17 Màu Nâu Cam Đất 2g', 144000, 1, 'Flawsome', 'Kraft Heinz', 84, '/images/SonMoi_3.jpg', 'Dòng son môi đến từ thương hiệu mỹ phẩm Miracle Apo kết hợp cùng Ofélia, với thiết kế thời thượng, giữ màu lâu trôi suốt nhiều giờ nhưng vẫn giữ độ dưỡng ẩm cho môi căng mọng. Sản phẩm có mùi hương ngọt ngào, dễ chịu.\r\n\r\n'),
(4, 'Son Môi Lancôme L\'Absolu Intimatte 274 Hồng Trà Sữa 3.4g', 900000, 1, 'LANCÔME', 'Beiersdorf', 79, '/images/sp4.png', 'Dòng son thỏi trang điểm môi cao cấp đầy quyền năng có công nghệ độc quyền từ Lancôme. Sắc màu thời thượng, chất son lì mềm mượt với chiết xuất hoa hồng, dưỡng chất Pro-xylane™ và Hyaluronic Acid cho đôi môi ngậm nước, mềm mịn và lên màu cực c'),
(5, 'Nước Uống Innerb Collagen Vitamin C Sáng Da Hộp 6x50ml GlowShot Collagen 3000', 215000, 7, 'InnerB', 'Unilever', 56, '/images/ThucPhamChucNang_1.jpg', 'Nước Uống Collagen Vitamin C Sáng Da InnerB GlowShot Collagen 3000 giúp bổ sung Elastin và Collagen dưới dạng phân tử peptide siêu nhỏ, dễ dàng hấp thu vào cơ thể, mang lại hiệu quả làm đẹp da cao: cải thiện cấu trúc da, tăng cường độ đàn hồi và săn chắc '),
(6, 'Viên Uống DHC Rau Củ Quả Tổng Hợp Premium 90 Ngày 360 Viên', 514000, 7, 'DHC', 'Reckitt', 95, '/images/ThucPhamChucNang_2.jpg', 'Dòng thực phẩm chức năng hỗ trợ sức khỏe nổi tiếng của Nhật Bản. Mỗi viên uống được cô đặc từ 32 loại rau củ tự nhiên trồng tại Nhật Bản với hơn 1000 tỷ lợi khuẩn tốt cho hệ tiêu hoá, giúp bổ sung hàm lượng chất xơ, dưỡng chất và vitamin thiết yếu cho cơ '),
(7, 'Kẹo Dẻo Vitamin Kích Thích Mọc Tóc Hairburst 60 Viên', 478000, 7, 'HAIRBURST', 'Diageo', 63, '/images/ThucPhamChucNang_3.jpg', 'Thực phẩm chức năng hỗ trợ làm đẹp mái tóc của thương hiệu HAIRBURST - hãng mỹ phẩm chuyên chăm sóc tóc đến từ Anh. Công thức độc đáo chứa các thành phần chiết xuất hoàn toàn từ thiên nhiên, giúp bổ sung các dưỡng chất thiết yếu nuôi dưỡng cho mái tóc thê'),
(8, 'Viên Uống Dầu Cá Blackmores Gấp Đôi Omega-3 90 Viên', 580000, 7, 'BLACKMORES', 'Kellogg\'s', 78, '/images/ThucPhamChucNang_4.jpg', 'Sản phẩm viên uống dầu cá cô đặc chất lượng cao đến từ thương hiệu thực phẩm chức năng BLACKMORES nổi tiếng của Úc, cung cấp hàm lượng gấp đôi Omega-3 trên mỗi viên nang so với viên uống dầu cá tiêu chuẩn của Blackmores*. Do đó, bạn chỉ cần sử dụng 1 viên'),
(9, 'Serum L\'Oreal Hyaluronic Acid Cấp Ẩm Sáng Da 30ml', 317000, 5, 'L\'OREAL', 'L\'Oréal', 69, '/images/Serum_2.jpg', 'Dòng sản phẩm serum đến từ thương hiệu L\'Oréal Paris nổi tiếng của Pháp, với sự kết hợp không chỉ 1 mà đến 2 loại Hyaluronic Acid ưu việt ở nồng độ 1.5% sẽ là giải pháp chăm sóc da hiệu quả dành cho làn da khô & lão hóa, giúp cung cấp độ ẩm tối đa cho da '),
(10, 'Tinh Chất Klairs Vitamin C Dưỡng Sáng Da, Mờ Thâm 35ml', 279000, 5, 'Klairs', 'Henkel', 89, '/images/Serum_1.jpg', 'Sản phẩm tinh chất đến từ thương hiệu Klairs của Hàn Quốc, tiếp thêm sinh lực trẻ hóa làn da với sức mạnh của 5% Vitamin C dạng Acid L-ascorbic nhẹ dịu; cùng chiết xuất Rau Má không gây kích ứng nhưng vẫn hiệu quả trong việc làm mờ các vết mụn và vết nám,'),
(11, 'Gel Dưỡng Eucerin Giảm Mụn Viêm & Không Viêm 40ml', 392000, 5, 'Eucerin', 'General Mills', 49, '/images/Serum_3.jpg', 'Sản phẩm gel đặc trị thích hợp cho tình trạng mụn nhẹ đến trung bình nhờ bộ 3 phức hợp Glycolic Acid, Salicylic Acid & Polyhydroxy Acid có khả năng tẩy tế bào chết dịu nhẹ, vừa giúp kháng khuẩn, loại bỏ tế bào chết vừa làm thông thoáng lỗ chân lông và hỗ '),
(12, 'Tinh Chất Bí Đao Cocoon Làm Giảm Mụn, Mờ Thâm 70ml ', 238000, 5, 'Cocoon', 'Kao Corporation', 103, '/images/Serum_4.jpg', 'Dòng sản phẩm chăm sóc da mụn của thương hiệu mỹ phẩm thuần chay Cocoon xuất xứ Việt Nam. Sản phẩm chứa các thành phần từ thực vật làm chủ đạo gồm chiết xuất bí đao, rau má, tràm trà và được bổ sung thêm 7% Niacinamide (vitamin B3) giúp hỗ trợ phục hồi tì'),
(13, 'Gel Rửa Mặt Cosrx Tràm Trà, 0.5% BHA Có Độ pH Thấp 150ml', 128000, 3, 'Cosrx', 'Shell plc', 96, '/images/SuaRuaMat_1.jpg', 'Dòng sữa rửa mặt đến từ thương hiệu mỹ phẩm Cosrx của Hàn Quốc, với độ pH lý tưởng 4.5 - 5.5 sản phẩm an toàn và dịu nhẹ trên mọi làn da ngay cả làn da nhạy cảm và da mụn. Gel rửa mặt chứa 0,5% BHA tự nhiên và chiết xuất tràm trà làm sạch sâu lỗ chân lông'),
(14, 'Gel Rửa Mặt La Roche-Posay Dành Cho Da Dầu, Nhạy Cảm 400ml', 420000, 3, 'LA ROCHE-POSAY', 'British American Tobacco', 75, '/images/SuaRuaMat_2.jpg', 'Dòng sản phẩm sữa rửa mặt chuyên biệt dành cho làn da dầu, mụn, nhạy cảm đến từ thương hiệu dược mỹ phẩm La Roche-Posay nổi tiếng của Pháp, với kết cấu dạng gel tạo bọt nhẹ nhàng giúp loại bỏ bụi bẩn, tạp chất và bã nhờn dư thừa trên da hiệu quả, mang đến'),
(15, 'Gel Rửa Mặt SVR Không Chứa Xà Phòng Cho Da Dầu 400ml', 439000, 3, 'SVR', 'Diageo', 78, '/images/SuaRuaMat_3.jpg', 'Sản phẩm sữa rửa mặt dành cho làn da dầu mụn đến từ thương hiệu dược mỹ phẩm SVR, với công thức không chứa xà phòng giúp làm sạch, nhẹ nhàng làm thông thoáng làn da. Khả năng tạo bọt mịn giúp loại trừ các chất bẩn và lượng bã nhờn dư thừa mà không làm khô'),
(16, 'Sữa Rửa Mặt Naruko Dạng Bùn Tràm Trà 120ml', 165000, 3, 'NARUKO', 'ITC Limited', 82, '/images/SuaRuaMat_4.jpg', 'Dòng sản phẩm đến từ thương hiệu mỹ phẩm thiên nhiên NARUKO nổi tiếng của Đài Loan, giúp làm sạch sâu lỗ chân lông và loại bỏ các tạp chất tồn đọng trên da, đồng thời chăm sóc da mặt dịu nhẹ cùng các chiết xuất tự nhiên như Tràm Trà, Hoa Hồng Nhung Rừng, '),
(17, 'Gel Dưỡng Megaduo Gel Giảm Mụn, Mờ Thâm 15g', 100000, 2, 'Gamma Chemicals', 'Nestlé', 52, '/images/KemDuong_1.jpg', 'Sản phẩm gel dưỡng giảm mụn đến từ thương hiệu Gamma Chemicals của Việt Nam, với khả năng làm giảm tình trạng mụn đồng thời ngăn hình thành các vết thâm sau mụn và làm mờ các đốm thâm hiệu quả, an toàn lành tính cho mọi loại da. '),
(18, 'Kem Dưỡng Ẩm Neutrogena Cấp Nước Cho Da Dầu 50g', 274000, 2, 'Neutrogena', 'Procter and Gamble', 64, '/images/KemDuong_2.jpg', 'Kem dưỡng ẩm đến từ thương hiệu mỹ phẩm Neutrogena của Mỹ, bảo vệ độ ẩm cho da mạnh hơn 80% cùng với công thức 1% các yếu tố giữ ẩm tự nhiên chứa Hyaluronic Acid, Axit Amin và chất điện giải. Kết cấu nhẹ thích hợp sử dụng hàng ngày.'),
(19, 'Kem Dưỡng Skin1004 Làm Dịu Da Chiết Xuất Rau Má 75ml', 273000, 2, 'Skin1004', 'GSK plc', 71, '/images/KemDuong_3.jpg', 'Kem dưỡng đến từ thương hiệu mỹ phẩm SKIN1004 của Hàn Quốc, thành phần chứa 72% chiết xuất rau má cùng với 4 loại Ceramide có nguồn gốc từ thực vật làm dịu làn da mụn, kích ứng, giúp tăng cường hàng rào bảo vệ da, nuôi dưỡng làn da khỏe mạnh. Hiện sản phẩ'),
(20, 'Kem Siêu Dưỡng Ẩm Embryolisse Hỗ Trợ Phục Hồi Da 30ml', 209000, 2, 'Embryolisse', 'Johnson and Johnson', 93, '/images/KemDuong_4.jpg', 'Sản phẩm kem dưỡng đa năng đến từ thương hiệu Embryolisse của Pháp, với các thành phần tự nhiên lành tính, không gây dị ứng, hỗ trợ cấp nước, giữ ẩm cho làn da luôn căng bóng, mềm mịn và rạng rỡ. Kết cấu sản phẩm dạng kem sữa, phù hợp làm lớp lót trước tr'),
(21, 'Phấn Phủ Australis Kiềm Dầu 2in1 Tông Tự Nhiên 12g', 239000, 6, 'australis', 'Danone', 43, '/images/Phan_1.jpg', 'Sản phẩm 2 trong 1 bao gồm phấn nền và phấn nén cung cấp giải pháp tức thời cho làn da dầu, nhạy cảm hoặc kích ứng. Hạt phấn mịn, phủ nhẹ tự nhiên không gây nặng mặt đồng thời kiềm dầu tốt cho da thoáng mịn, tươi tắn suốt ngày dài mà không lo xuống tông d'),
(22, 'Phấn Nước Gilaa Kiềm Dầu Và Dưỡng Da #01 Light Beige 13g', 325000, 6, 'Gilaa', 'Unicharm', 85, '/images/Phan_2.jpg', 'Dòng phấn nước cushion đến từ thương hiệu mỹ phẩm Gilaa của Hàn Quốc, với khả năng che phủ khuyết điểm lên đến 90% chỉ với 1 lần dặm phấn, sản phẩm tạo lớp nền mịn lì, kiềm dầu và bền màu suốt cả ngày. Đặc biệt, phấn nước kết hợp các thành phần dưỡng da v'),
(23, 'Phấn Má Hồng Cathy Doll Mịn Lì 03 Baby Boy 6g', 119000, 6, 'Cathy Doll', 'General Mills', 85, '/images/Phan_3.jpg', 'Dòng má hồng đến từ thương hiệu mỹ phẩm Cathy Doll của Thái Lan, thành phần chứa bột Silica hình cầu cải tiến với kích thước siêu nhỏ 5-7 micron giúp phấn má tệp vào da tự nhiên đồng thời che phủ lỗ chân lông mang đến lớp nền mịn màng, hồng hào.'),
(24, 'Phấn Má Hồng Vacosi Lolipop Màu 11 Maple Sweet 5g', 82000, 6, 'VACOSI', 'Kao Corporation', 73, '/images/Phan_4.jpg', 'Dòng phấn má hồng trang điểm đến từ thương hiệu mỹ phẩm Vacosi của Hàn Quốc, lấy cảm hứng từ những viên kẹo ngọt ngào, Vacosi đã cho ra đời bộ sản phẩm má hồng với 13 tone màu tự nhiên, phù hợp cho kiểu trang điểm hàng ngày. Phấn Má Hồng Lollipop Blush Se');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `trans_id` bigint(20) NOT NULL,
  `trans_status` int(11) DEFAULT NULL,
  `trans_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `trans_item`
--

CREATE TABLE `trans_item` (
  `trans_item_id` bigint(20) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `trans_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `reset_password_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `address`, `email`, `full_name`, `password`, `phone`, `point`, `reset_password_token`) VALUES
(6, NULL, 'admin@gmail.com', 'admin', '$2a$10$I6v0W4K1Y2n3scsMPASbDucNgdaeDNIiXtdF3IxZO.iu4a4NDKPaS', NULL, 0, NULL),
(9, NULL, 'test3@gmail.com', 'ly bao', '$2a$10$W3sku6gnAvMCinv6nS1hpecK6k2P2Wd4U0M5ctvSJeeAlSHxI8gVW', NULL, 0, NULL),
(10, NULL, 'test4@gmail.com', 'user test', '$2a$10$bWJt11Uo1VZm4PhiiXbFIeucVqwLltCKzIpos.dOEzS/VjKpKxtau', NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`role_id`, `user_id`) VALUES
(2, 9),
(1, 6),
(2, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `pk_products_category` (`category_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`),
  ADD UNIQUE KEY `UKiubw515ff0ugtm28p8g3myt0h` (`role_name`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`trans_id`);

--
-- Indexes for table `trans_item`
--
ALTER TABLE `trans_item`
  ADD PRIMARY KEY (`trans_item_id`),
  ADD KEY `FKiu5k33ep8w2321t5b0hcbk6x8` (`trans_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UKgnu0k8vv6ptioedbxbfsnan9g` (`email`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `pk_products_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

--
-- Constraints for table `trans_item`
--
ALTER TABLE `trans_item`
  ADD CONSTRAINT `FK1f8pv6hm7arvmi40fk3r8p3x2` FOREIGN KEY (`trans_item_id`) REFERENCES `transaction` (`trans_id`),
  ADD CONSTRAINT `FKiu5k33ep8w2321t5b0hcbk6x8` FOREIGN KEY (`trans_id`) REFERENCES `transaction` (`trans_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
