import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class ProjectController {
    private double w, h;
    private GraphicsContext gc;
    private Conway conway;

    @FXML
    public void initialize(){
        conway = new Conway(10,10);
        gc = canvas.getGraphicsContext2D();
        w = canvas.getWidth();
        h = canvas.getHeight();
        drawCanvas();
    }

    @FXML
    private Canvas canvas;

    //This method is activated as the user clicks on the bottom to see the next level of life
    @FXML
    void setMatrix(ActionEvent event) {
        conway.setLifeMatrix(10,10);//update the matrix
        drawCanvas();
    }

    //This method draws the new matrix according to the updated matrix.
    public void drawCanvas(){
        gc.clearRect(0, 0, w, h);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 ; j++) {
                if(conway.getLifeMatrix()[i][j] == 0) {
                    gc.rect(i * w / 10, j * h / 10, w / 10, h / 10);
                }
                else
                {
                    gc.fillRect(i * w / 10, j * h / 10, w / 10, h / 10);
                }
            }
        }
    }

}
