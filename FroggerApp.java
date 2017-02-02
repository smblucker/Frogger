/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

/**
 *
 * @author seanblucker
 */
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;



public class FroggerApp extends JFrame implements ActionListener {



    // Member variables for visual objects.

    private JLabel[][] board; // 2D array of labels. Displays either # for player,

                              // symbol for character, or empty space

    private JButton northButton, // player presses to move up

                    southButton, // player presses to move down

                    eastButton,  // player presses to move right

                    westButton;  // player presses to move left

    

    // Current width and height of board (will make static later).

    private int width = 9;

    private int height = 9;

    

    // Current location of player

    private int playerX = 5;

    private int playerY = 0;

    

    // Array of character objects (will actually store subclass objects)



    /****** Change this to use an ArrayList ******/



    private Character[] characters;

    private static final int CHARACTERS = 15;

    

    public FroggerApp() {

        

        // Construct a panel to put the board on and another for the buttons

        JPanel boardPanel = new JPanel(new GridLayout(height, width));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

        

        // Use a loop to construct the array of labels, adding each to the

        // board panel as it is constructed. Note that we create this in

        // "row major" fashion by making the y-coordinate the major 

        // coordinate. We also make sure that increasing y means going "up"

        // by building the rows in revers order.

        board = new JLabel[height][width];

        for (int y = height-1; y >= 0; y--) {

            for (int x = 0; x < width; x++) {

                

                // Construct a label to represent the tile at (x, y)

                board[y][x] = new JLabel(" ", JLabel.CENTER);

                

                // Add it to the 2D array of labels representing the visible board

                boardPanel.add(board[y][x]);

            }

        }

        

        // Construct the buttons, register to listen for their events,

        // and add them to the button panel

        northButton = new JButton("N");

        southButton = new JButton("S");

        eastButton = new JButton("E");

        westButton = new JButton("W");

        

        // Listen for events on each button

        northButton.addActionListener(this);

        southButton.addActionListener(this);

        eastButton.addActionListener(this);

        westButton.addActionListener(this);

        

        // Add each to the panel of buttons

        buttonPanel.add(northButton); 

        buttonPanel.add(southButton); 

        buttonPanel.add(eastButton); 

        buttonPanel.add(westButton);

        

        // Add everything to a main panel attached to the content pane

        JPanel mainPanel = new JPanel(new BorderLayout());

        getContentPane().add(mainPanel);

        mainPanel.add(boardPanel, BorderLayout.CENTER);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        

        // Size the app and make it visible

        setSize(200, 200);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        // Auxiliary method to create game setup

        createGame();

    }

    

    // Auxiliary method used to create board. Sets player, treasure, and walls.

    public void createGame() {

        

        // Construct array of character objects



        /****** Modify to construct an ArrayList of Characters instead **********/

        characters = new Character[CHARACTERS];

        

        // Construct each character in the array, passing it its initial location

        // and other parameters as necessary. Polymorphism is used to store 

        // subclass objects inot the supeclass array.



        /****** Modify to add each of these to the ArrayList *********/

        

        // Three patrollers on rows 2 and 6

        characters[0] = new Patroller(1, 2, width, "left");

        characters[1] = new Patroller(4, 2, width, "left");

        characters[2] = new Patroller(7, 2, width, "left");

        characters[3] = new Patroller(1, 6, width, "right");

        characters[4] = new Patroller(4, 6, width, "right");

        characters[5] = new Patroller(7, 6, width, "right");

        

        // Chasers in either corner at bottom of screen

        characters[6] = new Chaser(0, 0);

        characters[7] = new Chaser(8, 0);

        

        // Hiders in rows 3 and 5

        characters[8] = new Hider(2, 3);

        characters[9] = new Hider(6, 3);

        characters[10] = new Hider(2, 5);

        characters[11] = new Hider(6, 5);

        

        // One jumper each in rows 1, 4, and 7

        characters[12] = new Jumper(2, 1, width);

        characters[13] = new Jumper(7, 4, width);

        characters[14] = new Jumper(3, 7, width);

        

        // Call method to draw board

        drawBoard();

        

    }

    

    // Auxiliary method to display player and opponents in labels.

    public void drawBoard() {

        

        // "Erase" previous board by writing " " in each label

        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {

                board[y][x].setText(" ");

            }

        }        

        

        // Write the player onto the board.

        board[playerY][playerX].setText("#");



        /****** Modify this loop to use get to get the ith element from the ArrayList ******/

        

        // Get location of each opponent and write its marker into that label. 

        for (int i = 0; i < CHARACTERS; i++) {

            if (characters[i].isVisible()) {

                board[characters[i].getY()][characters[i].getX()].setText(characters[i].getMarker());

            }

        }

    }

    

    

    public void actionPerformed(ActionEvent e) {

        

        // Determine which button was pressed, and move player in that

        // direction (making sure they don't leave the board).

        if (e.getSource() == southButton && playerY > 0) {

            playerY--;

        }

        if (e.getSource() == northButton && playerY < height-1) {

            playerY++;

        }

        if (e.getSource() == eastButton && playerX < width-1) {

            playerX++;

        }

        if (e.getSource() == westButton && playerX > 0) {

            playerX--;

        }

        

        // Cause the opponents to take their particular action. 



        /****** Modify this loop to use get to get the ith element from the ArrayList ******/

       

        for (int i = 0; i < CHARACTERS; i++) {

            characters[i].act(playerX, playerY);

            

            // If one has captured the player, print a message and stop the game

            if (characters[i].getX() == playerX && characters[i].getY() == playerY) {

                JOptionPane.showMessageDialog(this, "You have been caught!");

                gameFinished();

            }

        }

        

        // If the player has reached the top row, print a message and stop the game

        if (playerY == 8) {

            JOptionPane.showMessageDialog(this, "You have escaped!");

            gameFinished();                

        }

        

        // Redraw the board

        drawBoard();

        

    }

    

    // Auxiliary method to disable all buttons at end of game

    public void gameFinished() {

        northButton.setEnabled(false);

        southButton.setEnabled(false);

        eastButton.setEnabled(false);

        westButton.setEnabled(false);        

    }

    /**

     * @param args the command line arguments

     */

    public static void main(String[] args) {

        FroggerApp a = new FroggerApp();

    }

}

