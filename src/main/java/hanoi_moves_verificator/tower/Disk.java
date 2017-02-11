package hanoi_moves_verificator.tower;

/**
 * Created by elirazyo on 2/9/2017.
 */
public class Disk <T extends Comparable> {
    private T weight;

    public T getWeight() {
        return weight;
    }

    public Disk(T weight) {
        this.weight = weight;
    }
}
