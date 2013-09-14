<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>SSM:MyLLP</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <!-- CSS -->
    <link rel="stylesheet" href="/resources/css/960gs/fluid.css">
    <!-- 960.gs Grid System -->
    <!-- The HTML5-Boilerplate CSS styling -->
    <link rel="stylesheet" href="/resources/css/h5bp/normalize.css">
    <!-- RECOMMENDED: H5BP reset styles -->
    <link rel="stylesheet" href="/resources/css/h5bp/non-semantic.helper.classes.css">
    <!-- RECOMMENDED: H5BP helpers (e.g. .clear or .hidden) -->
    <link rel="stylesheet" href="/resources/css/h5bp/print.styles.css">
    <!-- OPTIONAL: H5BP print styles -->
    <!-- The special page's styling -->
    <link rel="stylesheet" href="/resources/css/special-page.css">
    <!-- REQUIRED: Special page styling -->
    <link rel="stylesheet" href="/resources/css/sprites.css">
    <!-- REQUIRED: Basic sprites (e.g. buttons, jGrowl) -->
    <link rel="stylesheet" href="/resources/css/typographics.css">
    <!-- REQUIRED: Typographics -->
    <link rel="stylesheet" href="/resources/css/content.css">
    <!-- REQUIRED: Content (we need the boxes) -->
    <link rel="stylesheet" href="/resources/css/sprite.forms.css">
    <!-- SPRITE: Forms -->
    <link rel="stylesheet" href="/resources/css/ie.fixes.css">
    <!-- OPTOINAL: Fixes for IE -->

</head>
<body class="special_page">
<div class="top">
    <div class="gradient"></div>
    <div class="white"></div>
    <div class="shadow"></div>
</div>
<div class="content">
    <h1>SSM:MyLLP | Login</h1>

    <div class="background"></div>
    <div class="wrapper">
        <div class="box">
            <div class="header grey">
                <img src="resources/img/icons/packs/fugue/16x16/lock.png" width="16" height="16">

                <h3>Login</h3>
            </div>
            <form method="get" action="dashboard.html">
                <div class="content no-padding">
                    <div class="section _100">
                        <label>
                            Username
                        </label>

                        <div>
                            <input name="username" class="required">
                        </div>
                    </div>
                    <div class="section _100">
                        <label>
                            Password
                        </label>

                        <div>
                            <input name="password" type="password" class="required">
                        </div>
                    </div>
                </div>
                <div class="actions">
                    <div class="actions-right">
                        <input type="submit" value="Login"/>
                    </div>
                </div>
            </form>
        </div>
        <div class="shadow"></div>
    </div>
</div>


<!-- JavaScript at the bottom for fast page loading -->
<!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if offline -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/libs/jquery-1.7.1.js"><\/script>')</script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<script>window.jQuery.ui || document.write('<script src="js/libs/jquery-ui-1.8.16.min.js"><\/script>')</script>

<!-- scripts concatenated and minified via build script -->
<script defer src="js/plugins.js"></script>
<script defer src="js/mylibs/jquery.validate.js"></script>
<script defer src="js/mylibs/jquery.jgrowl.js"></script>
<script defer src="js/mylibs/jquery.checkbox.js"></script>
<script defer src="js/mylibs/jquery.validate.js"></script>
<script defer src="js/script.js"></script>
<!-- REQUIRED: Generic scripts -->
<!-- end scripts -->
<script>
    $(window).load(function() {
        /*
         * Validate the form when it is submitted
         */
        var validatelogin = $("form").validate({
            invalidHandler: function(form, validator) {
                var errors = validator.numberOfInvalids();
                if (errors) {
                    var message = errors == 1
                            ? 'You missed 1 field. It has been highlighted.'
                            : 'You missed ' + errors + ' fields. They have been highlighted.';
                    $('.box .content').removeAlertBoxes();
                    $('.box .content').alertBox(message, {type: 'warning', icon: true, noMargin: false});
                    $('.box .content .alert').css({
                        width: '',
                        margin: '0',
                        borderLeft: 'none',
                        borderRight: 'none',
                        borderRadius: 0
                    });
                } else {
                    $('.box .content').removeAlertBoxes();
                }
            },
            showErrors : function(errorMap, errorList) {
                this.defaultShowErrors();
                var self = this;
                $.each(errorList, function() {
                    var $input = $(this.element);
                    var $label = $input.parent().find('label.error').hide();
                    $label.addClass('red');
                    $label.css('width', '');
                    $input.trigger('labeled');
                    $label.fadeIn();
                });
            },
            submitHandler: function(form) {
                window.location.replace('dashboard.html');
            }
        });
    });
</script>
</body>
</html>
