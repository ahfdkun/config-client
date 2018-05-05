package com.ahfdkun.listener;

import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.bus.event.SentApplicationEvent;
import org.springframework.cloud.bus.event.TraceListener;
import org.springframework.context.event.EventListener;

public class MyTraceLisenter extends TraceListener {

	private TraceRepository repository;
	
	public MyTraceLisenter(TraceRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@EventListener
	public void onAck(AckRemoteApplicationEvent event) {
		this.repository.add(getReceivedTrace(event));
	}

	@EventListener
	public void onSend(SentApplicationEvent event) {
		this.repository.add(getSentTrace(event));
	}
}
