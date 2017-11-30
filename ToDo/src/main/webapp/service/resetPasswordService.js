var toDo = angular.module('toDo');

toDo.factory('resetPasswordService', function($http, $location) {

	var abc = {};
	
	abc.resetUser = function(user) {
		return $http({
			method : "POST",
			url : '/resetPassword/{token:.+}',
			data : user
		})
	}
	return abc;
});
