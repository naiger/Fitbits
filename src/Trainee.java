
public class Trainee {
	int position_x;
	int position_y;
	String orientation;
	
	public Trainee(int x, int y, String orien) {
		this.position_x = x;
		this.position_y = y;
		this.orientation = orien;
	}
	
	//get the current orientation of the trainee
	public String getCurrentOrien() {
		return this.orientation;
	}
	
	//get the current position of the trainee
	public int[] getPosition() {
		int[] position = {this.position_x, this.position_y};
		return position;
	}
	
	//let trainee move forward one grid position on the current orientation
	public void forward() {
		switch(this.orientation) {
		case "N":
			this.position_y ++;
			break;
		case "S":
			this.position_y --;
			break;
		case "E":
			this.position_x ++;
			break;
		case "W":
			this.position_x --;
			break;
		}
	}
	
	//let trainee turn left
	public void turnLeft() {
		switch(this.orientation) {
		case "N":
			this.orientation = "W";
			break;
		case "S":
			this.orientation = "E";
			break;
		case "E":
			this.orientation = "N";
			break;
		case "W":
			this.orientation = "S";
			break;
		}
	}
	
	//let trainee turn right
	public void turnRight() {
		switch(this.orientation) {
		case "N":
			this.orientation = "E";
			break;
		case "S":
			this.orientation = "W";
			break;
		case "E":
			this.orientation = "S";
			break;
		case "W":
			this.orientation = "N";
			break;
		}		
	}
	
	//verify position after movement is still in pitch 
	public boolean isInPitchAfterMove(Pitch p, int[] position) {
		int width = p.getWidth();
		int height = p.getHeight();
		String orien = this.getCurrentOrien();
		if (isInPitchAfterMoveOnX(width, position[0], orien) 
			&& isInPitchAfterMoveOnY(height, position[1], orien)) return true;
		else return false;
	}
		
	//verify movement on X coordinate 
	private boolean isInPitchAfterMoveOnX(int width, int x, String orien) {
		if ( x > 0 && x < width) return true;
		else if ( x == 0 && orien != "W") return true;
		else if ( x == width && orien != "E") return true;
		else return false;
	}
	
	//verify movement on Y coordinate 
	private boolean isInPitchAfterMoveOnY(int height, int y, String orien) {
		if ( y > 0 && y < height) return true;
		else if ( y == 0 && orien != "S") return true;
		else if ( y == height && orien != "N") return true;
		else return false;
	}
	
	//implement all movements to the trainee
	public void move(String movements, Pitch p) {
		String[] moves = movements.split("");
		for(int i = 0; i < moves.length; i++) {
			switch(moves[i]) {
			case "L": this.turnLeft();
				break;
			case "R": this.turnRight();
				break;
			case "M": if(isInPitchAfterMove(p, this.getPosition())) this.forward(); //if trainee is going to move out of the pitch, stop moving
					break;
			}
		}
	}
}
