package org.sid.kafkaspring;



import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.sid.kafkaspring.entity.PageEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @KafkaListener(topics = "test12", groupId = "groupe-ms")
    public void onMessage(ConsumerRecord<String, String> cr) throws Exception {
            System.out.println("***************************************");
            PageEvent pageEvent = pageEvent(cr.value());
            System.out.println("Key=>" + cr.key());
            System.out.println(pageEvent.getPage() + "," + pageEvent.getDate() + ","  + pageEvent.getDuration());
            System.out.println("***************************************");
    }

    private PageEvent pageEvent(String jsonPageEvent) throws Exception{
        JsonMapper jsonMapper = new JsonMapper();
        PageEvent pageEvent = jsonMapper.readValue(jsonPageEvent, PageEvent.class);
        return pageEvent;
    }
}
