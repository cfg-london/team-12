<?php
$databaseInfo = parse_ini_file("../../login.ini.php");
$database = mysqli_connect($databaseInfo['dbIP'], $databaseInfo['dbUser'], $databaseInfo['dbPass'], $databaseInfo['dbDataBase'], $databaseInfo['dbSocket']);
if (!$database) {
    //error connecting
    echo "Error: Unable to connect to MySQL." . PHP_EOL;
    echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
    echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
    exit;
}
//GET THE JOB TITLES
$job_titles = array();
$result = mysqli_query($database, "SELECT job_type FROM jobs;");
foreach ($result as $item) {
    $item = str_replace(" ", "_", $item['job_type']);
    $item = str_replace(",", "", $item);
    array_push($job_titles, $item);
}
//GET THE REFERRAL TYPES
$table = mysqli_query($database, "SELECT * FROM jobs");
$info = mysqli_fetch_fields($table);
$columnNames = array();
foreach ($info as $item) {
    if (!($item-> name == "job_type")) {
        array_push($columnNames, $item->name); //gets the column names
    }
}
//now check for info
$type = $_GET['type'];
$contents = $_GET['contents'];
if ($type == "deviceID") {
    $deviceID = $contents;
    //register deviceID in our push notification table
    mysqli_query($database, "INSERT INTO deviceids VALUES (" . $deviceID . ");");
} elseif ($type == "increment") {
    $contents = explode(",", $contents);
    $valid = in_array($contents[0], $job_titles);
    if ($valid) {
        $contents[0] = str_replace("_", " ", $contents[0]);
    }
    for ($i = 1; $i < count($contents); $i++) {
        if (in_array($contents[$i], $columnNames) && $valid) {
            //update the count in the SQL
            $query = "UPDATE jobs SET " . $contents[$i] . " = " . $contents[$i] . " + 1 WHERE job_type = \"" . $contents[0] . "\"";
            mysqli_query($database, $query);
        }
    }
}
/**
 * Created by PhpStorm.
 * User: James
 * Date: 18/11/2017
 * Time: 05:40
 */