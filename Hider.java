/*
 * Subclass object of superclass Character that defines
 * specific characteristics of Hiders. Also serves
 * as support class for FroggerApp.
 */
package frogger;

/**
 *
 * @author seanblucker
 */
public class Hider extends Character 
{
    //Constructor for Hiders that takes x,y-coordinates as arguments
    //Calls superclass Character
    public Hider(int x, int y)
    {
        super(x,y);
        setMarker("H");
    }
    
    //Modifier method that defines Hider object movement (stationary and reverses visibility every other act)
    @Override
    public void act(int playerX, int playerY)
    {
        if(getActsExecuted() % 2 == 0)
        {
            setVisibility(!isVisible());
        }
        
        incrementActs();
    }
}
