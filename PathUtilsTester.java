//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Path Utils Tester
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
 * This is the tester class for PathUtils
 * @author Chaitanya
 */
public class PathUtilsTester {
    /**
     * Main method for the tester class
     * @param args if needed
     */
    public static void main(String[] args){
        System.out.println(testCountPathsNoPath());
        System.out.println(testCountPathsOnePath());
        System.out.println(testCountPathsRecursive());
        System.out.println(testFindAllPathsNoPath());
        System.out.println(testFindAllPathsOnePath());
        System.out.println(testFindAllPathsRecursive());
    }

    /**
     * Tests the case of countPaths() when there are no valid Paths.
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsNoPath(){
        if(PathUtils.countPaths(new Intersection(2,3),new Intersection(0,3)) != 0){
            return false; // checks count paths if the end point is to the west
        }
        if(PathUtils.countPaths(new Intersection(2,3),new Intersection(2,1)) != 0){
            return false; // checks count paths if the end point is to the south
        }
        return true;
    }

    /**
     * Tests the case of countPaths() when there is a single valid Path.
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsOnePath(){
        if(PathUtils.countPaths(new Intersection(2,3),new Intersection(2,4)) != 1){
            return false; // checks count paths if there is only one valid path
        }
        return true;
    }

    /**
     * Tests the case of countPaths() when there are multiple possible paths.
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsRecursive(){
        if(PathUtils.countPaths(new Intersection(0,0),new Intersection(1,2)) != 3){
            return false; // checks count paths if there are multiple valid paths
        }
        return true;
    }

    /**
     * Tests the case of findAllPaths() when there are no valid Paths.
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsNoPath(){
        ArrayList<Path> paths = new ArrayList<Path>();// empty paths array list

        if(PathUtils.findAllPaths(new Intersection(1,1),new Intersection(1,0)).equals(paths)){
            return true; // checks for invalid case with an empty array list of paths
        }
        return false;
    }

    /**
     * Tests the case of findAllPaths() when there is a single valid Path.
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsOnePath(){
        Path path = new Path();
        path.addHead(new Intersection(1,1));
        path.addTail(new Intersection(1,2));

        if(PathUtils.findAllPaths(new Intersection(1,1),new Intersection(1,2)).size() != 1){
            return false; // checks whether there is only one valid path generated
        }
        if(PathUtils.findAllPaths(new Intersection(1,1),new Intersection(1,2)).get(0).toString().equals(path.toString())){
            return true; // checks if the find all paths returns correct output with one expected path
        }
        return false;
    }

    /**
     * Tests the case of findAllPaths() when there are multiple possible paths.
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsRecursive(){
        Path path1 = new Path(); Path path2 = new Path();
        path1.addHead(new Intersection(0,0)); path1.addTail(new Intersection(0,1));
        path1.addTail(new Intersection(1,1)); // path 1 from intersection (0,0) to (1,1)
        path2.addHead(new Intersection(0,0)); path2.addTail(new Intersection(1,0));
        path2.addTail(new Intersection(1,1));// path 2 from intersection (0,0) to (1,1)

        ArrayList<Path> testCase = PathUtils.findAllPaths(new Intersection(0,0),new Intersection(1,1));
        int testNum = 0;
        for(int i = 0;i<testCase.size();i++){// for loop to go through the find all paths output
            if(testCase.get(i).toString().equals(path1.toString()) || testCase.get(i).toString().equals(path2.toString())){
                testNum+=1; // increments the number everytime an expected path was found
            }
        }
        if(testNum == 2){
            return true; // returns true if both paths were found
        }
        return false;
    }
}
