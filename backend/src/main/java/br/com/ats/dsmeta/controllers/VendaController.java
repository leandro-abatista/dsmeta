package br.com.ats.dsmeta.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ats.dsmeta.entities.Venda;
import br.com.ats.dsmeta.services.SmsService;
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
	@Autowired
	private SmsService smsService;

	@GetMapping
	public Page<Venda> findVenda(
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, 
			Pageable pageable){
		return vendaService.findVenda(minDate, maxDate, pageable);
	}
	
	/**
	 * Método que envia um sms
	 */
	@GetMapping(value = "/{id}/notificacao")
	public void notificacaoSms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
