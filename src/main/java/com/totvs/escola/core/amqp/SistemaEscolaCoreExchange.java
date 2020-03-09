package com.totvs.escola.core.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SistemaEscolaCoreExchange {

	public static final String OUTPUT = "sistema-escola-core-output-events";

	@Output(SistemaEscolaCoreExchange.OUTPUT)
	MessageChannel outputEvent();

}
