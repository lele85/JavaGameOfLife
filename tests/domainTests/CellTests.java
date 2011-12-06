package domainTests;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Test;

import domain.Cell;
import domain.Point2d;


public class CellTests {
	
	@Test
	public void testCellsEquality()
	{
		Cell cell1 = new Cell(0,0);
		Cell cell2 = new Cell(1,2);
		Cell cell3 = new Cell(1,2);
		
		Assert.assertTrue(cell2.equals(cell3));
		Assert.assertFalse(cell1.equals(cell2));
		Assert.assertFalse(cell1.equals(cell3));
	}
	
	@Test
	public void testCellsCanGiveNeighboursPositions()
	{
		Point2d topLeft =  new Point2d(4,4);
		Point2d top = new Point2d(4,5);
		Point2d topRight = new Point2d(4,6);
		Point2d left = new Point2d(5,4);
		Point2d right = new Point2d(5,6);
		Point2d bottomLeft = new Point2d(6,4);
		Point2d bottom = new Point2d(6,5);
		Point2d bottomRight = new Point2d(6,6);
		
		HashSet<Point2d> expectedNeighboursPosition =  new HashSet<Point2d>();
		
		expectedNeighboursPosition.add(topLeft);
		expectedNeighboursPosition.add(top);
		expectedNeighboursPosition.add(topRight);
		expectedNeighboursPosition.add(left);
		expectedNeighboursPosition.add(right);
		expectedNeighboursPosition.add(bottomLeft);
		expectedNeighboursPosition.add(bottom);
		expectedNeighboursPosition.add(bottomRight);
		
		Cell cell1 =  new Cell(5,5);
		HashSet<Point2d> actualNeighboursPosition =  cell1.getNeighboursPositions();
		Assert.assertTrue(expectedNeighboursPosition.equals(actualNeighboursPosition));
	}
}
