package com.mp;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.mp.dao.UserMapper;
import com.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author tangmf
 * @Date 2020/1/14 13:55
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UpdateTest {
	@Autowired(required = false)
	private UserMapper userMapper;

	@Test
	public void updateById() {
		User user = new User();
		user.setId(1088248166370832385L);
		user.setAge(26);
		user.setEmail("wtf2@baomidou.com");
		int rows = userMapper.updateById(user);
		System.out.println("影响记录数：" + rows);
	}

	@Test
	public void updateByWrapper() {
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("name", "李艺伟").eq("age", 28);
		User user = new User();
		user.setEmail("lyw2@baomidou.com");
		user.setAge(29);
		int rows = userMapper.update(user, updateWrapper);
		System.out.println("影响记录数：" + rows);
	}

	@Test
	public void updateByWrapper1() {
		User whereUser = new User();
		whereUser.setName("李艺伟");// 设置为where可查询参数
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>(whereUser);
		// updateWrapper.eq("name", "李艺伟").eq("age", 28);
		User user = new User();// 只需要更新一个对象，不需要去创建对象
		user.setEmail("lyw2@baomidou.com");
		user.setAge(29);
		int rows = userMapper.update(user, updateWrapper);
		System.out.println("影响记录数：" + rows);
	}

	@Test // 只需要更新一个属性，不需要去创建对象
	public void updateByWrapper2() {
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("name", "李艺伟").eq("age", 29).set("age", 30);
		int rows = userMapper.update(null, updateWrapper);
		System.out.println("影响记录数：" + rows);
	}

	@Test // Lambda方式 加入防误写功能
	public void updateByWrapperLambda() {
		LambdaUpdateWrapper<User> lambdaUpdate = Wrappers.<User> lambdaUpdate();
		lambdaUpdate.eq(User::getName, "李艺伟").eq(User::getAge, 30).set(User::getAge, 31);
		int rows = userMapper.update(null, lambdaUpdate);
		System.out.println("影响记录数：" + rows);
	}
    @Test
    public void updateByWrapperLambdaChain() {
        boolean update = new LambdaUpdateChainWrapper<User>(userMapper).eq(User::getName, "李艺伟")
                .eq(User::getAge, 31).set(User::getAge, 32).update();
        System.out.println("是否成功：" + update);
    }
}
