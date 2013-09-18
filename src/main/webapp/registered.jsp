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
    <link rel="stylesheet" href="resources/css/sprite.tables.css">
    <link rel="stylesheet" href="resources/css/sprite.wizard.css">
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
        <jsp:include page="toolbar.jsp"/>
        <!-- End of the header toolbar -->

        <!-- Start of the main header bar -->
        <jsp:include page="header.jsp"/>
    </header>

    <!-- Start of the content -->
    <div role="main" class="container_12" id="content-wrapper">

        <!-- Start of the main content -->
        <div id="main_content">

            <h2 class="grid_12">Registration Successful - Congratulations!</h2>

            <div class="clean"></div>

            <div class="grid_12">
                <div class="box wizard" data-step="1">
                    <div class="header">
                        <img src="resources/img/icons/packs/fugue/16x16/application--arrow.png" alt="" width="16"
                             height="16">

                        <h3>Thank You!</h3>
                        <span></span>
                    </div>
                    <div class="content">
                        You have successfully completed your registration <br>
                        Please check your email as we have sent you all your right registration details.
                    </div>
                    <%--<div class="actions">
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
                    </div>--%>
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
<script>window.jQuery || document.write('<script src="resources/js/libs/jquery-1.7.1.js"><\/script>')</script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<script>window.jQuery.ui || document.write('<script src="resources/js/libs/jquery-ui-1.8.16.min.js"><\/script>')</script>

<!-- scripts concatenated and minified via build script -->
<script defer src="resources/js/plugins.js"></script>
<script defer src="resources/js/mylibs/jquery.ba-resize.js"></script>
<script defer src="resources/js/mylibs/jquery.easing.1.3.js"></script>
<script defer src="resources/js/mylibs/jquery.ui.touch-punch.js"></script>
<script defer src="resources/js/mylibs/jquery.chosen.js"></script>
<script defer src="resources/js/mylibs/jquery.validate.js"></script>
<script defer src="resources/js/script.js"></script>
</body>
</html>
