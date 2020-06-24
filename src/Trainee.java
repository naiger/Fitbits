
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
	public void move() {
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
}
