package oddstools;

public class OddsUtil {
	
	public static double vig(int odds1, int odds2) {
		return betPrct(odds1) + betPrct(odds2);
	}
	
	public static double betPrct(int integerOdds) {
		
		double odds = (double)integerOdds; 
		if (odds < 100) {
			return (-(odds)) / ((-(odds)) + 100);
		}
		else if (odds > 100) {
			return 100 / (odds + 100);
		}
		else throw new IllegalArgumentException("Illegal odds");
		
	}
	
	public static double[] impliedPrcts(int odds1, int odds2) {
		
		double vig = vig(odds1, odds2);
		double impliedPrct1 = (betPrct(odds1) / vig);
		double impliedPrct2 = (betPrct(odds2) / vig);
		
		double[] answer = {impliedPrct1, impliedPrct2};
		return answer;
		
	}

}
