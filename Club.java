// Tapaswini Kodavanti - Computer Science 3
//
// Each club at Rock Hill is represented by each club instance. The info included includes:
//	- Club name
//	- Club description
//	- Google Classroom code
//	- Meeting times
//	- Prerequisites for club
import java.util.*;
import java.io.*;

public class Club {
	
	private String name;
	private String description;
	private String gcCode;
	private String eligibility;
	private String meetingTimes;
	private String meetingLocation;
	private String fee;
	private String link;
	private ArrayList<String> sponsors;
	
	// constructor method
	
	public Club(String n, String d, String gc, String eligible, String meetTime, String meetLocation, String i, String link, ArrayList<String> s) {
		this.name = n;
		this.description = d;
		this.gcCode = gc;
		this.eligibility = eligible;
		this.meetingTimes = meetTime;
		this.meetingLocation = meetLocation;
		this.fee = i;
		this.link = link;
		this.sponsors = s;
	}
	
	// printing method (returns String to print out)
	
	public String toString() {
		String result = "";
		result += "========================================\n\n";
		result += "CLUB: " + this.name.trim() + "\n";
		result += this.description.trim() + "\n";
		result += "ELIGIBILITY: " + this.eligibility.trim() + "\n";
		result += "GOOGLE CLASSROOM CODE: " + this.gcCode.trim() + "\n";
		result += "MEETING TIMES: " + this.meetingTimes.trim() + "\n";
		result += "MEETING LOCATION: " + this.meetingLocation.trim() + "\n";
		result += "FEES: " + this.fee.trim() + "\n";
		result += "LINK: " + this.link.trim() + "\n";
		result += "SPONSORS: " + this.sponsors.toString().trim() + "\n\n";
		result += "========================================";
		
		return result;
	}
	
	// update club info
	
	public void updateDesc(String d) {
		this.description = d;
	}
	
	public void updateGcCode(String gc) {
		this.gcCode = gc;
	}
	
	public void updateEligibility(String pre) {
		this.eligibility = pre;
	}
	
	public void updateMeetingTimes(String meetTime) {
		this.meetingTimes = meetTime;
	}
	
	public void updateMeetingLocation(String meetLocation) {
		this.meetingLocation = meetLocation;
	}
	public void updateFees(String i) {
		this.fee = i;
	}
	
	public void updateLink(String l) {
		this.link = l;
	}

	
	// getter methods
	
	public String name() { return this.name; }
	public String description() { return this.description; }
	public String eligibility() { return this.eligibility; }
	public String gcCode() { return this.gcCode; }
	public String meetingTimes() { return this.meetingTimes; }
	public String meetingLocation() { return this.meetingLocation; }
	public String fee() { return this.fee; }
	public String link() { return this.link; }
	public ArrayList<String> sponsors() { return this.sponsors; }
	
	
}
