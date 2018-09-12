package springmvc.mybatis.dao;


import java.util.List;

import org.apache.ibatis.annotations.Select;

import springmvc.model.User;

public interface UserInterface {
	//请注意，这里面代码有一个方法名 getUserByID 必须与 User.xml 里面配置的 select 的 id 对应(<select id="getUserByID">)同名，虽使用注解映射不需要User.xml
	//@Select("select * from tb_user where id = #{id}")
	//public User getUserById(int id);
	
	/**
	 * 不使用注解的方式的话，我们需要在表对应的xml中根据每个方法名写一个SQL
	 * @param user
	 */
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public List<User> getUserList();
	
	public User getUser(int id);
}
