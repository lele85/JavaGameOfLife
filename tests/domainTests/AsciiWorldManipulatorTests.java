package domainTests;
import junit.framework.Assert;

import org.junit.Test;

import domain.AsciiWorldManipulator;
import domain.World;


public class AsciiWorldManipulatorTests {

	@Test
	public void testCanGenerateWorldFromAsciiRepresentation()
	{
		String asciiWorldRepresentation = 
				".o.\n" +
				".o.\n" +
				".o.\n";
		World world =  new World();
		AsciiWorldManipulator worldManipulator = new AsciiWorldManipulator(); 
		
		worldManipulator.populate(world, asciiWorldRepresentation);
		Assert.assertTrue(world.cellCount() == 3);
		Assert.assertTrue(world.containsCellAt(1, 0));
		Assert.assertTrue(world.containsCellAt(1, 1));
		Assert.assertTrue(world.containsCellAt(1, 2));
	}	
}
