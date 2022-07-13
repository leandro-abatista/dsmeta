package br.com.ats.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ats.dsmeta.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

	/**
	 * BUsca as 20 melhores vendas no intervalo de datas definidos pelo usuário
	 * @param min
	 * @param max
	 * @param pageable
	 * @return
	 */
	@Query("SELECT obj FROM Venda obj WHERE obj.data BETWEEN :min AND :max ORDER BY obj.valor DESC")/*Linguagem JPQL*/
	Page<Venda> findVenda(LocalDate min, LocalDate max, Pageable pageable);
	
}
