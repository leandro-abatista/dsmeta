package br.com.ats.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import br.com.ats.dsmeta.entities.Venda;
import br.com.ats.dsmeta.repositories.VendaRepository;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired
	private VendaRepository vendaRepository;

	public void sendSms(Long idVenda) {
		
		Venda venda = vendaRepository.findById(idVenda).get();
		String data = venda.getData().getMonthValue() + "/" + venda.getData().getYear();
		String msg = "O Vendedor :" + venda.getNomeVendedor() + " foi destaque em " + data
				+ " com um total de vendas realizadas no valor de R$ : " + String.format("%.2f", venda.getValor());

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}
