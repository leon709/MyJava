package leon.aj.clone;

public class TestClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sheep sheep = new Sheep();
		sheep.setName("orignal");

		try {
			Sheep s = (Sheep) sheep.clone();
			
			System.out.println(s.getName());
			System.out.println(sheep == s);
			System.out.println(sheep.equals(s));
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
