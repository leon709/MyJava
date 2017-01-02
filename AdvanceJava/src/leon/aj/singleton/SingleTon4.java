package leon.aj.singleton;
/**
 * 双重验证，解决了SingleTon3的性能问题，实例化后不再需要执行synchronize代码块。
 * 但是还存在问题，http://www.iteye.com/topic/575052有介绍，主要是new SingleTon4();为非原子操作
 * @author 123
 *
 */
public class SingleTon4 {
	private static SingleTon4 instance;
	private SingleTon4(){};
	public static SingleTon4 getInstance(){
		if(instance == null){
			synchronized(SingleTon4.class){
				if(instance == null){
					instance = new SingleTon4();
				}
			}
		}
		return instance;
	}
}
