import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class aiBot extends Player{
	int plays;
	
	public aiBot(int n){
		plays =n;
	}
	@Override
	move getMove(GameState g) {
		System.out.println("AI bot is thinking....");
		ArrayList<move> moves = g.PossibleMoves();
		ArrayList<Double> winPercents = new ArrayList<Double>();
		for (int i=0; i<moves.size();i++){
			move m = moves.get(i);
			if (GameState.Winner(m, g)){
				return m;
			}
			else{
				winPercents.add(playout(g,m,plays));
				
			}
			
			
		}
		int maxIDX = winPercents.indexOf(Collections.max(winPercents));
		DecimalFormat df = new DecimalFormat("#.####");
		String s="";
		for(int i = 0; i<winPercents.size();i++){
			s = s+df.format(winPercents.get(i))+" ";
		}
		//System.out.println("Move win percents: "+s);
		System.out.println("AI plays: "+moves.get(maxIDX).toString());
		return moves.get(maxIDX);
	}
	public double playout(GameState g, move m,int gamesToPlay){
		int wins = 0;
		GameState.Space p = g.Player_turn;
		for(int i=0; i<gamesToPlay ;i++ ){
			
			GameState gUpdate = GameState.UpdateStateRet(m, g);
			
	
			while (true){
		
			ArrayList<move> moves = gUpdate.PossibleMoves();
			if (moves.size()==0){
				break;
				
			}
			int moveIDX = ThreadLocalRandom.current().nextInt(0, moves.size());
			if (GameState.Winner(moves.get(moveIDX),gUpdate)){
				if (gUpdate.Player_turn == p){
					wins =wins+1;
					}
				gUpdate.UpdateState(moves.get(moveIDX));
				
				break;
				
			}
			else{
				gUpdate.UpdateState(moves.get(moveIDX));
			}
			
			
			}
			
		}
		
		return ((double) wins)/((double) gamesToPlay);
	}
	
	

}
