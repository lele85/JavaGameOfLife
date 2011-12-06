package utils;
import junit.framework.Assert;
import org.junit.Test;

public class TextReaderTests {
	
	@Test
	public void testTextReaderCanReadAllContents()
	{
		String expected = "TestData\n@23\npippo pippo\n";
		String content =  TextReader.getContents("tests/utils/TestData.txt");
		Assert.assertTrue(expected.equals(content));
	}
}
