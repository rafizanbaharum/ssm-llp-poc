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
                <!-- A small toolbar button -->
                <div class="toolbar_small">
                    <div class="toolbutton">
                        <span>3</span>
                        <img src="/resources/img/icons/16x16/mail.png" width="16" height="16" alt="mail">
                    </div>
                </div>
                <!-- End of small toolbar button -->

                <!-- A large toolbar button -->
                <div class="toolbar_large">
                    <div class="toolbutton">
                        <div class="toolicon">
                            <img src="/resources/img/icons/16x16/user.png" width="16" height="16" alt="user">
                        </div>
                        <div class="toolmenu">
                            <div class="toolcaption">
                                <span>${currentUser.realname}</span>
                            </div>
                            <!-- Start of menu -->
                            <div class="dropdown">
                                <ul>
                                    <li>
                                        <a href="#">Settings</a>
                                    </li>
                                    <li>
                                        <a href="/gate/out">Logout</a>
                                    </li>
                                </ul>
                            </div>
                            <!-- End of menu -->
                        </div>
                    </div>
                </div>
                <!-- End of large toolbar button -->
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
                    <a href="#">
                        <img src="/resources/img/icons/25x25/dark/computer-imac.png" width=25 height=25 alt="">
                        Dashboard</a>
                    <ul>
                        <li>
                            <a href="/secure/dashboard">Dashboard</a>
                        </li>
                    </ul>
                </li>
                <li class="current">
                    <a href="#">
                        <img src="/resources/img/icons/25x25/dark/documents.png" width=25 height=25 alt="">
                        My Companies</a>
                    <ul>
                        <li>
                            <a href="/secure/company/reserve">Reservations</a>
                        </li>
                        <li>
                            <a href="/secure/company/llp">LLP</a>
                        </li>
                        <li>
                            <a href="/secure/company/roc">ROC</a>
                        </li>
                        <li>
                            <a href="/secure/company/rob">ROB</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <img src="/resources/img/icons/25x25/dark/address-book.png" width=25 height=25 alt="">
                        Literatures</a>
                    <ul>
                        <li>
                            <a href="/secure/literature/legal">Legal</a>
                        </li>
                        <li>
                            <a href="/secure/literature/about">About</a>
                        </li>
                    </ul>
                </li>
                <sec:authorize ifAllGranted="ROLE_ADMINISTRATOR">
                    <li>
                        <a href="#">
                            <img src="/resources/img/icons/25x25/dark/archive.png" width=25 height=25 alt="">
                            Rules</a>
                        <ul>
                            <li>
                                <a href="/secure/filter/all">Filters</a>
                            </li>
                            <li>
                                <a href="/secure/name/all">Names</a>
                            </li>
                        </ul>
                    </li>
                </sec:authorize>
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
        <h2 class="grid_12">Company</h2>

        <div class="clean"></div>

        <div class="grid_12">
            <div class="box">
                <div class="header">
                    <img src="/resources/img/icons/packs/fugue/16x16/task-select-first.png" alt="" width="16"
                         height="16">

                    <h3>Update Company Form</h3>
                    <span></span>
                </div>
                <form method="post" action="/secure/company/update" class="validate">
                    <div class="content">
                        <fieldset>
                            <legend>
                                Company Details
                            </legend>
                            <div class="_100">
                                <p>
                                    <label for="name">
                                        Name
                                    </label>
                                    <input type="text" value="${company.name}" name="name"
                                           class="text" readonly="true">
                                </p>
                            </div>
                            <div class="_50">
                                  <p>
                                      <label for="type">
                                          Type
                                      </label>
                                      <input type="text" value="${company.companyType}" class="required" name="type"
                                             class="text" readonly="true">
                                  </p>
                              </div>
                              <div class="_50">
                                  <p>
                                      <label for="status">
                                          Status
                                      </label>
                                      <input type="text" value="${company.companyStatus}" class="required" name="status"
                                             class="text" readonly="true">
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
                                    <input type="text" name="phone" class="text" value="${company.phone}">
                                </p>
                            </div>
                            <div class="_50">
                                <p>
                                    <label for="textfield2">
                                        Fax
                                    </label>
                                    <input type="text" name="fax" class="text" value="${company.fax}">
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
                                <input type="text" name="address1" class="text" value="${company.address1}">
                            </p>

                            <p class="inline-small-label">
                                <input type="text" name="address2" class="text" value="${company.address2}">
                            </p>

                            <p class="inline-small-label">
                                <input type="text" name="address3" class="text" value="${company.address3}">
                            </p>
                        </fieldset>
                    </div>
                    <div class="actions">
                        <input type="hidden" name="id" value="${company.id}"/>

                        <div class="actions-right">
                            <input type="submit">
                        </div>
                    </div>
                </form>
            </div>
            <!-- End of .box -->
        </div>
        <!-- End of .grid_12 -->
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
                    <span><a href="/gate/out">Logout</a></span>
                </li>
            </ul>
        </div>
    </div>
</footer>
<!-- End of footer-->

<script src="/resources/js/libs/jquery-ui-1.8.16.min.js"></script>
<script defer src="/resources/js/plugins.js"></script>
<script defer src="/resources/js/mylibs/jquery.ba-resize.js"></script>
<script defer src="/resources/js/mylibs/jquery.easing.1.3.js"></script>
<script defer src="/resources/js/mylibs/jquery.ui.touch-punch.js"></script>
<script defer src="/resources/js/mylibs/jquery.chosen.js"></script>
<script defer src="/resources/js/mylibs/jquery.validate.js"></script>
<script defer src="/resources/js/script.js"></script>
</body>
</html>
