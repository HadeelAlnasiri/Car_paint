/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itzha
 */
package car_paint;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Car_Paint extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        final Circle c1 = new Circle(20);
        c1.setCenterX(50);
        c1.setCenterY(260);
        c1.setStroke(Color.WHITE);
        c1.setStrokeWidth(3);
     

        final Circle c2 = new Circle(20);
        c2.setCenterX(150);
        c2.setCenterY(260);
        c2.setStroke(Color.WHITE);
        c2.setStrokeWidth(3);

      
        final Rectangle body = new Rectangle(20,200, 160,50 );

        final Rectangle roof = new Rectangle(50,160, 90,40 );
        
        final Rectangle headlight = new Rectangle(170,200, 10,10 );
        headlight.setFill(Color.RED);
        
        final Pane pane = new Pane();
        //pane.setStyle("-fx-stroke-width:3;");
        pane.getChildren().addAll(c1,c2,body,roof,headlight);
        

        Label l1 = new Label("Select the car part: ");
        final ComboBox CarPart = new ComboBox();
        CarPart.getItems().addAll("Roof", "Body", "Wheel");
        CarPart.setValue("Roof");
        HBox forCombo = new HBox(20);
        forCombo.getChildren().addAll(l1, CarPart);
        forCombo.setAlignment(Pos.CENTER);

        Label l2 = new Label("Fill Color: ");
        final RadioButton r1 = new RadioButton("Red");
        final RadioButton r2 = new RadioButton("Green");
        final RadioButton r3 = new RadioButton("Yellow");
        HBox forRadio = new HBox(20);
        forRadio.getChildren().addAll(l2, r1, r2, r3);
        forRadio.setAlignment(Pos.CENTER);

        ToggleGroup radio = new ToggleGroup();
        r1.setToggleGroup(radio);
        r2.setToggleGroup(radio);
        r3.setToggleGroup(radio);


        final CheckBox chStrok = new CheckBox("Switch the car? ");
        chStrok.setSelected(true);
        HBox chStrokH = new HBox();
        chStrokH.getChildren().addAll(chStrok);
        chStrokH.setPadding(new Insets(0,0,0,150));


        Label l3 = new Label("Move Car: ");

        final Button btRight = new Button(">> ");
        final Button btLeft = new Button("<< ");
        
        HBox moveCar = new HBox(20);
        moveCar.setPadding(new Insets(0,0,0,100));
        moveCar.getChildren().addAll(l3,btLeft,btRight);
        
       
        
        
    
         r1.setOnAction(new EventHandler<ActionEvent>() {
              
    @Override
    public void handle(ActionEvent e) {

                   if(r1.isSelected() && CarPart.getValue().toString()=="Roof") 
                      roof.setFill(Color.RED);
                   
                   else if(r1.isSelected() && CarPart.getValue().toString()=="Body")
                       body.setFill(Color.RED);
                   
                   else if(r1.isSelected() && CarPart.getValue().toString()=="Wheel"){
                       c1.setFill(Color.RED);
                       c2.setFill(Color.RED);
                   }
             
           }
            });
         
         r2.setOnAction(new EventHandler<ActionEvent>() {
              
    @Override
    public void handle(ActionEvent e) {

                   if(r2.isSelected() && CarPart.getValue().toString()=="Roof") 
                      roof.setFill(Color.GREEN);
                   
                   else if(r2.isSelected() && CarPart.getValue().toString()=="Body")
                       body.setFill(Color.GREEN);
                   
                   else if(r2.isSelected() && CarPart.getValue().toString()=="Wheel"){
                       c1.setFill(Color.GREEN);
                       c2.setFill(Color.GREEN);
                   }
             
           }
            });
         
         r3.setOnAction(new EventHandler<ActionEvent>() {
              
    @Override
    public void handle(ActionEvent e) {

                   if(r3.isSelected() && CarPart.getValue().toString()=="Roof") 
                      roof.setFill(Color.YELLOW);
                   
                   else if(r3.isSelected() && CarPart.getValue().toString()=="Body")
                       body.setFill(Color.YELLOW);
                   
                   else if(r3.isSelected() && CarPart.getValue().toString()=="Wheel"){
                       c1.setFill(Color.YELLOW);
                       c2.setFill(Color.YELLOW);
                   }
             
           }
            });
        
          
         chStrok.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {

                   if(!chStrok.isSelected()){
                       headlight.setFill(Color.BLACK);
                   }
                   else if(chStrok.isSelected()){
                       headlight.setFill(Color.RED);
                   }
                   
             
           }
            });
         
         btRight.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
                   if (chStrok.isSelected()){
              c1.setCenterX(c1.getCenterX()+10);
              c2.setCenterX(c2.getCenterX()+10);
             body.setX(body.getX() +10);
             roof.setX(roof.getX() +10);
             headlight.setX(headlight.getX() +10);
                   }
           }
            });
         
         btLeft.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        
           if(chStrok.isSelected()){
              c1.setCenterX(c1.getCenterX()-10);
              c2.setCenterX(c2.getCenterX()-10);
             body.setX(body.getX() -10);
             roof.setX(roof.getX() -10);
             headlight.setX(headlight.getX() -10);
           }
        
           }
            });
        
         pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
             public void handle(MouseEvent e){
                 
                     pane.setStyle("-fx-border-color:black;-fx-border-width:2;");
                 
             }
         });
      
     
        VBox root = new VBox(20);
        root.getChildren().addAll(pane,forCombo,forRadio,chStrokH,moveCar);
        Scene scene = new Scene(root,500, 500);
        
       
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
             public void handle(KeyEvent e){
                 if(e.getCode() == KeyCode.ENTER){
                      c1.setFill(Color.BLACK);
                      c2.setFill(Color.BLACK);
                      roof.setFill(Color.BLACK);
                      body.setFill(Color.BLACK);
                      headlight.setFill(Color.BLACK);
                    }
                    
                }
                 

         });
        c1.requestFocus();
        c2.requestFocus();
        roof.requestFocus();
        body.requestFocus();
        headlight.requestFocus();

        stage.setTitle("Lab4");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
