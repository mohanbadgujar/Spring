/* Drivers controller */
var app= angular.module('F1FeederApp.controllers',[]);

 app.controller('driversController', function($scope, ergastAPIservice) {
	  console.log("contoller");
    $scope.nameFilter = null;
    $scope.driversList = [];
    $scope.searchFilter = function (driver) {
        var re = new RegExp($scope.nameFilter, 'i');
        return !$scope.nameFilter || re.test(driver.Driver.givenName) || re.test(driver.Driver.familyName);
    };

    ergastAPIservice.getDrivers().then(function (response) {
        //Digging into the response to get the relevant data
    	
        $scope.driversList = response.data.MRData.StandingsTable.StandingsLists[0].DriverStandings;
      
    });
  });

  /* Driver controller */

app.controller('driverController', function($scope, $routeParams, ergastAPIservice) {
	  console.log("printing here");
    $scope.id = $routeParams.id;
    console.log($scope.id);
    $scope.races = [];
    $scope.driver = null;

    ergastAPIservice.getDriverDetails($scope.id).then(function (response) {
        $scope.driver = response.data.MRData.StandingsTable.StandingsLists[0].DriverStandings[0]; 
    });

    ergastAPIservice.getDriverRaces($scope.id).then(function (response) {
        $scope.races = response.MRData.RaceTable.Races; 
    }); 
  });
