<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="placeholder.css">
    <title>Admin Page</title>
</head>
<body>
<?php
require '../header.html';
echo $_SESSION['error'];
$_SESSION['error'] = "";
?>
<form id="login" name="login" method="POST" action="admin_page.php">
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