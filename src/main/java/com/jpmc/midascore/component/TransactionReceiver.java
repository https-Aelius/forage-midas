package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
@Component
public class TransactionReceiver {
    private final TransactionHandler transactionHandler;

    public TransactionReceiver(TransactionHandler transactionHandler){
        this.transactionHandler = transactionHandler;
    }
    @KafkaListener(topics = "${general.kafka.topic}")
    public void receive(@Payload Transaction transaction) {
        transactionHandler.handleTransaction(transaction);
    }
}
