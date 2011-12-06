package domain;

public class AsciiWorldManipulator {

	final char aliveCellChar = 'o';
	final char lineSeparator = '\n';
	
	public void populate(World world, String asciiWorldRepresentation) {
		int x = 0;
		int y = 0;
		for (char currentChar:asciiWorldRepresentation.toCharArray())
		{
			if (currentChar == aliveCellChar){
				world.addCellAt(x, y);
			}
			x++;
			if (currentChar == lineSeparator){
				x = 0;
				y += 1;
			}
		}
	}
	
}
