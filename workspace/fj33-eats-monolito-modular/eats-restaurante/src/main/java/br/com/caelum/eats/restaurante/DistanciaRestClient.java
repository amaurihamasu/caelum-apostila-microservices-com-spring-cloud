package br.com.caelum.eats.restaurante;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class DistanciaRestClient {

	private String distanciaServiceURL;
	private RestTemplate restTemplate;

	DistanciaRestClient(RestTemplate restTemplate,
			@Value("${configuracao.distancia.service.url}") String distanciaServiceURL) {
		this.restTemplate = restTemplate;
		this.distanciaServiceURL = distanciaServiceURL;
	}

	void novoRestauranteAprovado(Restaurante restaurante) {
		RestauranteParaServicoDeDistancia informacoesParaInclusao = new RestauranteParaServicoDeDistancia(restaurante);
		String url = distanciaServiceURL + "/restaurantes";
		ResponseEntity<RestauranteParaServicoDeDistancia> responseEntity =
				restTemplate.postForEntity(url, informacoesParaInclusao, RestauranteParaServicoDeDistancia.class);
		HttpStatus statusCode = responseEntity.getStatusCode();
		if (!HttpStatus.CREATED.equals(statusCode)) {
			throw new RuntimeException("Status diferente do esperado: " + statusCode);
		}
	}

	void restauranteAtualizado(Restaurante restaurante) {
		RestauranteParaServicoDeDistancia informacoesParaAtualizacao = new RestauranteParaServicoDeDistancia(restaurante);
		String url = distanciaServiceURL + "/restaurantes/" + restaurante.getId();
		restTemplate.put(url, informacoesParaAtualizacao, RestauranteParaServicoDeDistancia.class);
	}

}
