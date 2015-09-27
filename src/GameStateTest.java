import static org.junit.Assert.*;


import org.junit.Test;



public class GameStateTest {

	@Test
	public void test() {
		
		GameState G=new GameState(GameState.Space.RED);
		G.UpdateState(G.new move(0,0));
		G.UpdateState(G.new move(0,1));
		G.UpdateState(G.new move(1,0));
		G.UpdateState(G.new move(1,1));
		G.UpdateState(G.new move(2,0));
		G.UpdateState(G.new move(2,1));
		System.out.println(G.Player_turn);
		System.out.print(GameState.Winner(G.new move(3,0), G));
		System.out.println(G.toString());
		
	}

}
