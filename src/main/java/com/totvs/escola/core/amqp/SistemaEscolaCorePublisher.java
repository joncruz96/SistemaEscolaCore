package com.totvs.escola.core.amqp;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.totvs.tjf.core.message.TOTVSMessage;

@EnableBinding(SistemaEscolaCoreExchange.class)
public class SistemaEscolaCorePublisher {

	private static final Logger LOG = LoggerFactory.getLogger(SistemaEscolaCorePublisher.class);

	@Autowired
	private SistemaEscolaCoreExchange sistemaEscolaCoreExchange;

	public SistemaEscolaCorePublisher(SistemaEscolaCoreExchange sistemaEscolaCoreExchange) {
		this.sistemaEscolaCoreExchange = sistemaEscolaCoreExchange;
	}

	public <T> void publish(T event) {
		Field field;
		String eventName = null;
		try {
			field = event.getClass().getField("NAME");
			eventName = (String) field.get(event);

			new TOTVSMessage<T>(eventName, event).sendTo(sistemaEscolaCoreExchange.outputEvent());

		} catch (Exception e) {
			LOG.debug("Exchange: {}\nTopic: {}\n", sistemaEscolaCoreExchange, eventName);
		}
	}

}
