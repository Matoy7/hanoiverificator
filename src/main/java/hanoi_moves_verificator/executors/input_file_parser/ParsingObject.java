package hanoi_moves_verificator.executors.input_file_parser;

import hanoi_moves_verificator.tower.Move;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elirazyo on 2/11/2017.
 *
 * This object saved data taken from the input file.
 * more specifically: the number of disk in the tower, and a list of all the moves needed
 */

public class ParsingObject {

    private int disksNumber;
    private List moves;

    public ParsingObject() {
        this.disksNumber = 0;
        this.moves = new ArrayList<Move>();
    }

    public void setDisksNumber(int disksNumber) {
        this.disksNumber = disksNumber;
    }

    public void addMove(Move move) {
        this.moves.add(move);
    }

    public int getDisksNumber() {

        return disksNumber;
    }

    public List getMoves() {
        return moves;
    }

    public boolean validate(){
        return ((disksNumber >0) && (!moves.isEmpty()));
    }


}
