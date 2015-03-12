import java.util.*;

// class representing a 6 sided die
// only has one method to roll the die and
// report what face is up
public class Die 
{
	static Random gen = new Random();

	// no constructor needed - no initialization required
	public int roll() 
	{
		int result = 0;
		double randNum = gen.nextDouble();
		
		// each face has probability of 1/6
		// randNum >= 0.0 and < 1.0 
		if (randNum >= 0.0 && randNum < (1.0/6.0) )
			result = 1;
		if (randNum >= (1.0/6.0) && randNum < (2.0/6.0) )
			result = 2;
		if (randNum >= (2.0/6.0) && randNum < (3.0/6.0) )
			result = 3;
		if (randNum >= (3.0/6.0) && randNum < (4.0/6.0) )
			result = 4;
		if (randNum >= (4.0/6.0) && randNum < (5.0/6.0) )
			result = 5;
		if (randNum >= (5.0/6.0) && randNum < 1.0 )
			result = 6;
		return result;  // value representing face
	} // end method roll()
}  // end class Die