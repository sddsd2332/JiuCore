package cat.jiu.core.util;

import java.util.Random;

public class JiuRandom extends Random {
	private static final long serialVersionUID = -8330324278894190587L;
	
	private Random rand;
	
	public JiuRandom() {
		this.rand = new Random();
	}
	
	public JiuRandom(Random rand) {
		this.rand = rand;
	}
	
	public JiuRandom(long seed) {
		this.rand = new Random(seed);
	}
	
	public void setSeed(long seed) {
		this.rand = new Random(seed);
	}
	
	public void setSeed(Random rand) {
		this.rand = rand;
	}
	
	public String nextIP() {
		int i0 = this.nextIntNoZero(254);
		int i1 = this.nextInt(254);
		int i2 = this.nextInt(254);
		int i3 = this.nextIntNoZero(254);
		
		return i0+"."+i1+"."+i2+"."+i3;
	}

	public String nextMAC(boolean toUpperCase) {
		String s0 = this.nextNumberOrLetter(toUpperCase, 9);
		String s1 = this.nextNumberOrLetter(toUpperCase, 9);
		String s2 = this.nextNumberOrLetter(toUpperCase, 9);
		String s3 = this.nextNumberOrLetter(toUpperCase, 9);
		String s4 = this.nextNumberOrLetter(toUpperCase, 9);
		String s5 = this.nextNumberOrLetter(toUpperCase, 9);
		String s6 = this.nextNumberOrLetter(toUpperCase, 9);
		String s7 = this.nextNumberOrLetter(toUpperCase, 9);
		String s8 = this.nextNumberOrLetter(toUpperCase, 9);
		String s9 = this.nextNumberOrLetter(toUpperCase, 9);
		String s10 = this.nextNumberOrLetter(toUpperCase, 9);
		String s11 = this.nextNumberOrLetter(toUpperCase, 9);

		return s0+s1+":"+s2+s3+":"+s4+s5+":"+s6+s7+":"+s8+s9+":"+s10+s11;
	}

	public String nextNumberOrLetter(boolean toUpperCase) {
		boolean i = this.nextBoolean();

		if(i){
			return this.nextLetter(toUpperCase);
		}else {
			return Integer.toString(this.nextInt());
		}
	}

	public String nextNumberOrLetter(boolean toUpperCase, int seed) {
		boolean i = this.nextBoolean();

		if(i){
			return this.nextLetter(toUpperCase);
		}else {
			return Integer.toString(this.nextInt(seed));
		}
	}

	public String nextLetter(boolean toUpperCase) {
		if(toUpperCase){
			return this.letter().toUpperCase();
		}else {
			return this.letter().toLowerCase();
		}
	}

	private String letter() {
		int i = this.nextInt(25);

		switch(i){
			case 0:return "A";
			case 1:return "B";
			case 2:return "C";
			case 3:return "D";
			case 4:return "E";
			case 5:return "F";
			case 6:return "G";
			case 7:return "H";
			case 8:return "I";
			case 9:return "J";
			case 10:return "K";
			case 11:return "L";
			case 12:return "M";
			case 13:return "N";
			case 14:return "O";
			case 15:return "P";
			case 16:return "Q";
			case 17:return "R";
			case 18:return "S";
			case 19:return "T";
			case 20:return "U";
			case 21:return "V";
			case 22:return "W";
			case 23:return "X";
			case 24:return "Y";
			default:return "Z";
		}
	}
	
	public int nextIntFromRange(int min, int max) {
		int i = 0;
		
		if(min > max) {
			i = this.nextInt(min);
		}else {
			i = this.nextInt(max);
		}
		
		if((i <= max && i >= min) || (i <= min && i >= max)) {
			return i;
		}else {
			return this.nextIntFromRange(min, max);
		}
	}
	
	public int nextIntNoZero() {
		int i = rand.nextInt();
		
		return i != 0 ? i : this.nextIntNoZero();
	}
	
	public int nextIntNoZero(int seed) {
		int i = rand.nextInt(seed);
		
		return i != 0 ? i : this.nextIntNoZero(seed);
	}

	public int nextInt() {
		return rand.nextInt();
	}

	public int nextInt(int seed) {
		return rand.nextInt(seed);
	}
	
	public boolean nextBoolean(int seed, int chance) {
		int i = this.nextInt(seed);
		return i <= chance;
	}
	
	public boolean nextBoolean(int chance) {
		return this.nextBoolean(100, chance);
	}
	
	public boolean nextBoolean() {
		return rand.nextBoolean();
	}
	
	public void nextBytes(byte[] buf) {
		rand.nextBytes(buf);
	}
	
	public double nextDoubleNoZero() {
		double i = rand.nextDouble();
		
		return i != 0 ? i : this.nextDoubleNoZero();
	}

	public double nextDouble() {
		return rand.nextDouble();
	}
	
	public float nextFloatNoZero() {
		float i = rand.nextFloat();
		
		return i != 0 ? i : this.nextFloatNoZero();
	}

	public float nextFloat() {
		return rand.nextFloat();
	}

	public double nextGaussian() {
		return rand.nextGaussian();
	}
	
	public long nextLongNoZero() {
		long i = rand.nextLong();
		
		return i != 0 ? i : this.nextLongNoZero();
	}

	public long nextLong() {
		return rand.nextLong();
	}
}