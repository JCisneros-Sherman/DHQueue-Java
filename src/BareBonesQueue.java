//Methods for the queue
public interface BareBonesQueue <E>
{
	public void offer (E obj); //Adding the data 
	public E poll();    //remove date 
	public boolean isEmpty();
	public boolean isFull();  //check if the Queue is full 
	public E peek();		//Returns the first elements without deletein git. 
	

	
}
