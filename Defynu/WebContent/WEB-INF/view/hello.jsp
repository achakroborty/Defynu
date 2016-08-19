<% response.setHeader("Cache-Control", "no-cache");

//Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control", "no-store");

//Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0);

//Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma", "no-cache");
//HTTP 1.0 backward enter code here


if (session == null && session.getAttribute("uname") == null) {
        response.sendRedirect("index");
        
}
else
        %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Avaran-Suit your Style environment.  </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <spring:url value="/resources/css/normalize.css" var="normalizeCSS" />
    <spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
    <spring:url value="/resources/css/flexslider.css" var="flexsliderCSS" />
    <spring:url value="/resources/css/hello.css" var="helloCSS" />
    <spring:url value="/resources/css/queries.css" var="queriesCSS" />
	<spring:url value="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" var="font-awesome.minCSS" />
	<link href="${normalizeCSS}" rel="stylesheet" />
	<link href="${bootstrapCSS}" rel="stylesheet" />
	<link href="${flexsliderCSS}" rel="stylesheet" />
	<link href="${helloCSS}" rel="stylesheet" />
	<link href="${queriesCSS}" rel="stylesheet" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/resources/css/jquery.fancybox.css">
	<link rel="stylesheet" href="/resources/css/etline-font.css">
	 <link rel="stylesheet" href="/resources/css/animate.min.css">
   
    <script type="text/javascript" src="resources/js/modernizr-2.8.3-respond-1.4.2.min.js" ></script>

    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="icon" type="image/png" href="favicon-32x32.png" sizes="32x32" />
    <link rel="icon" type="image/png" href="favicon-16x16.png" sizes="16x16" />
</head>
<body id="top">
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
    <section class="hero">
        <section class="navigation">
            <header>
                <div class="header-content">
                    <div class="logo"><a href="#"><img src="resources/img/aavaran-logo.png" alt="Sedna logo"></a></div>
                    <div class="header-nav">
                        <nav>
                            <ul class="primary-nav">
							    <li><a href="#feature">Customize</a></li>
                                <li><a href="#features">Shirts</a></li>
                               <li><a href="#three">FABRICS</a></li>
                            
                            </ul>
                            <ul class="member-actions">
               
                           
                           <c:set var="uname" scope="session" value="${loggedInUser}"/>
<c:choose>
  <c:when test="${uname == null}">
   <li><a href="#download" class="login">Sign In / Sign Up</a></li> 
  </c:when>
  
<c:otherwise>
   <li><a href="/signout" class="login">Signout</a></li>
  </c:otherwise>
