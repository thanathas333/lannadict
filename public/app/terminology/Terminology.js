var TerminologyApp = angular.module("TerminologyApp", ['ui.router']);

TerminologyApp.config(function ($stateProvider, $urlRouterProvider) {
    //
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/list");
    //
    // Now set up the states
    $stateProvider
        .state('list', {
            url: "/list",
            templateUrl: "assets/app/terminology/terminologyword/list.html",
            controller: "ListCtrl",
            resolve: {
                words: function ($http) {
                    return $http({
                        url: "/get-words",
                        method: "get"
                    })
                }
            }
        })
        .state('add', {
            url: "/add",
            templateUrl: "/assets/app/terminology/terminologyword/form.html",
            controller: "FormCtrl",
            resolve: {
                word: function () {
                    return {data: {}};
                }
            }
        })

        .state('edit', {
            url: "/edit/:id",
            templateUrl: "assets/app/terminology/terminologyword/form.html",
            controller: "FormCtrl",
            resolve: {
                word: function ($http, $stateParams) {
                    return $http({
                        url: "/api/word/" + $stateParams.id,
                        method: "get"
                    })
                }
            }
        })
});

TerminologyApp.controller('ListCtrl', function ($scope, $http,words) {
    console.log("ListCtrl...");
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

TerminologyApp.controller('FormCtrl', function ($scope, $http, $state, word) {

    $scope.word = word.data;

    $scope.submitForm = function () {
        $http({
            url: '/api/word/save',
            method: 'post',
            data: $scope.word
        }).success(function (response) {
            $state.go('list');
        })
    }

});