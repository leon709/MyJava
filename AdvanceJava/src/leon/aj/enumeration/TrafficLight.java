/**
 * 
 */
package leon.aj.enumeration;

/**
 * @author 123
 * Traffic light enumeration
 */
public enum TrafficLight {
	RED(30){
		public TrafficLight next(){
			return GREEN;
		}
	},
	GREEN(45){
		public TrafficLight next(){
			return YELLOW;
		}
	},
	YELLOW(5){
		public TrafficLight next(){
			return RED;
		}
	};
	public abstract TrafficLight next();
	private int time;
	private TrafficLight(int time){
		this.time = time;
	}
	
}
