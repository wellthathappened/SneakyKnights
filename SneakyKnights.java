// Name: Ian Lewis
// Date: 09/27/16
// Course: COP 3503C
// Assignment 3

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

public class SneakyKnights {

    static int row = 0, col = 0;
    static String nums, chars;
    
    public static boolean
    allTheKnightsAreSafe(ArrayList<String> coordinateStrings, int boardSize)
    {
        // We use HashSets to prevent overlaps
        HashSet<Point> plantedPoints = new HashSet<>();
        HashSet<Point> unsafePoints = new HashSet<>();
        
        // Initialize our points
        Point center;
        Point upLeft;
        Point upRight;
        Point rightUp;
        Point rightDown;
        Point downRight;
        Point downLeft;
        Point leftDown;
        Point leftUp;
        
        // We cycle through each coordinate string and find it's accompanying
        // 6 points of attack
        for(int i = 0;i < coordinateStrings.size();i++)
        {
            // Convert the given string to a coordinate set
            coordinateParser(coordinateStrings.get(i));
            
            // Establish our current point
            center = new Point(col,row);
            
            // If there is a duplicate found in plantedPoints or the point is
            // found to be unsafe, we know that not all knights are safe
            if((!plantedPoints.add(center)) || (unsafePoints.contains(center)))
                return false;
            
            // The following set of if-statements check to see if a given attack
            // point is actually on the board and if it is, we check to see if
            // any knights have already been placed on the given attack point.
            // If so, we know that not all knights are safe. If not, we add
            // the point to our pool of unsafe points and carry on.
            
            if(((col+2) < boardSize) || ((row-1 > 0)))
            {
                upLeft = new Point(col+2,row-1);
                
                if(!plantedPoints.contains(upLeft))
                    unsafePoints.add(upLeft);
                
                else return false;
            }
            
            if(((col+2) < boardSize) || ((row+1 < boardSize)))
            {
                upRight = new Point(col+2,row+1);
                
                if(!plantedPoints.contains(upRight))
                    unsafePoints.add(upRight);
                
                else return false;
            }
            
            if(((col+1) < boardSize) || ((row+2 < boardSize)))
            {
                rightUp = new Point(col+1,row+2);
                
                if(!plantedPoints.contains(rightUp))
                    unsafePoints.add(rightUp);
                
                else return false;
            }
            
            if(((col-1) > 0) || ((row+2 < boardSize)))
            {
                rightDown = new Point(col-1,row+2);
                
                if(!plantedPoints.contains(rightDown))
                    unsafePoints.add(rightDown);
                
                else return false;
            }
            
            if(((col-2) > 0) || ((row+1 < boardSize)))
            {
                downRight = new Point(col-2,row+1);
                
                if(!plantedPoints.contains(downRight))
                    unsafePoints.add(downRight);
                
                else return false;
            }
            
            if(((col-2) > 0) || ((row-1 > 0)))
            {
                downLeft = new Point(col-2,row-1);
                
                if(!plantedPoints.contains(downLeft))
                    unsafePoints.add(downLeft);
                
                else return false;
            }
            
            if(((col-1) > 0) || ((row-2 > 0)))
            {
                leftDown = new Point(col-1,row-2);
                
                if(!plantedPoints.contains(leftDown))
                    unsafePoints.add(leftDown);
                
                else return false;
            }
            
            if(((col+1) < boardSize) || ((row-2 > 0)))
            {
                leftUp = new Point(col+1,row-2);
                
                if(!plantedPoints.contains(leftUp))
                    unsafePoints.add(leftUp);
                
                else return false;
            }
        }
        
        // So long as all of our criteria are met, we have a safe board.
        return true;
    }
    
    // Converts our string input to a coordinate set
    // (This method is reused verbatim from my SneakyQueens assignment)
    public static void coordinateParser(String coordinates)
    {
        int coordinateSplitPoint = 0;
        
        col = 0;
        row = 0;
        chars = "";
        nums = "";
        
        // We find the dividing point where our letters end and our ints begin.
        for(int i = 0;i < coordinates.length();i++)
            if(i >= 1)
                if((coordinates.charAt(i - 1) >= 97) && (coordinates.charAt(i) < 97))
                {
                    coordinateSplitPoint = i;
                    break;
                }
        
        // Convert the integer substring quickly to an actual int.
        nums = coordinates.substring(coordinateSplitPoint);
        row = Integer.parseInt(nums);
        
        // Convert the characters in the letter substring to integer values.
        if(coordinateSplitPoint == 1)
            col = (int) coordinates.charAt(0) - 96;
        
        else
        {
            chars = coordinates.substring(0,coordinateSplitPoint);
        
            for(int i = 0;i < chars.length();i++)
            {
                if(i == chars.length() - 1)
                    col += (int) chars.charAt(i) - 96;
                
                else
                    col += ((int) Math.pow(26,chars.length() - (i + 1)) * ((int) chars.charAt(i) - 96));
            }
        }
    }
    
    public static double difficultyRating()
    {
        return 2.5;
    }
    
    public static double hoursSpent()
    {
        return 2.0;
    }
}
