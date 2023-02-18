//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Path Utils
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

/**
 * This is the PathUtils class.
 * @author Chaitanya
 */
public class PathUtils extends Object {

    /**
     * Constructor for the PathUtils class
     */
    public PathUtils() {

    }

    /**
     * Finds the number of valid Paths between the given start and end Intersections.
     *
     * @param start First intersection
     * @param end   Last intersection
     * @return the number of valid Paths which start and end at the given Intersections
     */
    public static int countPaths(Intersection start, Intersection end) {
        int numPaths = 0;

        if (start.getX() > end.getX() || start.getY() > end.getY()) {
            return 0;// returns 0 if no valid paths possible
        }
        if (start.getY() < end.getY()) {
            numPaths += countPaths(start.goNorth(), end);
        }
        if (start.getX() < end.getX()) {
            numPaths += countPaths(start.goEast(), end);
        }
        if (start.equals(end)) {
            numPaths += 1;
            return numPaths;
        }
        return numPaths;
    }

    /**
     * Finds all valid Paths between the given start and end Intersections.
     *
     * @param start Intersection to start at
     * @param end   Intersection to end at
     * @return
     */
    public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
        ArrayList<Path> paths = new ArrayList<Path>();
        if (start.equals(end)) {
            Path path = new Path();
            path.addTail(start);
            paths.add(path);
            return paths;
        } else if (start.getX() > end.getX() || start.getY() > end.getY()) {
            return paths;
        }
        if (start.getY() < end.getY()) {
            ArrayList<Path> upPaths = findAllPaths(start.goNorth(), end);

            for (int i = 0; i < upPaths.size(); i++) {
                upPaths.get(i).addHead(start);
                paths.add(upPaths.get(i));
            }
        }
        if (start.getX() < end.getX()) {
            ArrayList<Path> rightPaths = findAllPaths(start.goEast(), end);

            for (int i = 0; i < rightPaths.size(); i++) {
                rightPaths.get(i).addHead(start);
                paths.add(rightPaths.get(i));
            }
        }
        return paths;
    }
}