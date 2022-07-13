package br.com.ats.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ats.dsmeta.entities.Venda;
import br.com.ats.dsmeta.repositories.VendaRepository;

/**
 * Classe responsável por fazer operações com vendas
 * @author leand
 *
 */
@Service//transforma como componente do sistema
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	public Page<Venda> findVenda(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate dataHoje = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? dataHoje.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? dataHoje : LocalDate.parse(maxDate);
		Page<Venda> vendas = vendaRepository.findVenda(min, max, pageable);
		return vendas;
	}
	
}
