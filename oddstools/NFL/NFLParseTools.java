package oddstools.NFL;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NFLParseTools {
	
	
	//format:
	//week,awayTeam,homeTeam,awayOdds,homeOdds,awayScore,homeScore
	
	public static NFLGame parseGame(String gameString) {
		
		NFLGame game = null;
		
		try {
		
			String[] values = gameString.split(",");
			
			int week = Integer.parseInt(values[0]);
			int awayOdds = Integer.parseInt(values[3]);
			int homeOdds = Integer.parseInt(values[4]);
			int awayScore = Integer.parseInt(values[5]);
			int homeScore = Integer.parseInt(values[6]);
			
			NFLTeam team1 = StringToTeam.getTeam(values[1]);
			NFLTeam team2 = StringToTeam.getTeam(values[2]);
			
			game = new NFLGame(team1, team2, awayOdds, homeOdds, awayScore, homeScore, week);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return game;
			
	}
	
	public static NFLPick parseSinglePick(String pickString) {
		
		String[] values = pickString.split(",");
		int week = Integer.parseInt(values[0]);
		NFLTeam team = StringToTeam.getTeam(values[1]);
		double chance = Double.parseDouble(values[2]);
		
		NFLPick pick = new NFLPick(team, chance, week);		
		
		return pick;		
	}
	
	public static List<NFLPick> parsePickFile(Path file) {
		
		ArrayList<NFLPick> picks = new ArrayList<>();
		
		List<String> lines;
		try {
			lines = Files.readAllLines(file);
			for (String line : lines) {
				picks.add(parseSinglePick(line));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return picks;		
	}
	
	public static List<NFLGame> parseGameFile(Path file) {
		ArrayList<NFLGame> games = new ArrayList<>();
		
		List<String> lines;
		try {
			
			lines = Files.readAllLines(file);
			for (String line : lines) {
				games.add(parseGame(line));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return games;		
	}
}
