package br.com.eai.recruiting.livecode.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eai.recruiting.livecode.domain.Cep;
import br.com.eai.recruiting.livecode.endpoint.AdressEndPoint;
import br.com.eai.recruiting.livecode.exception.DuplicatedException;
import br.com.eai.recruiting.livecode.repository.AddressRepository;
import br.com.eai.recruiting.livecode.request.AddressRequest;

@Service
public class AddressService {

	
	@Autowired
	private AdressEndPoint adressEndPoint;
	
	@Autowired
	private AddressRepository adress;
    /*
        TODO: Cadastrar um novo endereço e busca conforme a versao abaixo:
         v1 - viacep => https://viacep.com.br/
         v2 - correiosapi => https://correiosapi.apphb.com/
     */
    public Cep create(AddressRequest addressRequest){
    	Cep cep = null;
    	if(addressRequest.getVersion().equals(1)){
    		cep = getCep(addressRequest);    		
    	}else{
    		cep = new Cep();
    	}
    	
    	adress.save(cep);
    	
    	return cep;
    }


	private Cep getCep(AddressRequest addressRequest) {
		return adressEndPoint.getCep(addressRequest.getZipCode());
	}
    
    
    public void duplicatedVerify(List<AddressRequest> addressRequest) {
    	HashMap<String,AddressRequest> verify = new HashMap<String,AddressRequest>();
    	ArrayList<Cep> ceps = new ArrayList<>();
    	
    	for (AddressRequest adress : addressRequest) {
    		
    		
    		if(verify.containsKey(adress.getZipCode()+"_"+adress.getNumber())){
    			throw new DuplicatedException();
    		}
    		verify.put(adress.getZipCode()+"_"+adress.getNumber(), adress);
    		ceps.add(getCep(adress));
		}
    	adress.saveAll((Iterable) ceps);
    }
}
