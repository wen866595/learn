package net.coderbee.learn.algorithm;

import org.junit.Assert;
import org.junit.Test;

import static net.coderbee.learn.algorithm.CountBits.*;

public class TestCountBits {
	
	@Test
	public void testCountByType() {
		Assert.assertEquals("", countByType(1), 1);
		Assert.assertEquals("", countByType(-1), 32);
		Assert.assertEquals("", countByType(3), 2);
		Assert.assertEquals("", countByType(6), 2);
	}

	@Test
	public void testCountByDeduct() {
		Assert.assertEquals("", countByDeduct(1), 1);
		Assert.assertEquals("", countByDeduct(-1), 32);
		Assert.assertEquals("", countByDeduct(3), 2);
		Assert.assertEquals("", countByDeduct(6), 2);
	}

	@Test
	public void testCountByLookUpTable() {
		Assert.assertEquals("", countByLookUpTable(1), 1);
		Assert.assertEquals("", countByLookUpTable(-1), 32);
		Assert.assertEquals("", countByLookUpTable(3), 2);
		Assert.assertEquals("", countByLookUpTable(6), 2);
		Assert.assertEquals("", countByLookUpTable(0), 0);
	}

    @Test
    public void testCountByTypeRecursive() {
        Assert.assertEquals("", countByTypeRecursive(1), 1);
        Assert.assertEquals("", countByTypeRecursive(-1), 32);
        Assert.assertEquals("", countByTypeRecursive(3), 2);
        Assert.assertEquals("", countByTypeRecursive(6), 2);
        Assert.assertEquals("", countByTypeRecursive(0), 0);
    }

    @Test
    public void testCountByDeductRecursive() {
        Assert.assertEquals("", countByDeductRecursive(1), 1);
        Assert.assertEquals("", countByDeductRecursive(-1), 32);
        Assert.assertEquals("", countByDeductRecursive(3), 2);
        Assert.assertEquals("", countByDeductRecursive(6), 2);
        Assert.assertEquals("", countByDeductRecursive(0), 0);
    }

}

