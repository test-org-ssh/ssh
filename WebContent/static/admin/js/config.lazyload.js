// lazyload config

angular.module('app')
/**
 * jQuery plugin config use ui-jq directive , config the js and css files that required
 * key: function name of the jQuery plugin
 * value: array of the css js file located
 */
    .constant('JQ_CONFIG', {
            easyPieChart: ['../static/admin/vendor/jquery/charts/easypiechart/jquery.easy-pie-chart.js'],
            sparkline: ['../static/admin/vendor/jquery/charts/sparkline/jquery.sparkline.min.js'],
            plot: ['../static/admin/vendor/jquery/charts/flot/jquery.flot.min.js',
                '../static/admin/vendor/jquery/charts/flot/jquery.flot.resize.js',
                '../static/admin/vendor/jquery/charts/flot/jquery.flot.tooltip.min.js',
                '../static/admin/vendor/jquery/charts/flot/jquery.flot.spline.js',
                '../static/admin/vendor/jquery/charts/flot/jquery.flot.orderBars.js',
                '../static/admin/vendor/jquery/charts/flot/jquery.flot.pie.min.js'],
            slimScroll: ['../static/admin/vendor/jquery/slimscroll/jquery.slimscroll.min.js'],
            sortable: ['../static/admin/vendor/jquery/sortable/jquery.sortable.js'],
            nestable: ['../static/admin/vendor/jquery/nestable/jquery.nestable.js',
                '../static/admin/vendor/jquery/nestable/nestable.css'],
            filestyle: ['../static/admin/vendor/jquery/file/bootstrap-filestyle.min.js'],
            slider: ['../static/admin/vendor/jquery/slider/bootstrap-slider.js',
                '../static/admin/vendor/jquery/slider/slider.css'],
            chosen: ['../static/admin/vendor/jquery/chosen/chosen.jquery.min.js',
                '../static/admin/vendor/jquery/chosen/chosen.css'],
            TouchSpin: ['../static/admin/vendor/jquery/spinner/jquery.bootstrap-touchspin.min.js',
                '../static/admin/vendor/jquery/spinner/jquery.bootstrap-touchspin.css'],
            wysiwyg: ['../static/admin/vendor/jquery/wysiwyg/bootstrap-wysiwyg.js',
                '../static/admin/vendor/jquery/wysiwyg/jquery.hotkeys.js'],
            dataTable: ['../static/admin/vendor/jquery/datatables/jquery.dataTables.min.js',
                '../static/admin/vendor/jquery/datatables/dataTables.bootstrap.js',
                '../static/admin/vendor/jquery/datatables/dataTables.bootstrap.css'],
            vectorMap: ['../static/admin/vendor/jquery/jvectormap/jquery-jvectormap.min.js',
                '../static/admin/vendor/jquery/jvectormap/jquery-jvectormap-world-mill-en.js',
                '../static/admin/vendor/jquery/jvectormap/jquery-jvectormap-us-aea-en.js',
                '../static/admin/vendor/jquery/jvectormap/jquery-jvectormap.css'],
            footable: ['../static/admin/vendor/jquery/footable/footable.all.min.js',
                '../static/admin/vendor/jquery/footable/footable.core.css']
        }
    )
    // oclazyload config
    .config(['$ocLazyLoadProvider', function ($ocLazyLoadProvider) {
        // We configure ocLazyLoad to use the lib script.js as the async loader
        $ocLazyLoadProvider.config({
            debug: false,
            events: true,
            modules: [
                {
                    name: 'ngGrid',
                    files: [
                        '../static/admin/vendor/modules/ng-grid/ng-grid.min.js',
                        '../static/admin/vendor/modules/ng-grid/ng-grid.min.css',
                        '../static/admin/vendor/modules/ng-grid/theme.css'
                    ]
                },
                {
                    name: 'ui.select',
                    files: [
                        '../static/admin/vendor/modules/angular-ui-select/select.min.js',
                        '../static/admin/vendor/modules/angular-ui-select/select.min.css'
                    ]
                },
                {
                    name: 'angularFileUpload',
                    files: [
                        '../static/admin/vendor/modules/angular-file-upload/angular-file-upload.min.js'
                    ]
                },
                {
                    name: 'ui.calendar',
                    files: ['../static/admin/vendor/modules/angular-ui-calendar/calendar.js']
                },
                {
                    name: 'ngImgCrop',
                    files: [
                        '../static/admin/vendor/modules/ngImgCrop/ng-img-crop.js',
                        '../static/admin/vendor/modules/ngImgCrop/ng-img-crop.css'
                    ]
                },
                {
                    name: 'angularBootstrapNavTree',
                    files: [
                        '../static/admin/vendor/modules/angular-bootstrap-nav-tree/abn_tree_directive.js',
                        '../static/admin/vendor/modules/angular-bootstrap-nav-tree/abn_tree.css'
                    ]
                },
                {
                    name: 'toaster',
                    files: [
                        '../static/admin/vendor/modules/angularjs-toaster/toaster.js',
                        '../static/admin/vendor/modules/angularjs-toaster/toaster.css'
                    ]
                },
                {
                    name: 'textAngular',
                    files: [
                        '../static/admin/vendor/modules/textAngular/textAngular-sanitize.min.js',
                        '../static/admin/vendor/modules/textAngular/textAngular.min.js'
                    ]
                },
                {
                    name: 'vr.directives.slider',
                    files: [
                        '../static/admin/vendor/modules/angular-slider/angular-slider.min.js',
                        '../static/admin/vendor/modules/angular-slider/angular-slider.css'
                    ]
                },
                {
                    name: 'com.2fdevs.videogular',
                    files: [
                        '../static/admin/vendor/modules/videogular/videogular.min.js'
                    ]
                },
                {
                    name: 'com.2fdevs.videogular.plugins.controls',
                    files: [
                        '../static/admin/vendor/modules/videogular/plugins/controls.min.js'
                    ]
                },
                {
                    name: 'com.2fdevs.videogular.plugins.buffering',
                    files: [
                        '../static/admin/vendor/modules/videogular/plugins/buffering.min.js'
                    ]
                },
                {
                    name: 'com.2fdevs.videogular.plugins.overlayplay',
                    files: [
                        '../static/admin/vendor/modules/videogular/plugins/overlay-play.min.js'
                    ]
                },
                {
                    name: 'com.2fdevs.videogular.plugins.poster',
                    files: [
                        '../static/admin/vendor/modules/videogular/plugins/poster.min.js'
                    ]
                },
                {
                    name: 'com.2fdevs.videogular.plugins.imaads',
                    files: [
                        '../static/admin/vendor/modules/videogular/plugins/ima-ads.min.js'
                    ]
                }
            ]
        });
    }])
;