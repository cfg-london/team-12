<?php
$username = $_POST['username'];
$password = $_POST['pass'];
$hash = password_hash($password, PASSWORD_DEFAULT);
function updateHash() {
    return $hash;
}
echo $hash;
$result = preg_replace_callback("(hashedPassword = [^\n]*)", updateHash(), file_get_contents("../../login.ini.php"));
file_put_contents("../../login.ini.php", $result);
$serverLoginDetails = parse_ini_file("../../login.ini.php");
echo "<br>" . $serverLoginDetails['hashedPassword'];
if ($username == $serverLoginDetails['username'] && password_verify($password, $serverLoginDetails['hashedPassword'])) {
    echo "\nsuccess";
} else {
    echo "\npassword incorrect";
}

/**
 * Created by PhpStorm.
 * User: James
 * Date: 17/11/2017
 * Time: 21:26
 */