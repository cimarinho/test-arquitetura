package br.com.microservices.integracaoserasa;

import br.com.microservices.integracaoserasa.bean.DadosUsuarioBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegracaoSerasaController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Configuration configuration;

	@GetMapping("/serasa/reativar/usuario/{idUsuario}")
	@HystrixCommand(fallbackMethod="fallbackIntegracaoSerasa")
	public ResponseEntity<Void> reativarUsuario(@PathVariable("idUsuario") Long idUsuario) {

		String url = this.configuration.getUrl();

		System.out.println("URL = "+url);

		//Recupera dados do usuario para mandar serasa
		DadosUsuarioBean dadosUsuarioBean = new DadosUsuarioBean();
		// enviar (serviço serasa)

		return new ResponseEntity(HttpStatus.CREATED);
	}

	@GetMapping("/serasa/reativar-erro/usuario/{idUsuario}")
	@HystrixCommand(fallbackMethod="fallbackIntegracaoSerasa")
	public ResponseEntity<Void>  reativarUsuarioErro(@PathVariable("idUsuario") Long idUsuario) {
		logger.error("erro no servico");
		throw new RuntimeException("Not available");
	}


	public ResponseEntity<Void> fallbackIntegracaoSerasa(Long idUsuario) {
		logger.error("ERRO NO ENVIO");

		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

}
