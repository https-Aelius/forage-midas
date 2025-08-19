package com.jpmc.midascore;

import com.jpmc.midascore.entity.TransactionRecord;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class TaskThreeTests {

    static final Logger logger = LoggerFactory.getLogger(TaskThreeTests.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private UserPopulator userPopulator;

    @Autowired
    private FileLoader fileLoader;

    UserRecord userRecord = new UserRecord("waldorf", 444.55f);
//now I am trying to create a UserRecord for all users and not just waldorf!!

    TransactionRecord transactionRecord = new TransactionRecord("", userRecord, 0.0f, 0.0f ); //requires userRecord

    float total = 0.0F;


    @Test
    void task_three_verifier() throws InterruptedException {
        this.userPopulator.populate();
        String[] UserRecord1 = new String[]{this.userRecord.toString()};
        //String[] transactionRecord1 = new String[]{this.transactionRecord.toString()};
        String[] users = this.fileLoader.loadStrings("/test_data/lkjhgfdsa.hjkl");
        String[] transactionLines = this.fileLoader.loadStrings("/test_data/mnbvcxz.vbnm");


        for (String transactionLine : transactionLines) {
            kafkaProducer.send(transactionLine);
            logger.info("Sent transaction Line: {}", transactionLine);

            logger.info("Send UserRecord Line: {}", UserRecord1[0]);
            //logger.info("Send TransactionRecord Record: {}", transactionRecord1[0]);
        }
        Thread.sleep(2000);

        logger.info("Total : {}", this.total);
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info("use your debugger to find out what waldorf's balance is after all transactions are processed");
        logger.info("kill this test once you find the answer");
        while (true) {
            Thread.sleep(20000);
            logger.info("...");
        }
    }
}
