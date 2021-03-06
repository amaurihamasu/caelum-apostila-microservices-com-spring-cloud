package br.com.caelum.apigateway;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.SubscribableChannel;

import br.com.caelum.apigateway.AmqpApiGatewayConfig.AtualizacaoPedidoSink;

@EnableBinding(AtualizacaoPedidoSink.class)
@Configuration
public class AmqpApiGatewayConfig {

	static interface AtualizacaoPedidoSink {
		String PEDIDO_COM_STATUS_ATUALIZADO = "pedidoComStatusAtualizado";
		@Input
		SubscribableChannel pedidoComStatusAtualizado();
	}

}
