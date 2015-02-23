/**
 * Created by ZAM on 2/23/2015.
 */

var app = angula.module('WordApp',[])

app.controller('WordApp',function($scope, $http){
    console.log('WordCtrl...');

    $scope.words;

    $scope.editWord = {};

    $scope.edit = function(word){
        $scope.editWord = angular.copy(word);


    }
    $scope.editSave = function(){
        $http ({
            url: 'api/word/save',
            method: 'post',
            header: 'application/json',
            data: $scope.editWord
        }).success ( function ( response ) {
                console.log(respons);

                var editto;

                    for (i=0;i<$scope.words.length;i++){
                            if($scope.words[i].id==response.id){
                                editto=i;
                                break;
                            }
                    }
                            $scope.words.splice(editto,1);
                             $scope.words.splice(editto,0 response);


                })
        })


    }



})