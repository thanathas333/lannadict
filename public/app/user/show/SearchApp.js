/**
 * Created by ZAM on 3/11/2015.
 */

var app = angular.module("SearchApp",[]);

app.controller('SearchCtrl',function($scope,$http){
    console.log("SearchCtrl...");

    $scope.searches = {};
    $scope.results = [];

    $scope.submitForm = function(){
        console.log("submit...");

        $http({
            url : "/searches",
            method : 'post',
            data : $scope.searches
        } ).success(function(response){
            $scope.results = response;
        })

    }

});