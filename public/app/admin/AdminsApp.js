

var app = angular.module("AdminsApp", ['ui.router']);

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
                words : function($http){
                    return $http({
                        url: "/get-words",
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
                word : function(){
                    return { data : { } };
                }
            }
        })

        .state('edit',{
            url : "/edit/:id",
            templateUrl: "assets/app/admin/user/form.html",
            controller : "FormCtrl",
            resolve : {
                word : function($http,$stateParams){
                    return $http({
                        url: "/api/word/" + $stateParams.id,
                        method: "get"
                    })
                }
            }
        })



});

app.controller('ListCtrl', function ($scope, $http,words) {
    console.log("ListCtrl...");
    console.log(words);
    $scope.words = words.data;

    $scope.delete = function(word){
        if ( confirm ("Do you want to delete this word[ID :" +word.id +"]  ?")){
            $http ( {
                url : '/api/word/delete',
                method : 'post',
                data : word
            } ).success ( function ( response ) {
                index = $scope.words.indexOf(word);
                $scope.words.splice(index,1);
            } )
        }
    }


});

app.controller('FormCtrl',function($scope,$http,$state,word){

    $scope.word = word.data;

    $scope.submitForm = function(){
        $http ( {
            url : '/api/word/save',
            method : 'post',
            data : $scope.word
        } ).success ( function ( response ) {
            $state.go('list');
        } )
    }

});