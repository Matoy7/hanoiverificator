package hanoi_moves_verificator.integer_tower;

import hanoi_moves_verificator.tower.Disk;
import hanoi_moves_verificator.tower.Rod;
import hanoi_moves_verificator.tower.Tower;
import hanoi_moves_verificator.tower.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by elirazyo on 2/9/2017.
 *
 * Information: this is a implementation of the hanoi tower, which weight values are integer.
 *
 * I chose to implement it this way because the weight values type has no significant importance
 * and integer seems as the neutral and simple selection for that....
 *
 * one can implement a different hanoi tower using the tower interface
 */

public class IntegerTower implements Tower<Integer> {
    private static final int rodesNumber = 3;
    private List<IntegerRod> rods;

    public IntegerTower(int numberOfWeights){
        rods= new ArrayList<>(rodesNumber);

        IntegerRod firstRode=new IntegerRod(1,numberOfWeights);
        rods.add(firstRode);

        for (int i = 2; i <=3 ; i++) {
            IntegerRod emptyRode=new IntegerRod(i,0);
            rods.add(emptyRode);
        }
    }
    @Override
    public boolean moveDisk(Move move){
        int sourceRodIndex=move.getSourceRod();
        int destRodIndex=move.getDestinationRod();

        Rod<Integer> sourceRod =rods.get(sourceRodIndex-1);
        Rod<Integer> destRod =rods.get(destRodIndex-1);

        Disk<Integer> pushedDisk = sourceRod.peekFirstDisk();

        if (pushedDisk==null){
            return false;
        }

        if (destRod.isPlaceDiskPossible(pushedDisk)){
            sourceRod.popFirstDisk();
            destRod.placeDisk(pushedDisk);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isComplete() {
        if (!rods.get(0).disks.empty()){
            return false;
        }
        if (rods.get(1).disks.empty() && !rods.get(2).disks.empty()){
            return true;
        }

        if (rods.get(2).disks.empty() && !rods.get(1).disks.empty()){
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        String retString="";
        for (int i = 0; i <rodesNumber ; i++) {
            retString+="    rod "+i+": "+rods.get(i);
        }
        return retString;
    }
}
