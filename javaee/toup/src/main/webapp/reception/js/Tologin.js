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
        dataType: 'json',
        url: 'http://localhost:8080/toup/user/islogin',
        success: function (data) {
        	console.log(data)
            if (data.code == -1) {
                $("#li_login").text("登录");
                $("#a_login").click(function () {
                    login();
                });
            } else {
            	if(data.data!=null){
            		login_username=data.data[0].username;
            		$("#li_login").text(login_username + "你好!").append($("<p>点击退出登录</p>"));
            		if(data.data[0].Administrator==1){            			
            			$("#Big-nav-ul").append($("<a href='../backstage/index.jsp' id='a_login'><li id='li_login'>后台管理</li></a>"));
            		}
            	}
                $("#a_login").click(function () {
                    exitlogin();
                });
            }
        }
    });
}
islogin();