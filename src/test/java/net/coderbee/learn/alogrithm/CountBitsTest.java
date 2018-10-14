package net.coderbee.learn.algorithm;

import org.junit.Assert;
import org.junit.Test;
import static net.coderbee.learn.algorithm.CountBits.*;

public class CountBitsTest {
	
	@Test
	public void testCountByType() {
		Assert.assertEquals("", countByType(1), 1);
		Assert.assertEquals("", countByType(-1), 32);
		System.out.println(countByType(-1));
		Assert.assertEquals("", countByType(3), 2);
		
	}

}

