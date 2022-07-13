package br.com.ats.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ats.dsmeta.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

	
}
