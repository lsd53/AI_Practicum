import java.util.ArrayList;
import java.util.Scanner;




public class HumanPlayer extends Player{

	@Override
		move getMove(GameState g) {
		
			Scanner in = new Scanner(System.in);
			System.out.println("Enter a column number for your move:");
			String s = in.nextLine();
			s = s.replaceAll("\\s+","");
			int col =Integer.parseInt(s.substring(0,1))-1;
			ArrayList<move> moves =g.PossibleMoves();
			for(move m: moves){
				
				if (m.y==col){
					System.out.println("Move "+m.toString()+ " was played.");
					return m;	
				}
			}
			return null;
		
	}
	

}
