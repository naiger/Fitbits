import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PitchTest {

	private final Pitch p = new Pitch(5,4);

	@Test
	void testGetHeight() {
		assertEquals(4, p.getHeight());
	}
	
	@Test
	void testGetWidth() {
		assertEquals(5, p.getWidth());
	}
}
