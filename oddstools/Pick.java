package oddstools;

public class Pick {
	
	protected Side pick;
	protected double chance;
	
	public Pick(Side side) {
		pick = side;
	}
	
	public Pick(Side side, double chance) {
		this(side);
		this.chance = chance;
	}
	
	public Side getPick() {
		return pick;
	}
	
	public double getChance() {
		return chance;
	}

}
