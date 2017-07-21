/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chutesandladders;

/**
 *
 * @author Emily
 */
public class Board {
        public static int[] boardArray = new int[101];
    
    
    public void initBoardDefault(){
        
        //First, let's put a value in every slot
        for(int i=0; i<=100; i++){
            boardArray[i] = 0;
        }
        //Now, let's add in the chutes and the ladders
        //For this I am just copying the board provided
        //If there is a chute/ladder then the value is # of spaces moved
        
        boardArray[1] = 37;
        boardArray[4] = 10;
        boardArray[9] = 38;
        boardArray[16] = -10;
        boardArray[21] = 21;
        boardArray[28] = 56; //I agree with this space; being nice to a cat should move you halfway up the board.
        boardArray[36] = 8;
        boardArray[47] = -11;
        boardArray[49] = -38;
        boardArray[51] = 16;
        boardArray[56] = -3;
        boardArray[62] = -43;
        boardArray[64] = -4;
        boardArray[71] = 20;
        boardArray[80] = 20;
        boardArray[87] = -53;
        boardArray[93] = -20;
        boardArray[95] = -20;
        boardArray[98] = -20;
        
    }
    /*
        pieceLoc = the current spot on the board for the piece being moved
        This function:
        -Rolls a die
        -Calculates the new spot
        -Checks if that spot is past 100, or if it has a chute/ladder, and reacts accordingly
        -returns the new location
    
    */
    public int movePiece(int pieceLoc){
        //roll the die, val between 1 to 6
        int dieRoll = (int)(Math.random()*6)+1;
        
        //calculate the new location of the 
        int newSpace = dieRoll + pieceLoc;
        
        System.out.println("They rolled a " + dieRoll + "! That will put them on space " + newSpace);
       
        //Make sure not to exceed 100. If so, they stay where they are, and lose the turn.
        if(newSpace > 100){
            System.out.println("Oh, tough luck. They overshot the goal! Try again next time.");
            return pieceLoc;
        }
        
        //Ok, we didn't go past. Now let's see what's on that space.
        //(There aren't any ladders that go above 100 so we don't need to check for overshooting again)
        int spaceVal = boardArray[newSpace];
        
        //if the spot is blank we can just return newSpace
        if(spaceVal == 0){
            System.out.println("Phew, space " + newSpace + " is blank.");  
            return newSpace;
        }
        
        if(spaceVal > 0)
            System.out.println("Oh dang! There's a ladder here. Moving up in the world!  :D");
        
        else if(spaceVal < 0)    
            System.out.println("Aw, beans! Hit a chute :(");
        
        System.out.println("Now they have to move " + (int)Math.abs(spaceVal) + " spaces.");
        
        return (newSpace + spaceVal);
    }

}
