package hanoi_moves_verificator.tower;

/**
 * Created by elirazyo on 2/9/2017.
 */
public class Move {

    private int sourceRod;
    private int destinationRod;

    public Move(int sourceRod, int destinationRod) {
        this.sourceRod = sourceRod;
        this.destinationRod = destinationRod;
    }

    public int getSourceRod() {
        return sourceRod;
    }

    public int getDestinationRod() {
        return destinationRod;
    }

    @Override
    public String toString(){
        return "("+sourceRod+" , "+destinationRod+")";

    }
}
