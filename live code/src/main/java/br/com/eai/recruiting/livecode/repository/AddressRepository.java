package br.com.eai.recruiting.livecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eai.recruiting.livecode.domain.Cep;

@Repository
public interface AddressRepository extends JpaRepository<Cep, Long> {

	
}
