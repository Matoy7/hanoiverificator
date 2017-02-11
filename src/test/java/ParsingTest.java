import hanoi_moves_verificator.executors.input_file_parser.*;
import org.junit.*;

import static utils.Constants.*;
import static utils.DirPathUtils.*;

/**
 * Created by elirazyo on 2/11/2017.
 *
 * we are checking the parsing functinality here. we check
 * invalid files (empty file, wrong charchters...) and also valid files
 */
public class ParsingTest {

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println(" ====  Parsing test suite ===== ");
    }

    @Test
    public void test_empty_file() {
        String inputFilePath = concatenateInvalidInputsPath(EMPTY_FILE_TXT);
        InputFileParser parser = new InputFileParser();
        parser.parse(inputFilePath);

        Assert.assertEquals(false,parser.validate());
    }

    @Test
    public void test_illegal_char_in_input() {
        String inputFilePath = concatenateInvalidInputsPath(ILLEGAL_CHAR_INPUT_TXT);
        InputFileParser parser = new InputFileParser();
        parser.parse(inputFilePath);

        Assert.assertEquals(false,parser.validate());
    }

    @Test
    public void test_negative_weight_number_input() {
        String inputFilePath = concatenateInvalidInputsPath(NEGETIVE_WEIGHT_NUMBER_INPUT_TXT);
        InputFileParser parser = new InputFileParser();
        parser.parse(inputFilePath);

        Assert.assertEquals(false,parser.validate());
    }

    @Test
    public void test_no_moves_input() {
        String inputFilePath = concatenateInvalidInputsPath(NO_MOVES_INPUT_TXT);
        InputFileParser parser = new InputFileParser();
        parser.parse(inputFilePath);

        Assert.assertEquals(false,parser.validate());
    }

    @Test
    public void test_no_weight_number_input() {
        String inputFilePath = concatenateInvalidInputsPath(NO_WEIGHT_NUMBER_INPUT_TXT);
        InputFileParser parser = new InputFileParser();
        parser.parse(inputFilePath);

        Assert.assertEquals(false,parser.validate());
    }

    @Test
    public void test_correct_sequence() {
        String inputFilePath = concatenateValidInputsPath(CORRECT_SEQUENCE_TXT);
        InputFileParser parser = new InputFileParser();
        parser.parse(inputFilePath);

        Assert.assertEquals(true,parser.validate());
    }

    @Test
    public void test_incorrect_sequence() {
        String inputFilePath = concatenateValidInputsPath(INCORRECT_SEQUENCE_TXT);
        InputFileParser parser = new InputFileParser();
        parser.parse(inputFilePath);

        Assert.assertEquals(true,parser.validate());
    }

}
