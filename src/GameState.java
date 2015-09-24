import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



public class GameState {
	public Space board[][]=new Space[6][7];
	public Space Player_turn;
	int spaces_filled;
	public Space winner=null;
	

	
	
	public GameState(Space p){
		Player_turn=p;
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				board[i][j]=Space.EMPTY;
				}
			}
		spaces_filled=0;
		}
	
	public Space Winner(Space Player,move m){
		
		
		return Space.BLUE;
	}
	public void UpdateState(move m){
		board[m.x][m.y]=Player_turn;
		if (Player_turn == Space.RED){
			Player_turn=Space.BLUE;
		}
		else{
			Player_turn=Space.RED;
			
		}
		spaces_filled++;
	}
	public  static GameState  UpdateStateRet(move m,GameState G){
		GameState G_updated=new GameState(G.Player_turn);
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				G_updated.board[i][j]=G.board[i][j];
				}
			}
		G_updated.spaces_filled=G.spaces_filled;
		G_updated.UpdateState(m);
		return G_updated;
	}
	
	
	public ArrayList<move> PossibleMoves(){
		ArrayList<move> possible_moves=new ArrayList<move>();
		for (int j=0;j<7;j++){
			if (board[5][j]==Space.EMPTY){
				int x=5;
				
				for(int i=5;i>=0;i=i-1){
					if (board[i][j]==Space.EMPTY)
					x=i;
				}
				move m=new move(x,j);
				possible_moves.add(m);
				}
		}
		return possible_moves;
	}
	
	
	 public class move{
		int x; int y;
		public move(int i, int j){
			x=i;
			y=j;
		
			
		}
		public String toString(){
			return "("+Integer.toString(x)+","+Integer.toString(y)+")";
		}
		
		
	}
	 
	public String toString(){
		String s="";
		for(int i=5;i>=0;i=i-1){
			for(int j=0;j<7;j++){
				if (board[i][j]==Space.EMPTY){
					s=s+"[ ]";
				}
				else if(board[i][j]==Space.RED){
					s=s+"[X]";
					}
				else{
					s=s+"[0]";
					}
				
			}
			s=s+"\n";
		}
		return s;
	}
	
	public enum Space{
		RED,
		BLUE,
		EMPTY
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Tree GameSpace=new Tree(G);
		GameHash.GameStateHash=new HashMap<GameState,GameState>();
		
		int games_played=0;
		//long startTime = System.nanoTime();
		while (games_played<1){
			GameState G=new GameState(Space.RED);
			while(true){
				
			System.out.println(G.toString());
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				 
				e.printStackTrace();
			}
			ArrayList<move> possib=G.PossibleMoves();
			if (possib.size()==0){
				games_played++;
				break;
			}
			else{
			int i=0 + (int)(Math.random() * ((possib.size()-1 - 0) + 1));
			GameHash.GameStateHash.put(GameState.UpdateStateRet(possib.get(i), G),GameState.UpdateStateRet(possib.get(i), G));
			G.UpdateState(possib.get(i));
			
			}
			}
			System.out.println(Integer.toString(games_played));
		}
		for(GameState Gh:GameHash.GameStateHash.keySet()){
			System.out.println(Gh.toString());
			System.out.println(GameHash.GameStateHash.keySet().size());
		}
		
		
		//long endTime = System.nanoTime();
		//System.out.println(Long.toString((endTime-startTime)/1000000));
		
		//long startTime = System.nanoTime();
		//GameSpace.AllPossibleStates(GameSpace.root, 3);
		//long endTime = System.nanoTime();
		//Tree.PrintTree(GameSpace.root);
		//System.out.println(Integer.toString(Tree.Size(GameSpace.root)));
		//System.out.println(Long.toString((endTime-startTime)/1000000));

	}
}
