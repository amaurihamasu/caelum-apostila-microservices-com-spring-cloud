package br.com.caelum.notafiscal;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.SubscribableChannel;

import br.com.caelum.notafiscal.AmqpNotaFiscalConfig.PagamentoSink;

@EnableBinding(PagamentoSink.class)
@Configuration
class AmqpNotaFiscalConfig {

	static interface PagamentoSink {
		String PAGAMENTOS_CONFIRMADOS = "pagamentosConfirmados";

		@Input
		SubscribableChannel pagamentosConfirmados();
	}

}
