package hanoi_moves_verificator.utils;

import hanoi_moves_verificator.tower.Move;

/**
 * Created by elirazyo on 2/11/2017.
 */
public class MoveUtils {
    public static Move createMoveFromString(String moveString) {
        int moveInt= Integer.parseInt(moveString);
        int sourceRod = moveInt/10;
        int destRod = moveInt % 10;
        if (!(verifyRodIndex(sourceRod) && verifyRodIndex(destRod))){
            return null;
        }
        return new Move(sourceRod,destRod);
    }
    private static boolean verifyRodIndex(int rodIndex){
        return (rodIndex>0 && rodIndex<4);
    }


    public static boolean isValidWeightNumber(String str)
    {
        int number;
        try
        {
            number = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return (number>0);
    }
    public static boolean isValidMove(String str)
    {
        int number;
        try
        {
            number = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return (number>10 && number<100);
    }
}
