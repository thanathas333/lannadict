/**
 * Created by ZAM on 2/24/2015.
 */

/**
 * Created by ZAM on 2/5/2015.
 */


var app = angular.module ( "WordApp", [ ] ) ;

app.controller ( 'WordCtrl', function ( $scope, $http ) {
    console.log ( "WordCtrl..." ) ;
    $scope.words = [];

    $scope.word = {};

    $scope.editWord={};


    $scope.save(function(){
        $http ({
            url : "/word-add",
            method : "post",
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
            url : "/api/word/save",
            method : "post",
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

    $scope.delete(function(word){

        var admins = $scope.words.adminsOf(word);

        if (confirm(" คุณแน่ใจว่าจะลบ คำศัพท์คำนี้ ("+word.id+") ?"))

            $http({
                url : "/api/word/delete",
                method : "post",
                data : word
            }).success(function(response){
                $scope.words.splice(admins,1);

                )}

    }

})

} ) ;