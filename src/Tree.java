

public class Tree 
{
	// instance variables
	// each tree contains an array of leaves and a position in the window
	private Oval[] leaves;
	private int xPos;
	
	/**
	 * Constructor
	 * 
	 * Instantiate the leaves array and set the position
	 * 
	 * @param pos int position of tree in window
	 */
	public Tree(int pos)
	{
		leaves = new Oval[6];
		xPos = pos;
	}
	
	
	/**
	 * Getter for xPos
	 * 
	 * @return xPos
	 */
	public int getPos()
	{
		return xPos;
	}
	
	
	/**
	 * Getter for leaves array
	 * 
	 * @return leaves
	 */
	public Oval[] getLeaves()
	{
		return leaves;
	}
	
}
