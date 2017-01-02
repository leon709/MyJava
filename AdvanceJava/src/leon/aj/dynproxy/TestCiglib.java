package leon.aj.dynproxy;

import leon.aj.dynproxy.cglib.CglibProxy;
import leon.aj.dynproxy.target.Hello;
import leon.aj.dynproxy.target.HelloImpl;
import leon.aj.dynproxy.target.UserDaoImpl;

public class TestCiglib {
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		Hello hello = (Hello) proxy.getProxyInstance(new HelloImpl());
		System.out.println(hello.sayHello("Leon"));
		UserDaoImpl userDao = (UserDaoImpl) proxy.getProxyInstance(new UserDaoImpl());
		userDao.login("Leon", "1234");
		System.out.println(userDao.getClass().getSuperclass());//看动态代理实例的父类
	}
}