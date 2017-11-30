var toDo = angular.module('toDo');

toDo.controller('resetPasswordController', function($scope, resetPasswordService,$location){
	
	$scope.resetUser = function(){
		var a= resetPasswordService.resetUser($scope.user,$scope.error);
			a.then(function(response) {
				
				$location.path("/login");
				
			},function(response){
				$scope.error=response.data.msg;
			});
	}
	
});
