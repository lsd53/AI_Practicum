import java.util.Scanner;




public class HumanPlayer extends Player{

	@Override
		move getMove(GameState g) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a move in the format: (row,col), where 0<=row<=6 and 0<=col<=5");
		String s = in.nextLine();
		s = s.replaceAll("\\s+","");
		int row =Integer.parseInt(s.substring(1,2));
		int col = Integer.parseInt(s.substring(3,4));
		move m = new move( row,col);
		return m;
	}
	

}
