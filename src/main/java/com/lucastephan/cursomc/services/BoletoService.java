package com.lucastephan.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.lucastephan.cursomc.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagamento, Date instantePedido) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(instantePedido);
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		pagamento.setDataVencimento(calendar.getTime());
	}
	
}
