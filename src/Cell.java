import java.util.HashSet;


public class Cell {

	private Point2d _position;
	
	public Point2d get_position() {
		return new Point2d(_position.get_x(),_position.get_y());
	}

	public Cell(int x, int y) {
		_position =  new Point2d(x,y);
	}

	@Override
	public boolean equals(Object otherObject) {
		if (!(otherObject instanceof Cell)){
			return false;
		}
		Cell otherCell = (Cell)otherObject;
		return haveSamePosition(this, otherCell);
	}
	
	@Override
	public int hashCode() {
		return _position.hashCode();
	};
	
	public HashSet<Point2d> getNeighboursPositions() {
		return _position.getNeighboursPositions();
	}

	private boolean haveSamePosition(Cell firstCell, Cell secondCell)
	{
		return (firstCell._position.equals(secondCell._position));
	}
}
