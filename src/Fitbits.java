import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Fitbits {

	public static void main(String[] args) {
		
		Path path = Paths.get(".");
		File file = new File(path.toAbsolutePath() + "/testInput.txt");
		String inputLine = "";
		String[] pitchSetUp = new String[2];
		Pitch p = null;
		
		String[] traineeSetUp = new String[3];
		String movement = "";
		ArrayList<Trainee> trainees = new ArrayList<Trainee>();
		ArrayList<String> movements = new ArrayList<String>();
		
		try {
			Scanner scan = new Scanner(file);
			if(scan.hasNextLine()) {
				inputLine = scan.nextLine();
				pitchSetUp = inputLine.split(" ");
				p = new Pitch(Integer.parseInt(pitchSetUp[0]), Integer.parseInt(pitchSetUp[1]));
			}
			while(scan.hasNextLine()) {
				inputLine = scan.nextLine();
				traineeSetUp = inputLine.split(" ");
				Trainee t = new Trainee(Integer.parseInt(traineeSetUp[0]), Integer.parseInt(traineeSetUp[1]), traineeSetUp[2]);
				movement = scan.nextLine();				
				trainees.add(t);
				movements.add(movement);
			}
			scan.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

		for (int i = 0; i < trainees.size(); i++) {
			trainees.get(i).move(movements.get(i), p);
			int[] position = trainees.get(i).getPosition();
			System.out.println(position[0] + " " + position[1] + " " + trainees.get(i).getCurrentOrien());
		}
		
		
	}
}
