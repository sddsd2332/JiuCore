package cat.jiu.core.util.helpers;

import java.math.BigDecimal;
import java.math.BigInteger;

import cat.jiu.core.JiuCore;
import cat.jiu.core.util.JiuUtils;

public class BigIntegerUtils {
	public BigInteger create(String value) {
		if(value == null || value.length() == 0) {
			return BigInteger.ZERO;
		}
		value = value.toLowerCase();
		StringBuilder v = new StringBuilder("0");
		for(int i = 0; i < value.length(); i++) {
			char n = value.charAt(i);
			if(JiuCore.containsNumber(n)) {
				v.append(n);
			}
			
			if(JiuCore.containsLetter(n)) {
				v.append(JiuUtils.other.toNumber(n));
			}
		}
		return new BigInteger(v.toString());
	}
	
	public BigInteger copy(BigInteger other) {
		return new BigInteger(other.toString());
	}
	
	/**
	 * @return true if '{@code less}' < '{@code to}'
	 * @author small_jiu
	 */
	public boolean less(BigInteger less, BigInteger to) {
		if(less == null && to == null) return true;
		if(less == null || to == null) return false;
		return to.compareTo(less) == -1;
	}
	
	/**
	 * @return true if '{@code less}' <= '{@code equ}'
	 * @author small_jiu
	 */
	public boolean lessOrEqual(BigInteger less, BigInteger equ) {
		if(less == null && equ == null) return true;
		if(less == null || equ == null) return false;
		return equ.compareTo(less) <= 0;
	}
	
	/**
	 * @return true if '{@code greater}' > '{@code to}'
	 * @author small_jiu
	 */
	public boolean greater(BigInteger greater, BigInteger to) {
		if(greater == null && to == null) return true;
		if(greater == null || to == null) return false;
		return greater.compareTo(to) == 1;
	}
	
	/**
	 * @return true if '{@code greater}' >= '{@code equ}'
	 * @author small_jiu
	 */
	public boolean greaterOrEqual(BigInteger greater, BigInteger equ) {
		if(greater == null && equ == null) return true;
		if(greater == null || equ == null) return false;
		return equ.compareTo(greater) >= 0;
	}
	
	public String format(long value) {
		return this.format(BigInteger.valueOf(value));
	}
	public String format(BigInteger value) {
		StringBuilder s = new StringBuilder(value.toString());
		
		int l = 0;
		for(int i = s.length()-1; i > 0; i--) {
			l+=1;
			if(l >= 3) {
				s.insert(i,",");
				l=0;
			}
		}
		
		return s.toString();
	}
	
