<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel=dns-prefetch href="//fonts.googleapis.com">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>SSM:MyLLP</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <!-- CSS -->
    <link rel="stylesheet" href="resources/css/960gs/fluid.css">
    <link rel="stylesheet" href="resources/css/h5bp/normalize.css">
    <link rel="stylesheet" href="resources/css/h5bp/non-semantic.helper.classes.css">
    <link rel="stylesheet" href="resources/css/h5bp/print.styles.css">
    <link rel="stylesheet" href="resources/css/sprites.css">
    <link rel="stylesheet" href="resources/css/header.css">
    <link rel="stylesheet" href="resources/css/navigation.css">
    <link rel="stylesheet" href="resources/css/sidebar.css">
    <link rel="stylesheet" href="resources/css/content.css">
    <link rel="stylesheet" href="resources/css/footer.css">
    <link rel="stylesheet" href="resources/css/typographics.css">
    <link rel="stylesheet" href="resources/css/ie.fixes.css">
    <link rel="stylesheet" href="resources/css/sprite.forms.css">
    <link rel="stylesheet" href="resources/css/sprite.lists.css">
    <link rel="stylesheet" href="resources/css/icons.css">
    <link rel="stylesheet" href="resources/css/external/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="resources/css/sidebar.css">
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

                <div class="grid_4">
                    <div class="toolbar_small">
                    </div>
                </div>
            </div>
        </div>
        <!-- End of the header toolbar -->

        <!-- Start of the main header bar -->
        <nav id="header_main">
            <div class="container_12">
                <ul id="nav_main">
                    <li>
                        <a href="#"> <img src="resources/img/icons/25x25/dark/computer-imac.png" width=25 height=25
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
                            <img src="resources/img/icons/25x25/dark/book-large.png" width=25 height=25 alt=""> Register</a>
                        <ul>
                            <li class="current">
                                <a href="/register">Register</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <div id="nav_sub"></div>
    </header>

    <!-- Start of the content -->
    <div role="main" class="container_12" id="content-wrapper">


        <!-- Start of the main content -->
        <div id="main_content">

            <h2 class="grid_12">Register</h2>

            <div class="clean"></div>

            <div class="grid_12">
                <div class="box">
                    <div class="header">
                        <img src="resources/img/icons/packs/fugue/16x16/task-select-first.png" alt="" width="16"
                             height="16">

                        <h3>Registration Form</h3>
                        <span></span>
                    </div>
                    <form method="post" action="register" class="validate">
                        <div class="content">
                            <fieldset>
                                <legend>
                                    Login Information
                                </legend>
                                <div class="_50">
                                    <p>
                                        <label for="textfield1">
                                            Name
                                        </label>
                                        <input type="text" value="" class="required" name="name" class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="textfield1">
                                            NRIC
                                        </label>
                                        <input type="text" value="" class="required" name="nricNo" class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="textfield1">
                                            Username
                                        </label>
                                        <input type="text" value="" class="required" name="username" class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="textfield2">
                                            Email
                                        </label>
                                        <input type="text" value="" name="email" class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="textfield1">
                                            Password
                                        </label>
                                        <input type="password" value="" class="required" name="password" class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="textfield2">
                                            Password Again
                                        </label>
                                        <input type="password" value="" name="passwordAgain" class="text">
                                    </p>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend>
                                    Contact Information
                                </legend>
                                <div class="_50">
                                    <p>
                                        <label for="textfield2">
                                            Phone
                                        </label>
                                        <input type="text" value="" name="phone" class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="textfield2">
                                            Fax
                                        </label>
                                        <input type="text" value="" name="fax" class="text">
                                    </p>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend>
                                    Address Information
                                </legend>
                                <p class="inline-small-label">
                                    <label for="field4">
                                        Address
                                    </label>
                                    <input type="text" name="address1" class="text">
                                </p>

                                <p class="inline-small-label">
                                    <input type="text" name="address2" class="text">
                                </p>

                                <p class="inline-small-label">
                                    <input type="text" name="address3" class="text">
                                </p>
                            </fieldset>
                        </div>
                        <div class="actions">
                            <div class="actions-left">
                                <input type="reset">
                            </div>
                            <div class="actions-right">
                                <input type="submit">
                            </div>
                        </div>
                    </form>
                </div>
                <!-- End of .box -->
            </div>
            <!-- End of .grid_6 -->

            <div class="clear"></div>

        </div>
        <!-- End of #main_content -->
        <div class="push clear"></div>

    </div>
    <!-- End of #content-wrapper -->
    <div class="clear"></div>
    <div class="push"></div>
    <!-- BUGFIX if problems with sidebar in Chrome -->

</div>
<!-- End of #height-wrapper -->

<!-- Start of footer-->
<footer>
    <div class="container_12">
        Copyright &copy; 2013 SSM, all rights reserved.
        <div id="button_bar">
            <ul>
                <li>
                    <span><a href="secure/dashboard.jsp">Dashboard</a></span>
                </li>
                <li>
                    <span><a href="/gate">Login</a></span>
                </li>
            </ul>
        </div>
    </div>
</footer>
<!-- End of footer-->

<!-- JavaScript at the bottom for fast page loading -->
<!-- Grab Google CDN's jQuery + jQueryUI, with a protocol relative URL; fall back to local -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/libs/jquery-1.7.1.js"><\/script>')</script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<script>window.jQuery.ui || document.write('<script src="resources/js/libs/jquery-ui-1.8.16.min.js"><\/script>')</script>

<!-- scripts concatenated and minified via build script -->
<script defer src="resources/js/plugins.js"></script>
<!-- REQUIRED: Different own jQuery plugnis -->
<script defer src="resources/js/mylibs/jquery.ba-resize.js"></script>
<!-- RECOMMENDED when using sidebar: page resizing -->
<script defer src="resources/js/mylibs/jquery.easing.1.3.js"></script>
<!-- RECOMMENDED: box animations -->
<script defer src="resources/js/mylibs/jquery.ui.touch-punch.js"></script>
<!-- RECOMMENDED: touch compatibility -->
<script defer src="resources/js/mylibs/jquery.chosen.js"></script>
<script defer src="resources/js/mylibs/jquery.validate.js"></script>
<script defer src="resources/js/script.js"></script>
<!-- REQUIRED: Generic scripts -->
<!-- end scripts -->
</body>
</html>
