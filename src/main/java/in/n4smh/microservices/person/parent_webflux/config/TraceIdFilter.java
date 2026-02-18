package in.n4smh.microservices.person.parent_webflux.config;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import io.micrometer.tracing.TraceContext;
import io.micrometer.tracing.Tracer;
import jakarta.annotation.Nullable;
import reactor.core.publisher.Mono;

@Component
public class TraceIdFilter implements WebFilter {

	/***
	 * Placing trace ID to response header
	 * 
	 */

	private final Tracer tracer;

	TraceIdFilter(Tracer tracer) {
		this.tracer = tracer;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		String traceId = getTraceId();
		if (traceId != null) {
			exchange.getResponse().getHeaders().add("X-Trace-Id", traceId);
		}
		
		return chain.filter(exchange);
	}

	public @Nullable String getTraceId() {
		TraceContext context = this.tracer.currentTraceContext().context();
		return context != null ? context.traceId() : null;
	}

}
