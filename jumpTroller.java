/*
 * Intermediate superclass for Patrollers and Jumpers
 * that defines general characteristics. Also serves 
 * as support class for FroggerApp.
 */
package frogger;

/**
 *
 * @author seanblucker
 */

public abstract class jumpTroller extends Character 
{
    private int width;                                                          //Variable that stores board width
    
    //Constructor for jumpTrollers that takes x,y-coordinates and board width as arguments
    //Calls superclass Character
    public jumpTroller(int x, int y, int w)
    {
        super(x,y);
        width = w;
    }
    
    //Inspector method that returns board width
    public int getWidth()
    {
        return width;
    }
}
