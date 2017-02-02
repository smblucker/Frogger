/*
 * Subclass object of superclass Character that defines
 * specific characteristics of Patrollers. Also serves
 * as support class for FroggerApp.
 */
package frogger;

/**
 *
 * @author seanblucker
 */
public class Patroller extends jumpTroller 
{
    private String direction;                                                   //Variable that stores direction of Patroller objects
    
    //Constructor for Patrollers that takes x,y-coordinates, width of board, and direction as arguments.
    //Calls intermediate superclass jumpTroller
    public Patroller(int x, int y, int width, String direction)
    {
        super(x, y, width);
        this.direction = direction;
        setMarker("P");
    }
    
    //Modifier method that defines Patroller object movement (left or right, every other act, with wrapping)
    @Override
    public void act(int playerX, int playerY)
    {
        if(getActsExecuted() % 2 == 0)
        {
            if(direction.equals("left") && getX() == 0)
            {
                setX(getWidth() - 1);
            }
            
            if(direction.equals("left"))
            {
                setX(getX() - 1);
            }
            
            if(direction.equals("right") && getX() == getWidth() - 1)
            {
                setX(0);
            }
            
            if(direction.equals("right"))
            {
                setX(getX() + 1);
            }
        }
   
        incrementActs();
    }
}
