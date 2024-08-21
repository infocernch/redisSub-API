package org.example.pubsubapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pubsubapi.domain.Rec;
import org.example.pubsubapi.domain.Test;
import org.example.pubsubapi.repository.RecRepository;
import org.example.pubsubapi.repository.TestRepository;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisSubscriber222 implements MessageListener {

    private static final Logger logger = LogManager.getLogger(RedisSubscriber222.class);
    private final RecRepository recRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            //들어온 데이터를 String으로 받음
            String msgBody = new String(message.getBody());
            //jackson라이브러리로 json형식의 데이터를 읽음
            Test test = objectMapper.readValue(msgBody, Test.class);
            //ReadValue : Test(pk=null, data1=woo, data2=adfaefa)


        } catch (Exception e) {
            logger.error("Save Fail... : "+ e);
        }

    }
}