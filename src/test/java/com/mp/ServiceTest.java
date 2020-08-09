package com.mp;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.entity.User;
import com.mp.service.UserService;
import java.util.Arrays;
import java.util.List;
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
public class ServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void getOne() {
		User user = userService.getOne(Wrappers.<User> lambdaQuery().gt(User::getAge, 25), false);
		System.out.println(user);
	}

	@Test
	public void batch() {
		User user1 = new User();
		user1.setName("徐丽1");
		user1.setAge(28);

		User user2 = new User();
		user2.setId(1094592041087729672L);
		user2.setName("徐2");
		user2.setAge(29);
		List<User> userList = Arrays.asList(user1, user2);
		// boolean b = userService.saveBatch(userList);
		boolean b = userService.saveOrUpdateBatch(userList);
		System.out.println("是否成功:" + b);
	}

	@Test
	public void chain() {
		List<User> userList = userService.lambdaQuery().ge(User::getAge, 25).like(User::getName, "雨").list();
		userList.forEach(System.out::println);
	}

	@Test
	public void chain1() {
        boolean update = userService.lambdaUpdate().eq(User::getAge, 25).set(User::getAge, 26)
                .update();
        System.out.println(update);
	}

    @Test
    public void chain2() {
        boolean update = userService.lambdaUpdate().eq(User::getAge, 29).remove();
        System.out.println(update);
    }
}
