package oddstools;

public class Game implements Comparable<Game>{
	
	protected Side side1;
	protected Side side2;
	
	private int side1Odds;
	private int side2Odds;
	
	private int side1Score;
	private int side2Score;
	
	boolean scoreEntered = false;
	
	public Game(Side side1, Side side2) {
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public Game(String str1, String str2) {
		side1 = new Side(str1);
		side2 = new Side(str2);
	}
	
	public Game(String str1, int str1Odds, String str2, int str2Odds)  {
		this(new Side(str1), str1Odds, new Side(str2), str2Odds);
	}

	public Game(Side side1, int side1Odds, Side side2, int side2Odds)  {
	  this(side1, side2);
	  if (side1Odds < 100 && side1Odds > -100) throw new IllegalArgumentException();
	  if (side2Odds < 100 && side2Odds > -100) throw new IllegalArgumentException();
	  this.side1Odds = side1Odds;
	  this.side2Odds = side2Odds;
	}
	
	public Game(Side away, Side home, int awayOdds, int homeOdds, int awayScore, int homeScore) {
	  side1 = away;
	  side2 = home;
	  side1Odds = awayOdds;
	  side2Odds = homeOdds;
	  side1Score = awayScore;
	  side2Score = homeScore;
	  scoreEntered = true;
	}
	
	public Game(Side away, Side home, int awayScore, int homeScore) {
		side1 = away;
		side2 = home;
		side1Score = awayScore;
		side2Score = homeScore;
		scoreEntered = true;
	}
	
	public Side getSide1() {
		return side1;
	}
	
	public Side getSide2() {
		return side2;
	}
	
	public int getSide1Odds() {
		return side1Odds;
	}
	
	public int getSide2Odds() {
		return side2Odds;
	}
	
	public boolean oddsSet() {
		return (side1Odds != 0 && side2Odds != 0);
	}
	
	public boolean oddsEven() {
		return side1Odds == side2Odds;
	}
	
	public boolean hasPlus() {
		return (side1Odds > 0 || side2Odds > 0);
	}
	
	public Side getFav() {
		if (oddsEven() || !oddsSet()) {
			return null;
		}
		else {
			if (side1Odds < side2Odds) {
				return side1;
			}
			else {
				return side2;
			}
		}
	}
	
	public Side getDog() {
		if (oddsEven() || !oddsSet()) return null;
		else if (side1 == getFav()) return side2;
		else return side1;
	}
	
	public Side getPlusDog() {
		if (side1Odds < 0 && side2Odds < 0) {
			return null;
		}
		else return getDog();
	}
	
	public boolean isDogPlus(Side side) {
		return (side == getPlusDog()); 
	}
	
	public Side getWinner() {
		if (side1Score > side2Score) return side1;
		else if (side2Score > side1Score) return side2;
		else return null;
	}

	public boolean isWinner(Side side) {
		if (side == getWinner()) return true;
		else return false;
	}

	public boolean isTie() {
		if (scoreEntered && side1Score == side2Score) return true;
		else return false;
	}
	
	public int getWinnerOdds() {
		if (side1Score > side2Score) return side1Odds;
		else if (side2Score > side1Score) return side2Odds;
		else throw new IllegalStateException("Game not played");
	}
	
	public int getLoserOdds() {
		if (side1Score < side2Score) return side1Odds;
		else if (side2Score > side1Score) return side2Odds;
		else throw new IllegalStateException("Game not played");
	}
	
	public int getOdds(Side side) {
		if (side1 == side) return side1Odds;
		else if (side2 == side) return side2Odds;
		else return 0;
	}
	
	public boolean played(Side side) {
		return (side1 == side || side2 == side);
	}
	
	public boolean hasSide(Side side) {
		return (side1 == side || side2 == side);
	}
	
	public boolean setScore(Side side1, int score1, Side side2, int score2) {
		
		if (side1 == side2) {
			return false;
		}
		if (!hasSide(side1) || !hasSide(side2)) {
			return false;
		}
		if (side1 == this.side1) {
			side1Score = score1;
			side2Score = score2;
		}
		else {
			side1Score = score2;
			side2Score = score1;
		}
		return true;		
	}

	@Override
	public int compareTo(Game arg0) {
		return 0;
	}
}


///**
// * The Game class represents a game between two Sides.  Each game must have two
// * sides, but the odds and score of the game are optional.  However, either the
// * odds and score for both sides are entered or not at all.  The class has 
// * various methods to return the results, favorite, underdog, etc..
// */
//
//package oddstools;
//
//public class Game {
//	
//	protected Side side1;
//	protected Side side2;
//	
//	/**
//	 * Odds are meant to be American Odds.  Values between -100 and +100 
//	 * (exclusive) are not allowed. Since un-entered odds will give a default
//	 * value of zero, methods returning odds must check to make sure they are
//	 * valid and were purposefully entered.
//	*/
//	
//	private int side1Odds;
//    private int side2Odds;
//	
//	private int side1Score;
//	private int side2Score;
//	
//	private boolean oddsEntered = false;
//	private boolean scoreEntered = false;
//	
//	public Game(Side side1, Side side2) {
//		this.side1 = side1;
//		this.side2 = side2;
//	}
//	
//	public Game(String str1, String str2) {
//		side1 = new Side(str1);
//		side2 = new Side(str2);
//	}
//	
//	public Game(String str1, int str1Odds, String str2, int str2Odds)  {
//		this(new Side(str1), str1Odds, new Side(str2), str2Odds);
//	}
//
//  public Game(Side side1, int side1Odds, Side side2, int side2Odds)  {
//      this(side1, side2);
//      if (side1Odds < 100 && side1Odds > -100) throw new IllegalArgumentException();
//      if (side2Odds < 100 && side2Odds > -100) throw new IllegalArgumentException();
//      this.side1Odds = side1Odds;
//      this.side2Odds = side2Odds;
//      oddsEntered = true;
//  }
//  
//  
//  public Game(Side away, Side home, int awayOdds, int homeOdds, int awayScore, int homeScore) {
//      side1 = away;
//      side2 = home;
//      side1Odds = awayOdds;
//      side2Odds = homeOdds;
//      side1Score = awayScore;
//      side2Score = homeScore;
//      oddsEntered = true;
//      scoreEntered = true;
//  }
//	
//	public Game(Side away, Side home, int awayScore, int homeScore) {
//		side1 = away;
//		side2 = home;
//		side1Score = awayScore;
//		side2Score = homeScore;
//		scoreEntered = true;
//	}
//	
//
//	
//	public Side getSide1() { return side1; }     
//    public Side getSide2() { return side2; }
//        
//    public int getSide1Odds() { return side1Odds; }     
//    public int getSide2Odds() { return side2Odds; }
//	
//	public void record() {
//      if (wasPlayed() == true) {
//          if (isWinner(side1)) {
//              ((NFLTeam)side1).record.incWins();
//              ((NFLTeam)side2).record.incLosses();
//          }
//          else if (isWinner(side2)) {
//              ((NFLTeam)side1).record.incLosses();
//              ((NFLTeam)side2).record.incWins();
//          }
//          else if (isTie()) {
//              ((NFLTeam)side1).record.incTies();
//              ((NFLTeam)side2).record.incTies();
//          }
//      }
//      ((NFLTeam)side1).getGames().add(this);
//      ((NFLTeam)side2).getGames().add(this);
//  }
//	
//  /** 
//    The following method determines how much money was won or lost on a bet
//    on a side given the result.  If the side had positive odds it is assumed
//    a 100 unit bet was made.  If the side had negative odds it is assumed a
//    bet was made equal to the absolute value of those odds.  For example, if
//    the Broncos(-300) play the Chargers(+250) it would be assumed the bet was
//    $300 if it were made on the Broncos, and $100 if it was on the Chargers.
//  */
//	
//	public int betTeam(Side side)  {
//
//		if (this.isTie()) return 0;
//		else if (this.getOdds(side) >= 100) {
//	
//			if (this.isWinner(side))
//				return this.getOdds(side);
//			else return -100;
//		}
//		else if (this.getOdds(side) <= -100) {
//			if (this.isWinner(side))
//				return 100;
//			else {
//				int result = this.getOdds(side);
//				return result;
//			}
//		}
//		else return -99999;
//	}
//	
//	public String toString() {
//		if (side1Odds == 0 || side2Odds == 0) {
//			return side1 + " vs " + side2;
//		}
//		else if (scoreEntered == false) {
//			return side1 + "(" + side1Odds + ") vs " + side2 + "(" + side2Odds + ")";
//		}
//		else {
//		  return side1 + "(" + side1Odds + ") vs " + side2 +  "(" + side2Odds + ")" + 
//		      "[" + side1Score + "," + side2Score + "]";
//		}
//	}
//	
//	public boolean oddsSet() {
//	    return oddsEntered;
//	}
//	
//	public boolean oddsEven() {
//		if (side1Odds == side2Odds) return true;
//		else return false;
//	}
//	
//	public boolean hasPlus() {
//		if (side1Odds > 0 || side2Odds > 0) return true;
//		else return false;
//	}
//	
//	public Side fav() {
//		if (oddsEven() || oddsEntered == false) return null;
//		else {
//			if (side1Odds < side2Odds) return side1;
//			else return side2;
//		}
//	}
//	
//	public Side dog() {
//		if (oddsEven() || !oddsEntered) return null;
//		else if (side1 == fav()) return side2;
//		else return side1;
//	}
//	
//	public int favOdds() {
//	    if (!oddsEntered) return -1;
//		if (oddsEven()) return 0;
//		else {
//			if (side1Odds <  side2Odds) return side1Odds;
//			else return side2Odds;
//		}
//	}
//	
//	public int dogOdds() {
//		if (side1 == fav()) return side2Odds;
//		else return side1Odds;
//	}
//	
//	/**
//	 *  The vig, or vigorish, also called the juice, is the percentage the casino
//	 *  takes in.  This is only calculable if odds for both sides are available.
//	 */
//	
//	public double vig()  {
//	  if (!oddsSet()) return Double.NaN;
//      return LineOdds.vig(side1Odds, side2Odds);
//	}
//	
//	// this method determines if a score was entered.
//	
//	public boolean wasPlayed() {
//		return scoreEntered;
//	}
//	
//	public String score() {
//	    if (!scoreEntered) return null;
//		return side1 + ": " + side1Score + "  " + side2 + ": " + side2Score; 
//	}
//	
//	/**
//	 *  These methods estimate the winning chance a team has based on the odds.
//	 *  The odds of both teams are needed for this calculation in order for the
//	 *  odds to be adjusted without any vig.
//	 */
//	
//	public double side1Prct() {
//		if (!oddsSet()) return Double.NaN;
//		return LineOdds.betProb(side1Odds) / (1 + vig());
//	}
//	
//	public double side2Prct()  {
//		if (!oddsSet()) return Double.NaN;
//		return LineOdds.betProb(side2Odds) / (1 + vig());
//	}
//	
//	
//	public double getWinningChance(Side side) {
//		if (side1.equals(side)) {
//			return side1Prct();
//		}
//		else if (side2.equals(side)) {
//			return side2Prct();
//		}
//		else throw new IllegalArgumentException("Team not part of game");
//	}
//	
//	/**
//	 * The bet percent is the percentage that you must believe the winning
//	 * chance of your side must be over in order for you to bet it with positive
//	 * expectation.
//	 */
//	
//	public double getBetPrct(Side side) {
//		if (side1.equals(side)) {
//			return LineOdds.betProb(side1Odds);
//		}
//		else if (side2.equals(side)) {
//			return LineOdds.betProb(side2Odds);
//		}
//		else throw new IllegalArgumentException("Team not part of game");
//	}
//	
//	/**
//	 * Your EV (Expected Value), is the amount you expect to make on average with
//	 * given bet, given that your estimated chance a team will win is accurate.
//	 * For the immediate following method, the bet amount is 100 units for 
//	 * positive lines and the absolute value of the odds for negative ones.
//	 */
//	
//	public double ev(Side side, double chance) {
//		if (!this.hasSide(side)) throw new IllegalArgumentException("Team not part of game");
//		if (chance > 1 || chance < 0) throw new IllegalArgumentException("Chance must be between 0 and 1");
//		int sideOdds = this.getOdds(side);
//		return LineOdds.ev(sideOdds, chance);
//	}
//	
//	/**
//	 * This method is the same as above except the bet size is part of the parameters.
//	 */
//	
//	public double ev(Side side, double chance, int betAmt)  {
//		if (!this.hasSide(side)) throw new IllegalArgumentException("Team not part of game");
//		if (chance > 1 || chance < 0) throw new IllegalArgumentException("Chance must be between 0 and 1");
//		if (betAmt < 0) throw new IllegalArgumentException("Bet amount must be positive");
//		int sideOdds = this.getOdds(side);
//		return LineOdds.ev(sideOdds, chance);
//		
//	}
//	
//	public int trueSide1Odds()  {
//      double prct = side1Prct();
//      int line = (int)((prct / (1 - prct)) * 100);
//      if (prct > .5) {
//          return -line;
//      }
//      else return line;
//  }
//	
//	public int trueSide2Odds()  {
//		double prct = side2Prct();
//		int line = (int)((prct / (1 - prct)) * 100);
//		if (prct > .5) {
//			return -line;
//		}
//		else return line;
//	}
//	
//	public Side getOpp(Side side) {
//		if (side == side1) return side2;
//		else if (side == side2) return side1;
//		else return null;
//	}
//	
//	// determines if the Side is part of the game or not.
//	
//	public boolean hasSide (Side side) {
//		if (side1 == side || side2 == side) return true;
//		else return false;
//	}
//	
//	public Side getWinner() {
//		if (side1Score > side2Score) return side1;
//		else if (side2Score > side1Score) return side2;
//		else return null;
//	}
//	
//	public boolean isWinner(Side side) {
//		if (side == getWinner()) return true;
//		else return false;
//	}
//	
//	// returns true if the game was played as was a tie
//	
//	public boolean isTie() {
//		if (scoreEntered && side1Score == side2Score) return true;
//		else return false;
//	}
//	
//	public int getWinnerOdds() {
//		if (side1Score > side2Score) return side1Odds;
//		else if (side2Score > side1Score) return side2Odds;
//		else return 0;
//	}
//	
//	public int getLoserOdds() {
//		if (side1Score < side2Score) return side1Odds;
//		else if (side2Score > side1Score) return side2Odds;
//		else return 0;
//	}
//	
//	public int getOdds(Side side) {
//		if (side1 == side) return side1Odds;
//		else if (side2 == side) return side2Odds;
//		else return 0;
//	}
//	
//	public boolean played(Side side) {
//		if (side1 == side || side2 == side) return true;
//		else return false;
//	}
//	
//	public void printStats() throws Exception {
//	    System.out.println(this);
//	    if (!oddsEntered) System.out.println("No odds entered");
//	    else if (oddsEntered && oddsEven()) {
//	      System.out.println("Odds Even at " + side1Odds);
//	    }
//	    else {
//	      Side fav = fav();
//	      Side dog = dog();
//	      System.out.println("Favorite = " + fav + "(" + getOdds(fav) + ")");
//	      System.out.println("Underdog = " + dog + "(" + getOdds(dog) + ")");
//	      System.out.println("Favorite chance = " + getWinningChance(fav));
//	      System.out.println("Underdog chance = " + getWinningChance(dog));
//	      System.out.println("Bet favorite over " + getBetPrct(fav));
//	      System.out.println("Bet underdog over " + getBetPrct(dog));
//	      System.out.println("Vig = " + vig());
//	    }
//	}
//	
////	public static ArrayList<Side> getFavs(ArrayList<Game> games) {
////		ArrayList<Side> favorites = new ArrayList<Side>();
////		for (Game game : games) {
////			favorites.add(game.fav());
////		}
////		return favorites;
////	}
////	
////	public static ArrayList<Side> getDogs(ArrayList<Game> games) {
////		ArrayList<Side> dogs = new ArrayList<Side>();
////		for (Game game : games) {
////			dogs.add(game.dog());
////		}
////		return dogs;
////	}
////	
////	// this method returns the total money won or lost if a team was bet in each
////	// game in which played amongst the list of games.
////	
////	public static double betTeam(ArrayList<Game> games, NFLTeam team) throws IllegalOddsException	 {
////		double totalBetAmt = 0;
////		int gameNum = games.size();
////		for (Game game : games) {
////			if (game.played(team)) {
////				int odds = game.getOdds(team);
////				if (game.isTie());
////				
////				else if (team == game.getWinner()) {
////					totalBetAmt += LineOdds.betResult(true, odds);
////				}
////				else totalBetAmt += LineOdds.betResult(false, odds);
////			}
////		}
////		return totalBetAmt;
////	}
//	
//	// testing
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	    try {
//	        Side col = new Side("Colorado");
//	        Side pitt = new Side("Pitt");
//    		Game g = new Game(col, +250,  pitt, -300);
//    		g.printStats();
//    		System.out.println(g);
//    		System.out.println("Favorite = " + g.fav() + "("+  g.favOdds() + ")");
//    		System.out.println("Dog = " + g.dog() + "(" + g.dogOdds() + ")");
//    		System.out.println("vig = " + g.vig());
//    		System.out.println("Bet " + g.getSide1() + " over " + LineOdds.betProb(g.getSide1Odds()));
//    		System.out.println("Bet " + g.getSide2() + " over " + LineOdds.betProb(g.getSide2Odds()));
//    		System.out.println(g.getSide1() + " chance to win = " + g.side1Prct());
//    		System.out.println(g.getSide2() + " chance to win = " + g.side2Prct());
//    		System.out.println("Bet " + g.getSide1() + " over " + g.trueSide1Odds());
//    		System.out.println("Bet " + g.getSide2() + " under " + g.trueSide2Odds());
//	    } catch (IllegalOddsException e) {
//	        System.out.println("Odds cannot be between -100 and 100 (exclusive)");
//	    } catch (Exception e1) {
//        // TODO Auto-generated catch block
//        e1.printStackTrace();
//      }
//		
//	}
//}
