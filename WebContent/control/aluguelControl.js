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
	    $scope.mensagens = [];
	}

	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

	
	$scope.salvar = function() {    	
    	if ($scope.aluguel.codigo == undefined || $scope.aluguel.codigo == '') {    		
			$http.post(url,$scope.aluguel).success(function(aluguelRetornado) {
				$scope.alugueis.push(aluguelRetornado);
				$scope.novo();
				$scope.mensagens.push('Aluguel salvo com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar aluguel: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.aluguel).success(function(aluguel) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Aluguel atualizado com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.aluguel.codigo == '') {
			alert('Selecione um aluguel');
		} else {
			urlExcluir = url+'/'+$scope.aluguel.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Aluguel excluído com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir aluguel: '+erro);
			});
		}
	}
	
	
	$scope.seleciona = function(aluguelTabela) {
		$scope.aluguel = aluguelTabela;
	}
});