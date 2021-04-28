package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;


public class Savings {
    public static void saving(){

        Stage stage1 = new Stage();
        stage1.setTitle("SAVINGS");

        Button btn1 = new Button("Back");
        btn1.setLayoutX(570);
        btn1.setLayoutY(10);
        btn1.setPrefSize(60,25);
        btn1.setStyle("-fx-background-color:   #E98973; -fx-text-fill: white; ");
        btn1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));


        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btn1.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();

            }
        });

        Label lbPeriod = new Label("N(Period)        :");
        lbPeriod.setLayoutX(120);
        lbPeriod.setLayoutY(50);
        lbPeriod.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        Label lbSp = new Label("Start Principal :");
        lbSp.setLayoutX(120);
        lbSp.setLayoutY(125);
        lbSp.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        Label lbInter = new Label("1/Y (interest)  :");
        lbInter.setLayoutX(120);
        lbInter.setLayoutY(200);
        lbInter.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        Label lbPay = new Label("Payment          :");
        lbPay.setLayoutX(120);
        lbPay.setLayoutY(275);
        lbPay.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        Label lbFv = new Label("Future value    :");
        lbFv.setLayoutX(120);
        lbFv.setLayoutY(350);
        lbFv.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));


        final TextField[] option = new TextField[1];

        TextField tfPeriod = new TextField();
        tfPeriod.setLayoutX(270);
        tfPeriod.setLayoutY(50);
        tfPeriod.setOnMouseClicked(event -> {
            option[0] = tfPeriod;
        });

        TextField tfSp = new TextField();
        tfSp.setLayoutX(270);
        tfSp.setLayoutY(125);
        tfSp.setOnMouseClicked(event -> {
            option[0] = tfSp;
        });

        TextField tfInter = new TextField();
        tfInter.setLayoutX(270);
        tfInter.setLayoutY(200);
        tfInter.setOnMouseClicked(event -> {
            option[0] = tfInter;
        });

        TextField tfPay = new TextField();
        tfPay.setLayoutX(270);
        tfPay.setLayoutY(275);
        tfPay.setOnMouseClicked(event -> {
            option[0] = tfPay;
        });

        TextField tfFv = new TextField();
        tfFv.setLayoutX(270);
        tfFv.setLayoutY(350);
        tfFv.setOnMouseClicked(event -> {
            option[0] = tfFv;
        });


        //Enter Button
        Button ent = new Button("Calculate");
        ent.setLayoutX(500);
        ent.setLayoutY(280);
        ent.setPrefSize(100,25);
        ent.setStyle("-fx-background-color:  #362F61; -fx-text-fill: white; -fx-background-radius:50px;");
        ent.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        ent.setOnAction(new EventHandler<ActionEvent>() {      //Calculate button and method

            @Override
            public void handle(ActionEvent event) {
                String set1 = tfPeriod.getText();
                String set2 = tfSp.getText();
                String set3 = tfInter.getText();
                String set4 = tfPay.getText();
                String set5 = tfFv.getText();



                try {
                    if(set5.isEmpty()){
                        double PMT = Double.parseDouble(set4);
                        double R = Double.parseDouble(set3);
                        double P = Double.parseDouble(set2);
                        double T = Double.parseDouble(set1);

                        double e1 = 1+(R/(12*100));
                        double e2 = 12*T;
                        double e3 = Math.pow(e1,e2);
                        double e4 = P*e3;

                        double e5 = e3-1;
                        double e6 = R/(12*100);
                        double e7 = e5/e6;
                        double e8 = PMT*(e7);
                        double A  = e4+e8;

                        tfFv.setText(String.valueOf(String.format("%.2f",A)));

                        File file = new File("DataExport");
                        PrintWriter printWriter;
                        FileWriter fileWriter;

                        try{
                            fileWriter=new FileWriter(file,true);
                            printWriter=new PrintWriter(fileWriter,true);
                            printWriter.println("**=**=**=**=**=**=**=**=**");
                            printWriter.println("N(Period)        :"+T);
                            printWriter.println("Start Principal  :"+P);
                            printWriter.println("1/Y (interest)   :"+R);
                            printWriter.println("Monthly Payment  :"+PMT);
                            printWriter.println("Future value     :"+A);
                            printWriter.println("**=**=**=**=**=**=**=**=**");
                        }catch (IOException e){
                            Alert test = new Alert(Alert.AlertType.ERROR);
                            test.setContentText("This formula is not available");
                            Optional<ButtonType> result = test.showAndWait();
                        }

                    }else if (set4.isEmpty()){
                        double P = Double.parseDouble(set1);
                        double T = Double.parseDouble(set2);
                        double R = Double.parseDouble(set3);
                        double A = Double.parseDouble(set5);

                        double e1 = 1+(R/(12*100));
                        double e2 = 12*T;
                        double e3 = Math.pow(e1,e2);

                        double e5 = e3-1;
                        double e6 = R/(12*100);
                        double e7 = e5/e6;

                        double PMT = A/e7;

                        tfPay.setText(String.valueOf(String.format("%.2f",PMT)));

                        File file = new File("DataExport");
                        PrintWriter printWriter;
                        FileWriter fileWriter;

                        try{
                            fileWriter=new FileWriter(file,true);
                            printWriter=new PrintWriter(fileWriter,true);
                            printWriter.println("**=**=**=**=**=**=**=**=**");
                            printWriter.println("N(Period)        :"+T);
                            printWriter.println("Start Principal  :"+P);
                            printWriter.println("1/Y (interest)   :"+R);
                            printWriter.println("Monthly Payment  :"+PMT);
                            printWriter.println("Future value     :"+A);
                            printWriter.println("**=**=**=**=**=**=**=**=**");
                        }catch (IOException e){
                            Alert test = new Alert(Alert.AlertType.ERROR);
                            test.setContentText("This formula is not available");
                            Optional<ButtonType> result = test.showAndWait();
                        }

                    }else if (set3.isEmpty()){

                        double P = Double.parseDouble(set1);
                        double T = Double.parseDouble(set2);
                        double A = Double.parseDouble(set5);

                        double e2 = 12*T;
                        double e3 = A/P;
                        double e4 = (1/e2);
                        double e5 = Math.pow(e3,e4);
                        double e6 = e5 *100;

                        tfInter.setText(String.valueOf(String.format("%.2f",e6)));

                    }else if (set2.isEmpty()){

                        Alert test = new Alert(Alert.AlertType.ERROR);
                        test.setContentText("This formula is not available");
                        Optional<ButtonType> result = test.showAndWait();

                    }else if (set1.isEmpty()){

                        Alert test = new Alert(Alert.AlertType.ERROR);
                        test.setContentText("This formula is not available");
                        Optional<ButtonType> result = test.showAndWait();
                    }
                }catch (Exception e){

                    Alert test = new Alert(Alert.AlertType.ERROR);
                    test.setContentText("Invalid Input or incomplete target");
                    Optional<ButtonType> result = test.showAndWait();
                }



            }
        });

        Button clearButton = new Button("Clear");
        clearButton.setLayoutX(500);
        clearButton.setLayoutY(205);
        clearButton.setPrefSize(100, 25);
        clearButton.setStyle("-fx-background-color:  #362F61; -fx-text-fill: white; -fx-background-radius:50px;");
        clearButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        clearButton.setOnAction(event -> {
            tfPay.clear();
            tfPeriod.clear();
            tfSp.clear();
            tfInter.clear();
            tfFv.clear();
        });


        Button history = new Button("History");
        history.setLayoutX(500);
        history.setLayoutY(130);
        history.setPrefSize(100,25);
        history.setStyle("-fx-background-color:   #362F61; -fx-text-fill: white; -fx-background-radius:20px;");
        history.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));


        history.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stageHis = new Stage();

                TextArea hist = new TextArea();
                hist.setLayoutX(0);
                hist.setLayoutY(0);
                hist.setPrefSize(250, 120);
                hist.clear();
                try {
                    File myFile = new File("DataExport");
                    Scanner myReader = new Scanner(myFile);

                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        //System.out.println(data);
                        hist.appendText(data+ " ");

                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Error");
                }
                Pane root = new Pane();
                root.getChildren().add(hist);
                stageHis.setScene(new Scene(root, 250, 120));
                stageHis.show();
            }

        });

        Button help = new Button("Help");
        help.setLayoutX(500);
        help.setLayoutY(10);
        help.setPrefSize(60,25);
        help.setStyle("-fx-background-color:   #E98973; -fx-text-fill: white;");
        help.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stageHis = new Stage();

                TextArea hist = new TextArea();
                hist.setLayoutX(0);
                hist.setLayoutY(0);
                hist.setPrefSize(250, 120);

                hist.clear();

                hist.setText("FINANCE CALCULATE\nversion 2.03" +
                        "\nSimply click your calculations and " +
                        "\nthe calculator will handle the rest!");

                Pane root = new Pane();
                root.getChildren().add(hist);
                stageHis.setScene(new Scene(root, 250, 120));
                stageHis.show();
            }
        });


        //number pad===========================================================

        Button zero = new Button("0");
        zero.setLayoutX(260);
        zero.setLayoutY(525);
        zero.setPrefSize(65, 30);
        zero.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        zero.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));


        zero.setOnAction(event -> {
            option[0].appendText("0");
        });

        Button dot = new Button(".");
        dot.setLayoutX(350);
        dot.setLayoutY(525);
        dot.setPrefSize(30, 30);
        dot.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        dot.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        dot.setOnAction(event -> {
            option[0].appendText(".");
        });

        Button one = new Button("1");
        one.setLayoutX(260);
        one.setLayoutY(480);
        one.setPrefSize(30, 30);
        one.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        one.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        one.setOnAction(event -> {
            option[0].appendText("1");
        });

        Button two = new Button("2");
        two.setLayoutX(305);
        two.setLayoutY(480);
        two.setPrefSize(30, 30);
        two.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        two.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        two.setOnAction(event -> {
            option[0].appendText("2");
        });

        Button three = new Button("3");
        three.setLayoutX(350);
        three.setLayoutY(480);
        three.setPrefSize(30, 30);
        three.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        three.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        three.setOnAction(event -> {
            option[0].appendText("3");
        });

        Button four = new Button("4");
        four.setLayoutX(260);
        four.setLayoutY(435);
        four.setPrefSize(30, 30);
        four.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        four.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        four.setOnAction(event -> {
            option[0].appendText("4");
        });

        Button five = new Button("5");
        five.setLayoutX(305);
        five.setLayoutY(435);
        five.setPrefSize(30, 30);
        five.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        five.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        five.setOnAction(event -> {
            option[0].appendText("5");
        });

        Button six = new Button("6");
        six.setLayoutX(350);
        six.setLayoutY(435);
        six.setPrefSize(30, 30);
        six.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        six.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        six.setOnAction(event -> {
            option[0].appendText("6");
        });

        Button seven = new Button("7");
        seven.setLayoutX(260);
        seven.setLayoutY(395);
        seven.setPrefSize(30, 30);
        seven.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        seven.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        seven.setOnAction(event -> {
            option[0].appendText("7");
        });

        Button eight = new Button("8");
        eight.setLayoutX(305);
        eight.setLayoutY(395);
        eight.setPrefSize(30, 30);
        eight.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        eight.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        eight.setOnAction(event -> {
            option[0].appendText("8");
        });

        Button nine = new Button("9");
        nine.setLayoutX(350);
        nine.setLayoutY(395);
        nine.setPrefSize(30, 30);
        nine.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        nine.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        nine.setOnAction(event -> {
            option[0].appendText("9");
        });


        Button back = new Button("C\n\nL\n\nE\n\nA\n\nR");
        back.setLayoutX(395);
        back.setLayoutY(395);
        back.setPrefSize(40, 160);
        back.setStyle("-fx-background-color:   #1E2F3E; -fx-text-fill: white; -fx-background-radius:20px;");
        back.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

        back.setOnAction(event -> {
            option[0].clear();
        });






        Pane root = new Pane();
        root.getChildren().add(btn1);
        root.getChildren().add(tfPeriod);
        root.getChildren().add(tfSp);
        root.getChildren().add(tfInter);
        root.getChildren().add(tfPay);
        root.getChildren().add(tfFv);
        root.getChildren().add(lbPeriod);
        root.getChildren().add(lbSp);
        root.getChildren().add(lbInter);
        root.getChildren().add(lbPay);
        root.getChildren().add(lbFv);
        root.getChildren().add(ent);
        root.getChildren().add(history);
        root.getChildren().add(help);
        root.getChildren().add(clearButton);

        root.getChildren().add(zero);
        root.getChildren().add(dot);
        root.getChildren().add(one);
        root.getChildren().add(two);
        root.getChildren().add(three);
        root.getChildren().add(four);
        root.getChildren().add(five);
        root.getChildren().add(six);
        root.getChildren().add(seven);
        root.getChildren().add(eight);
        root.getChildren().add(nine);
        root.getChildren().add(back);

        root.setStyle("-fx-background-color: #c9ba65;");




        stage1.setScene(new Scene(root, 650, 600));
        stage1.show();

    }
}
