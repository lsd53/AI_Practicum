import java.util.ArrayList;
import java.util.HashMap;



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
	
	public static boolean Winner(move m,GameState G){
		boolean win=false;
		int counter_v= 0;
		int counter_h = 0;
		int counter_d1 = 0;
		int counter_d2 = 0;
		for(int i=1;i<4;i++){
			if (m.x-i<0){
				break;
			}
			else if (G.board[m.x-i][m.y]==G.Player_turn){
				counter_v++;
				
			}
			else{
				break;
			}
		}
		
		for(int j=1;j<4;j++){
			if (6<m.y+j){
				break;
			}
			else if (G.board[m.x][m.y+j]==G.Player_turn){
				counter_h++;
				
			}
			else{
				break;
			}
		}
		for(int j=1;j<4;j++){
			if (m.y-j<0){
				break;
			}
			else if (G.board[m.x][m.y-j]==G.Player_turn){
				counter_h++;
				
			}
			else{
				break;
			}
		}
		for(int j=1;j<4;j++){
			if (m.y-j<0||m.x-j<0){
				break;
			}
			else if (G.board[m.x-j][m.y-j]==G.Player_turn){
				counter_d1++;
				
			}
			else{
				break;
			}
		}
		for(int j=1;j<4;j++){
			if (6<m.y+j||5<m.x+j){
				break;
			}
			else if (G.board[m.x+j][m.y+j]==G.Player_turn){
				counter_d1++;
				
			}
			else{
				break;
			}
		}
		
		for(int j=1;j<4;j++){
			if (5<m.x+j||m.y-j<0){
				break;
			}
			else if (G.board[m.x+j][m.y-j]==G.Player_turn){
				counter_d2++;
				
			}
			else{
				break;
			}
		}
		for(int j=1;j<4;j++){
			if (m.x-j<0||6<m.y+j){
				break;
			}
			else if (G.board[m.x-j][m.y+j]==G.Player_turn){
				counter_d2++;
				
			}
			else{
				break;
			}
		}
	
		
		System.out.println(Integer.toString(counter_d2));
		
		if (counter_v>=3||counter_h>=3||counter_d1>=3||counter_d2>=3){
			win=true;
		}
		return win;
		
		
	}
	public void UpdateState(move m){
		board[m.x][m.y]=Player_turn;
		if (GameState.Winner(m, this)){
			winner=Player_turn;
		}
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
		if (winner==null){
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
		}
		return possible_moves;
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
	

	}
}
