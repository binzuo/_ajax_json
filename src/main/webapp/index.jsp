<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/26
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index page</title>
    <script src="js/jquery-3.1.1.js"></script>
    <script>
      $(function () {
        var result;
        $('#email').blur(function () {
          var email = $(this).val();
          $.ajax({
            url: '/user',
            type: 'post',
            data: {'action': 'isEmailExisted', 'email': email},
//                    dataType: 'json',
            success: function (data) {
              result = data;
              console.log("success...");
              if (result == 'true') {
                $('#hint').text('email existed').css('color', '#f00');
              } else {
                $('#hint').text('email not exist').css('color', '#0f0');
              }
            },
            error: function (a, b, c) {
              console.log("error...");
              console.log('a:' + a);
              console.log('b:' + b);
              console.log('c:' + c);
            },
            beforeSend: function () {
              console.log("before...");
            },
            complete: function () {
              console.log("complete...");

            }
          });
        });
      });
    </script>
  </head>
  <body>
  <h1>index page</h1>
  <form action="" method="post">
    <input id="email" type="text" name="email" placeholder="EMAIL" value="18310996173xiaozuo@gmail.com">
    <small id="hint"></small>
    <br>
    <input type="password" name="password" placeholder="PASSWORD"><br>
    <input type="submit" value="SIGN UP">
  </form>

  </body>
</html>
