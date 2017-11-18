<?php
session_start();
$username = $_POST['username'];
$password = $_POST['pass'];
$updateDetails = $_POST['update'];
function updateHash($match) {
    return "hashedPassword = " . password_hash($_POST['pass'], PASSWORD_DEFAULT);
}
function updateNewName($match) {
    return "username = " . $_POST['newUsername'];
}
function updateNewPass($match) {
    return "hashedPassword = " . password_hash($_POST['newPass'], PASSWORD_DEFAULT);
}
if ($updateDetails) {
    $result = preg_replace_callback("(hashedPassword = [^\n]*)", 'updateNewPass', file_get_contents("../../login.ini.php"));
    $result = preg_replace_callback("(username = [^\n]*)", 'updateNewName', $result);
    file_put_contents("../../login.ini.php", $result);
    $username = $_POST['newUsername'];
    $password = $_POST['newPass'];
    $_SESSION['updated'] = "Password Updated <br>";
}
$serverLoginDetails = parse_ini_file("../../login.ini.php");
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
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="placeholder.css">
    <title>Admin Page</title>
</head>
<body>
<?php
    require '../header.html';
?>
<div id="container">
    <div>
        <?php echo $_SESSION['updated']; $_SESSION['updated'] = ""; ?>
        Update Login:
        <form id="newLogin" name="newLogin" method="POST" action="admin_page.php">
            New Username: <input type="text" name="newUsername" id="newUsername" />
            New Password: <input type="password" name="newPass" id="newPass" />
            <input type="submit" name="update" id="update" value="Update" />
        </form>
    </div>
<?php
    if (password_needs_rehash($serverLoginDetails['hashedPassword'], PASSWORD_DEFAULT)) {
        $result = preg_replace_callback("(hashedPassword = [^\n]*)", 'updateHash', file_get_contents("../../login.ini.php"));
        file_put_contents("../../login.ini.php", $result);
        //this updates the hash stored in the ini if required
    }
    //now connect to SQL server
    $databaseInfo = parse_ini_file("../../login.ini.php");
    $database = mysqli_connect($databaseInfo['dbIP'], $databaseInfo['dbUser'], $databaseInfo['dbPass'], $databaseInfo['dbDataBase'], $databaseInfo['dbSocket']);
    if (!$database) {
        //error connecting
        echo "Error: Unable to connect to MySQL." . PHP_EOL;
        echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
        echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
        exit;
    }

}
?>

    </div>
</body>
<?php
/**
 * Created by PhpStorm.
 * User: James
 * Date: 17/11/2017
 * Time: 21:26
 */
?>

