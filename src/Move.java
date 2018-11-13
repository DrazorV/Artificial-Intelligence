/* A class describing a move in the board
 * Every produced child corresponds to a move
 * and we need to keep the moves as well as the states.
 */
public class Move
{
	private int row;
	private int col;
	private char value;
	
	public Move(char value)
	{
		row = -1;
		col = -1;
		this.value = value;
}
	
	public Move( char value,int row, int col)
	{
		this.row = row;
		this.col = col;
		this.value = value;
	}

	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}
	
	public char getValue()
	{
		return value;
	}

	public void setRow(int row)
	{
		this.row = row;
	}

	public void setCol(int col)
	{
		this.col = col;
	}
	
	public void setValue(char value)
	{
		this.value = value;
	}
}
