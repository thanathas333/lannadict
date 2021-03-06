/**
 * Created by ZAM on 2/4/2015.
 */


var app = angular.module("UserApp", ['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider) {
    //
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/list");
    //
    // Now set up the states
    $stateProvider
        .state('list', {
            url: "/list",
            templateUrl: "assets/app/user/list/list.html",
            controller: "ListCtrl",
            resolve : {
                terminologys : function($http){
                    return $http({
                        url: "/get-terminologys",
                        method: "get"
                    })
                }
            }
        })
        .state('add', {
            url: "/add",
            templateUrl: "assets/app/admin/word/form1.html",
            controller : "FormCtrl",
            resolve : {
                terminology : function(){
                    return { data : { } };
                }
            }
        })

        .state('edit',{
            url : "/edit/:id",
            templateUrl: "assets/app/admin/word/form1.html",
            controller : "FormCtrl",
            resolve : {
                terminology : function($http,$stateParams){
                    return $http({
                        url: "/api/terminology/" + $stateParams.id,
                        method: "get"
                    })
                }
            }
        })



});

app.controller('ListCtrl', function ($scope, $http,terminologys) {
    console.log("ListCtrl...");
    console.log(terminologys);
    $scope.terminologys = terminologys.data;

    $scope.delete = function(terminology){
        if ( confirm ("Do you want to delete this terminology[ID :" +terminology.id +"]  ?")){
            $http ( {
                url : '/api/terminology/delete',
                method : 'post',
                data : terminology
            } ).success ( function ( response ) {
                index = $scope.terminologys.indexOf(terminology);
                $scope.terminologys.splice(index,1);
            } )
        }
    }


});

app.controller('FormCtrl',function($scope,$http,$state,terminology){

    $scope.terminology = terminology.data;

    $http({
        url : '/api/comment/all',
        method : 'get'
    } ).success(function(response){
        $scope.comments = response;
    })


    $scope.submitForm = function(){
        $http ( {
            url : '/api/terminology/save',
            method : 'post',
            data : $scope.terminology
        } ).success ( function ( response ) {
            $state.go('list1');
        } )
    }

});


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