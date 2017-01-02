package leon.aj.singleton;
/**
 * 采用私有静态内部类持有实例，来实现
 * 这是懒汉式，因为调用getInstance()方法时才加载静态内部类，进行实例化
 * @author 123
 *
 */
public class SingleTon5 {
	
	private SingleTon5(){};
	
	//私有静态内部类
	private static class SingletonHolder {  
        static final SingleTon5 INSTANCE = new SingleTon5();  
    }  
   
    public static SingleTon5 getInstance() {  
        return SingletonHolder.INSTANCE;  
    } 
    
    //如果需求上一定要求单例实现序列化接口，那么实现Serializable接口的同时，要添加一个方法
    /*
    private Object readResolve() {  
        return getInstance();  
    }  
    */
    
}
