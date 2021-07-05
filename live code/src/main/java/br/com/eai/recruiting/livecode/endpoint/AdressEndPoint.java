package br.com.eai.recruiting.livecode.endpoint;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.eai.recruiting.livecode.domain.Cep;

@FeignClient(value = "liveCode", url = "https://viacep.com.br/ws/")
public interface AdressEndPoint {

	@RequestMapping(method = RequestMethod.GET, value = "{cep}/json/")
	Cep getCep(@PathVariable("cep") String cep);
	

}
