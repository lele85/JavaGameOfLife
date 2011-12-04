import java.util.HashSet;


public class World {

	private HashSet<Cell> _cells;
	
	public World() {
		_cells =  new HashSet<Cell>();
	}
	
	public void addCellAt(int x, int y) {
		Cell cell = new Cell(x,y);
		_cells.add(cell);
	}
	
	public void addCellAt(Point2d position) {
		addCellAt(position.get_x(), position.get_y());		
	}

	public void addCellAtSamePositionOf(Cell cell) {
		_cells.add(cell);
	}

	public boolean containsCellAt(int x, int y)
	{
		Cell cell = new Cell(x,y);
		return _cells.contains(cell);
	}

	public boolean containsCellAt(Point2d position) {
		return containsCellAt(position.get_x(), position.get_y());
	}

	public boolean containsCellAtSamePositionOf(Cell cell) {
		return _cells.contains(cell);
	}

	public int cellCount() {
		return _cells.size();
	}

	public void clear() {
		_cells.clear();
	}

	public void evolveIn(World nextWorld) {
		nextWorld.clear();
		deathCycle(nextWorld);
		birthCycle(nextWorld);
		
	}

	private void birthCycle(World nextWorld) {
		for (Cell cell:_cells)
		{
			for (Point2d position:cell.getNeighboursPositions())
			{
				int neighboursCount =  neighboursCount(position);
				if (neighboursCount == 3)
				{
					nextWorld.addCellAt(position);
				}
			}
		}
	}

	private void deathCycle(World nextWorld) {
		for (Cell cell:_cells)
		{
			int neighboursCount =  neighboursCount(cell.get_position());
			if (neighboursCount == 2 || neighboursCount == 3)
			{
				nextWorld.addCellAtSamePositionOf(cell);
			}
		}
	}
	
	private int neighboursCount(Point2d cellPosition)
	{
		HashSet<Point2d> neighboursPositions = cellPosition.getNeighboursPositions();
		int neighbours = 0;
		for(Point2d position:neighboursPositions)
		{
			if (containsCellAt(position.get_x(), position.get_y()))
			{
				neighbours += 1;
			}
		}
		return neighbours;
	}
}
