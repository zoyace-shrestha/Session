
/**
 * This program draws several trees, to which graphical "leaves" can be added and
 * removed. Leaves can change colors, and can be made to grow larger and larger.
 *
 */

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Autumn implements ActionListener
{
    private JFrame window;
    private JButton addButton, changeButton, fallButton, growButton;
    private int numTrees = 4;
    private Tree[] trees = new Tree[4];
    private int numLeaves = 6;

    /**
     * main() to run constructor.
     *
     * @param args Not used.
     */
    public static void main( String[] args )
    {
        Autumn fall = new Autumn();
        fall.driver();
    }

    
    /**
     * Constructor
     * 
     * Instantiate the trees array and the individual trees.
     * 
     * The first tree is at position 260.  Each subsequent tree is 600 pixels
     * farther to the right.
     */
    public Autumn()
    {
    	for ( int i = 0 ; i < numTrees ; i ++)
    	{
    		
    		trees[i] = new Tree ( 260 + (600 * i));
    		
    	}
    }
    
    
    /**
     * Gets things going by creating the window, trees, leaves, and buttons.
     */
    private void driver()
    {
    	makeWindow();
    	makeGround();

    	for(int i = 0; i < numTrees; i++)
    	{
    		drawTree(trees[i]);
        	addLeaves(trees[i]);
    	}

    	addButtons();
    }
    
    /**
     * Create the window with white background,
     * containing three ActionButtons, along with an image of numTrees trees.
     */
    private void makeWindow()
    {
    	int windowWidth = numTrees * 600;
    	
        window = new JFrame();
        window.setTitle( "La Crosse Forest" );
        window.setLayout( null );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setVisible( true );
        window.setResizable( false );
        window.setBounds( 50, 50, windowWidth + window.getInsets().left + window.getInsets().right,
                          600 + window.getInsets().top + window.getInsets().bottom );
        window.getContentPane().setBackground( new Color( 204, 255, 255 ) );
    }

    /**
     * Add buttons to window. Each will communicate back with this Driver via
     * the actionPerformed() method.
     */
    private void addButtons()
    {
    	// determine the button positions based on the number of trees
    	int pos = ((numTrees * 600) - 520)/2;
    	int increment = 140;
    	
        addButton = new JButton( "Add" );
        addButton.setBounds( pos, 550, 100, 25 );
        addButton.addActionListener( this );
        window.add( addButton, 0 );

        changeButton = new JButton( "Change" );
        changeButton.setBounds( pos + increment, 550, 100, 25 );
        changeButton.addActionListener( this );
        window.add( changeButton, 0 );

        fallButton = new JButton( "Fall" );
        fallButton.setBounds( pos + 2*increment, 550, 100, 25 );
        fallButton.addActionListener( this );
        window.add( fallButton, 0 );

        growButton = new JButton( "Grow" );
        growButton.setBounds( pos + 3*increment, 550, 100, 25 );
        growButton.addActionListener( this );
        window.add( growButton, 0 );
        window.repaint();
    }

    
    /**
     * Create the ground -- the green rectangle under the trees.
     */
    private void makeGround()
    {
    	int width = numTrees * 600 + 1;
        Rectangle ground = new Rectangle( 0, 500, width, 100 );
        ground.setBackground( Color.green );
        window.add( ground, 0 );
    	
    }
    
    
    /**
     * Adds graphical representation of tree into window.
     */
    private void drawTree(Tree t)
    {
    	// each tree has a position attribute.  Get the value for tree t.
    	int x = t.getPos();
    	
        Rectangle trunk = new Rectangle( x, 200, 80, 301 );
        window.add( trunk, 0 );

        Line branch1 = new Line( x + 10, 210, x - 70, 130 );
        branch1.setThickness( 20 );
        window.add( branch1, 0 );
        Line branch1b = new Line( x - 65, 135, x - 65, 45 );
        branch1b.setThickness( 10 );
        window.add( branch1b, 0 );
        Line branch1c = new Line( x - 65, 135, x - 165, 135 );
        branch1c.setThickness( 10 );
        window.add( branch1c, 0 );

        Line branch2 = new Line( x + 70, 210, x + 150, 130 );
        branch2.setThickness( 20 );
        window.add( branch2, 0 );
        Line branch2b = new Line( x + 145, 135, x + 145, 45 );
        branch2b.setThickness( 10 );
        window.add( branch2b, 0 );
        Line branch2c = new Line( x + 145, 135, x + 245, 135 );
        branch2c.setThickness( 10 );
        window.add( branch2c, 0 );

        Line branch3 = new Line( x + 40, 200, x + 40, 130 );
        branch3.setThickness( 20 );
        window.add( branch3, 0 );
        Line branch3b = new Line( x + 45, 140, x - 10, 85 );
        branch3b.setThickness( 10 );
        window.add( branch3b, 0 );
        Line branch3c = new Line( x + 45, 135, x + 95, 85 );
        branch3c.setThickness( 10 );
        window.add( branch3c, 0 );
        window.repaint();
    }
        
        
    /**
     * Handles the action, by checking what button sent it.
     */
    public void actionPerformed( ActionEvent e )
    {
        // The getSource() method is built in to the ActionEvent class, and
        // tells us what GUI element caused the event to happen, namely what
        // button was pressed by the user.
        if ( e.getSource() == addButton )
        {
        	for ( int i = 0 ; i < numTrees ; i ++)
        	{
        		removeLeaves(trees[i]);
        	}
        	for ( int i = 0 ; i < numTrees ; i ++ )
        	{
        		addLeaves(trees[i]);
        	}
        }
        
        if ( e.getSource() == fallButton)
        {
        	for ( int i = 0 ; i < numTrees ; i ++)
        	{
        		removeLeaves(trees[i]);
        	}
        }
        
        if ( e.getSource() == changeButton )
        {
        	for ( int i = 0 ; i < numTrees ; i ++)
        	{
        		colorLeaves(trees[i]);
        	}
        }
        
        if ( e.getSource() == growButton)
        {
        	for ( int i = 0 ; i < numTrees ; i ++)
        	{
        		growLeaves(trees[i]);
        	}
        }
        	
    }


    /**
     * Adds all the leaves for Tree t to the window.
     * 
     * @param t  a Tree object
     */
    private void addLeaves(Tree t)
    {
    	Oval[] leaves = t.getLeaves();
    	int x = t.getPos();
    	
        leaves[0] = makeLeaf(x - 105, 5, 80);
        leaves[1] = makeLeaf(x - 205, 95, 80);
        leaves[2] = makeLeaf(x - 35, 60, 50);
        leaves[3] = makeLeaf(x + 70, 60, 50);
        leaves[4] = makeLeaf(x + 105, 5, 80);
        leaves[5] = makeLeaf(x + 205, 95, 80 );
        
       for ( int i = 0 ; i < numLeaves ; i ++)
       {
    	   
    	   window.add(leaves[i]);
       }
       window.repaint();

    }
    
    private void removeLeaves(Tree t)
    {
    	Oval [] leaves = t.getLeaves();
    	
    	for ( int i = 0 ; i < numLeaves ; i ++)
    	{
    		window.remove(leaves[i]);
    	}
    	window.repaint();
    	
    }
    /**
     * Makes an individual leaf, and places it in the window.
     *
     * @param x x-location of Oval
     * @param y y-location of Oval
     * @param diameter Diameter of Oval
     *
     * @return Oval of given bounds, with Color == green
     */
    private Oval makeLeaf( int x, int y, int diameter )
    {
        Oval leaf = new Oval( x, y, diameter, diameter );
        leaf.setBackground( Color.green );
        return leaf;
    }
    
    
    /**
     * Removes all the leaves of Tree t from the window.
     * 
     * @param t  a Tree object
     */



    /**
     * Colors each leaf on Tree t with randomly chosen colors.
     * 
     * @param t  a Tree object
     */
    private void  colorLeaves (Tree t)
    {
    	Oval [] leaves = t.getLeaves();
    	for ( int i = 0 ; i < numLeaves ; i++)
    	{
    		leaves[i].setBackground(getRandomColor());
    	}
    }



    /**
     * Returns a Color object at random.
     *
     * @return a Color chosen randomly from red/orange/yellow/brown
     */
    private Color getRandomColor()
    {
        Color col = Color.orange;

        int c = (int) ( Math.random() * 3 );
        if ( c == 0 )
        {
            col = Color.red;
        }
        else if ( c == 1 )
        {
            col = Color.yellow;
        }
        
        return col;
    }


    /**
     * Grows each leaf object on Tree t by 10% over the size of the first cluster (leaf1)
     * 
     * @param t  a Tree object
     */
   
    
    private void growLeaves(Tree t)
    {
    	Oval[] leaves = t.getLeaves();
    	
    	for ( int i = 0 ; i < numLeaves ; i ++)
    	{
        int width = leaves[0].getWidth();
        width = (int) ( width * 1.1 );

        if ( width <= 250 )
        {
        	width = (int)(width);
        }
    	}
    }
}
