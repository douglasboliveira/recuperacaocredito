package com.renegociacaocredito;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class AcordocaoService {

    public static void main(String[] args) {
        var acordoService = new AcordocaoService();
        try (var service = new KafkaService(AcordocaoService.class.getSimpleName(),
                "RECUPERACAO_ACORDO",
                acordoService::parse)) {
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("------------------------------------------");
        System.out.println("Processando acordo");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }
        System.out.println("acordo processado");
    }

}
