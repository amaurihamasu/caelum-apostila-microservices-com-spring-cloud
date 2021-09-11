/*
 * package br.com.caelum.apigateway;
 * 
 * import java.io.IOException; import java.io.InputStream; import
 * java.nio.charset.Charset;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.util.StreamUtils;
 * 
 * import com.netflix.zuul.ZuulFilter; import
 * com.netflix.zuul.context.RequestContext; import
 * com.netflix.zuul.exception.ZuulException;
 * 
 * @Configuration public class ModifyResponseBodyFilter {
 * 
 * @Bean ZuulFilter modifyResponseHeaderFilter() { return new ZuulFilter() {
 * 
 * @Override public boolean shouldFilter() { return true; }
 * 
 * @Override public Object run() throws ZuulException { try { RequestContext
 * context = RequestContext.getCurrentContext(); InputStream stream =
 * context.getResponseDataStream(); String body =
 * StreamUtils.copyToString(stream, Charset.forName("UTF-8")); body =
 * body.replace("8081", "9999").replace("8082", "9999").replace("8080", "9999");
 * context.setResponseBody(body); } catch (IOException e) { throw new
 * RuntimeException(e); } return null; }
 * 
 * @Override public String filterType() { return "post"; }
 * 
 * @Override public int filterOrder() { return 999; } }; }
 * 
 * }
 */