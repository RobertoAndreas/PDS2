var app = angular.module('bicicletaModule',[]);

app.controller('bicicletaControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaAlugaBicicleta/rs/bicicleta';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (bicicletasRetorno) {
			$scope.bicicletas = bicicletasRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.bicicleta = {};
	}

    $scope.salvar = function() {
		if ($scope.bicicleta.codigo == '') {
			$http.post(url,$scope.bicicleta).success(function(bicicleta) {
				$scope.bicicletas.push($scope.bicicleta);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.bicicleta).success(function(bicicleta) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.bicicleta.codigo == '') {
			alert('Selecione uma bicicleta');
		} else {
			urlExcluir = url+'/'+$scope.bicicleta.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(bicicletaTabela) {
		$scope.bicicleta = bicicletaTabela;
	}
});