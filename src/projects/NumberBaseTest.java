package projects;
import org.junit.Assert;
import org.junit.Test;

/**
 * Example unit tests for the NumberBase.conversions method
 *
 * @author Zachary Kurmas
 * @modifier Jared Moore
 */
// Created  8/26/13 at 11:48 AM
// (C) Zachary Kurmas 2013
// Modified 07/26/2016 by Jared Moore

public class NumberBaseTest {

   @Test
   public void decimal_to_binary() throws Throwable {
      Assert.assertEquals("0", NumberBase.convert("0", 10, 2));
      Assert.assertEquals("1", NumberBase.convert("1", 10, 2));
      Assert.assertEquals("1010", NumberBase.convert("10", 10, 2));
      Assert.assertEquals("1000011110001", NumberBase.convert("4337", 10, 2));
   }

   @Test
   public void binary_to_decimal() throws Throwable {
      Assert.assertEquals("0", NumberBase.convert("0", 2, 10));
      Assert.assertEquals("1", NumberBase.convert("1", 2, 10));
      Assert.assertEquals("2", NumberBase.convert("10", 2, 10));
      Assert.assertEquals("3", NumberBase.convert("11", 2, 10));
      Assert.assertEquals("10", NumberBase.convert("1010", 2, 10));
      Assert.assertEquals("4337", NumberBase.convert("1000011110001", 2, 10));
   }

   @Test
   public void decimal_to_hex() throws Throwable {
      Assert.assertEquals("0", NumberBase.convert("0", 10, 16));
      Assert.assertEquals("1", NumberBase.convert("1", 10, 16));
      Assert.assertEquals("a", NumberBase.convert("10", 10, 16));
      Assert.assertEquals("64", NumberBase.convert("100", 10, 16));
      Assert.assertEquals("dead", NumberBase.convert("57005", 10, 16));
   }

   // Remember:  When looking for an exception, you can do only *one* test
   // per method.
   @Test(expected = IllegalArgumentException.class)
   public void input_is_valid1() {
      NumberBase.convert("14d", 10, 2);
   }

   @Test
   public void hex_to_decimal() throws Throwable{
	   Assert.assertEquals("0", NumberBase.convert("0", 16, 10));
	   Assert.assertEquals("455339", NumberBase.convert("6f2ab", 16, 10));
	   Assert.assertEquals("35148", NumberBase.convert("894c", 16, 10));
	   Assert.assertEquals("831194", NumberBase.convert("caeda", 16, 10));
	   Assert.assertEquals("17829905", NumberBase.convert("01101011", 16, 10));
	   Assert.assertEquals("57005", NumberBase.convert("dead", 16, 10));
	   Assert.assertEquals("2989", NumberBase.convert("bad", 16, 10));
	   
   }
   
	@Test
	public void testNumberBaseToBaseTen() throws Throwable{
		String num = NumberBase.convert("1010", 2, 10);
		Assert.assertEquals("should be 10", "10", num);
		num = NumberBase.convert("52354",7, 10);
		Assert.assertEquals("should be 12877", "12877", num);
		num = NumberBase.convert("121021", 3, 10);
		Assert.assertEquals("should be 439", "439", num);
		num = NumberBase.convert("854657", 9, 10);
		Assert.assertEquals("should be 508651", "508651", num);
		num = NumberBase.convert("2054765", 10, 10);
		Assert.assertEquals("should be 2054765", "2054765", num);
	}
	
	@Test
	public void testNumberBaseDifferentBases() throws Throwable{
		String num = NumberBase.convert("11101001001111", 2, 16);
		Assert.assertEquals("should be 3a4f", "3a4f", num);
		num = NumberBase.convert("hfed", 20, 8);
		Assert.assertEquals("Should be 425725", "425725", num);
		num = NumberBase.convert("72p4ja", 28, 2);
		Assert.assertEquals("Should be 111010010010111010000011110", "111010010010111010000011110", num);
		num = NumberBase.convert("72p4ja", 30, 4);
		Assert.assertEquals("Should be 22101221221030", "22101221221030", num);
	}
	
	@Test
	public void testNumberBaseUnderBaseTen() throws Throwable{
		Assert.assertEquals("126755", NumberBase.convert("542045", 6, 8));
		Assert.assertEquals("1121211", NumberBase.convert("3313234", 5, 6));
		Assert.assertEquals("1211120012030131", NumberBase.convert("60101460124", 7, 4));
		Assert.assertEquals("1056", NumberBase.convert("1000101110", 2, 8));
		Assert.assertEquals("100100001011100010110101", NumberBase.convert("4412000334", 5, 2));
		Assert.assertEquals("15105616012", NumberBase.convert("15105616012", 7, 7));
	}
	
	@Test
	public void testNumberBaseOverBaseTen() throws Throwable{
		Assert.assertEquals("1507b34c2", NumberBase.convert("dcj2h5c", 23, 14));
		Assert.assertEquals("e4830d5", NumberBase.convert("a23c6g7", 18, 17));
		Assert.assertEquals("316267827", NumberBase.convert("5020d1df", 16, 12));
		Assert.assertEquals("5717063a", NumberBase.convert("c69060f", 19, 14));
		Assert.assertEquals("5pnaku", NumberBase.convert("97814b26", 12, 36));
		Assert.assertEquals("hb1oyf", NumberBase.convert("k0ivd0", 34, 35));
	}
	
	@Test(expected = IllegalArgumentException.class)
	   public void input_is_valid2() {
	      NumberBase.convert("5f6dcu8", 30, 2);
	   }
	
	@Test(expected = IllegalArgumentException.class)
	   public void input_is_valid3() {
	      NumberBase.convert("1516754", 2, 4);
	   }
	
	@Test(expected = IllegalArgumentException.class)
	   public void input_is_valid4() {
	      NumberBase.convert("14685a156", 10, 2);
	   }
	
	@Test(expected = IllegalArgumentException.class)
	   public void input_is_valid5() {
	      NumberBase.convert("4t6", 22, 12);
	   }
	
	@Test(expected = IllegalArgumentException.class)
	   public void input_is_valid6() {
	      NumberBase.convert("", 22, 12);
	   }
	
	@Test(expected = IllegalArgumentException.class)
	   public void input_is_valid7() {
	      NumberBase.convert("-3", 22, 12);
	   }
}
