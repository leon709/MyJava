package leon.aj.singleton;
/**
 * 最简单的一种，饿汉式，类加载时实例化对象
 * 其优势是多线程情况下，依然保证单例
 * 坏处1：如果单例类占用内存大，但不一定使用时，开销大，不划算
 * 坏处2：如果单例类的实例化需要读取配置文件或传参进行实例化时，普通的类加载器无法办到
 * @author 123
 *
 */
public class SingleTon1 {
	private static SingleTon1 instance = new SingleTon1();
	private SingleTon1(){};
	public static SingleTon1 getInstance(){
		return instance;
	}
}
