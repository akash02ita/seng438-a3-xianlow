package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.jmock.internal.ExpectationBuilder;
import org.junit.Before;
import org.junit.Test;

public class calculateColumnForTwoValuesNegativeTest extends DataUtilities {
    Mockery mockingContext = new Mockery();
    final Values2D values = mockingContext.mock(Values2D.class);
	@Before
	public void setUp() {
		//There will be two columns and first value of column 1 is 10.5 and 
		//for column 2 will be 5.5

	     mockingContext.checking((ExpectationBuilder) new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(-1));
	             one(values).getColumnCount();
	             will(returnValue(3));
	             one(values).getValue(0, 0);
	             will(returnValue(10.5));
	             one(values).getValue(0, 1);
	             will(returnValue(5.5));
	             
	         }
	     });
	}

	 @Test
	 public void calculateColumnForTwoValuesNegative() {
	     // exercise	
		//Usage of the function with values stated above and using only row zero

	     double result2 = DataUtilities.calculateColumnTotal(values, 0);
	     assertEquals(16.0, result2, .000000001d);
	     // tear-down: NONE in this test method
	 }
}
