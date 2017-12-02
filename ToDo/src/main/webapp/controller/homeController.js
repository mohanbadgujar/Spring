var toDo = angular.module('toDo');

toDo.controller('homeController', function($scope,$location){
	
	$scope.logout = function() {
		localStorage.removeItem('token');
	}

});
