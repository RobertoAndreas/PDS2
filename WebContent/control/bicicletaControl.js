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
    	if ($scope.bicicleta.codigo == undefined || $scope.bicicleta.codigo == '') {    		
			$http.post(url,$scope.bicicleta).success(function(bicicletaRetornado) {
				$scope.bicicletas.push(bicicletaRetornado);
				$scope.novo();
				$scope.mensagens.push('Bicicleta salva com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar bicicleta: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.bicicleta).success(function(bicicleta) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Bicicleta atualizada com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.bicicleta.codigo == '') {
			alert('Selecione um bicicleta');
		} else {
			urlExcluir = url+'/'+$scope.bicicleta.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Bicicleta excluída com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir bicicleta: '+erro);
			});
		}
	}
	
	$scope.seleciona = function(bicicletaTabela) {
		$scope.bicicleta = bicicletaTabela;
	}
});