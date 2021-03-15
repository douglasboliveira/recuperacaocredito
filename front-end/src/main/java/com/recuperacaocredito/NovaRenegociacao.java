package com.recuperacaocredito;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NovaRenegociacao {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		try (var dispatcher = new KafkaDispatcher()) {
            for (var i = 0; i < 10; i++) {

                var key = UUID.randomUUID().toString();
                var value = key + ",67523,1234";
                dispatcher.send("RECUPERACAO_RENEGOCIACAO", key, value);
            }
        }
	}
	
}
