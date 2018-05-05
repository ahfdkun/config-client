package com.ahfdkun.configuration;

import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ahfdkun.listener.MyTraceLisenter;

@Configuration
@ConditionalOnProperty(value = "spring.cloud.bus.trace.enabled", matchIfMissing = false)
public class BusAckTraceConfiguration {

	@Bean
	public MyTraceLisenter ackTraceListener(TraceRepository repository) {
		return new MyTraceLisenter(repository);
	}

}