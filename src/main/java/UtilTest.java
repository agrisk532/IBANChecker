import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
* JUnit test cases for class Util
* 
* @author Agris Klimkans
* 
*/
public class UtilTest {

	@Test
	void testIsIBANLengthCorrect() {
		assertEquals(true, Util.isIBANLengthCorrect("GB82WEST12345698765432", "GB"));
	}

	@Test
	void testIsIBANCorrect() {
		assertEquals("BE71 0961 2345 6769: ok", Util.isIBANCorrect("BE71 0961 2345 6769"));
	}
	
	@Test
	void testGetCountryCode()
	{
		assertEquals("GB",Util.getCountryCode("GB123"));
	}
	
	@Test
	void testGetIBANLength()
	{
		assertEquals(21, Util.getIBANLength("LV"));
	}
	
	@Test
	void testTransformIBAN()
	{
		assertEquals("3214282912345698765432161182", Util.transformIBAN("GB82WEST12345698765432"));
	}
	
	@Test
	void testMoveFirstFourChars()
	{
		assertEquals("WEST12345698765432GB82", Util.moveFirstFourChars("GB82WEST12345698765432"));
	}
	
	@Test
	void testConvertToInteger()
	{
		assertEquals("3214282912345698765432161182", Util.convertToInteger("WEST12345698765432GB82"));
	}
	
	@Test
	void testcomputeMod97Remainder()
	{
		assertEquals(1, Util.computeMod97Remainder("3214282912345698765432161182"));
	}

}
