<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var data1 = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var data2 = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var data3 = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        var chart1 = new google.visualization.PieChart(document.getElementById('piechart1'));
        var chart2 = new google.visualization.PieChart(document.getElementById('piechart2'));
        var chart3 = new google.visualization.PieChart(document.getElementById('piechart3'));

        chart.draw(data, options);
        chart1.draw(data1, options);
        chart2.draw(data2, options);
        chart3.draw(data3, options);
      }
    </script>
  </head>
  <body>
  <?php
  require 'header.html';
  //now connect to SQL server
  $databaseInfo = parse_ini_file("../login.ini.php");
  $database = mysqli_connect($databaseInfo['dbIP'], $databaseInfo['dbUser'], $databaseInfo['dbPass'], $databaseInfo['dbDataBase'], $databaseInfo['dbSocket']);
  if (!$database) {
      //error connecting
      echo "Error: Unable to connect to MySQL." . PHP_EOL;
      echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
      echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
      exit;
  }
  $query = "SELECT * FROM jobs;";
  $table = mysqli_query($database, $query);
  $info = mysqli_fetch_fields($table);
  echo "<table class='table'>";
  echo "<tr>";
  foreach ($info as $item) {
    echo "<th>" . $item->name . "</th>";
  }
  while ($row = mysqli_fetch_row($table)) {
      echo "<tr>";
      foreach($row as $item) {
          echo "<td>" . $item . "</td>";
      }
      echo "</tr>";
  }
  ?><table align="center">
      <tr valign="top">
        <td colSpan=1>
          <div id="piechart" style="width: 900px; height: 500px;"></div>
        </td>
        <td colSpan=1>
          <div id="piechart1" style="width: 900px; height: 500px;"></div>
        </td>
      </tr>
      <tr>
        <td colSpan=1>
          <div id="piechart2" style="width: 900px; height: 500px;"></div>
        </td>
        <td colSpan=1>
          <div id="piechart3" style="width: 900px; height: 500px;"></div>
        </td>
      </tr>
    </table>



  </body>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</html>
