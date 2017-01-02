package leon.aj.singleton;

/**
 * 懒汉式，解决SingleTon2多线程失效的问题。但是性能上存在不足，每次获取实例都需要同步，耗费性能
 * 但实际上有了一个实例，以后就不需要同步了，这种写法，synchronized耗费性能。
 * @author 123
 *
 */
public class SingleTon3 {
	private static SingleTon3 instance;
	private SingleTon3(){};
	public static SingleTon3 getInstance(){
		synchronized(SingleTon3.class){
			if(instance == null){
				instance = new SingleTon3();
			}
		}
		return instance;
	}
}
