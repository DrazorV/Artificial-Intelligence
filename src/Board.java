import java.util.*;

public class Board {
	public char[][] bo = new char[8][8];
	private boolean[] tabflip = new boolean[8];
	private char opp;
	public Board() {
		for(int i =0; i<8;i++) {
			for(int j = 0; j<8; j++) {
				bo[i][j] = 'o';
			}
		}
		bo[3][3] = 'W';
		bo[3][4] = 'B';
		bo[4][3] = 'B';
		bo[4][4] = 'W';
	}


	public boolean isAvailable(int row, int col) {
		if(bo[row][col]=='o') {
			return true;
		}else {
			return false;
		}
	}
	public void placeMove(char c,int row, int col) {
		if(isAvailable(row,col))
			bo[row][col] = c;
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
            opp = 'B';
        else
            opp ='W';
        try {
        	if(bo[row-1][col-1]==opp){
        		r = row-1;
        		c = col-1;
				boolean flag=true;
				while(bo[r][c]==opp) {
					r--;
					c--;
					if(bo[r][c]=='o') {
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
        	if(bo[row-1][col]==opp) {
        		r = row-1;
        		c = col;
				boolean flag=true;
				while(bo[r][c]==opp) {
					r--;
					if(bo[r][c]=='o') {
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
        	if(bo[row-1][col+1]==opp) {
        		r = row-1;
        		c = col+1;
				boolean flag=true;
				while(bo[r][c]==opp) {
					r--;
					c++;
					if(bo[r][c]=='o') {
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
        	if(bo[row][col+1]==opp) {
        		r = row ;
        		c = col+1;
				boolean flag=true;
				while(bo[r][c]==opp) {
					c++;
					if(bo[r][c]=='o') {
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
        	if(bo[row+1][col+1]==opp) {
        		r = row+1;
        		c = col+1;
				boolean flag=true;
				while(bo[r][c]==opp) {
					r++;
					c++;
					if(bo[r][c]=='o') {
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
        	if(bo[row+1][col]==opp) {
        		r = row+1;
        		c = col ;
				boolean flag=true;
				while(bo[r][c]==opp) {
					r++;
					if(bo[r][c]=='o') {
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
        	if(bo[row+1][col-1]==opp) {
        		r = row+1;
        		c = col-1;
        		boolean flag=true;
        		while(bo[r][c]==opp) {
        			r++;
        			c--;
        			if(bo[r][c]=='o') {
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
        	if(bo[row][col-1]==opp) {
        		r = row ;
        		c = col-1;
				boolean flag=true;
				while(bo[r][c]==opp) {
					c--;
					if(bo[r][c]=='o') {
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
            opp = 'B';
        else
            opp ='W';
		int r = row;
		int c = col;
		
		if(tabflip[0]){
			r--;
			c--;
			try{
				while(bo[r][c]==opp){
					bo[r][c]=player;
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
				while(bo[r][c]==opp){
					bo[r][c]=player;
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
				
				while(bo[r][c]==opp){
					bo[r][c]=player;
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
				while(bo[r][c]==opp){
					bo[r][c]=player;
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
				while(bo[r][c]==opp){
					bo[r][c]=player;
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
				while(bo[r][c]==opp){
					bo[r][c]=player;
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
				while(bo[r][c]==opp){
					bo[r][c]=player;
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
				while(bo[r][c]==opp){
					bo[r][c]=player;
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


