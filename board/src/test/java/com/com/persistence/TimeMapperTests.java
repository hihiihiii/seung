package com.com.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Kspring.Kspring.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TimeMapperTests {

	@Autowired
	private TimeMapper timeMapper;

	@Test
	public void testGetTime() {

		System.out.println("지금 시간은 ? " + timeMapper.getTime());

//		System.out.println("김승환의 생일 날짜는?"+timeMapper.getMyBirthDay());
		
//		//문제발생.
//		System.out.println("현재시간은 ? "+timeMapper.getTime2());
		

	}
	@Test
	public void testGetTime2() {
		System.out.println(timeMapper.getTime2());
	}
	

}
