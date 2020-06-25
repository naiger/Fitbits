import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TraineeTest {
	
	Pitch p = new Pitch(5, 5);
	Trainee t = new Trainee(1, 2, "W");
	
	@Test
	void testGetCurrentOrien() {
		assertEquals("W", t.getCurrentOrien());
	}

	@Test
	void testTrunLeft() {
		t.turnLeft();
		assertEquals("S", t.getCurrentOrien());
	}
	
	@Test
	void testTurnRight() {
		t.turnRight();
		assertEquals("N", t.getCurrentOrien());
	}
	
	@Test 
	void testGetPosition(){
		int[] position = t.getPosition();
		assertEquals(1, position[0]);
		assertEquals(2, position[1]);
	}

	
	@Test
	void testForward() {
		t.forward();
		int[] position = t.getPosition();
		assertEquals(0, position[0]);
	}
	
	@Test
	void testIsInPitchAfterMove() {
		//test on x coordinate
		int[] position = {0, 2};
		assertEquals(false, t.isInPitchAfterMove(p, position));
		
		//test on y coordinate
		t.turnRight();
		int[] position2 = {1, 5};
		assertEquals(false, t.isInPitchAfterMove(p, position2));
	}
	
	@Test
	void testMove() {
		t.move("LMLMLMLMM", p);
		int[] position = t.getPosition();
		assertEquals(0, position[0]);
		assertEquals(2, position[1]);
		assertEquals("W", t.getCurrentOrien());
	}
	
}
