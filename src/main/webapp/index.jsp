<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>图书商城-首页</title>
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
    </head>
<body>
    <div id="menu">
        <div id="menu-user">
            <div id="no-login" class="dislpay">
                <a href="login.jsp">登录</a>
            </div>
            <div id="user_info" class="no_display">
                <div id="user_name"></div>
            </div>
        </div>
    </div>
    <div>

    </div>
    <footer>

    </footer>
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script>
        state();

        function writeUserToDiv(){
            alert(data);
            $("#no-login").className = "no_display";
            $("#user_info").className = "display";
            $("#user_name").innerText=document.cookie.split(";")[0].split("=")[1];
        }

        function isLogin(userName){
            if(userName == null)
                return false;
            else{
                writeUserToDiv();
            }
        }

        function state() {
            var userName=document.cookie.split(";")[0].split("=")[1];
            if(!(login = isLogin(userName)))
                return;
            $.ajax({
                url: "UserInfo",
                data:{
                    userName:userName
                },
                dataType:"Text",
                seccess:function(data){
                    writeUserToDiv();
                },
                error:function(XMLHttpRequest, textStatus){
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    document.write(XMLHttpRequest.responseText);
                },
                type:'GET',
                async:true,
                cache:false
            })
        }
    </script>
</body>
</html>
