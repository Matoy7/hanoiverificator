package hanoi_moves_verificator.executors.input_file_parser;

import hanoi_moves_verificator.tower.Move;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static hanoi_moves_verificator.utils.MoveUtils.createMoveFromString;
import static hanoi_moves_verificator.utils.MoveUtils.isValidMove;
import static hanoi_moves_verificator.utils.MoveUtils.isValidWeightNumber;

/**
 * Created by elirazyo on 2/11/2017.
 *
 * Information: represents a Parser object which parse the input file and extracts
 * the data related to the move and to the tower
 *
 * The data is saved in a parsing object designed for that purpose.
 */

public class InputFileParser {
    private ParsingObject parsingObject;

    public InputFileParser() {
        this.parsingObject = new ParsingObject();
    }

    public boolean validate(){
        if (parsingObject==null) return false;
        return parsingObject.validate();
    }

    public int getDisksNumber() {
        return parsingObject.getDisksNumber();
    }

    public List getMoves() {
        return parsingObject.getMoves();
    }

    public void parse(String filePath){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            currentLine = br.readLine();
            if (currentLine==null){
                // the file is empty /;
                return;
            }

            if (!isValidWeightNumber(currentLine)){
                parsingObject=null;
                return;
            }

            parsingObject.setDisksNumber(Integer.parseInt(currentLine));

            while ((currentLine = br.readLine()) != null) {
                if (!isValidMove(currentLine)){
                    parsingObject=null;
                    return;
                }
                Move move = createMoveFromString(currentLine);
                if (move==null){
                    parsingObject=null;
                    return;
                }
                parsingObject.addMove(move);
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }



}
