package com.mp;

import com.mp.entity.User;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author tangmf
 * @Date 2020/1/10 13:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ARTest {
	@Test
	public void insert() {
		User user = new User();
		user.setName("向北");
		user.setAge(26);
		user.setEmail("xb@baomidou.com");
		user.setManagerId(1088248166370832385L);
		user.setCreateTime(LocalDateTime.now());
		boolean insert = user.insert();
		System.out.println("是否成功:" + insert);
	}

	@Test
	public void selectById() {
		User user = new User();
		User user1 = user.selectById(0L);
		System.out.println(user1);
		System.out.println(user1 == user);
	}
	@Test
	public void updateById() {
		User user = new User();
		user.setId(0L);
		user.setName("向");
		boolean b = user.updateById();
		System.out.println(b);
	}
	@Test
	public void deleteById() {
		User user = new User();
		user.setId(0L);
		boolean b = user.deleteById();
		System.out.println(b);
	}

}
