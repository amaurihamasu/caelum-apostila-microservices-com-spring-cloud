package br.com.caelum.apigateway.pedido;

import java.util.Map;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class StatusDoPedidoService {

	private SimpMessagingTemplate websocket;

	void pedidoAtualizado(Map<String, Object> pedido) {
		websocket.convertAndSend("/pedidos/" + pedido.get("id") + "/status", pedido);
		if ("PAGO".equals(pedido.get("status"))) {
			Map<String, Object> restaurante = (Map<String, Object>) pedido.get("restaurante");
			websocket.convertAndSend("/parceiros/restaurantes/" + restaurante.get("id") + "/pedidos/pendentes", pedido);
		}
	}

}
