/**
 * Created by ZAM on 2/4/2015.
 */

var app = angular.module("AdminApp", ['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider) {
    //
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/list");
    //
    // Now set up the states
    $stateProvider
        .state('list', {
            url: "/list",
            templateUrl: "assets/app/admin/user/list.html",
            controller: "ListCtrl",
            resolve : {
                users : function($http){
                    return $http({
                        url: "/get-users",
                        method: "get"
                    })
                }
            }
        })
        .state('add', {
            url: "/add",
            templateUrl: "assets/app/admin/user/form.html",
            controller : "FormCtrl",
            resolve : {
                user : function(){
                    return { data : { } };
                }
            }
        })

        .state('edit',{
            url : "/edit/:id",
            templateUrl: "assets/app/admin/user/form.html",
            controller : "FormCtrl",
            resolve : {
                user : function($http,$stateParams){
                    return $http({
                        url: "/api/user/" + $stateParams.id,
                        method: "get"
                    })
                }
            }
        })



});

app.controller('ListCtrl', function ($scope, $http,users,$timeout) {
    console.log("ListCtrl...");
    console.log(users);
    $scope.users = users.data;

    $scope.delete = function(user){
        if ( confirm ("Do you want to delete this users[ID :" +user.id +"]  ?")){
            $http ( {
                url : '/api/user/delete',
                method : 'post',
                data : user
            } ).success ( function ( response ) {
                index = $scope.users.indexOf(user);
                $scope.users.splice(index,1);
            } )
        }
    }

    $timeout(function(){
        $("#listUser").dataTable();
    },100)


});

app.controller('FormCtrl',function($scope,$http,$state,user){

    $scope.user = user.data;

    $http({
        url : '/api/status/all',
        method : 'get'
    } ).success(function(response){
        $scope.statuss = response;
    })

    $scope.submitForm = function(){
        $http ( {
            url : '/api/user/save',
            method : 'post',
            data : $scope.user
        } ).success ( function ( response ) {
            $state.go('list');
        } )
    }

});