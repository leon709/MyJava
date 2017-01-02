package leon.aj.enumeration;

public abstract class MySeason {
	private MySeason(){};
	public static final MySeason SPR = new MySeason(){

		@Override
		public MySeason nextSeason() {
			return SUM;
		}

		@Override
		public String toString() {
			return "Spring";
		}
		
	};
	public static final MySeason SUM = new MySeason(){

		@Override
		public MySeason nextSeason() {
			return AUT;
		}

		@Override
		public String toString() {
			return "Summer";
		}
		
	};
	public static final MySeason AUT = new MySeason(){

		@Override
		public MySeason nextSeason() {
			return WIN;
		}

		@Override
		public String toString() {
			return "Autumn";
		}
		
	};
	public static final MySeason WIN = new MySeason(){

		@Override
		public MySeason nextSeason() {
			return SPR;
		}

		@Override
		public String toString() {
			return "Winter";
		}
		
	};
	
	public abstract MySeason nextSeason();
	public abstract String toString();
}
