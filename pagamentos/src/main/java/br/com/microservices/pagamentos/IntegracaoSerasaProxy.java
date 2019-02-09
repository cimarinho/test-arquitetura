package br.com.microservices.pagamentos;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="integracao-serasa")
public interface IntegracaoSerasaProxy {

	@GetMapping("/integracao-serasa/serasa/reativar/usuario/{idUsuario}")
    ResponseEntity<Void> reativarUsuario(@PathVariable("idUsuario") Long idUsuario) ;
}
