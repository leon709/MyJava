package leon.aj.clone;

public class Sheep implements Cloneable{
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
