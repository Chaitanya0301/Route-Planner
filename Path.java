//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Path
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

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This is the Path class
 * @author Chaitanya
 */
public class Path extends Object{

    private ArrayList<Intersection> intersections;//List of Intersections followed in this Path
    /**
     * Constructor for the path class which initializes it as empty.
     */
    public Path(){
        intersections = new ArrayList<Intersection>();
    }

    /**
     * Returns the number of Intersections in this Path
     * @return Number of intersections
     */
    public int length(){
        return this.intersections.size();
    }

    /**
     * Returns the first Intersection in this Path, if it is not empty.
     * @return the first Intersection in this Path, if it is not empty
     * @throws NoSuchElementException if this path is empty
     */
    public Intersection getHead() throws NoSuchElementException {
        if(intersections.get(0) != null) {
            return intersections.get(0);
        }
        else{
            throw new NoSuchElementException("Intersection null");
        }
    }

    /**
     * Returns the last Intersection in this Path, if it is not empty.
     * @return the last Intersection in this Path, if it is not empty
     * @throws NoSuchElementException if this path is empty
     */
    public Intersection getTail() throws NoSuchElementException {
        int size = intersections.size() - 1;
        if(intersections.get(size) != null) {
            return this.intersections.get(size);
        }
        else{
            throw new NoSuchElementException("Intersection null");
        }
    }

    /**
     * Adds the given Intersection to the end of this Path if it is a valid addition.
     * An Intersection is a valid addition if the current Path is empty, or the Intersection
     * to add is one step directly east, or one step directly north of the current tail
     * Intersection in this Path.
     * @param toAdd  Intersection to add to the end of this Path
     * @throws IllegalArgumentException if the Intersection to add is not valid
     */
    public void addTail(Intersection toAdd) throws IllegalArgumentException{
        if(intersections.size() == 0){
            intersections.add(toAdd);
        }
        else if((getTail().getX() + 1 == toAdd.getX() && getTail().getY() == toAdd.getY()) ||
                (getTail().getX() == toAdd.getX() && getTail().getY() + 1 == toAdd.getY())){
            intersections.add(toAdd);
        }
        else{
            throw new IllegalArgumentException("Invalid intersection");
        }

    }
    /**
     * Adds the given Intersection to the front of this Path if it is a valid addition.
     * An Intersection is a valid addition if the current Path is empty, or the Intersection
     * to add is one step directly west, or one step directly south of the current tail
     * Intersection in this Path.
     * @param toAdd  Intersection to add to the end of this Path
     * @throws IllegalArgumentException if the Intersection to add is not valid
     */
    public void addHead(Intersection toAdd) throws IllegalArgumentException {
        if (intersections.size() == 0) {
            intersections.add(0,toAdd);
        } else if(getHead().goWest().equals(toAdd)||getHead().goSouth().equals(toAdd)){
            intersections.add(0,toAdd);
        } else {
            throw new IllegalArgumentException("Invalid intersection");
        }
    }

    @Override
    /**
     * Returns a String representing the coordinates taken in this Path.
     */
    public String toString(){
        String to = "";
        if(intersections.size() == 0){
            to = "Empty";
        }
        else{
            for(int i = 0;i<intersections.size()-1;i++){
                to+= intersections.get(i).toString();
                to+= "->";
            }
            to+=intersections.get(intersections.size()-1).toString();
        }
        return to;
    }
}