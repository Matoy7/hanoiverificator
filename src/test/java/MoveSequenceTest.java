import hanoi_moves_verificator.executors.MovesVerificator;
import hanoi_moves_verificator.executors.input_file_parser.InputFileParser;
import hanoi_moves_verificator.integer_tower.IntegerTower;
import hanoi_moves_verificator.tower.Move;
import hanoi_moves_verificator.tower.Tower;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import static utils.Constants.*;
import static utils.DirPathUtils.concatenateValidInputsPath;

/**
 * Created by elirazyo on 2/11/2017.
 *
 * This test was desgined in order to test the move sequence.
 *
 * we are checking valid input alone. we check these cases: 1. correct moves seq (that prints "Yes")
 * incorrect move seq, and a move seq which cannot be placed (a heavy weight on top of a smaller weight)
 *
 */

public class MoveSequenceTest {

    private static MovesVerificator getMovesVerificatorFromFile(String inputFilePath){

        InputFileParser parser = new InputFileParser();
        parser.parse(inputFilePath);

        int disksNumber= parser.getDisksNumber();
        List<Move> moves = parser.getMoves();
        Tower towerToBeVerified = new IntegerTower(disksNumber);

        return new MovesVerificator(towerToBeVerified, moves);
    }

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println(" ====  Move sequence test suite ===== ");
    }

    @Test
    public void test_no_weight_number_input() {
        String inputFilePath = concatenateValidInputsPath(ILLEGAL_WEIGHT_MOVE_SEQUENCE);
        MovesVerificator movesVerificator = getMovesVerificatorFromFile(inputFilePath);
        boolean result = movesVerificator.verifySequences();

        Assert.assertEquals(result, false);
    }

    @Test
    public void test_correct_sequence() {
        String inputFilePath = concatenateValidInputsPath(CORRECT_SEQUENCE_TXT);
        MovesVerificator movesVerificator = getMovesVerificatorFromFile(inputFilePath);
        boolean result = movesVerificator.verifySequences();

        Assert.assertEquals(result, true);
    }

    @Test
    public void test_incorrect_sequence() {
        String inputFilePath = concatenateValidInputsPath(INCORRECT_SEQUENCE_TXT);
        MovesVerificator movesVerificator = getMovesVerificatorFromFile(inputFilePath);
        boolean result = movesVerificator.verifySequences();

        Assert.assertEquals(result, false);
    }

}
