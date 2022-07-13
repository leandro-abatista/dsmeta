package br.com.ats.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ats.dsmeta.entities.Venda;
import br.com.ats.dsmeta.services.VendaService;

/**
 * Classe responsável pelo controle dos endpoints
 * @author leand
 *
 */
@RestController
@RequestMapping(value = "/vendas")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;

	@GetMapping
	public List<Venda> findVenda(){
		return vendaService.findVenda();
	}
}
