package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class Main extends Application {


    @Override
    public void start(Stage mainStage) throws Exception{

        mainStage.setTitle("Finance Calculator");

        Button fdbtn = new Button("Fixed Deposit");
        fdbtn.setLayoutX(150);
        fdbtn.setLayoutY(200);
        fdbtn.setPrefSize(170, 100);
        fdbtn.setStyle("-fx-background-color: #7d77a3; -fx-text-fill: white;");
        fdbtn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));


        Button savbtn = new Button("Savings");
        savbtn.setLayoutX(150);
        savbtn.setLayoutY(330);
        savbtn.setPrefSize(170, 100);
        savbtn.setStyle("-fx-background-color: #7d77a3; -fx-text-fill: white;");
        savbtn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));


        Button lnbtn = new Button("Loan");
        lnbtn.setLayoutX(350);
        lnbtn.setLayoutY(330);
        lnbtn.setPrefSize(170, 100);
        lnbtn.setStyle("-fx-background-color: #7d77a3; -fx-text-fill: white;");
        lnbtn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));


        Button mtgbtn = new Button("Mortgage");
        mtgbtn.setLayoutX(350);
        mtgbtn.setLayoutY(200);
        mtgbtn.setPrefSize(170, 100);
        mtgbtn.setStyle("-fx-background-color: #7d77a3; -fx-text-fill: white;");
        mtgbtn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        Button exit = new Button("Exit");
        exit.setLayoutX(280);
        exit.setLayoutY(450);
        exit.setPrefSize(100, 40);
        exit.setStyle("-fx-background-color: #693b6e; -fx-text-fill: white; -fx-background-radius:20px;");
        exit.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));



        fdbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                FixedDep.fixed();

            }
        });

        savbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Savings.saving();
            }
        });

        lnbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Loan.loan();
            }
        });

        mtgbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Mortgage.mortG();
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                mainStage.close();

            }
        });


        //Creating an image
        Image image1 = new Image("payment.png");
        Image image2 = new Image("bank.png");
        Image image3 = new Image("money.png");

        //Setting the image view
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);

        //Setting the position of the image
        imageView1.setX(150);
        imageView1.setY(50);

        imageView2.setX(280);
        imageView2.setY(50);

        imageView3.setX(410);
        imageView3.setY(50);

        //setting the fit height and width of the image view
        imageView1.setFitHeight(100);
        imageView1.setFitWidth(255);

        imageView2.setFitHeight(100);
        imageView2.setFitWidth(255);

        imageView3.setFitHeight(100);
        imageView3.setFitWidth(255);

        //Setting the preserve ratio of the image view
        imageView1.setPreserveRatio(true);
        imageView1.setSmooth(true);
        imageView1.setCache(true);

        imageView2.setPreserveRatio(true);
        imageView2.setSmooth(true);
        imageView2.setCache(true);

        imageView3.setPreserveRatio(true);
        imageView3.setSmooth(true);
        imageView3.setCache(true);




        Pane root = new Pane();

        root.getChildren().add(fdbtn);
        root.getChildren().add(savbtn);
        root.getChildren().add(lnbtn);
        root.getChildren().add(mtgbtn);
        root.getChildren().add(exit);
        root.getChildren().add(imageView1);
        root.getChildren().add(imageView2);
        root.getChildren().add(imageView3);


        root.setStyle("-fx-background-color: #2f2f4a;");

        mainStage.setScene(new Scene(root, 650, 510));
        mainStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
