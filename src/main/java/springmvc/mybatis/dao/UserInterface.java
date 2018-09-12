package springmvc.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import springmvc.model.User;

public interface UserInterface {
	//请注意，这里面代码有一个方法名 getUserByID 必须与 User.xml 里面配置的 select 的 id 对应(<select id="getUserByID">)同名，虽使用注解映射不需要User.xml
	@Select("select * from tb_user where id = #{id}")
	public User getUserById(int id);
	
}
