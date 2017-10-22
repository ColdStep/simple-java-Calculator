package sample;

import javafx.event.ActionEvent;
import javafx.event.ActionEvent.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class Controller  {

    @FXML
    TextField textField;
    @FXML
    Label label;

    String historyArray ="";
    String array="";
    String result;
    String firstNumber;
    String secondNumber;

    double r = 0;


    //Scan numbers and add to history memory buffer
    public void initializeNumbers(ActionEvent event) {

        String scanner = ((Button) event.getSource()).getText().toString();
        history(scanner);
        textField.setText(textField.getText()+scanner);



    }


    //Scan operator plus and add to history memory buffer
    public void plus(ActionEvent event){

        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();


        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        array=scanner;
        history(scanner);




    }

    //Scan operator minus and add to history memory buffer

    public void minus(ActionEvent event){
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();
        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        history(scanner);
        array=scanner;


    }
    //Scan operator multiply and add to history memory buffer
    public void multiply(ActionEvent event){
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();
        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        history(scanner);
        array=scanner;

    }
    //Scan operator divide and add to history memory buffer
    public void divide(ActionEvent event) {
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();
        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        history(scanner);
        array=scanner;


    }
    //Equal-finish operates
    public void equal(ActionEvent event){
        String scanner = ((Button) event.getSource()).getText().toString();
        matematika(array);
        history(scanner);
        labelView();
        switch (result){
            case "На нуль ділити не можна !": //this mean - "you can't divide by zero "
                textField.setText(result);
                clearHistory();
                break;
            default:
                String string = result;
                historyArray+=string;
                labelView();
                textField.setText(result);

                break;
        }

    }

    //Clean memory buffer and visual effects
    public void allDelete(ActionEvent event){
        clearHistory();
        labelView();
        textField.setText("");

    }
    //Clean last symbols
    public void buttonDelete(ActionEvent event) {
        String temp = textField.getText();
        char[] charTemp= temp.toCharArray();
        temp="";
        for (int i=0; i<charTemp.length-1; i++){

            temp+=charTemp[i];
        }
        char[] charHistoryArray= historyArray.toCharArray();
        if (charHistoryArray[charHistoryArray.length-1]=='+'||charHistoryArray[charHistoryArray.length-1]=='-'||charHistoryArray[charHistoryArray.length-1]=='/'||charHistoryArray[charHistoryArray.length-1]=='*'){
            array="";
        }
        historyArray="";
        for ( int i=0; i<charHistoryArray.length-1; i++){
            history(String.valueOf(charHistoryArray[i]));
        }
        textField.setText(temp);

    }

    //Memory buffer
    public void history(String count) {
        historyArray += count;
        labelView();
    }

    //Logic of matematik operations
    private void matematika(String operator){
        secondNumber=textField.getText();

        switch (operator) {
            case "+":
                r = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                result = String.valueOf(r);
                break;

            case "-":
                r = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                result = String.valueOf(r);
                break;

            case "*":
                r =Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                result = String.valueOf(r);
                break;

            case "/":
                switch (secondNumber){
                    case "0":
                        result= "На нуль ділити не можна !";
                        break;
                    default:
                        r = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                        result = String.valueOf(r);
                        break;

                }
            default:
                break;
        }
    }

    //Clear memory buffer
    public void clearHistory(){
        historyArray = "";
        firstNumber="";
        secondNumber="";
        result="";

    }

    //Show history on the screen
    public void labelView(){
        label.setText(historyArray);
    }


}
