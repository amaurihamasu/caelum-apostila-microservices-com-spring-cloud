package br.com.caelum.apigateway;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
class DistanciaRestClient {

	private RestTemplate restTemplate;
	private String distanciaServiceUrl;

	DistanciaRestClient(RestTemplate restTemplate,
			@Value("${configuracao.distancia.service.url}") String distanciaServiceUrl) {
		this.restTemplate = restTemplate;
		this.distanciaServiceUrl = distanciaServiceUrl;
	}

	Map<String, Object> restauranteSemDistanciaNemDetalhe(String cep, Long restauranteId) {
		Map<String, Object> resultado = new HashMap<>();
		resultado.put("restauranteId", restauranteId);
		resultado.put("cep", cep);
		return resultado;
	}

	@HystrixCommand(fallbackMethod = "restauranteSemDistanciaNemDetalhe")
	Map<String, Object> porCepEId(String cep, Long restauranteId) {
		String url = distanciaServiceUrl + "/restaurantes/" + cep + "/restaurante/" + restauranteId;
		return restTemplate.getForObject(url, Map.class);
	}

}
