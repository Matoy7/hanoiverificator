package hanoi_moves_verificator.integer_tower;

import hanoi_moves_verificator.tower.Disk;
import hanoi_moves_verificator.tower.Rod;

import java.util.Stack;

/**
 * Created by elirazyo on 2/9/2017.
 *
 * represent an integer rod.
 * The rode is implement using a java built in Stack (from the java utils)
 * stack seems to be a neutral solution for representing the rod
 */


public class IntegerRod implements Rod<Integer> {
    Stack<Disk<Integer>> disks;
    int diskId;

    public IntegerRod(int diskId, int diskNumber) {
        this.diskId=diskId;
        disks = new Stack<>();
        for (int i = 0; i < diskNumber; i++) {
            disks.push(new Disk(i));
        }
    }

    @Override
    public Disk<Integer> peekFirstDisk() {
        return disks.peek();
    }

    @Override
    public Disk<Integer>  popFirstDisk() {
        return disks.pop();
    }

    @Override
    public boolean isPlaceDiskPossible(Disk<Integer> newDisk){
        if (disks.empty()) return true;

        int topDiskWeight = disks.peek().getWeight();
        int newDiskWeight = newDisk.getWeight();

        return (topDiskWeight<newDiskWeight);
    }

    @Override
    public void placeDisk(Disk<Integer> newDisk) {
        if (isPlaceDiskPossible(newDisk)){
            disks.push(newDisk);
        }
    }

    @Override
    public String toString(){
        String retString="";
        for (Disk disk: disks) {
            retString+=" "+disk.getWeight();
        }
        return retString;
    }
}
