package br.com.eai.recruiting.livecode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eai.recruiting.livecode.exception.DuplicatedException;
import br.com.eai.recruiting.livecode.request.AddressRequest;
import br.com.eai.recruiting.livecode.response.AddressesResponse;
import br.com.eai.recruiting.livecode.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService service;

	/*
	 * TODO: Cadastrar um novo endereço e busca conforme a versao abaixo: v1 -
	 * viacep => https://viacep.com.br/ v2 - correiosapi =>
	 * https://correiosapi.apphb.com/
	 */

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity create(@RequestBody AddressRequest addressRequest) {

		service.create(addressRequest);

		return ResponseEntity.ok().build();

	}

	/*
	 * TODO: CRIAÇAO DE ENDEREÇOS EM LOTE(LISTA) E NAO PODE TER ENDEREÇO
	 * DUPLICADO NA LISTA! CASO EXISTA, RETORNAR ERRO
	 * 
	 * ZipCode + number
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/create_batch", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity creationBatch(@RequestBody List<AddressRequest> addressRequest) {
		try {
			service.duplicatedVerify(addressRequest);
		} catch (DuplicatedException e) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok().build();

	}

	/*
	 * TODO: Buscar todos os endereços cadastrados no BD pelo CEP informado e
	 * com paginação
	 */
	@GetMapping
	public AddressesResponse getAllByZipCode(String zipCode, Integer pageCurrent, Integer limit) {

		return new AddressesResponse();
	}

}
