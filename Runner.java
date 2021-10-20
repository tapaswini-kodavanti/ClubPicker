import java.util.*;
import java.io.*;

public class Runner {
	public static void main(String[] args) {
		
		// Create the clubs
		
		ArrayList<ClubGroup> clubGroups = new ArrayList<>();
		
		
		// Create club groups
		
		ClubGroup acadHonorsArts = new ClubGroup("Academic", "Honors Societies", "Fine Arts");
		ClubGroup acadHonorsLang = new ClubGroup("Academic", "Honors Societies", "Foreign Language");
		
		ClubGroup acadCareerBus = new ClubGroup("Academic", "Career", "Business");
		ClubGroup acadCareerMed = new ClubGroup("Academic", "Career", "Medical");
		ClubGroup acadCareerLaw = new ClubGroup("Academic", "Career", "Law Enforcement");
		ClubGroup acadCareerCula = new ClubGroup("Academic", "Career", "Culinary Arts");
		
		ClubGroup acadClassTeach = new ClubGroup("Academic", "Class-Oriented", "Teaching");
		ClubGroup acadClassJournal = new ClubGroup("Academic", "Class-Oriented", "Journalism");
		ClubGroup acadClassSpeech = new ClubGroup("Academic", "Class-Oriented", "Debate");
		
		
		
		
		ClubGroup athlGeneralFca = new ClubGroup("Athletic", "General", "FCA");
		ClubGroup athlTeamWrestling = new ClubGroup("Athletic", "Sports Team", "Wrestling");
		ClubGroup athlTeamGirls = new ClubGroup("Athletic", "Sports Team", "Lacrosse Girls");
		ClubGroup athlTeamBoys = new ClubGroup("Athletic", "Sports Team", "Lacrosse Boys");
		
		
		
		
		ClubGroup ldLocal = new ClubGroup("Leadership Development", "Local", null);
		ClubGroup ldGlobal = new ClubGroup("Leadership Development", "Global", null);
		ClubGroup ldCom = new ClubGroup("Leadership Development", "Community Service", null);

		

		
		ClubGroup socialGamePerson = new ClubGroup("Social Networking", "Games", "In-Person");
		ClubGroup socialGameVirtual = new ClubGroup("Social Networking", "Games", "Virtual");
		
		ClubGroup socialArt = new ClubGroup("Social Networking", "Fine Arts", null);
		
		ClubGroup socialCulture = new ClubGroup("Social Networking", "Culture", null);
		ClubGroup socialDisc = new ClubGroup("Social Networking", "Discussion-based", null);
		ClubGroup socialActivity = new ClubGroup("Social Networking", "Physical Activity", null);
		
		
		
		// Check Scanning
		Scanner input = null;
		
		try {
			input = new Scanner(new File("Clubs.txt"));
		}
		catch (IOException e) {
			System.out.println("Not found");
		}
		String nameDummy = "";
		boolean nameDummyExists = false;
		while (input.hasNext()) {
			String name = "";
			String desc = "";
			String gcCode = "";
			String eligible = "";
			String mTime = "";
			String mLocation = "";
			String fee = "";
			String link = "";
			ArrayList<String> sponsors = new ArrayList<String>();
			
			
			for (int i = 0; i < 8; i++) {
				// Scan each individual line
				Scanner inputLine = null;
				try {
					inputLine = new Scanner(input.nextLine());
				} catch(NoSuchElementException e){
					break;
				}
				
				// If it is the name, store in name variable
				if (i == 0) {
					if (nameDummyExists) {
						name = nameDummy;
						nameDummyExists = false;
						desc = inputLine.nextLine();
					}
					else {
						name = inputLine.nextLine();
					}
					input.nextLine();
					input.nextLine();
					continue;
				}
				// If it is the description, store in desc variable
				else if (i == 1 && desc == "") {
					
					desc = inputLine.nextLine();
					input.nextLine();
					input.nextLine();
					continue;
				}
				
				String inputC = inputLine.nextLine();
				Scanner inputCategory = new Scanner(inputC);
				
				if (!inputC.contains(":")) {
					nameDummy = inputC;
					nameDummyExists = true;
					input.nextLine();
					input.nextLine();
					break;
				}
				
				// Find the category for each line based on the colon
				String category = inputCategory.next();
				while (!category.contains(":")) {
					category += inputCategory.next();
				}
				
				// Assign data to each variable
				switch (category) {
				case "GoogleClassroomCode:":
					gcCode = inputCategory.nextLine();
					break;
				case "Eligibility:":
					eligible = inputCategory.nextLine();
					break;
				case "MeetingDays/Times:": 
					mTime = inputCategory.nextLine();
					break;
				case "MeetingLocation:":
					mLocation = inputCategory.nextLine();
					break;
				case "RequiredFees:":
					fee = inputCategory.nextLine();
					break;
				case "ForMoreInfo:":
					link = inputCategory.nextLine();
					break;
				case "ClubSponsor:":
					String sponsor;
					while(inputCategory.hasNext()) {
						sponsor = "";
						sponsor += inputCategory.next() + " " + inputCategory.next() + " " + inputCategory.next();
						sponsors.add(sponsor);
					}
					break;
				default:
					System.out.println("Error" + category);
				}
				
				input.nextLine();
				try {
					input.nextLine();
				}
				catch (NoSuchElementException e){
					break;
				}
			}
			Club temp = new Club(name, desc, gcCode, eligible, mTime, mLocation, fee, link, sponsors);
			
			String switchName = temp.name();
			switch (switchName) {
			case "International Thespian Society":
			case "Tri-M Music Honor Society":
			case "National Art Honor Society":
				acadHonorsArts.addClub(temp);
				break;
			case "ASL Honor Society":
			case "Spanish Honor Society":
				acadHonorsLang.addClub(temp);
				break;
			case "DECA":
			case "FFA (Future Farmers of America)":
				acadCareerBus.addClub(temp);
				break;
			case "HOSA (Health Occupations Students of America)":
				acadCareerMed.addClub(temp);
				break;
			case "Law Enforcement Club":
				acadCareerLaw.addClub(temp);
				break;
			case "ProStart":
				acadCareerCula.addClub(temp);
				break;
			case "TAFE (Texas Association of Future Educators)":
				acadClassTeach.addClub(temp);
				break;
			case "Media Club":
				acadClassJournal.addClub(temp);
				break;
			case "Speech & Debate Club":
			case "Improv Club":
				acadClassSpeech.addClub(temp);
				break;
			case "FCA (Fellowship of Christian Athletes)":
				athlGeneralFca.addClub(temp);
				break;
			case "Talon Wrestling Club":
				athlTeamWrestling.addClub(temp);
				break;
			case "Girls Lacrosse":
				athlTeamGirls.addClub(temp);
				break;
			case "Boys Lacrosse (through Prosper Youth Sports Association)":
				athlTeamBoys.addClub(temp);
				break;
			case "Environmental Club":
			case "ASL Club":
			case "UNICEF Club":
				ldLocal.addClub(temp);
				break;
			case "Model United Nations Club":
			case "Junior World Affairs Council":
				ldGlobal.addClub(temp);
				break;
			case "Best Buddies":
			case "Community Service Club":
			case "Red Cross Club":
				ldCom.addClub(temp);
				break;
			case "Cornhole Club":
				socialGamePerson.addClub(temp);
				break;
			case "Dungeons and Dragons":
			case "Chess Club (Virtual)":
			case "Video Gaming Club":
				socialGameVirtual.addClub(temp);
				break;
			case "Art Club":
				socialArt.addClub(temp);
				break;
			case "Spanish Club":
			case "United Cultural Society":
			case "Black Student Union":
			case "Bollywood Dance Club":
			case "K-Pop Club":
				socialCulture.addClub(temp);
				break;
			case "Book Club":
			case "Philosophy Club":
				socialDisc.addClub(temp);
				break;
			case "Nostalgic Club - Elementary Indoor Recess":
			case "Step Team":
			case "Bass Fishing Tournament Team":
				socialActivity.addClub(temp);
				break;
				
			
			}
			
//			System.out.println(temp);
			
			
			
		}
		
		clubGroups.add(acadHonorsArts);
		clubGroups.add(acadHonorsLang);
		clubGroups.add(acadCareerBus);
		clubGroups.add(acadCareerMed);
		clubGroups.add(acadCareerLaw);
		clubGroups.add(acadCareerCula);
		clubGroups.add(acadClassTeach);
		clubGroups.add(acadClassJournal);
		clubGroups.add(acadClassSpeech);
		clubGroups.add(athlGeneralFca);
		clubGroups.add(athlTeamWrestling);
		clubGroups.add(athlTeamGirls);
		clubGroups.add(athlTeamBoys);
		clubGroups.add(ldLocal);
		clubGroups.add(ldGlobal);
		clubGroups.add(ldCom);
		clubGroups.add(socialGamePerson);
		clubGroups.add(socialGameVirtual);
		clubGroups.add(socialArt);
		clubGroups.add(socialCulture);
		clubGroups.add(socialDisc);
		clubGroups.add(socialActivity);
		
		ClubRunner runner = new ClubRunner(clubGroups);
		
		System.out.println("Hello!");
		
		boolean proceed = true;
		Scanner user = new Scanner(System.in);
		while (proceed) {
			runner.askIntro();
			System.out.print("Would you like to continue? Y means yes, anything else is no: ");
			String answer = user.next();
			if (answer.equals("Y") || answer.equals("y")) {
				continue;
			}
			else {
				break;
			}
			
		}
		runner.endProgram();
		System.out.println("Thanks for using ClubPicker!");
		
		
		
	}
}
