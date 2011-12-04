import java.util.HashSet;


public class Point2d {

	private int _x;
	private int _y;
	private int _hashCode;
	
	public Point2d(int x, int y)
	{
		_x = x;
		_y = y;
	}

	public int get_x() {
		return _x;
	}

	public int get_y() {
		return _y;
	}
	
	@Override
	public int hashCode() {
		calculateHashCode();
		return _hashCode;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (!(otherObject instanceof Point2d)){
			return false;
		}
		Point2d otherPoint = (Point2d)otherObject;
		return haveSamePosition(this, otherPoint);
	}

	public HashSet<Point2d> getNeighboursPositions() {
		HashSet<Point2d> neighboursPositions =  new HashSet<Point2d>();
		
		neighboursPositions.add(getTopLeftPosition());
		neighboursPositions.add(getTopPosition());
		neighboursPositions.add(getTopRightPosition());
		neighboursPositions.add(getLeftPosition());
		neighboursPositions.add(getRightPosition());
		neighboursPositions.add(getBottomLeftPosition());
		neighboursPositions.add(getBottomPosition());
		neighboursPositions.add(getBottomRightPosition());
		
		return neighboursPositions;
	}

	/*
	 * hashCode for the object is lazy loaded
	 * and cached inside _hashcode. We can do
	 * this due to the fact that Cell is immutable
	 */
	private void calculateHashCode()
	{
		if (_hashCode == 0) {
			int hash = 23;
			hash = hash * 31 + _x;
			hash = hash * 31 + _y;
			_hashCode = hash;
		}
	}
	
	private boolean haveSamePosition(Point2d firstPoint, Point2d secondPoint)
	{
		boolean haveSamePosition =
				(firstPoint._x == secondPoint._x) &&
				(firstPoint._y == secondPoint._y);
		return haveSamePosition;
	};
	
	private Point2d getTopLeftPosition()
	{
		return getPosition(-1, -1);
	}

	private Point2d getTopPosition()
	{
		return getPosition(0,-1);
	}

	private Point2d getTopRightPosition() {
		return getPosition(+1, -1);
	}

	private Point2d getRightPosition() {
		return getPosition(+1, 0);
	}

	private Point2d getBottomRightPosition() {
		return getPosition(+1, +1);
	}

	private Point2d getBottomPosition() {
		return getPosition(0, +1);
	}

	private Point2d getBottomLeftPosition() {
		return getPosition(-1, +1);
	}

	private Point2d getLeftPosition() {
		return getPosition(-1, 0);
	}
	
	private Point2d getPosition(int xOffset, int yOffset)
	{
		int x =  _x + xOffset;
		int y =  _y + yOffset;
		Point2d position =  new Point2d(x, y);
		return position;
	}
}
