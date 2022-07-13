package br.com.ats.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Venda> findVenda() {
		
		List<Venda> vendas = vendaRepository.findAll();
		return vendas;
	}
	
}
