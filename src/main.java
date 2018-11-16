import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
	static int r;
	static int c;
	static int counter;
	static int bMarks = 2;
	static int wMarks = 2;
	
	public static void main(String[] args) {

		Board b = new Board();
		b.setLastLetterPlayed('W');
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose difficulty by typing the appropriate number:");
		System.out.println("1. Very Easy");
		System.out.println("2. Easy");
		System.out.println("3. Medium");
		System.out.println("4. Hard");
		System.out.println("5. Very Hard");
		int depth = getDepth();
		System.out.println("You want to play as black or white? Enter B or W (Black plays first).");
		char player = sc.nextLine().toUpperCase().charAt(0);
		while (player != 'B' && player != 'W') {
			System.out.println("Enter B or W.");
			player = sc.next().toUpperCase().charAt(0);
		}
		char comp = (player == 'B') ? 'W' : 'B';
		GamePlayer computer = new GamePlayer(depth, comp);

		b.print(b);
		totalMoves(player,comp,b);
		while (true) {
			counter=0;
			
			if (b.getLastLetterPlayed() == player  ) {
				if(!b.hasMoves(comp)){
					counter++;
					System.out.println("Computer has no valid moves");
					b.setLastLetterPlayed(comp);
					
				}
				else{
					System.out.println("Bot is thinking...");
					//System.out.println();
					Move WMove = computer.MiniMax(b);
					b.makeMove(WMove);
					b.flip(b.getGameBoard(), WMove.getPlayer(), WMove.getRow(), WMove.getCol());
					b.print(b);
					totalMoves(player,comp,b);
				}
				
			}

			if (b.getLastLetterPlayed() == comp ) {
				if(!b.hasMoves(player)){
					counter++;
					System.out.println("You have no valid moves");
					b.setLastLetterPlayed(player);
				}
				else{
					r = getRowWithCheck();
					c = getColumnWithCheck();
					while (!Board.isValidMove(b.getGameBoard(), player, r, c)) {
						System.out.println("Enter an available position on the board");
						r = getRowWithCheck();
						c = getColumnWithCheck();
					}
					Move playMove = new Move(player);
					playMove.setCol(c);
					playMove.setRow(r);
					b.makeMove(playMove);
					b.flip(b.getGameBoard(), playMove.getPlayer(), r, c);
					b.print(b);
					totalMoves(player,comp,b);
				}
				if(counter==2){
					System.out.println("Both players have no valid moves. Game ended!");
					winnerWinner(player,comp,b);
					break;
				}
				
			}
			

		}
	}
	public static void winnerWinner(char player,char comp, Board b) {
		System.out.println();
		if(getMarksByPlayer(comp, b)>getMarksByPlayer(player,b)) {
			System.out.println("Winner COMPUTER with total "+getMarksByPlayer(comp,b)+" marks on the board.");
		}else if (getMarksByPlayer(comp, b)<getMarksByPlayer(player,b)){
			System.out.println("Winner USER with total "+getMarksByPlayer(comp,b)+" marks on the board.");
		}else {
			System.out.println("ITS A DRAW.");
		}
		
	}
	
	public static void totalMoves(char player,char comp, Board b) {
		System.out.println("AI Score: " + getMarksByPlayer(comp, b));
		System.out.println("Your Score: " + getMarksByPlayer(player,b));
	}
	public static int getMarksByPlayer(char player,Board b) {
		int n = 0;
		char[][] bo = b.getGameBoard();
		for(int i = 0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(bo[i][j]==player) {
					n++;
				}
			}
		}
		return n;
	}
		
	
	public static int getRowWithCheck() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter row coordinate");
			int Row = sc.nextInt();
			while(Row>8||Row<1) {
				System.out.println("Enter a correct row coordinate (0<->7)");
				Row = sc.nextInt();
			}
			return Row-1;
		}catch (InputMismatchException e){
			System.out.println("Enter a correct row coordinate (0<->7)");
			return getRowWithCheck();
		}
	}
	public static int getColumnWithCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter column coordinate");
		char col ;
		col = sc.nextLine().toLowerCase().charAt(0);
		while(Character.toString(col).matches("^[i-zI-Z0-9]*$")) {
			System.out.println("Enter a correct column coordinate a-h");
			col = sc.next().toLowerCase().charAt(0);
		}

		return fromCharToInt(col);
	}
	public static int fromCharToInt(char c) {
		switch(c) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		case 'h':
			return 7;

		}
		return 0;
	}

    public static int getDepth() {
        Scanner sc = new Scanner(System.in);
        int depth = 0;
        depth = sc.nextInt();
        while(depth>5||depth<1) {
            System.out.println("Please enter a valid number from 1 to 5.");
            depth = sc.nextInt();
        }
        System.out.println("You have selected difficulty : " + depth+".");
        return depth*2;
    }

}
