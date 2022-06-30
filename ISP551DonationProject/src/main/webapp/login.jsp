<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<title>Log In</title>
<style>
*{
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  font-family: Georgia, serif;
}

body {
    background-color: #E5A186;
}
header {
    background-color: #E5A186;
    color: white;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 15vh;
    box-shadow: 5px 5px 10px rgb(0,0,0,0.3);
}
h1 {
    letter-spacing: 1.5vw;
    font-family: 'system-ui';
    text-transform: uppercase;
    text-align: center;
}
main {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 75vh;
    width: 100%;
    background: url(https://c4.wallpaperflare.com/wallpaper/726/526/438/peach-fruit-gradation-blur-wallpaper-preview.jpg) no-repeat center center;
    background-size: cover;
}
.form {
    width: 500px;
    padding: 40px;
    border-radius: 8px;
    background-color: #ebebe0;
    font-family: 'system-ui';
    box-shadow: 5px 5px 10px rgb(0,0,0,0.3);
}
.form > .f {
    text-transform: uppercase;
}
.form > label {
    letter-spacing: 3px;
    font-size: 1rem;
}
.info {
    text-align: center;
    margin-top: 20px;
    letter-spacing: 1px;
}
.field {
    width: 100%;
    border-radius: 6px;
    border-style: solid;
    border-width: 1px;
    padding: 5px 0px;
    text-indent: 6px;
    margin-top: 10px;
    margin-bottom: 20px;
    font-family: 'system-ui';
    font-size: 0.9rem;
    letter-spacing: 2px;
}
.submit {
    border-style: none;
    border-radius: 5px;
    background-color: #ff8080;
    padding: 8px 20px;
    font-family: 'system-ui';
    text-transform: uppercase;
    letter-spacing: .8px;
    display: block;
    margin: auto;
    margin-top: 10px;
    box-shadow: 2px 2px 5px rgb(0,0,0,0.2);
    cursor: pointer;
}


</style>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
</head>
<body>
  <header>
        <h1>Surau As Sakeenah</h1>
  </header>
  <main>
        <form id="loginform" class="form" action="login/login-access.php" method="post">
            <div class="f">
                <label>Login:</label>
                <input id="email" class="field" name="emailtxt" type="email" autofocus required>
                <label>Password:</label>
                <input id="pass" class="field" name="pwtxt" type="password" required>
                <button class="submit" type="submit" form="loginform" onclick="return validarLogin()">Log In</button>
            </div>
            <div class="info">
                <p>Don't have any registered account yet? <a href="signup.jsp">Sign Up</a></p>
            </div>
        </form>
    </main>
</body>
</html>