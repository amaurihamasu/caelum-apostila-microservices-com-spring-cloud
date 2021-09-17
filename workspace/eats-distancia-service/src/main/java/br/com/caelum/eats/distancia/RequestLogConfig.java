package br.com.caelum.eats.distancia;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
class RequestLogConfig {

	CommonsRequestLoggingFilter requestLoggingFilter() {

		CommonsRequestLoggingFilter logginFilter = new CommonsRequestLoggingFilter();
		logginFilter.setIncludeClientInfo(true);
		logginFilter.setIncludePayload(true);
		logginFilter.setIncludeHeaders(true);
		logginFilter.setIncludeQueryString(true);
		return logginFilter;

	}

}
