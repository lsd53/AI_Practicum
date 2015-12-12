


public class Game {
	public Player one;
	public Player two;
	public GameState gameBoard;
	
	
	public Game(Player first,Player second){
		one = first;
		two = second;
		gameBoard = new GameState(GameState.Space.RED);
		System.out.println("New Game of ConnectFour !");
		
		}
		
	public void playGame(){
		while (true){
			System.out.println(gameBoard.toString());
			move m1 = this.one.getMove(gameBoard);
			boolean winnerP1 = GameState.Winner(m1, gameBoard);
			gameBoard.UpdateState(m1);
			System.out.println(gameBoard.toString());
			if (winnerP1){
				System.out.println("Player One won!");
				break;
			}
			move m2 = this.two.getMove(gameBoard);
			boolean winnerP2 = GameState.Winner(m2, gameBoard);
			gameBoard.UpdateState(m2);
			System.out.println(gameBoard.toString());
			if (winnerP2){
				System.out.println("Player Two won!");
				break;
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Player one = new HumanPlayer();
		Player two = new HumanPlayer();
		
		Game connectFour = new Game(one,two);
		connectFour.playGame();

	}
	

}
