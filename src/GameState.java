import java.util.ArrayList;


public class GameState {
	public Space board[][]=new Space[6][7];
	public Space Player_turn;
	int spaces_filled;
	

	
	
	public GameState(Space p){
		Player_turn=p;
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				board[i][j]=Space.EMPTY;
				}
			}
		spaces_filled=0;
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
					s=s+"[E]";
				}
				else if(board[i][j]==Space.RED){
					s=s+"[R]";
					}
				else{
					s=s+"[B]";
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
		GameState G=new GameState(Space.RED);
		
		
		G.UpdateState(G.new move(0,6));
		G.UpdateState(G.new move(1,6));
		System.out.println(G.toString());
		ArrayList<move> possib=G.PossibleMoves();
		for(move m:possib){
			System.out.println(m);
		}

	}
}
