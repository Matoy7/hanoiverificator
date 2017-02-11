package utils;

import java.io.File;
import static utils.Constants.*;

/**
 * Created by elirazyo on 2/11/2017.
 */
public class DirPathUtils {
    public static String concatenateValidInputsPath(String fileName) {
        return  new File(SRC_TEST_RESOURCES).getAbsolutePath()+ "/" + VALID_INPUTS_DIR + "/" +fileName;
    }

    public static String concatenateInvalidInputsPath(String fileName) {
        return  new File(SRC_TEST_RESOURCES).getAbsolutePath()+ "/" + INVALID_INPUTS_DIR + "/" +fileName;
    }
}
