<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 濃霧-遠方
  Date: 2020/2/13
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书商城-用户登录</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="login">
        <div id="login_img">
            <img src="images/library.jpg" alt="背景" width="246" height="200"/>
        </div>
        <div id="login_user">
            <form id="login_from">
                <label for="userName_input" class="login_label">用户名：</label>
                <input type="text" name="userName" id="userName_input" /><br/>
                <label for="password_input" class="login_label">密码：</label>
                <input type="password" name="password" id="password_input"/>
            </form>
        </div>
        <div id="button">
            <input type="button" id="login_button" name="login_button" value="登录" onclick="login()"/>
            <input type="button" id="register_button" name="register_button" value="注册"/>
        </div>
    </div>
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">

        const userNameInput = $('input[name="userName"]');
        const passwordInput = $('input[name="password"]');

        function getData(){
            var userName = userNameInput.val();
            var password = passwordInput.val();

            if(userName.length < 4){
                alert("用户名长度必须超过4个字符");
                return null;
            }
            if(password.length < 8){
                alert("密码长度必须超过8个字符");
                return null;
            }
            return {key1:userName,key2:password};
        }

        //重置输入框
        function resetInput(){
            userNameInput.val("");
            passwordInput.val("");
        }

        function toIndex(userName){
            document.cookie="user_name="+userName;
            window.location="index.jsp";
        }

        function login(){
            var login = getData();
            if (!login) {
                return; 
            }
            $.ajax({
                url: "login",
                data: {
                    userName: login.key1,
                    password: login.key2
                },
                success: function (data) {
                    alert(data);
                    if(data == "登陆成功"){
                        toIndex(login.key1);
                    }
                },
                error:function(XMLHttpRequest, textStatus){
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    document.write(XMLHttpRequest.responseText);
                    console.log(textStatus);
                },
                type: `POST`,
                async:true,
                cache:false
            });
            resetInput();
        }
    </script>
</body>
</html>