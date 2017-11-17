<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="placeholder.css">
    <title>Admin Page</title>
</head>
<body>
<?php
    require 'verify_login.php';
?>
<form id="login" name="login" method="POST" action="verify()">
    Username: <input type="text" name="username" id="username" />
    Password: <input type="password" name="pass" id="pass" />
    <input type="submit" name="submit" id="submit" value="Login" />
</form>
</body>
</html>
<?php
/**
 * Created by PhpStorm.
 * User: James
 * Date: 17/11/2017
 * Time: 21:13
 */