<?php
session_start();
define( 'API_ACCESS_KEY', 'ACCESS-KEY' ); //PUT API ACCESS KEY IN HERE
$username = $_POST['username'];
$password = $_POST['pass'];
$updateDetails = $_POST['update'];
$sendMessage = $_POST['sendNotification'];
function updateHash($match)
{
    return "hashedPassword = " . password_hash($_POST['pass'], PASSWORD_DEFAULT);
}

function updateNewName($match)
{
    return "username = " . $_POST['newUsername'];
}

function updateNewPass($match)
{
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
if ($sendMessage) {
    $message = $_POST['message'];
    file_put_contents("message.txt", $message);
//    //send push notification
//    $databaseInfo = parse_ini_file("../../login.ini.php");
//    $database = mysqli_connect($databaseInfo['dbIP'], $databaseInfo['dbUser'], $databaseInfo['dbPass'], $databaseInfo['dbDataBase'], $databaseInfo['dbSocket']);
//    if (!$database) {
//        //error connecting
//        echo "Error: Unable to connect to MySQL." . PHP_EOL;
//        echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
//        echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
//        exit;
//    }
//    //GET IDs
//    $result = mysqli_query($database, "SELECT * FROM deviceids");
//    $deviceIDs = array();
//    while ($row = mysqli_fetch_row($result)) {
//        foreach($result as $item) {
//            array_push($deviceIDs, $item['id']);
//        }
//    }
//    $notification = array(
//            'message' => $message,
//            'title' => "Notification"
//    );
//    $fields = array (
//        'registration_ids' => $deviceIDs,
//        'data' => $notification
//    );
//    $headers = array (
//        'Authorization: key=' . API_ACCESS_KEY,
//        'Content-Type: application/json'
//    );
//    $ch = curl_init();
//    curl_setopt( $ch,CURLOPT_URL, 'https://android.googleapis.com/gcm/send' );
//    curl_setopt( $ch,CURLOPT_POST, true );
//    curl_setopt( $ch,CURLOPT_HTTPHEADER, $headers );
//    curl_setopt( $ch,CURLOPT_RETURNTRANSFER, true );
//    curl_setopt( $ch,CURLOPT_SSL_VERIFYPEER, false );
//    curl_setopt( $ch,CURLOPT_POSTFIELDS, json_encode( $fields ) );
//    $result = curl_exec($ch );
//    curl_close( $ch );
//    echo $result;
}
$serverLoginDetails = parse_ini_file("../../login.ini.php");
if (!($username == $serverLoginDetails['username'] && password_verify($password, $serverLoginDetails['hashedPassword'])) && !$sendMessage) {
    //this is the error message which is outputted onto login page
    $_SESSION['error'] = "<h1>Login details incorrect</h1>";
    header("Location: login.php?err=true");
    exit;
} else {
?>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
      integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="placeholder.css">
    <title>Admin Page</title>
</head>
<body>
<?php
require '../header.html';
?>
<div class="container">
    <div class="row float-right">
        <?php echo $_SESSION['updated'];
        $_SESSION['updated'] = ""; ?>
        <div class="col">
            <form id="sendMessage" name="sendMessage" method="POST" action="admin_page.php">
                <h4>Send a notification to all mobile app users</h4>
                Message: <input type="text" name="message" id="message"/>
                <input type="submit" name="sendNotification" id="sendNotification" value="Send"/>
            </form>
        </div>
        <form id="newLogin" name="newLogin" method="POST" action="admin_page.php">

            <div class="col-md-4 float-right text-center">
                <h4>Update Admin Login:</h4>
                New Username: <input type="text" name="newUsername" id="newUsername"/>
                New Password: <input type="password" name="newPass" id="newPass"/>
                <input type="submit" name="update" id="update" value="Update"/>
            </div>
        </form>
    </div>
</div>
<?php
if (password_needs_rehash($serverLoginDetails['hashedPassword'], PASSWORD_DEFAULT)) {
    $result = preg_replace_callback("(hashedPassword = [^\n]*)", 'updateHash', file_get_contents("../../login.ini.php"));
    file_put_contents("../../login.ini.php", $result);
    //this updates the hash stored in the ini if required
}
//TODO TEXT BOX AND SUBMIT BUTTON TO NOTIFY THE APP USERS
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

