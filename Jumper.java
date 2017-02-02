/*
 * Subclass object of superclass Character that defines
 * specific characteristics of Jumpers. Also serves
 * as support class for FroggerApp.
 */
package frogger;

/**
 *
 * @author seanblucker
 */

import java.util.Random;

public class Jumper extends jumpTroller 
{
    //Constructor for Jumpers that takes x,y-coordinates and board width as arguments
    //Calls intermediate superclass jumpTroller
    public Jumper(int x, int y, int w)
    {
        super(x,y,w);
        setMarker("J");
    }
    
    //Modifier method that defines Jumper object movement (jumps to random location every fourth act)
    @Override
    public void act(int playerX, int playerY)
    {
        if(getActsExecuted() % 4 == 0)
        {
            Random rn = new Random();
            setX(rn.nextInt(getWidth() - 1));
        }
        
        incrementActs();
    }
}
