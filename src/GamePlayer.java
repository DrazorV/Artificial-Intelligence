import java.util.ArrayList;
import java.util.Random;

public class GamePlayer
{
    //Variable that holds the maximum depth the MiniMax algorithm will reach for this player
	private int maxDepth;
    //Variable that holds which letter this player controls
	private char botletter;

	public GamePlayer(int maxDepth, char playerLetter)
	{
		this.maxDepth = maxDepth;
		this.botletter = playerLetter;
	}

    //Initiates the MiniMax algorithm
	public Move MiniMax(Board board)
	{
        //If the X plays then it wants to MAXimize the heuristics value
        if (botletter == 'B')
        {
            return max(new Board(board), 0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        //If the O plays then it wants to MINimize the heuristics value
        else
        {
            return min(new Board(board), 0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
	}

    // The max and min functions are called interchangingly, one after another until a max depth is reached
	public Move max(Board board, int depth,int a,int b)
	{
        Random r = new Random();

        /* If MAX is called on a state that is terminal or after a maximum depth is reached,
         * then a heuristic is calculated on the state and the move returned.
         */
		if((board.isTerminal) || (depth == maxDepth))
		{
			Move lastMove = new Move(botletter,board.getLastMove().getRow(), board.getLastMove().getCol(), Board.sBOARD_VALUE[board.getLastMove().getRow()][board.getLastMove().getCol()]);
			return lastMove;
		}
        //The children-moves of the state are calculated
		ArrayList<Board> children = board.getChildren(board,botletter);
		Move maxMove = new Move(Integer.MIN_VALUE);
        maxMove.setPlayer(botletter);
		for (Board child : children)
		{
            //And for each child min is called, on a lower depth
			Move move = min(child, depth + 1,a,b);
            //The child-move with the greatest value is selected and returned by max
			if(move.getValue() >= maxMove.getValue())
			{
                if ((move.getValue() == maxMove.getValue()))
                {
                    //If the heuristic has the save value then we randomly choose one of the two moves
                    if (r.nextInt(2) == 0)
                    {
                        maxMove.setRow(child.getLastMove().getRow());
                        maxMove.setCol(child.getLastMove().getCol());
                        maxMove.setValue(move.getValue());
                    }
                }
                else
                {
                    maxMove.setRow(child.getLastMove().getRow());
                    maxMove.setCol(child.getLastMove().getCol());
                    maxMove.setValue(move.getValue());
                }
			}
			if(maxMove.getValue()>=b) return maxMove;

            a = Math.max(a,maxMove.getValue());
		}
		return maxMove;
	}

    //Min works similarly to max
	public Move min(Board board, int depth,int a,int b)
	{
        Random r = new Random();

		if((board.isTerminal) || (depth == maxDepth))
		{
            Move lastMove = new Move(botletter,board.getLastMove().getRow(), board.getLastMove().getCol(), Board.sBOARD_VALUE[board.getLastMove().getRow()][board.getLastMove().getCol()]);
			return lastMove;
		}
        ArrayList<Board> children = board.getChildren(board,botletter);
		Move minMove = new Move(Integer.MAX_VALUE);
		minMove.setPlayer(botletter);
		for (Board child : children){
			Move move = max(child, depth + 1,a,b);
			if(move.getValue() <= minMove.getValue())
			{
                if ((move.getValue() == minMove.getValue()))
                {
                    if (r.nextInt(2) == 0){
                        minMove.setRow(child.getLastMove().getRow());
                        minMove.setCol(child.getLastMove().getCol());
                        minMove.setValue(move.getValue());
                    }
                }
                else{
                        minMove.setRow(child.getLastMove().getRow());
                        minMove.setCol(child.getLastMove().getCol());
                        minMove.setValue(move.getValue());
                }
            }
            if(minMove.getValue()<=a) return minMove;
            b = Math.min(b,minMove.getValue());
        }
        return minMove;
    }
}
