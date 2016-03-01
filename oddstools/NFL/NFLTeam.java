package oddstools.NFL;

import oddstools.Side;

public class NFLTeam extends Side {
	
	private String city;

	public NFLTeam(String city, String name) {
		super(name);
		this.city = city;
	}

}
