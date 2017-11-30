<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="style/login.css">
<link rel="stylesheet" href="style/register.css">
<link rel="stylesheet" href="style/forgotPassword.css">

<style type="text/css"></style>
</head>

<body ng-app="toDo">
	<div ui-view></div>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.3/angular-ui-router.min.js"></script>

<script type="text/javascript" src="script/app.js"></script>

<script type="text/javascript" src="service/loginService.js"></script>
<script src="controller/loginController.js"></script>

<script type="text/javascript" src="service/registerService.js"></script>
<script src="controller/registerController.js"></script>

<script type="text/javascript" src="service/forgotPasswordService.js"></script>
<script src="controller/forgotPasswordController.js"></script>

</html>




















<!-- <html>
<head>

<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>

</head>
<body ng-app="myApp">
	<div layout="column" layout-padding ng-cloak>

		<br/>
		<md-content class="md-no-momentum"> <md-input-container
			class="md-icon-float md-block"> Use floating label instead of placeholder
		<label>Name</label> <md-icon md-svg-src="img/icons/ic_person_24px.svg"
			class="name"></md-icon> <input ng-model="user.name" type="text">
		</md-input-container> <md-input-container md-no-float class="md-block">
		<md-icon md-svg-src="img/icons/ic_phone_24px.svg"></md-icon> <input
			ng-model="user.phone" type="text" placeholder="Phone Number">
		</md-input-container> <md-input-container class="md-block"> Use floating placeholder instead of label
		<md-icon md-svg-src="img/icons/ic_email_24px.svg" class="email"></md-icon>
		<input ng-model="user.email" type="email"
			placeholder="Email (required)" ng-required="true"> </md-input-container> </md-content>

	</div>
</body>
<script>
	var app = angular.module('myApp', [ 'ngMaterial' ]);
</script>
</html> -->