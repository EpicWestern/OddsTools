package oddstools;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BetableGames {
	
	public static Map<Game, Side> betableGames(List<Game> games, List<Side> picks) {
		Map<Game, Side> betableGames = new TreeMap<>();
		
		outer: for (Side side: picks) {
			for (Game game: games) {
				if (game.isDogPlus(side)) {
					betableGames.put(game, side);
					continue outer;
				}
			}
		}
		
		return betableGames;
	}
	
	public static Map<Game, Side> betableGames(List<Game> games, Map<Side, Double> picks) {
		Map<Game, Side> betableGames = new TreeMap<>();
		
		for (Side key : picks.keySet()) {
			for (Game game : games) {
				if (game.hasSide(key)) {
					if (picks.get(key) > OddsUtil.betPrct(game.getOdds(key))) {
						betableGames.put(game, key);
						break;
					}
				}
			}
		}
		
		return betableGames;
	}

}
