/*
 * Subclass object of superclass Character that defines
 * specific characteristics of Chasers. Also serves
 * as support class for FroggerApp.
 */
package frogger;

/**
 *
 * @author seanblucker
 */
public class Chaser extends Character 
{ 
    //Constructor for Chasers that takes x,y-coordinates as arguments
    //Calls superclass Character
    public Chaser(int x, int y)
    {
        super(x,y);
        setMarker("C");
    }
    
    //Modifier method that defines Chaser object movement (converges on player every third act)
    @Override
    public void act(int playerX, int playerY)
    {
        if(getActsExecuted() % 3 == 0)
        {
            if(getX() > playerX)
            {
                setX(getX() - 1);
            }
            
            if(getX() < playerX)
            {
                setX(getX() + 1); 
            }
            
            if(getY() > playerY)
            {
                setY(getY() - 1); 
            }
            
            if(getY() < playerY)
            {
                setY(getY() + 1); 
            }
        }
        
        incrementActs();
    }
}
