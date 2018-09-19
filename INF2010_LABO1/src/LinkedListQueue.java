
public class LinkedListQueue<AnyType> implements Queue<AnyType>
{	
	// Un noeud de la file
	@SuppressWarnings("hiding")
	private class Node<AnyType> 
	{
		private AnyType data;
		private Node next;
		
		public Node(AnyType data, Node<AnyType> next) 
		{
			this.data = data;
			this.next = next;
		}

		public void setNext(Node next) 
		{
			this.next = next;
		}
		
		public Node<AnyType> getNext() 
		{
			return next;
		}
		
		public AnyType getData() 
		{
			return data;
		}
	}
   
	private int size = 0;		//Nombre d'elements dans la file.
	private Node<AnyType> last;	//Dernier element de la liste
	
	//Indique si la file est vide
	public boolean empty() 
	{ 
		return size == 0; 
	}
	
	//Retourne la taille de la file
	public int size() 
	{ 
		return size; 
	}
	
	//Retourne l'element en tete de file
	//Retourne null si la file est vide
	//complexit� asymptotique: O(1)
	public AnyType peek()
	{
		if(empty()){
			return null;
		} else {
			return last.data;
		}
	}
	
	//Retire l'element en tete de file
	//complexit� asymptotique: O(1)
	public void pop() throws EmptyQueueException
	{
		if(empty()){
			throw new EmptyQueueException("Il n'y a rien a retirer");
		}
		last = last.next;
		size--;
	}
	
	//Ajoute un element a la fin de la file
	//complexit� asymptotique: O(1) ???
	public void push(AnyType item)
	{		
		Node<AnyType> ptr;
		if(empty()){
			last = new Node<AnyType>(item, null);
			size++;
		} else {
			ptr = last;
			for(int i = 0; i < size-1; i++){
				ptr = ptr.next;
			}
			Node<AnyType> NewNode = new Node<AnyType>(item, null);
			ptr.next = NewNode;
			size++;
		}
	}  
}
