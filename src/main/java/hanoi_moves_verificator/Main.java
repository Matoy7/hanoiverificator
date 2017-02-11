package hanoi_moves_verificator;

import hanoi_moves_verificator.executors.MovesVerificator;
import hanoi_moves_verificator.executors.input_file_parser.InputFileParser;
import hanoi_moves_verificator.integer_tower.IntegerTower;
import hanoi_moves_verificator.tower.Move;
import hanoi_moves_verificator.tower.Tower;

import java.util.List;


/**
 * Created by elirazyo on 2/10/2017.
 *
 */

public class Main {
    public static void main(String[] args) {
        if (args.length==0){
            System.out.println("Please provide: <Input file path>");
            return;
        }
        String inputFilePath=args[0];

        InputFileParser parser = new InputFileParser();
        parser.parse(inputFilePath);

        if (!parser.validate()){
            System.out.println("No");
            return;
        }

        int disksNumber= parser.getDisksNumber();
        List<Move> moves = parser.getMoves();

        Tower towerToBeVerified = new IntegerTower(disksNumber);

        MovesVerificator movesVerificator = new MovesVerificator(towerToBeVerified, moves);
        movesVerificator.verifySequences();
    }



}

