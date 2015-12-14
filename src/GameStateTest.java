import static org.junit.Assert.*;


import org.junit.Test;



public class GameStateTest {

	@Test
	public void test() {
		
		GameState G=new GameState(GameState.Space.RED);
		G.UpdateState(new move(0,3));
		G.UpdateState(new move(0,2));
		G.UpdateState(new move(1,3));
		G.UpdateState(new move(2,3));
		G.UpdateState(new move(1,2));
		G.UpdateState(new move(0,1));
		G.UpdateState(new move(1,1));
		G.UpdateState(new move(0,5));
		G.UpdateState(new move(2,1));
		G.UpdateState(new move(2,2));
		G.UpdateState(new move(3,1));
		G.UpdateState(new move(4,1));
		G.UpdateState(new move(0,0));
		G.UpdateState(new move(1,0));
		G.UpdateState(new move(3,3));
		G.UpdateState(new move(3,2));
		G.UpdateState(new move(4,2));
		G.UpdateState(new move(1,5));
		G.UpdateState(new move(2,5));
		G.UpdateState(new move(3,5));
		G.UpdateState(new move(0,4));
		//G.UpdateState(new move(1,4));
		System.out.println(G.toString());
		System.out.print(GameState.Winner(new move(1,4), G));
		//G.UpdateState(new move(4,2));
		//G.UpdateState(new move(1,5));
		//System.out.println(G.Player_turn);
		//System.out.print(GameState.Winner(G.new move(3,0), G));
		//System.out.println(G.toString());
		
	}

}
