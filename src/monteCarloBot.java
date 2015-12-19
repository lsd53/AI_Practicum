import java.util.ArrayList;




public class monteCarloBot extends Player{
	
	int itermax;
	
	public monteCarloBot(int iters){
		itermax = iters;
		
	}
	
	@Override
	move getMove(GameState g) {
		
		System.out.println("AI bot is thinking....");
		ArrayList<move> moves = g.PossibleMoves();
		for (int i=0; i<moves.size();i++){
			move m = moves.get(i);
			if (GameState.Winner(m, g)){
				return m;
			}
		}
		
		
		GameState gCopy = GameState.GameStateCopy(g);
		Node rootNode = new Node(gCopy);
		rootNode.UCT(itermax);
		ArrayList<Node> children = rootNode.children;
		double maxWins = 0;
		int index = 0;
		for(Node c: children){
			System.out.println((double) c.nVisits);
			if (c.nVisits>maxWins){
				maxWins = ((double) c.nVisits);
				index = children.indexOf(c);
				}
			}
		
		return gCopy.PossibleMoves().get(index);
	}

}
