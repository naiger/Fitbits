import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TraineeTest {
	
	Trainee t = new Trainee(1, 2, "N");
	
	@Test
	void testGetCurrentOrien() {
		assertEquals("N", t.getCurrentOrien());
	}

	@Test
	void testTrunLeft() {
		t.turnLeft();
		assertEquals("W", t.getCurrentOrien());
	}
	
	@Test
	void testTurnRight() {
		t.turnRight();
		assertEquals("E", t.getCurrentOrien());
	}
	
	@Test 
	void testGetPosition(){
		int[] position = t.getPosition();
		assertEquals(1, position[0]);
		assertEquals(2, position[1]);
	}

	
	@Test
	void testMove() {
		t.move();
		int[] position = t.getPosition();
		assertEquals(3, position[1]);
	}
	
}
