package com.renegociacaocredito;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class RenegociacaoService {

    public static void main(String[] args) {
        var renegociacaoService = new RenegociacaoService();
        try (var service = new KafkaService(RenegociacaoService.class.getSimpleName(),
                "RECUPERACAO_RENEGOCIACAO",
                renegociacaoService::parse)) {
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("------------------------------------------");
        System.out.println("Processando renegociacao");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // no error success
            e.printStackTrace();
        }
        System.out.println("renegociacao processada");
    }

}
