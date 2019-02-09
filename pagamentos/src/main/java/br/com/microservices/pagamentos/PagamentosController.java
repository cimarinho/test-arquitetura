package br.com.microservices.pagamentos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentosController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IntegracaoSerasaProxy proxy;

	@GetMapping("/pagamentos/{idUsuario}")
	public ResponseEntity<Void> pagamentosRealizados(@PathVariable Long idUsuario) {

		//TODO envia dados mainframe

		//Envia Integracao serasa
		ResponseEntity<Void> response = proxy.reativarUsuario(idUsuario);

		logger.info("Integracao serasa status = "+response.getStatusCode());

		if (HttpStatus.ACCEPTED.equals(response.getStatusCode())){
			//TODO alguma acao
		}

		logger.info("{}",response);

		return new ResponseEntity(HttpStatus.CREATED);

	}


}