</c:choose>
                   
                                <h7 style="color:white;">${loggedInUser}</h7>
                               <li><a href="/checkout" class="btn-white btn-small">bag &nbsp; <span data-icon="&#xe027;" class="icon"></span> &nbsp; (${cart})</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="navicon">
                        <a class="nav-toggle" href="#"><span></span></a>
                    </div>
                </div>
            </header>
        </section>
		
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="hero-content text-center">
                        <a href="/customize" class="btn btn-fill btn-large btn-margin-right">CUSTOMIZE MY SHIRT</a> 
                    </div>
                </div>
            </div>
        </div>
        <div class="down-arrow floating-arrow"><a href="#"><i class="fa fa-angle-down"></i></a></div>
    </section>
     
    <section class="intro section-padding" id="feature">
        <div class="container">
            <div class="row">
                <div class="col-md-4 intro-feature"> <img src="resources/img/choose.jpg" alt="choose">
                    <div class="intro-icon">
                         <span data-icon="&#xe035;" class="icon"></span> 
                    </div>
                    <div class="intro-content">
				        
                        <h5>Choose Fabric</h5>
                        <p>Choose the fabric suits your attire from our wide range of premium </p>
                    </div>
                </div>
                <div class="col-md-4 intro-feature"><img src="resources/img/customize.jpg" alt="choose">
                    <div class="intro-icon">
                        <span data-icon="&#xe046;" class="icon"></span>
                    </div>
                    <div class="intro-content">
					
                        <h5>Customize</h5>
                        <p>Customize your shirt with collar, cuff and contrast fabric well suited to your persona. </p>
                    </div>
                </div>
                <div class="col-md-4 intro-feature"><img src="resources/img/get measured.jpg" alt="choose">
                    <div class="intro-icon">
                        <span data-icon="&#xe033;" class="icon"></span>
                    </div>
                    <div class="intro-content last">
					
                        <h5>Get Measured</h5>
                        <p>Get your accurate measurement through our responsive tailoring guide or choose satndard sizes. </p>
                    </div>
                </div>
            </div>
        </div><a href="/customize"  class="lets btn-fill btn-large ">Lets Start</a>
    </section>
    <section class="features section-padding" id="features">
        <div class="container">
            <div class="row">
                <div class="col-md-5 col-md-offset-7">
                    <div class="feature-list">
                        <h3>The Formal Attire</h3>
						<hr \>
                        <!--<p>Present your product, start up, or portfolio in a beautifully modern way. Turn your visitors in to clients.</p>
                        --><ul class="features-stack">
                            <li class="feature-item">
                                <div class="feature-icon">
                                    <span data-icon="&#xe02c;" class="icon"></span>
                                </div>
                                <div class="feature-content">
                                    <h5>Universal & Responsive</h5>
                                    <p>Sedna is universal and will look smashing on any device.</p>
                                </div>
                            </li>
                            <li class="feature-item">
                                <div class="feature-icon">
                                    <span data-icon="&#xe040;" class="icon"></span>
                                </div>
                                <div class="feature-content">
                                    <h5>User Centric Design</h5>
                                    <p>Sedna takes advantage of common design patterns, allowing for a seamless experience for users of all levels.</p>
                                </div>
                            </li>
                            <li class="feature-item">
                                <div class="feature-icon">
                                    <span data-icon="&#xe03c;" class="icon"></span>
                                </div>
                                <div class="feature-content">
                                    <h5>Clean reusable code</h5>
                                    <p>Download and re-use the Sedna open source code for any other project you like.</p>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="device-showcase">
            <div class="devices">
                <div class="ipad-wrap wp1"></div>
                <div class="iphone-wrap wp2"></div>
        <div class="responsive-feature-img"><img src="resources/img/devices.png" alt="responsive devices"></div>
            </div>
        </div>
    </section>
    <section class="features-extra section-padding" id="assets">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <div class="feature-list">
                        <h3>Designed with Sketch!</h3>
                        <p>Easily change/switch/swap every placeholder inside every image on Sedna with the included Sketch files. You’ll have this template customised to suit your business in no time! </p>
                        <p>Nam vehicula malesuada lectus, interdum fringilla nibh. Duis aliquam vitae metus a pharetra. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec fermentum augue quis augue ornare, eget faucibus felis pharetra. Proin condimentum et leo quis fringilla.
                        </p>
                        <a href="/customize" class="btn btn-ghost btn-accent btn-small">Customize Now!!</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="macbook-wrap wp3"></div>
        <div class="responsive-feature-img"><img src="resources/img/macbook-pro.png" alt="responsive devices"></div>
    </section>
	<section class="blog text-center" id="three" >
        <div class="container-fluid" >
           
        </div>
    </section>
    <section class="blog text-center" >
        <div class="container-fluid" >
            <div class="row">
                <div class="col-md-4">
                    <article class="blog-post" >
                        <figure>
                            <a href="resources/img/blog-img-01.jpg" class="single_image">
                                <div class="blog-img-wrap">
                                    <div class="overlay">
                                        <i class="fa fa-search"></i>
                                    </div>
                                    <img src="resources/img/blog-img-01.jpg" alt="Sedna blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a href="/browse" class="blog-category" data-toggle="tooltip" data-placement="top" data-original-title="See more posts">100% Cotton</a></h2>
                            <!-- <p><a href="#" class="blog-post-title">Getting started with Sedna <i class="fa fa-angle-right"></i></a></p> -->
                            </figcaption>
                        </figure>
                    </article>
                </div>
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a href="resources/img/blog-img-02.jpg" class="single_image">
                                <div class="blog-img-wrap">
                                    <div class="overlay">
                                        <i class="fa fa-search"></i>
                                    </div>
                                    <img src="resources/img/blog-img-02.jpg" alt="Sedna blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a href="/browse" class="blog-category" data-toggle="tooltip" data-placement="top" data-original-title="See more posts">Pima Cotton</a></h2>
                           
                            </figcaption>
                        </figure>
                    </article>
                </div>
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a href="resources/img/blog-img-03.jpg" class="single_image">
                                <div class="blog-img-wrap">
                                    <div class="overlay">
                                        <i class="fa fa-search"></i>
                                    </div>
                                    <img src="resources/img/blog-img-03.jpg" class="single_image" alt="Sedna blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a href="/browse" class="blog-category" data-toggle="tooltip" data-placement="top" data-original-title="See more posts">Giza Cotton</a></h2>
                           </figcaption>
                        </figure>
                    </article>
                </div>
                <a href="/browse" class="btn btn-ghost btn-accent btn-small">Browse</a>
            </div>
        </div>
    </section>
    
	 
	<section class="testimonial-slider section-padding text-center" id="car">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="flexslider">
                        <ul class="slides">
                            <li>
                                <div class="avatar"><img src="resources/img/hero.jpg" alt="Sedna Testimonial Avatar"></div>
                                <h2>"Melfort, Red"</h2>
                                <p class="author">Oxford, 160 g/m2</p>
                            </li>
                            <li>
                                <div class="avatar"><img src="resources/img/shirt2.png" alt="Sedna Testimonial Avatar"></div>
                                <h2>"Milano, Black."</h2>
                                <p class="author">Poplin, 105 g/m2</p>
                            </li>
                            <li>
                                <div class="avatar"><img src="resources/img/shirt3.png" alt="Sedna Testimonial Avatar"></div>
                                <h2>"Burton RS, Purple"</h2>
                                <p class="author">Twill, 87 g/m2</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>		
    
    <section class="sign-up section-padding text-center" id="download">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>Get started with Aavaran</h3>
                    <p>Grab your shirt today, exclusively from Aavaran</p>
                    <form class="signup-form" action="/hello" method="POST" role="form">
                        <div class="form-input-group">
                            <i class="fa fa-envelope"></i><input type="text" name="email" id="email" class="formfield long" placeholder="Enter your email" required>
                        </div>
                        <div class="form-input-group">
                            <i class="fa fa-lock"></i><input type="password" name="password" id="password" class="formfield small" placeholder="Enter your password" required>
                        </div>
                        <button type="submit" class="btn-fill sign-up-btn">Sign in </button>
						<button type="submit" formaction="/register" class="btn-fill-new sign-up-btn">Sign up </button>
						
                    </form>
                </div>
            </div>
        </div>
    </section>
    <section class="to-top">
        <div class="container">
            <div class="row">
                <div class="to-top-wrap">
                    <a href="#top" class="top"><i class="fa fa-angle-up"></i></a>
                </div>
            </div>
        </div>
    </section>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <div class="footer-links">
                        <ul class="footer-group">
                            <li><a href="#">Blog</a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#">Sign up</a></li>
                            <li><a href="#">How It Works</a></li>
                            
                        </ul>
                        <p>Copyright © 2016 <a href="#">AAVARAN <span class="fa fa-heart pulse2"></span></a><br>
                         </div>
                </div>
                <div class="social-share">
                    <p>Share Avaran with your friends</p>
                    <a href="https://twitter.com/peterfinlan" class="twitter-share"><i class="fa fa-twitter"></i></a> <a href="#" class="facebook-share"><i class="fa fa-facebook"></i></a>
                </div>
            </div>
        </div>
    </footer>
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="resources/js/jquery-1.11.2.min.js"><\/script>')</script>
    <script src="resources/js/retina.js"></script>
    <script src="resources/js/jquery.fancybox.pack.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/scripts.js"></script>
    <script src="resources/js/jquery.flexslider-min.js"></script>
    <script src="resources/js/classie.js"></script>
    <script src="resources/js/jquery.waypoints.min.js"></script>
    <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
    <script>
    (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
    function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
    e=o.createElement(i);r=o.getElementsByTagName(i)[0];
    e.src='//www.google-analytics.com/analytics.js';
    r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
    ga('create','UA-XXXXX-X','auto');ga('send','pageview');
    </script>
</body>
</html>