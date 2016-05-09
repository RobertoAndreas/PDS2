var app = angular.module('aluguelModule',[]);

app.controller('aluguelControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaAlugaBicicleta/rs/aluguel';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (alugueisRetorno) {
			$scope.alugueis = alugueisRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.aluguel = {};
	}

    $scope.salvar = function() {
		if ($scope.aluguel.codigo == '') {
			$http.post(url,$scope.aluguel).success(function(aluguel) {
				$scope.alugueis.push($scope.aluguel);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.aluguel).success(function(aluguel) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.aluguel.codigo == '') {
			alert('Selecione um Aluguel');
		} else {
			urlExcluir = url+'/'+$scope.aluguel.codigo;
			$http,delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(aluguelTabela) {
		$scope.aluguel = aluguelTabela;
	}
});