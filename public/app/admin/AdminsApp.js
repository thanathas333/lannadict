/**
 * Created by ZAM on 2/5/2015.
 */


var app = angular.module ( "AdminsApp", [ ] ) ;

app.controller ( 'WordCtrl', function ( $scope, $http ) {
    console.log ( "WordCtrl..." ) ;
    $scope.words = [];

    $scope.word = {};

    $scope.editWord={};


    $http({
        url : "/get-words",
        method : "get"
    } ).success(function(response){
        $scope.words = response;
    })

    $scope.save(function(){
        $http ({
            url : '/word-add',
            method : 'post',
            header : 'application/json',
            data : $scope.word
        }).success(function(response){
            $scope.words.push(response)
            $scope.word ={}
        })
    })


    $scope.edit =function(word){
        $scope.editWord= angular.copy(word);

    }

    $scope.editSave=function{
        $http({
            url : '/word-add',
            method : 'post',
            header : 'application/json',
            data : $scope.editWord
        }).success(function(response){
            console.log(response);

            var admins;

            for (i=0;i<$scope.words.length;i++){
                if($scope.words[i].id==response.id){
                    admins = i;
                    break;
                }
            }

            $scope.words.splice(admins,1);
            $scope.words.splice(admins,0,response);
        })

    }

} ) ;