package springmvc.mybatis.oneToMany;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import springmvc.mybatis.oneToMany.model.Post;
import springmvc.mybatis.oneToMany.model.User;

public class MybatisOneToManyDemo {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("mybatis/MybatisOneToManyCfg.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
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
			int userid = 1;
			User user = session.selectOne("springmvc.mybatis.oneToMany.model.UserMapper.getUser", 1); 
		     System.out.println("username: "+user.getName()+",");
                     List<Post> posts = user.getPosts();  
                     for(Post p : posts) {
                         System.out.println("Title:" + p.getTitle()); 
                         System.out.println("Content:" + p.getContent());                
                      }  
		 } finally {
			session.close();
		 }
	}
}
