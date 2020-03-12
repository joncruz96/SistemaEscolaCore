package com.totvs.escola.core.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EscolaExchange {

	public static final String OUTPUT = "escola-output-events";

	@Output(EscolaExchange.OUTPUT)
	MessageChannel outputEvent();

}
