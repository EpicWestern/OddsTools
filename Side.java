/**
 * The Side class represents a team or single competitor in a competition.
 * For example, the Denver Broncos or Tiger Woods could be a side.  Individual
 * members of a team, such as Peyton Manning, should not be considered a side.
 * 
 * @author Justin St. John
 */


package oddstools;

public class Side {
	
	private String name;
	
	public Side(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
//	public boolean equals(Side that) {
//		if (this.toString().equals(that.toString())) {
//			return true;
//		}
//		else return false;
//	}
	
	// testing

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  Side tiger = new Side("Tiger Woods");
	  System.out.println(tiger);

	}

}
