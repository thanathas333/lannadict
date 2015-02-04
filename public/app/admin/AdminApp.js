/**
 * Created by ZAM on 2/4/2015.
 */


var app = angular.module ( "AdminApp", [ ] ) ;

app.controller ( 'ListCtrl', function ( $scope, $http ) {
    console.log ( "ListCtrl..." ) ;
    $scope.users = [];

    $http({
        url : "/get-users",
        method : "get"
    } ).success(function(response){
        $scope.users = response;
    })

} ) ;