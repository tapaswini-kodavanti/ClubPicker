// Tapaswini Kodavanti - Computer Science 3
//
// Each club is sorted into different club groups. Each club group has different levels
// of specificity, that get more precise as the level increase. A ClubGroup's instance variables include:
//	- First level specificity
//	- Second level
// 	- Third level
//	- ArrayList of all the clubs in that ClubGroup

import java.util.*;

public class ClubGroup {
	
	private String firstLevel;
	private String secondLevel;
	private String thirdLevel;
	private ArrayList<Club> clubList = new ArrayList<Club>();
	
	// constructor method (no clubs added at beginning)
	public ClubGroup(String first, String second, String third) {
		this.firstLevel = first;
		this.secondLevel = second;
		this.thirdLevel = third;
		
	}
	
	// add clubs
	public void addClub(Club c) {
		this.clubList.add(c);
	}
	
	// getter methods
	public String firstLevel() { return this.firstLevel; }
	public String secondLevel() { return this.secondLevel; }
	public String thirdLevel() { return this.thirdLevel; }
	public Club getClub(int index) { return this.clubList.get(index); }
	public ArrayList<Club> clubList() { return this.clubList; }
}
