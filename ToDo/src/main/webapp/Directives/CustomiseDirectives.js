var app = angular.module("toDo");

app.directive("topNavigationBar", function() {
    return {
    	templateUrl :'template/topNavigationBar.html'
    };
});

app.directive("sideNavigationBar", function() {
    return {
    	templateUrl :'template/sideNavigationBar.html'
    };    
});

/*app.directive("addNote", function() {
    return {
    	templateUrl :'template/addNote.html'
    };    
});*/