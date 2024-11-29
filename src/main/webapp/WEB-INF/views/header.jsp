<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <title>TechNova</title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
</head>

<body>

   <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__close">+</div>
        <ul class="offcanvas__widget">
            <li><span class="icon_search search-switch"></span></li>
            <li><a href="#"><span class="icon_heart_alt"></span>
                <div class="tip">2</div>
            </a></li>
            <li><a href="#"><span class="icon_bag_alt"></span>
                <div class="tip">2</div>
            </a></li>
        </ul>
        <div class="offcanvas__logo">
            <a href="./index.html"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""></a>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__auth">
            <a href="#">Login</a>
            <a href="#">Register</a>
        </div>
    </div>
    <!-- Offcanvas Menu End -->
    
   <!-- Header Section Begin -->
   <header class="header">
       <div class="container-fluid">
           <div class="row">
               <div class="col-xl-3 col-lg-2">
                   <div class="header__logo">
                       <a href="/"><img style="width: 200px; height: 30px; margin: 0 0 0 30px" src="${pageContext.request.contextPath}/resources/images/logo4.JPG" alt=""></a>
                   </div>
               </div>
               <div class="col-xl-6 col-lg-7">
                   <nav class="header__menu">
                       <ul>
                           <li><a href="/">노트북</a></li>
                           <li><a href="#">PC</a></li>
                           <li><a href="#">모니터</a></li>
                           <li><a href="./shop.html">키보드</a></li>
                           <li><a href="#">컴퓨터부품</a>
                               <ul class="dropdown">
                                   <li><a href="./product-details.html">저장장치</a></li>
                                   <li><a href="./shop-cart.html">그래픽카드</a></li>
                                   <li><a href="./checkout.html">CPU</a></li>
                                   <li><a href="./blog-details.html">메인보드</a></li>
                               </ul>
                           </li>
                           <li><a href="./blog.html">웹캠</a></li>
                           <li><a href="./contact.html">스피커</a></li>
                       </ul>
                   </nav>
               </div>
               <div class="col-lg-3">
                   <div class="header__right">
                       <div class="header__right__auth">
                           <a href="#">Login</a>
                           <a href="#">Register</a>
                       </div>
                       <ul class="header__right__widget">
                           <li><span class="icon_search search-switch"></span></li>
                           <li><a href="/product/mypage"><span class="icon_heart_alt"></span>
                           </a></li>
                           <li><a href="/product/cart"><span class="icon_bag_alt"></span>
                               <div class="tip">2</div>
                           </a></li>
                       </ul>
                   </div>
               </div>
           </div>
           <div class="canvas__open">
               <i class="fa fa-bars"></i>
           </div>
       </div>
   </header>
   <!-- Header Section End -->
   
   
   <!-- Search Begin -->
   <div class="search-model">
       <div class="h-100 d-flex align-items-center justify-content-center">
           <div class="search-close-switch">+</div>
           <form class="search-model-form">
               <input type="text" id="search-input" placeholder="검색어를 입력하세요." onkeypress="show_name(event)">
           </form>
       </div>
   </div>
   <!-- Search End -->
   
   <script type="text/javascript">
        function show_name(e){
           e.preventDefault();
            var keyword = document.getElementById("search-input").value;
           const code = e.code;
           if(code == 'Enter'){
               location.href = "/product/list?keyword="+keyword;
           }
        }
    </script>
    
    </body>
</html>
    