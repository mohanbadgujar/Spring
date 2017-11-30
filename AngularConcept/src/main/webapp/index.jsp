<!DOCTYPE html>
<html>
<head>
  <title>Angular Concepts</title>
</head>
<link rel="stylesheet" href="css/app.css">
<body ng-app="F1FeederApp" ng-controller="driversController">

<input type="text" ng-model="searchFilter" placeholder="Search..."/>

  <table>
    <thead>
      <tr><th colspan="4">Drivers Championship Standings</th></tr>
    </thead>
    <tbody>
      
      <tr ng-repeat="driver in driversList | filter: searchFilter">
        <td>{{$index + 1}}</td>
        <td>
          <img src="img/flags/{{driver.nationality}}.png" />
          {{driver.Driver.givenName}}&nbsp;{{driver.Driver.familyName}}
        </td>
        <td>{{driver.Constructors[0].name}}</td>
        <td>{{driver.points}}</td>
      </tr>
    </tbody>
  </table>
  
  <script src="bower_components/angular/angular.js"></script>
  <script src="bower_components/angular-route/angular-route.js"></script>
  <script src="js/app.js"></script>
  <script src="js/services.js"></script>
  <script src="js/controllers.js"></script>
  
</body>
</html>