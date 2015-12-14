import java.util.ArrayList;
import java.util.List;


public class Tree {
	public Node root;
	
	public Tree(GameState datum){
		root= new Node(datum,null,0);
		
	}
	
	public static void PrintTree(Node n){
		System.out.println(n.data.toString());
		for(Node child:n.children){
			Tree.PrintTree(child);
		}
	}
	
	public void AllPossibleStates(Node n, int dep){
		if (n.depth==dep){
			
		}
		else{
			ArrayList<move> possib=n.data.PossibleMoves();
			for(move m:possib){
				Node G=new Node(GameState.UpdateStateRet(m, n.data),n,n.depth+1);
				n.AddChild(G);
				AllPossibleStates(G,dep);
			}
		}
	}
	
	public static int Size(Node n){
		if (n.children.size()==0){
			return 1;
		}
		else{
			
		int size=1;
		for(Node t:n.children){
			size=size+Tree.Size(t);
		}
		return size;
		}
	}
	
    public  class Node{
        public GameState data;
        public Node parent;
        public List<Node> children;
        int depth;
        double nVisits = 0;
        double totValue = 0;
        
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

}
