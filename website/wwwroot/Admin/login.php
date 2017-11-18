<?php
session_start();
$err = $_GET['err'];
?>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="placeholder.css">
    <title>Login Page</title>
</head>
<body>
<?php
require '../header.html';
if ($err) {
    echo $_SESSION['error'];
    $_SESSION['error'] = "";
}
?>
<form id="login" name="login" method="POST" action="admin_page.php">
  <div class ="form-group">
    Username: <input type="text"  name="username" id="username" />
  </div>
  <div class ="form-group">
    Password: <input type="password" name="pass" id="pass" />
  </div>

    <input type="submit" name="submit" id="submit" value="Login" />
</form>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</html>
<?php
/**
 * Created by PhpStorm.
 * User: James
 * Date: 17/11/2017
 * Time: 21:13
 */
