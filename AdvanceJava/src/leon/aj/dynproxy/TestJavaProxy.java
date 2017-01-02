package leon.aj.dynproxy;

import leon.aj.dynproxy.java.JavaDynProxy;
import leon.aj.dynproxy.target.Hello;
import leon.aj.dynproxy.target.HelloImpl;
import leon.aj.dynproxy.target.UserDao;
import leon.aj.dynproxy.target.UserDaoImpl;

public class TestJavaProxy {
	public static void main(String[] args) {
		JavaDynProxy proxy = new JavaDynProxy();
		Hello hello = (Hello)proxy.getProxyInstance(new HelloImpl());
		String s = hello.sayHello("Leon");
		System.out.println(s);
		
		UserDao userDao = (UserDao) proxy.getProxyInstance(new UserDaoImpl());
		userDao.login("Leon", "1234");
		System.out.println(userDao.getClass().getName());
	}
}
