var app = angular.module("piadaapp", []);

app.controller("piadactrl", function($scope, $http){
    $scope.salvar = function(piada){
        $scope.enviando=true;
        console.log(piada);   
        $http.post("http://piada.herokuapp.com/piada", piada)
                .then(function(){
                    $scope.enviando=false;
                    $scope.mensagem="Piada cadastrada com sucesso!";
                }, function(){
                    $scope.enviando=false;
                    $scope.mensagem="Erro no cadastro!"
                });
        console.log("foi");
        
    }
    
    $scope.listar = function(piada){
        $scope.buscando = true;
        $http.get("http://piada.herokuapp.com/piada")
                .then(function(result){
                    $scope.buscando = false;
                    console.log(result);
                    $scope.piadas = result.data;
                },function(erro){
                    $scope.buscando = false;
                    console.log(erro);                    
                });
    }
    
});