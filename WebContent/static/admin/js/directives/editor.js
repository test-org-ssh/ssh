
app.directive('editor', function () {
    return {
        restrict: 'AE', 
        replace: true,
        template: '<script name="content" type="text/plain">',
        link: function (scope, el, attr) {
            var id = attr.id;
            UM.delEditor(id);

            var ue = UM.getEditor(id, {
                initialFrameWidth: '100%',
                initialFrameHeight: 300,
                autoHeightEnabled: false
            });
            ue.ready(function () {
                if (attr.config == 'post'){
                    ue.setContent(scope.post.content);
                }else if(attr.config == 'comment'){
                	ue.setContent(scope.comment.content);
                }
            });
        }

    }
})