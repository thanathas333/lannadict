/**
 * Created by ZAM on 2/5/2015.
 */


var app = angular.module ( "AdminsApp", [ ] ) ;

app.controller ( 'ListCtrl', function ( $scope, $http ) {
    console.log ( "ListCtrl..." ) ;
    $scope.words = [];

    $scope.word ={};


    $http({
        url : "/get-words",
        method : "get"
    } ).success(function(response){
        $scope.words = response;
    })

    $scope.save=function(){
        console.log($scope , word);
    }

} ) ;