package com.festas.SID.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.festas.SID.domain.model.Cliente;

public interface ClienteRepository  extends CustomJpaRepository<Cliente, Long>, ClienteRepositoryQueries,
JpaSpecificationExecutor<Cliente> {
	
	List<Cliente> findTodasByNomeContaining(String nome);

	
	@Query("from Cliente where cpf_cnpj = :cpf_cnpj")
	Cliente consultarPorCpfCnpj(@Param("cpf_cnpj") String cpf_cnpj);
	
	// boolean existsByNome(String cpf_cnpj);
	
	
	
}
