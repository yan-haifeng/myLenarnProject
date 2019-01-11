//依赖layui
//导入该js时必须导入layui.all.js
//登录弹出框

function login() {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.open({
            type: 2,
            content: ['ReceptionViews/login.html', 'no'], //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            area: ['330px', '320px'],
            resize: false,
            shade: 0.8,
            shadeClose: true
        });
    });
}

function exitlogin() {
    $.ajax({
        type: 'GET',
        dataType: 'text',
        url: 'http://localhost:8080/toup/user/exitlogin',
        success: function (data) {
            window.location.reload();
        }
    });
}

function islogin() {
    $.ajax({
        type: 'GET',
        dataType: 'text',
        url: 'http://localhost:8080/toup/user/islogin',
        success: function (data) {
            login_username=data;
            if (data == 'nologin') {
                $("#li_login").text("登录");
                $("#a_login").click(function () {
                    login();
                });
            } else {
                $("#li_login").text(data + "你好!点击退出登录");
                $("#a_login").click(function () {
                    exitlogin();
                });
            }
        }
    });
}
islogin();