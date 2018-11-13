/* A class describing a move in the board
 * Every produced child corresponds to a move
 * and we need to keep the moves as well as the states.
 */
public class Move
{
	private int row;
	private int col;
	private int value;
	private int counter;
	private char player;
	
	public Move(char player)
	{
		row = -1;
		col = -1;
		this.player = player;
		this.value = 0;
}
	
	public Move( char player,int row, int col,int value)
	{
		this.row = row;
		this.col = col;
		this.value = value;
		this.player = player;
	}

	public Move(int value)
	{
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
	
	public int getValue()
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
	
	public void setValue(int value)
	{
		this.value = value;
	}

	public void setPlayer(char player){
		 this.player=player;
	}

	public char getPlayer(){
		return player;
	}

	public char getOpp(){
		if (getPlayer()=='W'){
			return 'B';
		}else{
			return 'W';
		}
	}
}
