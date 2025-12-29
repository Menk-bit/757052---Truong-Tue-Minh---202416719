package hust.soict.dsai.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private RadioButton penSelectionButton;
    
    @FXML
    private RadioButton eraserSelectionButton;
    
    private int tool = 0;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle;
    	
    	if (tool == 1) {
	    	newCircle = new Circle(event.getX(), 
	    			event.getY(), 4, Color.BLACK);
	    	
    	} else {newCircle = new Circle(event.getX(), 
    			event.getY(), 4, Color.WHITE);}
    	
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void penSelected(ActionEvent event) {
    	tool = 1;
    }
    
    @FXML
    void eraserSelected(ActionEvent event) {
    	tool = 2;
    }
}
