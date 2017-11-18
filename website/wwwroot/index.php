<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        <?php
          //first connect to SQL server
          $databaseInfo = parse_ini_file("../login.ini.php");
          $database = mysqli_connect($databaseInfo['dbIP'], $databaseInfo['dbUser'], $databaseInfo['dbPass'], $databaseInfo['dbDataBase'], $databaseInfo['dbSocket']);
          if (!$database) {
              //error connecting
              echo "Error: Unable to connect to MySQL." . PHP_EOL;
              echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
              echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
              exit;
          }
          //get all data from table
          $query = "SELECT * FROM jobs;";
          $table = mysqli_query($database, $query);
          $info = mysqli_fetch_fields($table);
          $columnNames = array();
          $variableNames = array();
          foreach ($info as $item) {
              array_push($columnNames, $item->name); //gets the column names
          }
          while ($row = mysqli_fetch_row($table)) {
              //for each job/row
              $counter = 0;
              foreach($row as $item) {
                  $columnName = $columnNames[$counter];
                  if ($counter == 0) {
                    //title of chart
                    $item = preg_replace("( )", "_", $item);
                    $item = str_replace(",", "", $item);
                    array_push($variableNames, $item);
                    echo "\n\t\tvar " . $item . " = google.visualization.arrayToDataTable([\n\t\t['Referral Type', 'Frequency']";
                  } else {
                      $columnName = str_replace("_", " ", ucfirst($columnName));
                    echo ",\n\t\t['" . $columnName . "', " . $item . "]";
                  }
                  //for each referral type/column
                  $counter++;
              }
              //end of current var
              echo "]);\n\t\t";
          }
          ?>
        var options = {
          title: 'Job Types - Referral Types'
        };
        <?php
            $graphType = "PieChart";
            echo "\n\t\t";
            foreach($variableNames as $name) {
                echo "var chart" . $name . " = new google.visualization." . $graphType . "(document.getElementById('htmlChart" . $name . "'));\n\t\t";
            }
            echo "\n\t\t";
            foreach($variableNames as $name) {
                echo "chart" . $name . ".draw(" . $name . ", options);\n\t\t";
            }
        ?>
}
    </script>
  </head>
  <body>
  <?php
  require 'header.html';
  ?>
  <table align="center">
      <tr valign="top">
        <?php
            $counter = 0;
            echo "<tr>";
            foreach($variableNames as $name) {
                if ($counter == 2) {
                    echo "\n\t\t</tr>\n\t\t<tr>";
                    $counter = 0;
                }
                echo "\n\t\t\t<td colSpan=1>";
                echo "\n\t\t\t\t<div id=\"htmlChart" . $name . "\" style=\"width: 900px; height: 500px;\"></div>";
                echo "\n\t\t\t</td>";
                $counter++;
            }
            echo "\n\t\t</tr>\n";
        ?>
    </table>
  </body>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</html>
