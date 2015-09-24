import java.util.ArrayList;
import java.util.List;


public class Tree<T> {
	public Node<T> root;
	
	public Tree(T datum){
		root= new Node<T>(datum,null,0);
		
	}
	
    public  class Node<T> {
        public T data;
        public Node<T> parent;
        public List<Node<T>> children;
        int depth;
        
        public Node(T datum,Node<T> paren,int d){
        	data=datum;
        	parent=paren;
        	children=new ArrayList<Node<T>>();
        	depth=d;
        }
        
        public void AddChild(Node<T> child){
        	children.add(child);
        }
        
        
    }

}
