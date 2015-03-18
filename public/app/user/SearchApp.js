/**
 * Created by ZAM on 3/11/2015.
 */

var app = angular.module("SearchApp",[]);

app.controller('SearchCtrl',function($scope,$http){
    console.log("SearchCtrl...");

    $scope.search = {};
    $scope.results = [];

    $scope.submitForm = function(){
        console.log("submit...");

        $http({
            url : "/search",
            method : 'post',
            data : $scope.search
        } ).success(function(response){
            $scope.results = response;

        })

    }

});