	public String format(long value, int length) {
		return this.format(BigInteger.valueOf(value), length);
	}
	public String format(BigInteger value, int length) {
		String bi = BigInteger.ZERO.toString();
		if(this.greaterOrEqual(value, this.LONG_MAX)) {
			if(this.greaterOrEqual(value, this.PDD)) {
				bi = value.divide(this.PDD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "PDD";
			}
			if(this.greaterOrEqual(value, this.TDD)) {
				bi = value.divide(this.TDD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "TDD";
			}
			if(this.greaterOrEqual(value, this.GDD)) {
				bi = value.divide(this.GDD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "GDD";
			}
			if(this.greaterOrEqual(value, this.MDD)) {
				bi = value.divide(this.MDD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "MDD";
			}
			if(this.greaterOrEqual(value, this.KDD)) {
				bi = value.divide(this.KDD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "KDD";
			}
			if(this.greaterOrEqual(value, this.DD)) {
				bi = value.divide(this.DD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "DD";
			}
			if(this.greaterOrEqual(value, this.ND)) {
				bi = value.divide(this.ND).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "ND";
			}
			if(this.greaterOrEqual(value, this.BD)) {
				bi = value.divide(this.BD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "BD";
			}
			if(this.greaterOrEqual(value, this.YD)) {
				bi = value.divide(this.YD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "YD";
			}
			if(this.greaterOrEqual(value, this.ZD)) {
				bi = value.divide(this.ZD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "ZD";
			}
			if(this.greaterOrEqual(value, this.ED)) {
				bi = value.divide(this.ED).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "ED";
			}
			if(this.greaterOrEqual(value, this.PD)) {
				bi = value.divide(this.PD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "PD";
			}
			if(this.greaterOrEqual(value, this.TD)) {
				bi = value.divide(this.TD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "TD";
			}
			if(this.greaterOrEqual(value, this.GD)) {
				bi = value.divide(this.GD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "GD";
			}
			if(this.greaterOrEqual(value, this.MD)) {
				bi = value.divide(this.MD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "MD";
			}
			if(this.greaterOrEqual(value, this.KD)) {
				bi = value.divide(this.KD).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "KD";
			}
			if(this.greaterOrEqual(value, this.D)) {
				bi = value.divide(this.D).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "D";
			}
			if(this.greaterOrEqual(value, this.N)) {
				bi = value.divide(this.N).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "N";
			}
			if(this.greaterOrEqual(value, this.B)) {
				bi = value.divide(this.B).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "B";
			}
			if(this.greaterOrEqual(value, this.Y)) {
				bi = value.divide(this.Y).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "Y";
			}
			if(this.greaterOrEqual(value, this.Z)) {
				bi = value.divide(this.Z).toString();
				return bi + "." + subString(value.toString().substring(bi.length()), length) + "Z";
			}
		}
		
		if(this.greaterOrEqual(value, this.E)) {
			bi = value.divide(this.E).toString();
			return bi + "." + subString(value.toString().substring(bi.length()), length) + "E";
		}
		if(this.greaterOrEqual(value, this.P)) {
			bi = value.divide(this.P).toString();
			return bi + "." + subString(value.toString().substring(bi.length()), length) + "P";
		}
		if(this.greaterOrEqual(value, this.T)) {
			bi = value.divide(this.T).toString();
			return bi + "." + subString(value.toString().substring(bi.length()), length) + "T";
		}
		if(this.greaterOrEqual(value, this.G)) {
			bi = value.divide(this.G).toString();
			return bi + "." + subString(value.toString().substring(bi.length()), length) + "G";
		}
		if(this.greaterOrEqual(value, this.M)) {
			bi = value.divide(this.M).toString();
			return bi + "." + subString(value.toString().substring(bi.length()), length) + "M";
		}
		if(this.greaterOrEqual(value, this.K)) {
			bi = value.divide(this.K).toString();
			return bi + "." + subString(value.toString().substring(bi.length()), length) + "K";
		}
		if(this.less(value, this.K)) {
			return value.toString();
		}
		return bi;
	}
	
	private String subString(String str, int endlength) {
		if(str.length() > endlength) {
			return str.substring(0, endlength);
		}else {
			return str;
		}
	}
	
//	/** 2^5000000000 : BigInteger max*/ public final BigInteger BIGINTEGER_MAX = this.TWO.pow(1666666667).add(this.TWO.pow(1666666666)).add(this.TWO.pow(1666666667));
	
	/** 2^63-1 : Long max*/ public final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
	/** -2^63 : Long min*/ public final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
	
	/** 2^31-1 : Integer max*/ public final BigInteger INTEGER_MAX = BigInteger.valueOf(Integer.MAX_VALUE);
	/** -2^31 : Integer min*/ public final BigInteger INTEGER_MIN = BigInteger.valueOf(Integer.MIN_VALUE);
	
	/** 2^15-1 : Double max*/ public final BigInteger SHORT_MAX = BigInteger.valueOf(Short.MAX_VALUE);
	/** -2^15 : Double min*/ public final BigInteger SHORT_MIN = BigInteger.valueOf(Short.MIN_VALUE);
	
	/** 2^7-1 : Byte max*/ public final BigInteger BYTE_MAX = BigInteger.valueOf(Byte.MAX_VALUE);
	/** -2^7 : Byte min*/ public final BigInteger BYTE_MIN = BigInteger.valueOf(Byte.MIN_VALUE);
	
	/** (2-2^52).2^1023 : Double max*/ public final BigDecimal DOUBLE_MAX = BigDecimal.valueOf(Double.MAX_VALUE);
	/** 2^-1074 : Double min*/ public final BigDecimal DOUBLE_MIN = BigDecimal.valueOf(Double.MIN_VALUE);
	
	/** (2-2^23).2^127 : Float max*/ public final BigDecimal FLOAT_MAX = BigDecimal.valueOf(Float.MAX_VALUE);
	/** 2^-149 : Float min*/ public final BigDecimal FLOAT_MIN = BigDecimal.valueOf(Float.MIN_VALUE);
	
	/** 10^81 */public final BigInteger PDD = BigInteger.TEN.pow(3*27);
	/** 10^78 */public final BigInteger TDD = BigInteger.TEN.pow(3*26);
	/** 10^75 */public final BigInteger GDD = BigInteger.TEN.pow(3*25);
	/** 10^72 */public final BigInteger MDD = BigInteger.TEN.pow(3*24);
	/** 10^69 */public final BigInteger KDD = BigInteger.TEN.pow(3*23);
	/** 10^66 */public final BigInteger DD = BigInteger.TEN.pow(3*22);
	/** 10^63 */public final BigInteger ND = BigInteger.TEN.pow(3*21);
	/** 10^60 */public final BigInteger BD = BigInteger.TEN.pow(3*20);
	/** 10^57 */public final BigInteger YD = BigInteger.TEN.pow(3*19);
	/** 10^54 */public final BigInteger ZD = BigInteger.TEN.pow(3*18);
	/** 10^51 */public final BigInteger ED = BigInteger.TEN.pow(3*17);
	/** 10^48 */public final BigInteger PD = BigInteger.TEN.pow(3*16);
	/** 10^45 */public final BigInteger TD = BigInteger.TEN.pow(3*15);
	/** 10^42 */public final BigInteger GD = BigInteger.TEN.pow(3*14);
	/** 10^39 */public final BigInteger MD = BigInteger.TEN.pow(3*13);
	/** 10^36 */public final BigInteger KD = BigInteger.TEN.pow(3*12);
	/** 10^33 */public final BigInteger D = BigInteger.TEN.pow(3*11);
	/** 10^30 */public final BigInteger N = BigInteger.TEN.pow(3*10);
	/** 10^27 */public final BigInteger B = BigInteger.TEN.pow(3*9);
	/** 10^24 */public final BigInteger Y = BigInteger.TEN.pow(3*8);
	/** 10^21 */public final BigInteger Z = BigInteger.TEN.pow(3*7);
	/** 10^18 */public final BigInteger E = BigInteger.TEN.pow(3*6);
	/** 10^15 */public final BigInteger P = BigInteger.TEN.pow(3*5);
	/** 10^12 */public final BigInteger T = BigInteger.TEN.pow(3*4);
	/** 10^9 */public final BigInteger G = BigInteger.TEN.pow(3*3);
	/** 10^6 */public final BigInteger M = BigInteger.TEN.pow(3*2);
	/** 10^3 */public final BigInteger K = BigInteger.TEN.pow(3*1);
}
