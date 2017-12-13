angular.module('F1FeederApp.services', [])
  .factory('ergastAPIservice', function($http, $sce) {
	  console.log("services");

    var ergastAPI = {};

    ergastAPI.getDrivers = function() {
      return $http({
        method: 'JSONP', 
        url: $sce.trustAsResourceUrl('http://ergast.com/api/f1/2013/driverStandings.json'),
        jsonpCallbackParam: 'callback'
      });
    }

    ergastAPI.getDriverDetails = function(id) {
    	console.log("printing here also");
      return $http({
    	  
      
        method: 'JSONP', 
        url: $sce.trustAsResourceUrl('http://ergast.com/api/f1/2013/drivers/'+ id +'/driverStandings.json'),
		jsonpCallbackParam: 'callback'
      });
    }
    
    ergastAPI.getDriverRaces = function(id) {
      return $http({
        method: 'JSONP', 
        url: $sce.trustAsResourceUrl('http://ergast.com/api/f1/2013/drivers/'+ id +'/results.json'),
        jsonpCallbackParam: 'JSON_CALLBACK'
      });
    }

    return ergastAPI;
  });