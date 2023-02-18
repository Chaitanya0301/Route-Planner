//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Intersection
// Course:   CS 300 Fall 2022
//
// Author:   Chaitanya Sharma
// Email:    csharma4@wisc.edu
// Lecturer: Mouna Kacem
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This is the Intersection class
 * @author Chaitanya
 */
public class Intersection extends Object{
    private final int x;//X-axis coordinate of this intersection
    private final int y;//Y-axis coordinate of this intersection

    /**
     * The constructor for the Intersection class of the city route
     * @param x X-axis coordinate
     * @param y Y-axis coordinate
     */
    public Intersection(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for the x-axis coordinate.
     * @return X coordinate
     */
    public int getX(){
        return x;
    }

    /**
     * Getter for the y-axis coordinate.
     * @return Y coordinate
     */
    public int getY(){
        return y;
    }
    @Override
    /**
     * Returns a coordinate-pair representation of this Intersection in the form "(x,y)"
     */
    public String toString(){
        String to = "("+getX()+","+getY()+")";
        return to;
    }
    @Override
    /**
     * Returns true if the given Object is identical to this Intersection
     * @param o   the reference object with which to compare.
     * @return true if the given Object is an Intersection object
     *         which has the same x and y coordinates as this Intersection
     */
    public boolean equals(Object o){
        if(o instanceof Intersection){
            if(((Intersection) o).getX() == this.getX()&&((Intersection) o).getY() == this.getY()){
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a new Intersection instance which is one step directly above this Intersection.
     * @return New upwards instance
     */
    public Intersection goNorth(){
        return new Intersection(getX(),getY()+1);
    }

    /**
     * Creates a new Intersection instance which is one step directly below this Intersection.
     * @return New downwards instance
     */
    public Intersection goSouth(){
        return new Intersection(getX(),getY()-1);
    }

    /**
     * Creates a new Intersection instance which is one step directly to the right of this Intersection.
     * @return New rightwards instance
     */
    public Intersection goEast(){
        return new Intersection(getX()+1,getY());
    }

    /**
     * Creates a new Intersection instance which is one step directly to the left of this Intersection.
     * @return New lefttwards instance
     */
    public Intersection goWest(){
        return new Intersection(getX()-1,getY());
    }

}
