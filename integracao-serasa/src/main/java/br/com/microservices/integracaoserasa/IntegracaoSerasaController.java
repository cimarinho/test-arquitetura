package br.com.microservices.integracaoserasa;

import br.com.microservices.integracaoserasa.bean.DadosUsuarioBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class IntegracaoSerasaController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Configuration configuration;

	@GetMapping("/pagamentos/{idUsuario}")
	@HystrixCommand(fallbackMethod="fallbackIntegracaoSerasa")
	public ResponseEntity<Void> pagamentoRealizado(@PathParam("idUsuario") Long idUsuario) {

		String url = this.configuration.getUrl();

		//Recupera dados do usuario para mandar serasa
		DadosUsuarioBean dadosUsuarioBean = new DadosUsuarioBean();
		// enviar (serviço serasa)

		return new ResponseEntity(HttpStatus.CREATED);
	}



	public void fallbackIntegracaoSerasa() {
		logger.error("ERRO NO ENVIO");

		//enviar fila
	}

}
