package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadio;
    @FXML
    private RadioButton eraserRadio;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = penRadio.isSelected() ? Color.BLACK : Color.WHITE;
        Circle newCircle = new Circle(event.getX(), event.getY(), 10, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
