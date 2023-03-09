<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/reset.css" rel="stylesheet" type="text/css">
    <link href="/css/jcllogin.css" rel="stylesheet" type="text/css">
    <title>OP Manager 로그인</title>
</head>

<body>
    <section class="login-form">
        <h1>OP Manager 로그인</h1>
        <form action="jclLoginCheck" method="post">
            <div class="int-block">
                <input type="text" name="id" id="id" autocomplete="off" required>
                <label for="id">USER ID</label>
            </div>
            <div class="int-block">
                <input type="password" name="pw" id="pw" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <div class="btn-block">
                <button type="submit">LOGIN</button>
            </div>
        </form>
    </section>

</body>
</html>