import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class UtepTube {
	public static void main(String[] args) {
		File corpus = new File("corpus.csv");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Welcome to UtepTube! Please select an option below to continue: " +
			"\n\t1. List videos in corpus\n\t2. Add video to playlist\n\t3. View playlist\n\t4. Clear playlist\n\t5. Close UtepTube\n");
		Boolean keepGoing = true;
		int hour = 0;
		int count = 0;
		int totalMinutes = 0;
		int totalSeconds = 0;
		String playlist = ("------------- YOUR PLAYLIST ------------\n");
		
		while(keepGoing){
		int n = scanner.nextInt();

		if(n == 1){
		try{
			Scanner reader = new Scanner(corpus);
			// reader.useDelimiter(",l\\n");
			while(reader.hasNextLine()){
				String currentLine = reader.nextLine();
				System.out.println(currentLine);
				// String id = reader.next();
				// String firstName = reader.next();
				// String lastName = reader.next();

			}
		}catch(FileNotFoundException e){

		}
		System.out.println("----------------------------------------");
		System.out.print("Please select an option below to continue: " +
			"\n\t1. List videos in corpus\n\t2. Add video to playlist\n\t3. View playlist\n\t4. Clear playlist\n\t5. Close UtepTube\n");

			
		}
		else if(n == 2){
			Scanner input = new Scanner(System.in);
			System.out.println("Enter video Id: ");
			String inputId = input.nextLine();
			Boolean videoNotFound = true;

			try{
			Scanner idReader = new Scanner(corpus);
			idReader.useDelimiter(",|\\n");

			while(idReader.hasNext()){
				String videoId = idReader.next();
				String title = idReader.next();
				String creator = idReader.next();
				String minutes = idReader.next();
				String seconds = idReader.next();
				String preRoll = idReader.next();
				String midRoll = idReader.next();
				String postRoll = idReader.next();

				if(inputId.equals(videoId)){
					System.out.println(title);
					System.out.println(creator);
					videoNotFound = false;
					int a = Integer.parseInt(minutes);
					int b = Integer.parseInt(seconds);
					totalMinutes += a;
					totalSeconds += b;
					if(totalSeconds > 59){
						totalMinutes ++;
						totalSeconds = 0;
					}
					if(totalMinutes > 59){
						hour ++;
						totalMinutes = 0;
					}
					if(preRoll.equals("false") && midRoll.equals("false") && postRoll.equals("false")){
						preRoll="";
						midRoll="no ads";
						postRoll="";
					}
					else{
					if(preRoll.equals("true")){
						preRoll=("+30s of preroll");
					}
					else if(preRoll.equals("false")){
						preRoll = "";
					}

					if(midRoll.equals("true")){
						System.out.println("This video has a mid roll ad, do you want to skip? (yes or no)");
						midRoll = scanner.next();
						if(midRoll.equals("no")){
							midRoll = "+2m midroll";
						}
						else if (midRoll.equals("yes")){
							midRoll = "+10s of midroll";
						}
					}
					else if(midRoll.equals("false")){
						midRoll=" ";
					}

					if (postRoll.equals("true")){
						postRoll="+5s of post roll";
					}
					else if(postRoll.equals("false")){
						postRoll=" ";
					}
				}
					count++;
					if(count>10){playlist += (count+". https://youtu.be/"+ videoId +" | "+minutes+":"+seconds +" ( " + preRoll +" "+ midRoll + " "+postRoll+" )\n");
				}
				else{
					playlist += (" "+count+". https://youtu.be/"+ videoId +" | "+minutes+":"+seconds +" ( " + preRoll +" "+ midRoll + " "+postRoll+" )\n");
				}
				}
			}
			
			}
		catch(FileNotFoundException e){
			}
		if(videoNotFound){
				System.out.println("Video not found.");
		}
		System.out.println("----------------------------------------");
		System.out.print("Please select an option below to continue: " +
			"\n\t1. List videos in corpus\n\t2. Add video to playlist\n\t3. View playlist\n\t4. Clear playlist\n\t5. Close UtepTube\n");
				
			}

		else if(n == 3){
			System.out.println(playlist);
			if(totalSeconds <10 && totalMinutes<10){
				System.out.println("Total play time: " +hour + ":0" + totalMinutes + ":0" +totalSeconds);
			}
			else if(totalSeconds <10){
				System.out.println("Total play time: " +hour + ":" + totalMinutes + ":0" +totalSeconds);
			}
			else if(totalMinutes <10){
				System.out.println("Total play time: " +hour + ":0" + totalMinutes + ":" +totalSeconds);
			}
			else{
				System.out.println("Total play time: " +hour + ":" + totalMinutes + ":" +totalSeconds);
			}
			System.out.println("----------------------------------------");
			System.out.print("Please select an option below to continue: " +
			"\n\t1. List videos in corpus\n\t2. Add video to playlist\n\t3. View playlist\n\t4. Clear playlist\n\t5. Close UtepTube\n");
		}

		else if(n == 4){
			System.out.println("Do you wish to clear your playlist? (yes or no");
			String answer = scanner.next();
			if(answer.equals("yes")){
				hour = 0;
				totalMinutes = 0;
				totalSeconds = 0;
				playlist = ("------------- YOUR PLAYLIST ------------\n");
			}
			else{}
			System.out.println("----------------------------------------");		
			System.out.print("Please select an option below to continue: " +
			"\n\t1. List videos in corpus\n\t2. Add video to playlist\n\t3. View playlist\n\t4. Clear playlist\n\t5. Close UtepTube\n");


		}

		else if(n == 5){
			keepGoing = false;
			System.out.println("Thank you, goodbye!");
		}

		else{
			System.out.print("Welcome to UtepTube! Please select an option below to continue: " +
			"\n\t1. List videos in corpus\n\t2. Add video to playlist\n\t3. View playlist\n\t4. Clear playlist\n\t5. Close UtepTube\n");
		}
		}
		

	}
}