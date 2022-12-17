let menu = document.querySelector('#menu-btn');
let navbar1 = document.querySelector('.header .navbar-1');

menu.onclick = () =>{
    menu.classList.toggle('fa-times');
    navbar1.classList.toggle('active');
}