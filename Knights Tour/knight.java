package tour;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/** * Program (knight class) to solve knights tour using random traversal
 * 
 * @author Kaveri Krishnaraj
 * @version 1.0
 *
 */


public class knight
{
	public static int row;
	public static int column;
	public static int attempt;
	
	public static int count;
	public static int[][] board ;
	
	/**return the number of attempt
	 * @return attempt number of attempts to solve the Knight's Tour
	 */
	public static int getAttempt() {
		return attempt;
	}
	
	/**main method
	 * 
	 */
   public static void main(String [] args)
	{
	    /*row = Integer.parseInt(args[0]);
		column = Integer.parseInt(args[1]);
		attempt = Integer.parseInt(args[2]);*/
		row = 4;
		column = 4;
		attempt = 50;
		knight kt = new knight(row,column,attempt);
		
		for(int k = 0; k < kt.getAttempt(); k++){
            boolean result = kt.checkAttempt();
            if(result)
                break;
            else if (!result && k < kt.getAttempt()-1){
            	for (int i=0;i<row;i++)
       		 {
       		   for(int j=0;j<column; j++)
       		   {
       		     board[i][j] = -1;
       	      }
              }
            }
        }
		print();
	}
   /**constructs an instance of this class
    * @param row number of rows on the board
    * @param column number of columns on the board
    * @param attempt number of attempts given to solve the knight's tour
    */
	public knight(int row, int column,int attempt)
	 {
	    this.row = row;
		 this.column = column;
		 this.attempt= attempt;
	    board = new int[row][column];
		 for (int i=0;i<row;i++)
		 {
		   for(int j=0;j<column; j++)
		   {
		     board[i][j] = -1;
	      }
       }
		
     }
	/**return a Coords list of legal moves from a given position
	 * @param x x value of a given coordinate
	 * @param y y value of a given coordinate
	 */
	
	public static List<Coords> getMoves(int x, int y) {
        List<Coords> l = new ArrayList<Coords>();
        if (x + 2 < column && y - 1 >= 0)
        	if(board[x+2][y-1] == -1)
            l.add(new Coords(x + 2, y - 1)); 
        if (x + 1 < column && y - 2 >= 0)
        	if(board[x+1][y-2] == -1)
            l.add(new Coords(x + 1, y - 2)); 
        if (x - 1 >= 0 && y - 2 >= 0)
        	if(board[x-1][y-2] == -1)
            l.add(new Coords(x - 1, y - 2)); 
        if (x - 2 >= 0 && y - 1 >= 0)
        	if(board[x-2][y-1] == -1)
            l.add(new Coords(x - 2, y - 1)); 
        if (x - 2 >= 0 && y + 1 < row)
        	if(board[x-2][y+1] == -1)
            l.add(new Coords(x - 2, y + 1));
        if (x - 1 >= 0 && y + 2 < row)
        	if(board[x-1][y+2] == -1)
            l.add(new Coords(x - 1, y + 2)); 
        if (x + 1 < row && y + 2 < row)
        	if(board[x+1][y+2] == -1)
        	l.add(new Coords(x + 1, y + 2)); 
        if (x + 2 < row && y + 1 < row)
        	if(board[x+2][y+1] == -1)
            l.add(new Coords(x + 2, y + 1));
        return l;
    }
	/**performs the Knight's tour 
	 * @param current_x x value of a given coordinate
	 * @param currrent_y y value of a given coordinate
	 */
    public static void tour(int current_x, int current_y)
    {
    	
    	       board[current_x][current_y] = count;
				Random rand = new Random();
		        int random;
		        List<Coords> l = getMoves(current_x, current_y);
		        if(l.size() == 0)
		            return;
		        else{
		        	random = rand.nextInt(l.size()); 
		        
	              board[l.get(random).getX()][l.get(random).getY()] = count; 
	               count++;
	              tour(l.get(random).getX(), l.get(random).getY());
	                   
	              return;  
	               }
	}
	/**checks if the board is solved or if each square is visited atleast once (no squares with -1)
	 *@return boolean value true if the board is solved, false if it's not 	        
	 */
		       
	 
    public boolean checkSolution(){
        int moves = row * column;
        int counter = 0;
        boolean ret = false;        
        for (int r = 0; r < row; r++){
            for (int c = 0; c < column; c++){
                if(board[r][c] != -1)
                    counter++;
            }
        }
        if(moves == counter)
            ret = true;
        
        return ret;
    }
    /**checks if there is a solution to the Knight's Tour
     * @return true if there is a solution, false if there is not
     */
public boolean checkAttempt(){
        
        boolean ret;
        
        count = 1;
        tour(0,0);
        if(checkSolution()){
           ret = true;
        } else
            ret = false;
        
        return ret;
    }
/**prints the board with rows and columns
 * 
 */
	 public static void print()
	{
	
		for(int i = 0;i < row ;i++)
		{
			for(int j=0;j < column ;j++)
			{
				   
				   System.out.printf("%3d", board[i][j]);
			
			}
		    System.out.println("\n");
		}
	}
}
