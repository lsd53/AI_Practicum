import java.util.ArrayList;


public class aiBot extends Player{

	@Override
	move getMove(GameState g) {
		System.out.println("AI bot is thinking....");
		ArrayList<move> moves = g.PossibleMoves();
		for (move m: moves){
			
			
			
		}
		
		
		
		return null;
	}

}
