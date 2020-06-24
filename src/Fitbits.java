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
		
		//initial trainee one
		System.out.println("Enter the position and orientation of the 1st trainee: ");
		int position_x = scan.nextInt();
		int position_y = scan.nextInt();
		String orien = scan.next();

		Trainee t1 = new Trainee(position_x, position_y, orien);
		
		//initial movements of trainee one
		System.out.println("Enter the movements of the 1st trainee: ");
		String m1 = scan.next();
		
		//initial trainee one
		System.out.println("Enter the position and orientation of the 2nd trainee: ");
		position_x = scan.nextInt();
		position_y = scan.nextInt();
		orien = scan.next();
		
		Trainee t2 = new Trainee(position_x, position_y, orien);
		
		System.out.println("Enter the movements of the 2nd trainee: ");
		String m2 = scan.next();
		
		//close input
		scan.close();
		
		//moving two trainees
		t1.move(m1, p);
		t2.move(m2, p);
		
		int[] position1 = t1.getPosition();
		int[] position2 = t2.getPosition();
		
		System.out.println("The 1st Trainee: " + position1[0]+ " " + position1[1] + " " + t1.getCurrentOrien());
		System.out.println("The 1st Trainee: " + position2[0]+ " " + position2[1] + " " + t2.getCurrentOrien());
		
	}
}
