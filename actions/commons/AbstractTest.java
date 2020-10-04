package commons;

import java.util.Random;

public class AbstractTest {

	protected int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
}
