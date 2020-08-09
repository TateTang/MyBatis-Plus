package com.mp.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description
 * @Author tangmf
 * @Date 2020/1/10 11:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {
//	@TableId(type = IdType.ID_WORKER)
	private long id; // 主键
	@TableField(condition = SqlCondition.LIKE)
	private String name;// 姓名
	@TableField(condition = "%s&lt;#{%s}")
	private Integer age;// 年龄
	private String email;// 邮箱
	private Long managerId;// 直属上级
	private LocalDateTime createTime;// 创建时间
}
