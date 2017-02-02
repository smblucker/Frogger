/*
 * Superclass for all subclass character objects that defines
 * all general characteristics of a character. Also serves as
 * support class for FroggerApp.
 */
package frogger;

/**
 *
 * @author seanblucker
 */
public abstract class Character 
{
    private int characterX;                                                     //Variable that stores character's x-coordinate
    private int characterY;                                                     //Variable that stores character's y-coordinate
    private String marker;                                                      //Variable that stores character's symbolic representation on the board
    private int actsExecuted;                                                   //Variable that stores total number of acts executed in game
    private boolean visible;                                                    //Boolean variable to indicate whether character is visible
    
    //Constructor for superclass that takes x,y-coordinates as arguments
    public Character(int x, int y)
    {
        characterX = x;
        characterY = y;
        marker = "";
        actsExecuted = 0;
        visible = true;
    }
    
    //Inspector method that returns character's x-coordinate
    public int getX()
    {
        return characterX;
    }
    
    //Inspector method that returns character's y-coordinate
    public int getY()
    {
        return characterY;
    }
    
    //Inspector method that returns total number of acts executed in game
    public int getActsExecuted()
    {
        return actsExecuted;
    }
    
    //Modifier method that increments the number of acts executed
    public void incrementActs()
    {
        actsExecuted++;
    }
    
    //Protected modifier method that allows subclass objects to modify character's x-coordinate
    protected void setX(int x)
    {
        characterX = x;
    }
    
    //Protected modifier method that allows subclass objects to modify character's y-coordinate
    protected void setY(int y)
    {
        characterY = y;
    }
    
    //Protected modifer method that allows subclass objects to modify character's visibility
    protected void setVisibility(boolean v)
    {
        visible = v;
    }
    
    //Protected modifier method that allows subclass objects to modify symbolic representation on board
    protected void setMarker(String n)
    {
        marker = n;
    }
    
    //Inspector method that returns character's symbolic representation on the board
    public String getMarker()
    {
        return marker;
    }
    
    //Inspector method that returns boolean value to indicate whether character is visible
    public boolean isVisible()
    {
        return visible;
    }
    
    //Abstract modifier method that, when overriden by subclass objects, defines character movement and timing
    public abstract void act(int playerX, int playerY);

}
