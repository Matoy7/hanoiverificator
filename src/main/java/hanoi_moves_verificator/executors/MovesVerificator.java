package hanoi_moves_verificator.executors;

import hanoi_moves_verificator.tower.Tower;
import hanoi_moves_verificator.tower.Move;

import java.util.List;

/**
 * Created by elirazyo on 2/9/2017.
 */
public class MovesVerificator {

    private Tower tower;
    private List<Move> moves;

    public MovesVerificator(Tower tower, List<Move> moves){
        this.moves= moves;
        this.tower=tower;
    }

    public boolean verifySequences(){
        for (Move move: moves) {
            boolean isMovedSuccessfully = tower.moveDisk(move);
            if (!isMovedSuccessfully){
                System.out.println("No");
                return false;
            }
        }

        if (tower.isComplete()){
            System.out.println("Yes");
            return true;
        }
        else{
            System.out.println("No");
            return false;
        }
    }


}
