package tour;
/*
 * Coords class contains the x and y coordinates of a square in the board
 * @author Kaveri Krishnaraj
 * @version 1.0
 */

public class Coords {
    private int x;
    private int y;
    /*constructs an instance of this class
     * @param x x coordinate of the square
     * @param y y coordinate of the square
     */
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x coordinate of this square
     */
    public int getX() {
        return x;
    }

    /**
     * @param x set the x coordinate of this square
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the x coordinate of this square
     */
    public int getY() {
        return y;
    }

    /**
     * @param y set the y coordinate of this square
     */
    public void setY(int y) {
        this.y = y;
    }
}