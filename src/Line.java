/**
 * Creates a simple graphical line.
 *
 */
import javax.swing.*;
import java.awt.*;

@SuppressWarnings( "serial" )
public class Line extends JComponent
{
    private int thickness;
    private int theX1, theY1, theX2, theY2;
    
    /**
     * Initiates a 1-pixel line from initial coorindates to end coordinates.
     *
     * @param x1 x-coordinate of initial point.
     * @param y1 y-coordinate of initial point.
     * @param x2 x-coordinate of end point.
     * @param y2 y-coordinate of end point.
     */
    public Line( int x1, int y1, int x2, int y2 )
    {
        super();
        thickness = 1;
        theX1 = x1;
        theY1 = y1;
        theX2 = x2;
        theY2 = y2;
        setBounds( Math.min( x1, x2 ) - 1, Math.min( y1, y2 ) - 1,
                  Math.max( x1, x2 ) + 2, Math.max( y1, y2 ) + 2 );
        setBackground( Color.black );
    }
    
    /**
     * Initiates a t-pixel line from initial coorindates to end coordinates.
     *
     * @param x1 x-coordinate of initial point.
     * @param y1 y-coordinate of initial point.
     * @param x2 x-coordinate of end point.
     * @param y2 y-coordinate of end point.
     * @param t Thickness of line (pixels).
     */
    public Line( int x1, int y1, int x2, int y2, int t )
    {
        super();
        thickness = t;
        theX1 = x1;
        theY1 = y1;
        theX2 = x2;
        theY2 = y2;
        setBounds( Math.min( x1, x2 ) - t - 1, Math.min( y1, y2 ) - t - 1,
                  Math.max( x1, x2 ) + t + 1, Math.max( y1, y2 ) + t + 1 );
        setBackground( Color.black );
    }
    
    /**
     * @param t Thickness of line (in pixels).
     */
    public void setThickness( int t )
    {
        thickness = t;
        setBounds( Math.min( theX1, theX2 ) - t - 1, Math.min( theY1, theY2 ) -
                  t - 1,
                  Math.max( theX1, theX2 ) + t + 1, Math.max( theY1, theY2 ) +
                  t + 1 );
    }
    
    /**
     * post: draws line from initial points (theX1, theY1) to end (theX2, theY2)
     */
    public void paint( Graphics g )
    {
        ( (Graphics2D) g ).setStroke( new BasicStroke( thickness,
                                                      BasicStroke.CAP_BUTT,
                                                      BasicStroke.JOIN_BEVEL ) );
        g.setColor( getBackground() );
        g.drawLine( theX1 - getX(), theY1 - getY(), theX2 - getX(), theY2 -
                   getY() );
        ( (Graphics2D) g ).setStroke( new BasicStroke( 1.0f ) );
    }
}
