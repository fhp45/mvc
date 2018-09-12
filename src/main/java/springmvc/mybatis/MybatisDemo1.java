package springmvc.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import springmvc.model.User;
import springmvc.mybatis.dao.UserInterface;

public class MybatisDemo1 {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("mybatis/MybatisCfg.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSessionFactory.getConfiguration().addMapper(UserInterface.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserInterface userInterface = session.getMapper(UserInterface.class);
			User user = userInterface.getUserById(1);
			/*User user = (User) session.selectOne(
					"springmvc.model.UserMapper.GetUserByID", 1);*/
			if(user!=null){
				String userInfo = "名字："+user.getName()+", 年龄："+user.getName()+", 住址："+user.getLocation();
				System.out.println(userInfo);
			}
		} finally {
			session.close();
		}
	}

}
