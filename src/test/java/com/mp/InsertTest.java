package com.mp;

import com.mp.dao.UserMapper;
import com.mp.entity.User;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author tangmf
 * @Date 2020/1/10 13:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class InsertTest {
	@Autowired(required = false)
	private UserMapper userMapper;

	@Test
	public void insert() {
		User user = new User();
		user.setName("向北3");
		user.setAge(26);
		user.setEmail("x3@baomidou.com");
		user.setManagerId(1088248166370832385L);
		user.setCreateTime(LocalDateTime.now());

		// 影响记录数
		int rows = userMapper.insert(user);
		System.out.println("影响记录数:" + rows);
		System.out.println("主键:" + user.getId());
	}
}
