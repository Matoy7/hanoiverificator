package hanoi_moves_verificator.tower;

/**
 * Created by elirazyo on 2/9/2017.
 *
 * represent a interface of a rod in the tower.
 */
public interface Rod<T extends Comparable> {
    void placeDisk(Disk<T> disk);
    boolean isPlaceDiskPossible(Disk<T> disk);
    Disk<T> peekFirstDisk();
    Disk<T> popFirstDisk();

}
