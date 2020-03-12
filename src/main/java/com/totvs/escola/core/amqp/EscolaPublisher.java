package com.totvs.escola.core.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.totvs.tjf.core.message.TOTVSMessage;

@EnableBinding(EscolaExchange.class)
public class EscolaPublisher {

	private static final Logger LOG = LoggerFactory.getLogger(EscolaPublisher.class);

	@Autowired
	private EscolaExchange sistemaEscolaCoreExchange;

	public EscolaPublisher(EscolaExchange sistemaEscolaCoreExchange) {
		this.sistemaEscolaCoreExchange = sistemaEscolaCoreExchange;
	}

	public <T> void publish(T event, String eventName) {
		System.out.println("Aeeee01");
		new TOTVSMessage<T>(eventName, event).sendTo(sistemaEscolaCoreExchange.outputEvent());
		System.out.println("Aeeee02");
	}

}
