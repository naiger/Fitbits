import java.util.Scanner;

public class Fitbits {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//initial pitch
		System.out.println("Enter the upper-right coordinates of the pitch: ");
		int width = scan.nextInt();
		int length = scan.nextInt();
		//System.out.println(width + " " + length);

		Pitch p = new Pitch(width, length);
		
		//enter multiple trainees in this pitch
		do {
			//initial trainee
			System.out.println("Enter the position and orientation of trainee: ");
			int position_x = scan.nextInt();
			int position_y = scan.nextInt();
			String orien = scan.next();

			Trainee t = new Trainee(position_x, position_y, orien);
			
			//initial movements of trainee
			System.out.println("Enter the movements of the trainee: ");
			String m = scan.next();
			
			//implement movements of this trainee
			t.move(m, p);
			int[]position = t.getPosition();
			
			//print position and orientation after move
			System.out.println("The trainee's position and orientation after move: ");
			System.out.println(position[0]+ " " + position[1] + " " + t.getCurrentOrien() + "\n");
			System.out.println("Enter 'exit' to exit or enter any value to continue");
		} while(!scan.next().equals("exit"));

		scan.close();
	}
}
