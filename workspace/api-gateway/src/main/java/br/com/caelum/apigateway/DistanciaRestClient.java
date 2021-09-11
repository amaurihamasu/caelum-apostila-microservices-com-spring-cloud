package br.com.caelum.apigateway;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanciaRestClient {

	private RestTemplate restTemplate;
	private String distanciaServiceURL;

	public DistanciaRestClient(RestTemplate restTemplate,
			@Value("${zuul.routes.distancia.url}") String distanciaServiceURL) {
		this.restTemplate = restTemplate;
		this.distanciaServiceURL = distanciaServiceURL;
	}

	Map<String, Object> porCepEId(String cep, Long restauranteId) {
		String URL = distanciaServiceURL + "/restaurantes/" + cep + "/restaurante/" + restauranteId;
		return restTemplate.getForObject(URL, Map.class);
	}

}
