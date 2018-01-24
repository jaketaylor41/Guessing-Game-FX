package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.util.Random;

public class Controller {


    Random rNumber = new Random();
    int maxNumber = 10;
    int jakesRandom = rNumber.nextInt(maxNumber);
    int counter = 0;
    int numberOfTimesGuessed = 0;
    int low = 1;
    int high = 10;


    @FXML
    private Text greetingText;

    @FXML
    private TextField userGuess;

    @FXML
    private Button enterButton;

    @FXML
    private Text numberOfGuesses;

    @FXML
    private Button restartButton;

    userGuess.setOnKeyPressed(new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            if(event.getCode().equals(KeyCode.ENTER)) {
                // do something
            }
        }
    });


    public void clickedEnterButton(ActionEvent actionEvent){
            numberOfTimesGuessed++;
            String userEntry = userGuess.getText();
            int userIntEntry = Integer.parseInt(userEntry);

            greetingText.setText("Please guess a number between  " + low + " and " + high);
            userGuess.clear();

            if (userIntEntry > jakesRandom) {
                high = userIntEntry;
                greetingText.setText("TOO HIGH. Enter a number between " + low + " and " + high);
                numberOfGuesses.setText("Guess: " + numberOfTimesGuessed);

            }

            if (userIntEntry < jakesRandom) {
                low = userIntEntry;
                greetingText.setText("TOO LOW. Enter a number between " + low + " and " + high);
                numberOfGuesses.setText("Guess: " + numberOfTimesGuessed);
            }

            if (userIntEntry == jakesRandom) {
                greetingText.setText("MATCH!");
                numberOfGuesses.setText("Total Amount of Guesses: " + numberOfTimesGuessed);

            }
        }


    public void clickedRestartButton(ActionEvent actionEvent){
        jakesRandom = rNumber.nextInt(10);
        numberOfTimesGuessed = 0;
        greetingText.setText("Please guess a number between  " + 1 + " and " + 10);

    }

    }








