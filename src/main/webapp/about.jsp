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
                        <li class="current">
                            <a href="/literature/about">About</a>
                        </li>
                        <li>
                            <a href="/literature/faq">FAQ</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <img src="/resources/img/icons/25x25/dark/book-large.png" width=25 height=25 alt=""> Register</a>
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
    <!-- Start of the sidebar -->
    <aside>
        <div id="sidebar_content">
            <h2>Starting a LLP</h2>

            <p></p>

            <div class="divider"></div>
            <nav>
                <ul class="menu">
                    <li class="first-child current">
                        <a href="#what">What is it?</a>
                    </li>
                    <li>
                        <a href="#who">Who is it for?</a>
                    </li>
                    <li>
                        <a href="#feature">Salient features</a>
                    </li>
                    <li class="last-child">
                        <a href="#portal">Accessing MyLLP Portal</a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- End of the sidebar-->

    <!-- Start of the main content -->
    <div id="main_content">

        <a name="what"/>
        <h2 class="grid_12">What is it?</h2>
        <div class="clear"></div>

        <p>Limited Liability Partnership (LLP) is an alternative business vehicle regulated under the Limited
            Liability Partnerships Act 2012 which combines the characteristics of a company and a conventional
            partnership.
        </p>
        <div class="clear"></div>

        <a name="who"/>
        <h2 class="grid_12">Who is it for?</h2>
        <div class="clear"></div>

        <p>The LLP business structure is designed for all lawful business purposes with a view to make profit. LLP
            may also be formed by professionals such as Lawyers, Chartered Accountants and Company Secretaries for
            the purpose of carrying on their professional practice. The LLP concept will also support start ups,
            small and medium enterprises (SMEs) to grow their businesses without having to worry too much on their
            personal liabilities, personal assets and strict compliance requirements.
        </p>
        <div class="clear"></div>

        <a name="feature"/>
        <h2 class="grid_12">Salient features</h2>
        <div class="clear"></div>

        <p>Amongst others, LLP is featured with the protection of limited liability to its partners similar to the
            limited liability enjoyed by shareholders of a company coupled with flexibility of internal business
            regulation through partnership arrangement similar to a conventional partnership.
        </p>

        <p>
            Any debts and obligations of the LLP will be borne by the assets of the LLP and not that of its partners’.
            An LLP has the legal status of a body corporate which is capable of suing and being sued in its own name,
            holding assets and doing such other acts and things in its name as bodies corporate may lawfully do and
            suffer.
        </p>

        <p>
            LLP also offers flexibility in terms of its formation, maintenance and termination while simultaneously
            has the necessary dynamics and appeal to be able to compete domestically and internationally. With the
            introduction of LLP, entrepreneurs will have more options to choose the most preferred form of business
            vehicle.
        </p>

        <p>
            For more information click the following:-
        <p>
        <ul>
            <li>LLP Act 2012</li>
            <li>LLP Regulations 2012</li>
            <li>General Guidelines For Registration of Limited Liability Partnership And Related Matters</li>
            <li>LLP Brochure</li>
            <li>LLP Booklet</li>
            <li>FAQs on LLP</li>
        </ul>

        <div class="clear"></div>

        <a name="portal"/>
        <h2 class="grid_12">Accessing the MyLLP Portal</h2>
        <div class="clear"></div>

        <ul>
            <li> Application For Registration Of Foreign LLP</li>
            <li> Application For Conversion from Conventional Partnership to LLP</li>
            <li> Application For Conversion from Conversion Private Company to LLP</li>
            <li> Application For Change Of Name</li>
            <li> Change Of Address Of Registered Office</li>
            <li> Change Of Address Of Place Of Business</li>
            <li> Change Of Nature Of Business/Principal Activities</li>
            <li> Change Of Particulars Of Partner - Individual</li>
            <li> Change Of Particulars Of Partner – Body Corporate</li>
            <li> Change Of Particulars Of Partner – Goverment Agency</li>
            <li> Change Of Particulars Of Compliance Officer</li>
        </ul>
        <p>
        Click here to download forms.
        </p>
        <div class="clear"></div>
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
