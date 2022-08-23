import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SceneController {
    
    private Stage stage;
    private int secretNumber = (int)(int)(Math.random()*99) + 1;
    public void switchToStart(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    public void switchToMain(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    @FXML
    private Button Restart;

    @FXML
    private Label prompt;

    @FXML
    private Label hint;

    @FXML
    private Label lbguessleft;

    @FXML
    private Button sub;
    
    @FXML
    private ImageView Win;
    
    @FXML
    private ImageView Lose;
    

    @FXML
    private TextField tfnum;

    @FXML
    void Submit(ActionEvent event) {
        String str = lbguessleft.getText();
        int left = Integer.parseInt(str.substring(str.length()-1)) - 1;
        int num = Integer.parseInt(tfnum.getText());
        tfnum.clear();
        if(left==0){
            tfnum.setVisible(false);
            sub.setVisible(false);
            prompt.setVisible(false);
            hint.setText("You Lose!!! the number was "+ secretNumber +".");
            lbguessleft.setText("Your Score is 0.");
            Restart.setVisible(true);
            Lose.setVisible(true);
        }
        else if(num > secretNumber){
            hint.setText("Guess a lower number than "+num);
            lbguessleft.setText(str.substring(0,str.length()-1)+String.valueOf(left));
        }     
        else if(num == secretNumber){
            tfnum.setVisible(false);
            sub.setVisible(false);
            prompt.setVisible(false);
            hint.setText("You Win!!!");
            lbguessleft.setText("Your Score is : "+ String.valueOf(left+3));
            Restart.setVisible(true);
            Win.setVisible(true);
        }
        else{
            hint.setText("Guess a higher number than "+num);
            lbguessleft.setText(str.substring(0,str.length()-1)+String.valueOf(left));
        }
        // System.out.println(secretNumber);
    }
}
