package oddstools.NFL;

import static oddstools.NFL.NFLLeague.*;

public class StringToTeam {
	
	public static NFLTeam getTeam(String team) {
		
		switch (team) {
			
			case "NE": return NE; 
			case "NYJ": return NYJ; 
			case "BUF": return BUF; 
			case "MIA": return MIA;
			
			case "CIN": return CIN;
			case "PIT": return PIT;
			case "BAL": return BAL;
			case "CLE": return CLE;
			
			case "HOU": return HOU;
			case "IND": return IND;
			case "JAX": return JAX;
			case "TEN": return TEN;
			
			case "DEN": return DEN;
			case "KC": return KC;
			case "OAK": return OAK;
			case "SD": return SD;
			
			case "WAS": return WAS;
			case "PHI": return PHI;
			case "NYG": return NYG;
			case "DAL": return DAL;
			
			case "MIN": return MIN;
			case "GB": return GB;
			case "DET": return DET;
			case "CHI": return CHI;
			
			case "CAR": return CAR;
			case "ATL": return ATL;
			case "NO": return NO;
			case "TB": return TB;
			
			case "ARI": return ARI;
			case "SEA": return SEA;
			case "LA": return LA;
			case "STL": return LA;
			case "SF": return SF;
			
			default: return null;
					
		}
		
	}
	
}
