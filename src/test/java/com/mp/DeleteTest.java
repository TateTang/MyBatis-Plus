package com.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.dao.UserMapper;
import com.mp.entity.User;
import java.util.Arrays;
import java.util.HashMap;
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
public class DeleteTest {
	@Autowired(required = false)
	private UserMapper userMapper;

	@Test
	public void deleteById() {
		int rows = userMapper.deleteById(0L);
		System.out.println("删除条数:" + rows);

	}

	@Test
	public void deleteByMap() {
		HashMap<String, Object> columnMap = new HashMap<>();
		columnMap.put("name", "王天风1");
		columnMap.put("age", 26);
		int rows = userMapper.deleteByMap(columnMap);
		System.out.println("删除条数:" + rows);
	}

	@Test
	public void deleteByIds() {
		int rows = userMapper.deleteBatchIds(Arrays.asList(1094590409767661571L, 1094590409767661572L));
		System.out.println("删除条数：" + rows);
	}

	@Test
	public void deleteByWrapper() {
		LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User> lambdaQuery();
		lambdaQuery.eq(User::getAge, 27).or().gt(User::getAge, 41);
		int rows = userMapper.delete(lambdaQuery);
		System.out.println("删除条数：" + rows);
	}

}
