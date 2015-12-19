import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;








public class Node {
	static Random r = new Random();
	static double epsilon = 1e-6;
	public GameState data;
    public Node parent;
    public ArrayList<Node> children;
    int depth;
    double nVisits = 0;
    double totValue = 0;
    
    
    public Node(GameState g){
    	data = g;
    	parent = null;
    	children = new ArrayList<Node>();
    	depth = 0;
    }
    
    public void UCT(int itermax){
    	Node rootNode = this;
    	for(int i=0;i<itermax;i++){
    		rootNode.selectAction();
    		
    	}
    	
    	
    }
    
    public void selectAction() {
    	
    	LinkedList<Node> visited = new LinkedList<Node>();
    	Node cur = this;
    	visited.add(cur);
    	while (cur.children.size()!= 0 && cur.data.winner==null){
    		cur = cur.select();
    		visited.add(cur);
    	}
    	GameState gcopy= GameState.GameStateCopy(cur.data);
    	//System.out.println(cur.data.toString());
		//System.out.println(cur.data.winner);
    	//System.out.println(gcopy.toString());
    	//System.out.println(gcopy.winner);
    	if(gcopy.winner==null){
    		cur.expand();
    		cur = cur.select();
    		visited.add(cur);
    	}
    	//System.out.println(cur.data.toString());
    	//System.out.println(cur==null);

    	GameState gcopy1 = GameState.GameStateCopy(cur.data);
    
    	
    	
    	
    	while(gcopy1.winner==null){
    		ArrayList<move> moves = gcopy1.PossibleMoves();
    		//System.out.println(gcopy1.toString());
    		int moveIDX = ThreadLocalRandom.current().nextInt(0, moves.size());
    		gcopy1.UpdateState(moves.get(moveIDX));
    		
    	}
    	//System.out.println(gcopy1.winner);
    	for(Node n :visited){
    		double value =0;
    		if (gcopy1.winner !=n.data.Player_turn){
    			value = .5;
    		}
    		else if(gcopy1.winner==GameState.Space.EMPTY){
    			value =1;
    		}
    		n.updateStats(value);
    		
    		
    		
    		
    		
    	}
    	

    	
    }
    
    
    
    
    
    
    
    
    public void expand() {
    	ArrayList<move> moves = this.data.PossibleMoves();
    	for (move m: moves){
    		Node child = new Node(GameState.UpdateStateRet(m, this.data));
    		//System.out.println(child.data.toString());
    		this.children.add(child);
    		
    	}
    }
    
    public boolean isLeaf(){
    	return this.children.size() == 0;
    	
    }
    
    public Node select(){
    	
    	
    	
    	
    	Node selected = null;
    	double bestValue = Double.MIN_VALUE;
    	//System.out.println(this.data.toString());
    	//System.out.println(children.size());
    	for (Node c: children){
    		
        	//	System.out.println(children.indexOf(c));
        		//System.out.println(c.data.toString());
        	
    		
    		
    		double uctValue =c.totValue/(c.nVisits+epsilon)+ (2/Math.sqrt(2))*
    				Math.sqrt(Math.log(nVisits+1) / (c.nVisits + epsilon)) +
    				r.nextDouble() *epsilon;
    	//	System.out.println(uctValue);
    		//System.out.println(bestValue);
    		if (uctValue > bestValue) {
                selected = c;
                bestValue = uctValue;
            }
    	}
    	
    	return selected;
    }
    
    
    public void updateStats(double value) {
        nVisits++;
        totValue += value;
    }
    	
    	
    public GameState.Space playOut(Node n){
    	
    	GameState g = new GameState(GameState.Space.RED);
    	g.board = n.data.board;
    	g.Player_turn = n.data.Player_turn;
    	g.spaces_filled = n.data.spaces_filled;
    	
    	
    	while (true){
    		
			ArrayList<move> moves = g.PossibleMoves();
			if (moves.size()==0){
				return null;
				
			}
			int moveIDX = ThreadLocalRandom.current().nextInt(0, moves.size());
			if (GameState.Winner(moves.get(moveIDX),g)){
				g.UpdateState(moves.get(moveIDX));
				return g.winner;
			}
			
			
			
			
			else{
				g.UpdateState(moves.get(moveIDX));
			}
			
			
		}
    }
    	
    	
    	
    	
    	
    	
  
    
    
    
    
    
    public Node(GameState datum,Node paren,int d){
    	data=datum;
       	parent=paren;
       	children=new ArrayList<Node>();
       	depth=d;
    }
        
    public void AddChild(Node child){
       	children.add(child);
    }
    
}
        
        
    


	
	


