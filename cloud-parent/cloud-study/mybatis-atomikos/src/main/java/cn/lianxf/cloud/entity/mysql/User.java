package cn.lianxf.cloud.entity.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @className User
 * @description User
 * @date 2021/8/11 下午11:04
 * @author little
 * @version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = -2163497649341943700L;

    @TableField("ID")
    private Integer id;

    @TableField("NAME")
    private String name;

    @TableField("AGE")
    private Integer age;
}
