import java.util.Scanner;


public class Test {

	
	public static void main(String[] args) {
		Position p = new Position();
		Board b = new Board(p);
		
		Scanner s = new Scanner(System.in);
		while (true) {
			Move m = new Move(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
			b.move(m);
		}
	}

}
