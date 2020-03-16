package com.example.bootDemo;

import com.example.bootDemo.demo.mapper.IDemoMapper;
import com.rabbitmq.direct.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDemoApplicationTests {


	@Autowired
	private IDemoMapper demoMappers;

	//引入消息发送者
	@Autowired
	private Sender firstSender;



	@Test
	public void testSend(){

		firstSender.send();
	}
}
