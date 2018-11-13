import java.util.*;

public class Board {
    private char [][] gameBoard;
	private boolean[] tabflip = new boolean[8];
    private Move lastMove;
	private char lastLetterPlayed;
	public Board() {

        gameBoard = new char[8][8];
		for(int i =0; i<8;i++) {
			for(int j = 0; j<8; j++) {
                gameBoard[i][j] = 'o';
			}
		}
        gameBoard[3][3] = 'W';
        gameBoard[3][4] = 'B';
        gameBoard[4][3] = 'B';
        gameBoard[4][4] = 'W';
	}

    public Board(Board board)
    {
        lastMove = board.lastMove;
        lastLetterPlayed = board.lastLetterPlayed;
        gameBoard = new char[8][8];
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                gameBoard[i][j] = board.gameBoard[i][j];
            }
        }
    }

    public Move getLastMove()
    {
        return lastMove;
    }

    public int getLastLetterPlayed()
    {
        return lastLetterPlayed;
    }

    public char[][] getGameBoard()
    {
        return gameBoard;
    }

    public void setLastMove(Move lastMove)
    {
        this.lastMove.setRow(lastMove.getRow());
        this.lastMove.setCol(lastMove.getCol());
        this.lastMove.setValue(lastMove.getValue());
    }



    public boolean isAvailable(int row, int col) {
		if(gameBoard[row][col]=='o') {
			return true;
		}else {
			return false;
		}
	}
	public void placeMove(char c,int row, int col) {
		if(isAvailable(row,col))
            gameBoard[row][col] = c;
	}


	public void print(char[][] board) {

		System.out.println("* A B C D E F G H *");
		for(int i= 0; i<8; i++) {
			System.out.print(i+1+" ");
			for(int j = 0; j<8; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.print(i+1+" ");
			System.out.println();
		}
		System.out.println("* A B C D E F G H *");

	}
	
	public boolean validation(char player,int row, int col) {
		
		int r = row ;
		int c = col;
        if (player=='W')
            lastLetterPlayed = 'B';
        else
            lastLetterPlayed ='W';
        try {
        	if(gameBoard[row-1][col-1]==lastLetterPlayed){
        		r = row-1;
        		c = col-1;
				boolean flag=true;
				while(gameBoard[r][c]==lastLetterPlayed) {
					r--;
					c--;
					if(gameBoard[r][c]=='o') {
						flag=false;
						break;
					}
				}
				if(flag){
					tabflip[0]=true;
					//return true;
				}
        	}
        }catch(ArrayIndexOutOfBoundsException exception){

        }
        try {
        	if(gameBoard[row-1][col]==lastLetterPlayed) {
        		r = row-1;
        		c = col;
				boolean flag=true;
				while(gameBoard[r][c]==lastLetterPlayed) {
					r--;
					if(gameBoard[r][c]=='o') {
						flag=false;
						break;
					}
				}
				if(flag) {
					tabflip[1]=true;
					//return true;
				}
        	}
        }catch(ArrayIndexOutOfBoundsException exception){
        	
        }
        try {
        	if(gameBoard[row-1][col+1]==lastLetterPlayed) {
        		r = row-1;
        		c = col+1;
				boolean flag=true;
				while(gameBoard[r][c]==lastLetterPlayed) {
					r--;
					c++;
					if(gameBoard[r][c]=='o') {
						flag=false;
						break;
					}
				}
				if(flag){
					tabflip[2]=true;
					//return true;
				}
        	}
        }catch(ArrayIndexOutOfBoundsException exception){
        	System.out.println("aaaa" );
        }
        try {
        	if(gameBoard[row][col+1]==lastLetterPlayed) {
        		r = row ;
        		c = col+1;
				boolean flag=true;
				while(gameBoard[r][c]==lastLetterPlayed) {
					c++;
					if(gameBoard[r][c]=='o') {
						flag=false;
						break;
					}
				}
				if(flag){
					tabflip[3]=true;
					//return true;
				}
        	}
        }catch(ArrayIndexOutOfBoundsException exception){
			System.out.println("aaaa" );
        }
        try {
        	if(gameBoard[row+1][col+1]==lastLetterPlayed) {
        		r = row+1;
        		c = col+1;
				boolean flag=true;
				while(gameBoard[r][c]==lastLetterPlayed) {
					r++;
					c++;
					if(gameBoard[r][c]=='o') {
						flag=false;
						break;
					}
				}
				if(flag) {
					tabflip[4]=true;
					//return true;
				}
        	}
        }catch(ArrayIndexOutOfBoundsException exception){
        	
        }
        try {
        	if(gameBoard[row+1][col]==lastLetterPlayed) {
        		r = row+1;
        		c = col ;
				boolean flag=true;
				while(gameBoard[r][c]==lastLetterPlayed) {
					r++;
					if(gameBoard[r][c]=='o') {
						flag=false;
						break;
					}
				}
				if(flag){
					tabflip[5]=true;
					//return true;
				}
        	}
        }catch(ArrayIndexOutOfBoundsException exception){
        	
        }
        try {
        	if(gameBoard[row+1][col-1]==lastLetterPlayed) {
        		r = row+1;
        		c = col-1;
        		boolean flag=true;
        		while(gameBoard[r][c]==lastLetterPlayed) {
        			r++;
        			c--;
        			if(gameBoard[r][c]=='o') {
        				flag=false;
						break;
					}
            	}
            	if(flag){
            		tabflip[6]=true;
            		//return true;
            	}
        	}
        }catch(ArrayIndexOutOfBoundsException exception){
        	
        }
        try {
        	if(gameBoard[row][col-1]==lastLetterPlayed) {
        		r = row ;
        		c = col-1;
				boolean flag=true;
				while(gameBoard[r][c]==lastLetterPlayed) {
					c--;
					if(gameBoard[r][c]=='o') {
						flag=false;
						break;
					}
				}
				if(flag) {
					tabflip[7]=true;
					//return true;
				}
        	}
        }catch(ArrayIndexOutOfBoundsException exception){
        	
        }
        for (int i=0;i<8;i++){
        	if(tabflip[i]) return true;
        }
        return false;
	}


	


	public static boolean finished(){
		return true;
	}

	public void Flip(char player,int row, int col){
		if (player=='W')
            lastLetterPlayed = 'B';
        else
            lastLetterPlayed ='W';
		int r = row;
		int c = col;
		
		if(tabflip[0]){
			r--;
			c--;
			try{
				while(gameBoard[r][c]==lastLetterPlayed){
					gameBoard[r][c]=player;
					r--;
					c--;
					
					
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				
	        }
			r = row;
			c = col;
		}
		
		if(tabflip[1]){
			r--;
			try{
				while(gameBoard[r][c]==lastLetterPlayed){
					gameBoard[r][c]=player;
					r--;					
					
					
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				
	        }
			r = row;
			c = col;
		}
		
		if(tabflip[2]){
			r--;
			c++;
			try{
				
				while(gameBoard[r][c]==lastLetterPlayed){
					gameBoard[r][c]=player;
					r--;
					c++;
					
					
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				
	        }
			r = row;
			c = col;
		}
		if(tabflip[3]){
			
			c++;
			try{
				while(gameBoard[r][c]==lastLetterPlayed){
					gameBoard[r][c]=player;
					c++;
					
					
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				
	        }
			r = row;
			c = col;
		}
		if(tabflip[4]){
			r++;
			c++;
			try{
				while(gameBoard[r][c]==lastLetterPlayed){
					gameBoard[r][c]=player;
					r++;
					c++;
					
					
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				
	        }
			r = row;
			c = col;
		}
		if(tabflip[5]){
			r++;
			try{
				while(gameBoard[r][c]==lastLetterPlayed){
					gameBoard[r][c]=player;
					r++;
					
					
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				
	        }
			r = row;
			c = col;
		}
		if(tabflip[6]){
			r++;
			c--;
			try{
				while(gameBoard[r][c]==lastLetterPlayed){
					gameBoard[r][c]=player;
					r++;
					c--;
					
					
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				
	        }
			r = row;
			c = col;
		}
		if(tabflip[7]){
			c--;
			try{
				while(gameBoard[r][c]==lastLetterPlayed){
					gameBoard[r][c]=player;
					c--;
					
					
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				
	        }
			r = row;
			c = col;
		}
		Arrays.fill(tabflip, Boolean.FALSE);
		
	}
	public boolean[][] FindMoves(char player){
		boolean[][] FMArray = new boolean[8][8];
		for (int i=0;i<8;i++){
			for (int j=0;j<8;j++){
				if(this.validation(player, i, j)) {
					FMArray[i][j]=true;
				}
			}
		}
		return FMArray;
	}

}


