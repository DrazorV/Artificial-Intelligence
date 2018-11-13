import java.util.Scanner;

public class main {
	static int r;
	static int c;
	

	public static void main(String[] args) {
		Board b = new Board();
		char opp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose difficulty by typing the appropriate number:");
        System.out.println("1. Very Easy");
        System.out.println("2. Easy");
        System.out.println("3. Medium");
        System.out.println("4. Hard");
        System.out.println("5. Very Hard");
        int depth = getDepth();
		System.out.println("You want to play as black or white? Enter B or W.");
		char start = sc.nextLine().toUpperCase().charAt(0);
		while(start !='B' && start !='W'){
			System.out.println("Enter B or W.");
			start = sc.next().toUpperCase().charAt(0);
		}
		
		b.print(b.bo);

		while(b.finished()) {
			if (start=='W')
	            opp = 'B';
	        else
	            opp ='W';
			r = getRowWithCheck();
			c = getColumnWithCheck();
			while (!b.isAvailable(r, c)  ){
				
				System.out.println("Enter an available position on the board");
				r = getRowWithCheck();
				c = getColumnWithCheck();
				
			}

			while(!b.validation(start,r,c)){
				System.out.println("Enter an available position on the board");
				r = getRowWithCheck();
				c = getColumnWithCheck();
			}
			b.bo[r][c] = start;
			b.Flip(start, r, c);

			//b.validation(start,r,c);
			b.print(b.bo);
			start=opp;
		}
	}
	
	public static int getRowWithCheck() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter row coordinate");
		int Row = sc.nextInt();
		while(Row>8||Row<1) {
			System.out.println("Enter a correct row coordinate (0<->7)");
			Row = sc.nextInt();

		}
	
		return Row-1;
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
        return depth;
    }

}
