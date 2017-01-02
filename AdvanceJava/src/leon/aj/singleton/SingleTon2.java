package leon.aj.singleton;
/**
 * 懒汉式单例，第一次获取实例时判空实例化，可以解决SingleTon1的缺点
 * 但同时也丢了SingleTon1的优势，即多线程情况下无法保证单例
 * @author 123
 *
 */
public class SingleTon2 {
	private static SingleTon2 instance;
	private SingleTon2(){};
	public static SingleTon2 getInstance(){
		if(instance == null){
			instance = new SingleTon2();
		}
		return instance;
	}
}
