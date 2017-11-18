<?php
session_start();
$username = $_POST['username'];
$password = $_POST['pass'];
$serverLoginDetails = parse_ini_file("../../login.ini.php");
function updateHash($match) {
    return "hashedPassword = " . password_hash($_POST['pass'], PASSWORD_DEFAULT);
}
if (!($username == $serverLoginDetails['username'] && password_verify($password, $serverLoginDetails['hashedPassword']))) {
    //this is the error message which is outputted onto login page
    $_SESSION['error'] = "<h1>Login details incorrect</h1>";
    header("Location: login.php");
    exit;
} else {
    ?>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<?php
    require '../header.html';
    echo "Password Correct";
    if (password_needs_rehash($serverLoginDetails['hashedPassword'], PASSWORD_DEFAULT)) {
        $result = preg_replace_callback("(hashedPassword = [^\n]*)", 'updateHash', file_get_contents("../../login.ini.php"));
        file_put_contents("../../login.ini.php", $result);
        //this updates the hash stored in the ini if required
    }
}
/**
 * Created by PhpStorm.
 * User: James
 * Date: 17/11/2017
 * Time: 21:26
 */
?>