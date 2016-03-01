package oddstools.NFL;

import oddstools.Pick;
import oddstools.Side;

public class NFLPick extends Pick {
	
	private int week;

	public NFLPick(Side side) {
		super(side);
	}
	
	public NFLPick(Side side, double chance) {
		super(side, chance);
	}
	
	public NFLPick(Side side, int week) {
		super(side);
		this.week = week;
	}
	
	public NFLPick(Side side, double chance, int week) {
		super(side, chance);
		this.week = week;
	}
	
	public int getWeek() {
		return week;
	}
	
	public String toString() {
		return "" + this.pick + "(" + this.chance + ")" + "(week " + week + ")"; 
	}

}
