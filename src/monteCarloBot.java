import GameState.Space;


public class monteCarloBot extends Player{

	@Override
	move getMove(GameState g) {
		GameState gCopy = new GameState(GameState.Space.RED);
		gCopy.board = g.board;
		gCopy.Player_turn = g.Player_turn;
		gCopy.spaces_filled = g.spaces_filled;
		Tree T = new Tree(gCopy);
		
		
		
		
		
		
		return null;
	}

}
