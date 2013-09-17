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
    <link rel="stylesheet" href="/resources/css/sprite.tables.css">
    <link rel="stylesheet" href="/resources/css/sprite.wizard.css">
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
    <jsp:include page="include/header.jsp"/>
    <!-- End of the header toolbar -->

    <!-- Start of the main header bar -->
    <jsp:include page="include/nav.jsp"/>
</header>

<!-- Start of the content -->
<div role="main" class="container_12" id="content-wrapper">

<!-- Start of the main content -->
<div id="main_content">

<h2 class="grid_12">Wizard</h2>

<div class="clean"></div>

<div class="grid_12">
<div class="box wizard" data-step="1">
<div class="header">
    <img src="/resources/img/icons/packs/fugue/16x16/application--arrow.png" alt="" width="16"
         height="16">

    <h3>Registration Steps</h3>
    <span></span>
</div>
<div class="content">
    <form method="post" action="/secure/company/confirm" class="validate">

        <div class="steps">
            <ul>
                <li class="current">
                    <a href="#step_1"> <span>1</span>

                        <div>
                            <strong>Register</strong>
                            <small>
                                It only takes a minute
                            </small>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#step_2"> <span>2</span>

                        <div>
                            <strong>Registrar</strong>
                            <small>
                                Fill out who is registering for you
                            </small>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#step_3"> <span>3</span>

                        <div>
                            <strong>Payment</strong>
                            <small>
                                Method of payment
                            </small>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <div class="wiz_page step_1">
            <div class="wiz_sidebar grid_3">
                <span>1</span>

                <div>
                    <strong>Register</strong>
                    <small>
                        Choose company name
                    </small>
                </div>
                <p>
                </p>
            </div>
            <div class="wiz_content grid_9">
                <h3>Registration Information</h3>

                <p>Your choosen LLP name</p>

                <div class="_100">
                    <p>
                        <label for="name">
                            Choosen Name
                        </label>
                        <input type="text" value="${name}" class="required" name="name" class="text">
                    </p>
                </div>
                <div class="_100">
                    <p>
                        <select name="type">
                            <option selected>LLP</option>
                            <option>ROC</option>
                            <option>ROB</option>
                        </select>
                    </p>
                </div>

            </div>
        </div>
        <div class="wiz_page step_2">
            <div class="wiz_sidebar grid_3">
                <span>2</span>

                <div>
                    <strong>Registrar</strong>
                    <small>
                        Your official registrar
                    </small>
                </div>
            </div>
            <div class="wiz_content grid_9">
                <h3>Registrar Information</h3>

                <p>Registrar can be yourself or Compliant Officers</p>

                <div class="_100">
                    <p>
                        <label for="name">
                            Choosen Registar
                        </label>
                        <input type="text" class="required" name="name" class="text">
                    </p>
                </div>

            </div>
        </div>
        <div class="wiz_page step_3">
            <div class="wiz_sidebar grid_3">
                <span>3</span>

                <div>
                    <strong>Payment</strong>
                    <small>
                        Payment method
                    </small>
                </div>
                <p>
                </p>
            </div>
            <div class="wiz_content grid_9">
                <h3>Payment Information</h3>

                <p>Payment can be made via credit card or prepaid</p>

                <div class="_100">
                    <p>
                        <select name="paymentMethod">
                            <option selected>VISA</option>
                            <option>MASTER_CARD</option>
                            <option>ELECTRONIC_FUND</option>
                        </select>
                    </p>
                </div>

                <div class="_50">
                    <p>
                        <label for="billingName">
                            Billing Name
                        </label>
                        <input type="text" class="required" name="billingName" class="text">
                    </p>
                </div>

                <div class="_50">
                    <p>
                        <label for="email">
                            Email
                        </label>
                        <input type="text" class="required" name="email" class="text">
                    </p>
                </div>

                <div class="_100">
                    <p>
                        <label for="address1">
                            Address
                        </label>
                        <input type="text" class="required" name="address1" class="text">
                    </p>
                </div>

                <div class="_100">
                    <p>
                        <label for="address2">
                        </label>
                        <input type="text" class="required" name="address2" class="text">
                    </p>
                </div>

                <div class="_100">
                    <p>
                        <label for="address3">
                        </label>
                        <input type="text" class="required" name="address3" class="text">
                    </p>
                </div>

                <div class="_100">
                    <p>
                        <label for="address4">
                        </label>
                        <input type="text" class="required" name="address4" class="text">
                    </p>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="actions">
    <div class="actions-left">
        <button class="prev">
            &laquo; Back
        </button>
    </div>
    <div class="actions-right">
        <button class="next">
            Forward &raquo;
        </button>
    </div>
</div>
<!-- End of .content -->
<div class="clear"></div>
</div>
<!-- End of .box -->
</div>
<!-- End of .grid_12 -->


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
                    <span><a href="/secure/gate/out">Logout</a></span>
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
<script defer src="/resources/js/mylibs/jquery.ba-resize.js"></script>
<script defer src="/resources/js/mylibs/jquery.easing.1.3.js"></script>
<script defer src="/resources/js/mylibs/jquery.ui.touch-punch.js"></script>
<script defer src="/resources/js/mylibs/jquery.chosen.js"></script>
<script defer src="/resources/js/mylibs/jquery.validate.js"></script>
<script defer src="/resources/js/script.js"></script>
</body>
</html>
