import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class GUI extends Application{
    private final TextEditor file = new TextEditor();

    @Override
    public void start(Stage window) throws Exception {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(40);

        grid.setVgap(30);
        Scene scene = new Scene(grid, 1000, 500);
        window.setScene(scene);

        Text windowTitle = new Text("Welcome");
        windowTitle.setFont(Font.font("Tacoma", FontWeight.NORMAL, 30));
        grid.add(windowTitle, 2, 0, 1, 1);

        Button button1 = new Button("Swap two rows");
        grid.add(button1, 0, 1);

        Button button2 = new Button("Swap two words");
        grid.add(button2 , 5, 1);

        Label indexOfFirstRow = new Label("Index of first row:");
        grid.add(indexOfFirstRow,0,2);

        TextField indexOfFirstRowText = new TextField();
        grid.add(indexOfFirstRowText , 1 , 2);

        Label indexOfSecondRow = new Label("Index of second row:");
        grid.add(indexOfSecondRow,0,3);

        TextField indexOfSecondRowText = new TextField();
        grid.add(indexOfSecondRowText , 1 , 3);

        Label indexOfFirstRowWord = new Label("Index of first row:");
        grid.add(indexOfFirstRowWord,5,2);

        TextField indexOfFirstRowTextWord = new TextField();
        grid.add(indexOfFirstRowTextWord , 6 , 2);

        Label indexOfWord = new Label("Index of the first word:");
        grid.add(indexOfWord,5,3);

        TextField indexOfFirstWordText = new TextField();
        grid.add(indexOfFirstWordText , 6 , 3);

        Label indexOfSecondRowWord = new Label("Index of second row:");
        grid.add(indexOfSecondRowWord,5,4);

        TextField indexOfSecondRowTextWord = new TextField();
        grid.add(indexOfSecondRowTextWord , 6 , 4);

        Label indexOfSecondWord = new Label("Index of the second word:");
        grid.add(indexOfSecondWord,5,5);

        TextField indexOfSecondWordText = new TextField();
        grid.add(indexOfSecondWordText , 6 , 5);

        button1.setOnAction(action-> {
            try {
                Reader reader = new BufferedReader(new FileReader("filename.txt"));
                int firstRow = Integer.parseInt(indexOfFirstRowText.getText());
                int secondRow = Integer.parseInt(indexOfSecondRowText.getText());
                file.swapTwoRows(firstRow , secondRow ,reader );
            } catch (IOException e) {
                throw new NumberFormatException("Use only numbers");
            }
        });
        button2.setOnAction(action-> {
            try {
                Reader reader = new BufferedReader(new FileReader("filename.txt"));
                int firstRow = Integer.parseInt(indexOfFirstRowTextWord.getText());
                int indexFirstWord = Integer.parseInt(indexOfFirstWordText.getText());
                int secondRow = Integer.parseInt(indexOfSecondRowTextWord.getText());
                int indexSecondWord = Integer.parseInt(indexOfSecondWordText.getText());
                file.swapTwoWords(firstRow , indexFirstWord , secondRow , indexSecondWord , reader);
            } catch (NumberFormatException | IOException e) {
                throw new NumberFormatException("Use only numbers");
            }
        });
        window.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
