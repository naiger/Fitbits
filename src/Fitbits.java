import java.util.Scanner;

public class Fitbits {
	
	//implement all movements of the trainee
	public static void movements(String movements, Pitch p, Trainee t) {
		String[] moves = movements.split("");
		for(int i = 0; i < moves.length; i++) {
			switch(moves[i]) {
			case "L": t.turnLeft();
				break;
			case "R": t.turnRight();
				break;
			case "M": if(isInPitchAfterMove(p, t)) t.move(); //if trainee is going get out of the coach, stop moving
				break;
			}
		}
	}
	
	//verify position after movement is still in coach 
	public static boolean isInPitchAfterMove(Pitch p, Trainee t) {
		int width = p.getWidth();
		int height = p.getHeight();
		int[] position = t.getPosition();
		String orien = t.getCurrentOrien();
		if (isInPitchAfterMoveOnX(width, position[0], orien) 
			&& isInPitchAfterMoveOnY(height, position[1], orien)) return true;
		else return false;
	}
	
	//verify movement on X coordinate 
	private static boolean isInPitchAfterMoveOnX(int width, int x, String orien) {
		if ( x > 0 && x < width) return true;
		else if ( x == 0 && orien != "W") return true;
		else if ( x == width && orien != "E") return true;
		else return false;
	}
	
	//verify movement on Y coordinate 
	private static boolean isInPitchAfterMoveOnY(int height, int y, String orien) {
		if ( y > 0 && y < height) return true;
		else if ( y == 0 && orien != "S") return true;
		else if ( y == height && orien != "N") return true;
		else return false;
	}

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
		movements(m1, p, t1);
		movements(m2, p, t2);
		
		int[] position1 = t1.getPosition();
		int[] position2 = t2.getPosition();
		
		System.out.println(position1[0]+ " " + position1[1] + " " + t1.getCurrentOrien());
		System.out.println(position2[0]+ " " + position2[1] + " " + t2.getCurrentOrien());
		
	}
}
