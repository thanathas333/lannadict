/**
 * Created by ZAM on 3/11/2015.
 */

var app = angular.module("SearchApp",['ui.bootstrap']);

app.controller('SearchCtrl',function($scope,$http,$location){
    console.log("SearchCtrl...");

    $scope.search = {};
    $scope.results = [];

    $scope.firstSearch = false;

    $scope.submitForm = function(){
        console.log("submit...");
        $scope.firstSearch = true;
        $http({
            url : "/search",
            method : 'post',
            data : $scope.search
        } ).success(function(response){
            $scope.results = response;
        })
    }
});