<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel=dns-prefetch href="//fonts.googleapis.com">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title></title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <!-- CSS -->
    <link rel="stylesheet" href="/resources/css/960gs/fluid.css">
    <link rel="stylesheet" href="/resources/css/h5bp/normalize.css">
    <link rel="stylesheet" href="/resources/css/h5bp/non-semantic.helper.classes.css">
    <link rel="stylesheet" href="/resources/css/h5bp/print.styles.css">
    <link rel="stylesheet" href="/resources/css/sprites.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/navigation.css">
    <link rel="stylesheet" href="/resources/css/sidebar.css">
    <link rel="stylesheet" href="/resources/css/content.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/typographics.css">
    <link rel="stylesheet" href="/resources/css/ie.fixes.css">
    <link rel="stylesheet" href="/resources/css/sprite.forms.css">
    <link rel="stylesheet" href="/resources/css/sprite.lists.css">
    <link rel="stylesheet" href="/resources/css/icons.css">
    <link rel="stylesheet" href="/resources/css/external/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="/resources/css/sidebar.css">
</head>

<body>

<!-- Begin of #height-wrapper -->
<div id="height-wrapper">
    <!-- Begin of header -->
    <header>
        <!-- Begin of the header toolbar -->
        <div id="header_toolbar">
            <div class="container_12">
                <h1 class="grid_8">SSM | MyLLP</h1>
                <!-- Start of right part -->
                <div class="grid_4">
                    <div class="toolbar_large">
                        <div class="toolbutton">
                            <div class="toolicon">
                                <img src="/resources/img/icons/16x16/user.png" width="16" height="16" alt="user">
                            </div>
                            <div class="toolmenu">
                                <div class="toolcaption">
                                    <span>Internal</span>
                                </div>
                                <!-- Start of menu -->
                                <div class="dropdown">
                                    <ul>
                                        <li>
                                            <a href="/gate/in">Login</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- End of menu -->
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End of right part -->
            </div>
        </div>
        <!-- End of the header toolbar -->

        <!-- Start of the main header bar -->
        <nav id="header_main">
            <div class="container_12">
                <!-- Start of the main navigation -->
                <ul id="nav_main">
                    <li>
                        <a href="#"> <img src="/resources/img/icons/25x25/dark/computer-imac.png" width=25 height=25
                                          alt="">
                            Home</a>
                        <ul>
                            <li>
                                <a href="/index">Dashboard</a>
                            </li>
                        </ul>
                    </li>
                    <li class="current">
                        <a href="#">
                            <img src="/resources/img/icons/25x25/dark/address-book.png" width=25 height=25 alt="">
                            Literatures</a>
                        <ul>
                            <li>
                                <a href="/literature/about">About</a>
                            </li>
                            <li class="current">
                                <a href="/literature/faq">FAQ</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <img src="/resources/img/icons/25x25/dark/book-large.png" width=25 height=25 alt="">
                            Register</a>
                        <ul>
                            <li>
                                <a href="/register">Register</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- End of the main navigation -->
            </div>
        </nav>
        <div id="nav_sub"></div>
    </header>

    <!-- Start of the content -->
    <div role="main" class="container_12" id="content-wrapper">
        <!-- Start of the main content -->
        <div id="main_content">

            <h2 class="grid_12">FAQ</h2>

            <div class="clear"></div>
            <ol>
                <li><a href="#1">Fundamentals of LLP</a></li>
                <li><a href="#1">Formation and registration of LLP</a></li>
                <li><a href="#1">Management of LLP</a></li>
                <li><a href="#1">Conversion to LLP</a></li>
                <li><a href="#1">LLP for Professional Practice</a></li>
                <li><a href="#1">Foreign LLP</a></li>
                <li><a href="#1">Closing an LLP</a></li>
                <li><a href="#1">General matters</a></li>
            </ol>

            <h2 class="grid_12">Fundamentals of LLP</h2>

            <h3 class="grid_12">Why LLP in Malaysia?</h3>
            <ul>
                <li>To provide the business community with an alternative business vehicle to
                    complement the traditional choices of sole proprietorships, partnerships and
                    companies (local and foreign)
                </li>
                <li> To provide access to limited liability status for partnership type businesses</li>
                <li> More affordable business vehicle</li>
            </ul>

            <h3 class="grid_12">What is the legal status of an LLP?</h3>

            <p>
                An LLP is a separate entity with the legal status of a body corporate.
            </p>

            <h3 class="grid_12">Why would one choose to register an LLP as opposed to registering a
                business or incorporating a company?</h3>

            <p>
                The LLP provides the flexibility of organizational arrangement through the partnership
                agreement whereas a company is subject to a more stringent compliance requirement. On
                the other hand, registering LLP provides the limited liability status as compared to registering
                a business which exposes the owner to unlimited liability.
            </p>

            <h3 class="grid_12">Is there any restriction as to what kind of business can use LLP as a
                business vehicle?</h3>

            <p>No. It is for all kind of lawful businesses with a view to make profit.</p>

            <h3 class="grid_12">Can a charity organisation register as LLP?</h3>

            <p>No. LLP is intended only for businesses with a view to make profit.</p>
        </div>
        <!-- End of #main_content -->
        <div class="push clear"></div>

    </div>
    <!-- End of #content-wrapper -->
    <div class="clear"></div>
    <div class="push"></div>
</div>

<!-- Start of footer-->
<footer>
    <div class="container_12">
        Copyright &copy; 2013 SSM all rights reserved.
        <div id="button_bar">
            <ul>
                <li>
                    <span><a href="/secure/dashboard">Dashboard</a></span>
                </li>
                <li>
                    <span><a href="/gate/in">Login</a></span>
                </li>
            </ul>
        </div>
    </div>
</footer>
<!-- End of footer-->


<!-- JavaScript at the bottom for fast page loading -->
<!-- Grab Google CDN's jQuery + jQueryUI, with a protocol relative URL; fall back to local -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.js"></script>
<script>window.jQuery || document.write('<script src="/resources/js/libs/jquery-1.7.1.js"><\/script>')</script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<script>window.jQuery.ui || document.write('<script src="/resources/js/libs/jquery-ui-1.8.16.min.js"><\/script>')</script>

<!-- scripts concatenated and minified via build script -->
<script defer src="/resources/js/plugins.js"></script>
<!-- REQUIRED: Different own jQuery plugnis -->
<script defer src="/resources/js/mylibs/jquery.ba-resize.js"></script>
<!-- RECOMMENDED when using sidebar: page resizing -->
<script defer src="/resources/js/mylibs/jquery.easing.1.3.js"></script>
<!-- RECOMMENDED: box animations -->
<script defer src="/resources/js/mylibs/jquery.ui.touch-punch.js"></script>
<!-- RECOMMENDED: touch compatibility -->
<script defer src="/resources/js/mylibs/jquery.chosen.js"></script>
<script defer src="/resources/js/mylibs/jquery.validate.js"></script>
<script defer src="/resources/js/script.js"></script>
<!-- REQUIRED: Generic scripts -->
<!-- end scripts -->
</body>
</html>
