import java.util.*;
import java.io.*;

public class ClubRunner {
	private ArrayList<ClubGroup> listOfAllGroups = new ArrayList<ClubGroup>();
	private Scanner user = new Scanner(System.in);
	
	public ClubRunner(ArrayList<ClubGroup> al) {
		this.listOfAllGroups = al;
	}
	
	public void askIntro() {
		System.out.println("Would you like to be matched to a club or change club info?");
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		System.out.println("0: Club Quiz");
		System.out.println("1: Change club info");
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		System.out.print("Your answer: ");
		int option = user.nextInt();
		if (option == 0) {
			this.startQuiz();
		}
		else if (option == 1) {
			this.changeClubInfo();
		}
		
		
	}
	
	// min and max inclusive
	public int getUserNumber(int min, int max) {
		int num;
		boolean numCollected = false;
		while (!numCollected) {
			System.out.print("Enter a number from " + min + " to " + max + ": ");
			try {
				user = new Scanner(System.in);
				num = user.nextInt();
				
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number.");
				continue;
			}
			if ((num > min && num < max) || num == min || num == max) {
				return num;
			} else {
				System.out.println("Please enter a number within the range.");
			}
		}
		return 0;
		
	}
	
	public void printClubs(ClubGroup cg) {
		System.out.println();
		System.out.println("YOU HAVE MATHCED WITH THE FOLLOWING CLUBS:");
		for (Club club : cg.clubList()) {
			System.out.println(club);
		}
	}

	
	public void startQuiz() {
		System.out.println("Enter the number next to the category you are interested in.");
		// Resulting club group
		ClubGroup result = null;
		// ClubGroup checked at each level
		ClubGroup current = null;
		
		int firstLevelIndex = 0;
		ArrayList<String> firstLevelsCompleted = new ArrayList<String>();
		
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		for (ClubGroup cg : this.listOfAllGroups) {
			if (!firstLevelsCompleted.contains(cg.firstLevel())) {
				System.out.println(firstLevelIndex + ": " + cg.firstLevel());
				firstLevelsCompleted.add(cg.firstLevel());
				firstLevelIndex++;
			}
		}
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		
		
		String prevLevel = firstLevelsCompleted.get(getUserNumber(0, firstLevelIndex-1));
		int secondLevelIndex = 0;
		ArrayList<String> secondLevelsCompleted = new ArrayList<String>();
		
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		for (ClubGroup cg : this.listOfAllGroups) {
			if (cg.firstLevel().equals(prevLevel) && !secondLevelsCompleted.contains(cg.secondLevel())) {
				System.out.println(secondLevelIndex + ": " + cg.secondLevel());
				secondLevelsCompleted.add(cg.secondLevel());
				secondLevelIndex++;
			}
		}
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		
		prevLevel = secondLevelsCompleted.get(getUserNumber(0, secondLevelIndex-1));
		int thirdLevelIndex = 0;
		
		ArrayList<String> thirdLevelsCompleted = new ArrayList<String>();
		
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		for (ClubGroup cg : this.listOfAllGroups) {
			if (cg.secondLevel().equals(prevLevel) && cg.thirdLevel() == null) {
				result = cg;
				break;
			}
			if (cg.secondLevel().equals(prevLevel) && !thirdLevelsCompleted.contains(cg.thirdLevel())) {
				System.out.println(thirdLevelIndex + ": " + cg.thirdLevel());
				thirdLevelsCompleted.add(cg.thirdLevel());
				thirdLevelIndex++;
			}
		}
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		
		if (result == null) {
			prevLevel = thirdLevelsCompleted.get(getUserNumber(0, thirdLevelIndex-1));
			for (int j = 0; j < this.listOfAllGroups.size(); j++) {
				ClubGroup temp = this.listOfAllGroups.get(j);
				if (temp.thirdLevel() == null) {
					continue;
				}
				if (temp.thirdLevel().equals(prevLevel)) {
					result = temp;
					break;
				}
			}
		}
		
		this.printClubs(result);
	}
	
	public void changeClubInfo() {
		int clubNum = 0;
		ArrayList<Club> clubsListed = new ArrayList<Club>();
		System.out.println("Which club's info would you like to change?");
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		for (ClubGroup cg : this.listOfAllGroups) {
			for (Club c : cg.clubList()) {
				System.out.println(clubNum + ": " + c.name());
				clubNum++;
				clubsListed.add(c);
			}
		}
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		
		int clubWanted = getUserNumber(0, 40);
		
		
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		System.out.println("1: Description");
		System.out.println("2: Google Classroom code");
		System.out.println("3: Eligibility");
		System.out.println("4: Meeting Times");
		System.out.println("5: Meeting Location");
		System.out.println("6: Fee");
		System.out.println("7: Link");
		System.out.println("<><><><><><><><><><><><><><><><><><><><>");
		System.out.print("What do you want to change?: ");
		int category = getUserNumber(1, 7);
		System.out.print("Enter the new info: ");
		user = new Scanner(System.in);
		String info = user.nextLine();
		
		switch (category) {
		case 1:
			clubsListed.get(clubWanted).updateDesc(info);
			break;
		case 2:
			clubsListed.get(clubWanted).updateGcCode(info);
			break;
		case 3:
			clubsListed.get(clubWanted).updateEligibility(info);
			break;
		case 4:
			clubsListed.get(clubWanted).updateMeetingTimes(info);
			break;
		case 5:
			clubsListed.get(clubWanted).updateMeetingLocation(info);
			break;
		case 6:
			clubsListed.get(clubWanted).updateFees(info);
			break;
		case 7:
			clubsListed.get(clubWanted).updateLink(info);
			break;
		default:
			System.out.println("Updating Switch statement error");
		}
		
		System.out.println(clubsListed.get(clubWanted));
	}
	
	public void endProgram() {
		StringBuilder builder = new StringBuilder();
		for (ClubGroup cg : this.listOfAllGroups) {
			for (Club c : cg.clubList()) {
				
				// Add name
				builder.append(c.name());
				builder.append("\n\n\n");
				
				// Add description
				builder.append(c.description());
				builder.append("\n\n\n");
				
				// Add sponsors
				builder.append("Club Sponsor: ");
				for (String sponsor : c.sponsors()){
					builder.append(sponsor + " ");
				}
				builder.append("\n\n\n");
				
				// Add Eligibility
				if (!c.eligibility().equals("")) {
					builder.append("Eligibility: ");
					builder.append(c.eligibility());
					builder.append("\n\n\n");
				}
				
				
				// Add GC Code
				if (!c.gcCode().equals("")) {
					builder.append("Google Classroom Code: ");
					builder.append(c.gcCode());
					builder.append("\n\n\n");
				}
				
				// Add meeting times
				if (!c.meetingTimes().equals("")) {
					builder.append("Meeting Days/Times: ");
					builder.append(c.meetingTimes());
					builder.append("\n\n\n");
				}
				
				// Add meeting location
				if (!c.meetingLocation().equals("")) {
					builder.append("Meeting Location: ");
					builder.append(c.meetingLocation());
					builder.append("\n\n\n");
				}
				
				// Add fees
				if (!c.fee().equals("")) {
					builder.append("Required Fees:  ");
					builder.append(c.fee());
					builder.append("\n\n\n");
				}
				
				// Add link
				if (!c.link().equals("")) {
					builder.append("For More Info: ");
					builder.append(c.link());
					builder.append("\n\n\n");
				}
			}
		}
		
		String newContent = builder.toString();
		FileWriter writer = null;
		try {
			writer = new FileWriter("Clubs.txt");
			writer.write(newContent);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FileWriter Error");
		}
	}
}
