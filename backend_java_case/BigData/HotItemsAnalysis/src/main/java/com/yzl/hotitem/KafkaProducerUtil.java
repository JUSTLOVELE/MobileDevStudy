package com.yzl.hotitem;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

/**
 * @author yangzl 2021.06.08
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class KafkaProducerUtil {

    /**
     * 高并发写入脚本
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        writeToKafka("hotitems");
    }

    public static void writeToKafka(String topic) throws Exception {
        //kafka配置
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //定义一个kafka producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\HotItemsAnalysis\\src\\main\\resources\\UserBehavior.csv"));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, line);
            kafkaProducer.send(producerRecord);
        }
        kafkaProducer.close();
    }
}
