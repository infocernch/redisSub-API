package org.example.pubsubapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pubsubapi.config.RedisRunner;
import org.example.pubsubapi.domain.Test;
import org.example.pubsubapi.repository.TestRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

@Service
@RequiredArgsConstructor
public class RedisSubscriber implements MessageListener {

    private static final Logger logger = LogManager.getLogger(RedisSubscriber.class);
    private final TestRepository testRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            //들어온 데이터를 String으로 받음
            String msgBody = new String(message.getBody());
            //msgBody : {"data1":"woo","data2":"adfaefa"}
            logger.info("msgBody : "+ msgBody);
            //jackson라이브러리로 json형식의 데이터를 읽음
            Test test = objectMapper.readValue(msgBody, Test.class);
            //ReadValue : Test(pk=null, data1=woo, data2=adfaefa)
            logger.info("ReadValue : " + objectMapper.readValue(msgBody, Test.class));

            Test testEntity = new Test();
            testEntity.setData1(test.getData1());
            testEntity.setData2(test.getData2());
            //데이터 set한 후에 저장 (Entity와 dto 분리를 하면 더 좋음)
            testRepository.save(testEntity);
            logger.info("Saved user: " + testEntity.getData1() + ", " + testEntity.getData2());

        } catch (Exception e) {
            logger.error("Save Fail... : "+ e);
        }

    }
}