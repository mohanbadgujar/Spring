angular.module('F1FeederApp', [
  'F1FeederApp.services',
  'F1FeederApp.controllers',
   'ngRoute'
]).
config(['$routeProvider', function($routeProvider) {
	console.log("printing some thing");
	  $routeProvider.
	
		when("/drivers", {templateUrl: "partials/drivers.html", controller: "driversController"}).
		when("/driver/:id", {templateUrl: "partials/driver.html", controller: "driverController"}).
		otherwise({redirectTo: '/drivers'});
}]);