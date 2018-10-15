package net.coderbee.learn.algorithm;

import org.junit.Assert;
import org.junit.Test;
import static net.coderbee.learn.algorithm.CountBits.*;

public class CountBitsTest {
	
	@Test
	public void testCountByType() {
		Assert.assertEquals("", 1, countByType(1));
		Assert.assertEquals("", 32, countByType(-1));
		System.out.println(countByType(-1));
		Assert.assertEquals("", 2, countByType(3));
		
	}

}

