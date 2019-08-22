package com.example.bootDemo;

import com.example.bootDemo.demo.mapper.IDemoMapper;
import com.mybatis.generator.mapper.DemoMapper;
import com.mybatis.generator.pojo.DemoExample;
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
	private DemoMapper demoMapper;

	@Autowired
	private IDemoMapper demoMappers;

	@Autowired
	private Sender firstSender;

	@Test
	public void doTest(){
		DemoExample demoExample = new DemoExample();
		demoExample.createCriteria().andAgeIsNotNull();

		System.out.println(demoMappers.selectById("1"));
		System.out.println(demoMapper);
		System.out.println(demoMappers);
//        List<Demo> demoList = demoMapper.selectByExample(demoExample);
//        System.out.println(demoList);
	}


	@Test
	public void doTest1(){
		String s1 = "";
		System.out.println(s1.trim());
	}
}
