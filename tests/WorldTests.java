import junit.framework.Assert;

import org.junit.Test;


public class WorldTests {

	@Test
	public void testWorldAddCell(){
		World world =  new World();
		world.addCellAt(1, 2);
		Point2d position =  new Point2d(12,34);
		world.addCellAt(position);
		Cell cell = new Cell(25,73);
		world.addCellAtSamePositionOf(cell);
		Assert.assertTrue(world.containsCellAt(1,2));
		Assert.assertFalse(world.containsCellAt(2,2));
		Assert.assertTrue(world.containsCellAt(position));
		Assert.assertTrue(world.containsCellAt(12,34));
		Assert.assertTrue(world.containsCellAt(25,73));
		Assert.assertTrue(world.containsCellAtSamePositionOf(cell));
	}
	
	@Test
	public void testClearWorld()
	{
		World world =  new World();
		world.addCellAt(1, 1);
		world.addCellAt(2, 3);
		world.clear();
		Assert.assertFalse(world.containsCellAt(1, 1));
		Assert.assertFalse(world.containsCellAt(2, 3));
	}
	
	@Test
	public void testWorldCellCount()
	{
		World world =  new World();
		Assert.assertTrue(world.cellCount() == 0);
		world.addCellAt(1,3);
		Assert.assertTrue(world.cellCount() == 1);
		world.addCellAt(2,3);
		Assert.assertTrue(world.cellCount() == 2);
		world.addCellAt(3,3);
		Assert.assertTrue(world.cellCount() == 3);
		world.addCellAt(4,3);
		Assert.assertTrue(world.cellCount() == 4);
		world.addCellAt(1,3);
		Assert.assertTrue(world.cellCount() == 4);
	}
	
	@Test
	/*
	 * Simple oscillator evolution in GameOfLife
	 * 
	 * 010    000
	 * 010 => 111
	 * 010    000
	 */
	public void testOscillatorEvolution(){
		
		World firstWorld =  new World();
		World secondWorld =  new World();
		
		firstWorld.addCellAt(0, 1);
		firstWorld.addCellAt(1, 1);
		firstWorld.addCellAt(2, 1);
		
		firstWorld.evolveIn(secondWorld);
		
		Assert.assertTrue(secondWorld.containsCellAt(1,0));
		Assert.assertTrue(secondWorld.containsCellAt(1,1));
		Assert.assertFalse(secondWorld.containsCellAt(0,1));
		Assert.assertFalse(secondWorld.containsCellAt(2,1));
		Assert.assertTrue(secondWorld.containsCellAt(1,2));
		Assert.assertTrue(secondWorld.cellCount() == 3);
	}
	
}
