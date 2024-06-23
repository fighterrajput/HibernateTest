package com.rays.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAssertEqual {

	@Test
	public void testAssertEqual() {
		Calculation.findMax(new int[] { 1, 2, 4, 3, 6 });

		assertEquals(2, max);

	}
}
