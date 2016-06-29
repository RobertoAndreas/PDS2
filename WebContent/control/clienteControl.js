var app = angular.module('clienteModule',[]);

app.controller('clienteControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SistemaAlugaBicicleta/rs/cliente';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (clientesRetorno) {
			$scope.clientes = clientesRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
			$scope.mensagens.push('Erro ao pesquisar clientes '+mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.cliente = {};
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
		if ($scope.cliente.codigo == '' || $scope.cliente.codigo == undefined) {
			$http.post(url, $scope.cliente).success(function(cliente) {
				$scope.clientes.push($scope.cliente);
				$scope.novo();
				$scope.mensagens.push('Cliente salvo com sucesso!');
				$scope.$parent.alerts.push({type: 'success', msg: 'Saved!'});
			}).error(function (erro) {
				// alert(erro);
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.cliente).success(function(cliente) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente atualizado com sucesso!');
				$scope.$parent.alerts.push({type: 'success', msg: 'Updated!'});
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
				$scope.$parent.alerts.push({type: 'danger', msg: 'Server: '+error.statusText});
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.cliente.codigo == '') {
			alert('Selecione um cliente');
		} else {
			urlExcluir = url+'/'+$scope.cliente.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente excluído com sucesso');
			}).error(function (erro) {
				alert(erro);
				$scope.mensagens.push('Erro ao excluir cliente: '+erro);
			});
		}
	}
	
	$scope.seleciona = function(clienteTabela) {
		$scope.cliente = clienteTabela;
	}
	
});