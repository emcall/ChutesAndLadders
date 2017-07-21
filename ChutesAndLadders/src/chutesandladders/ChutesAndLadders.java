package chutesandladders;

public class ChutesAndLadders {
    
    //This is the board containing the values of every space. 

    
    public static void main(String[] args) {
        
        //Initialize the board, which contains an array of all the spots with chutes/ladders.
        Board board = new Board();
        board.initBoardDefault();
        
        //Players need only be integers, since all we need from them. This array contains each player's location.
        //I chose to have four.
        int[] players = {0,0,0,0};
        
        //This is the main loop of the game. Once someone's location is 100 we exit the game.
        while(true){
            for(int i=0; i<4; i++){
                System.out.println("Player " + (i + 1) + "'s turn!");
                players[i] = board.movePiece(players[i]);
                if (players[i] == 100){
                    System.out.println("We have a winner! Congratulations to player " + (i + 1) + "! It's totally random, so not much of an accomplishment, but still!");
                    return;
                }
            }    
        }
        
        
    }
    
}
