package hanoi_moves_verificator.tower;

/**
 * Created by elirazyo on 2/9/2017.
 *
 * Information: This is a generic hanio tower.
 * It has 2 methods:
 * ---   move disk() - move a disk based on the Move object
 * ----  is complete() - returns true/false based on if the tower follows the hanoi complete rule.
 * meaning the first rod had located to another rod (could be the 2nd or the 3rd rod)
 */

public interface Tower<T extends Comparable> {
    boolean moveDisk(Move move);
    boolean isComplete();
}
