//This is the Queue Class using circular array concept.
public class CircularQueue <E> implements BareBonesQueue<E> {

	//Data
	private E[] Q;		//Array reference for the actual queue
	private int front; 	//front of the queue
	private int rear; 	//rear of the queue 
	private int size;	//numbers of elements in the  queue 
	private int capacity;
	private final int DEFAULT_CAPACITY = 5; //default capacity
	
	//Default constructor (created but empty)
	public CircularQueue() {
		this.Q = (E[]) new Object[this.DEFAULT_CAPACITY]; //Queue is created here (cast it)
		this.front = 0;
		this.rear = 0;	//front and rear = 0 no element to begin with
		this.size =0;
		this.capacity = this.DEFAULT_CAPACITY;
			
	}
	
	public CircularQueue(int capacity) {
		this.capacity = capacity; //given by the user 
		Q = (E[]) new Object[this.capacity];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
		
	}
	
	
	@Override
	public void offer(E obj) {
		// Adds elements at rear, first check if there is space to add
		if(isFull()) {
			System.out.println("Queue out of space ; calling reallocate");
			reallocate();
			this.offer(obj); //Once space avaliable, this method is called again. 
		}
		else { //So we have space to add element at the rear of the queue
			Q[rear] = obj;					//inserts the elements
			rear =(rear + 1)%this.capacity; //update the rear pointer
			size++;							//updates number of elements in queue
		}
	}

	private void reallocate()
	{
		// Implement this one alone 
		int newCapacity = 2 * this.capacity;
		E[] newQ = (E[]) new Object[newCapacity];
		int newfront = front;
		for (int i = 0; i < size; i++) {
		newQ[i] = Q[newfront];
		newfront = (newfront + 1) % capacity;
		}
		front = 0;
		rear = size;
		capacity = newCapacity;
		Q = newQ;

		
	}

	@Override
	public E poll() {
		// Remove an element from the front of the queue , if there is one 
		if(isEmpty()) {
			System.out.println("Queue underFlow!");
			return null;
		}
		//So the Q is not empty 
		//We will remove the dater from the front , and return it
		E temp = Q[front];					//Store data to be returned 
		front = (front + 1) %this.capacity; //updates front
		size--;								//updates size 
		return temp;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return(this.size == 0);
	}

	@Override
	public boolean isFull() {
		// 
		return (this.size == this.capacity);
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("Queue underFlow!");
			return null;
		}
		return Q[front];
	}

	//implement the toString method to display the contenets of the queue 
	public String toString() 
	{
		String s = "Q : "; 
		//loop over the elements in the  Q, from the front to the rear
		for(int i= front; i < front + size; i++)
		{
			s += Q[i %this.capacity] + " | " ;
		}
		return s;

	}	
	
	
	
}

