package oddstools.NFL;

import oddstools.Game;
import oddstools.Side;

public class NFLGame extends Game {
	
	private int week;

	public NFLGame(Side away, Side home, int awayOdds, int homeOdds, int awayScore, int homeScore, int week) {
		super(away, home, awayOdds, homeOdds, awayScore, homeScore);
	}
	
	public int getWeek() {
		return week;
	}
	
	public void setWeek(int week) {
		this.week = week;
	}
	

}
