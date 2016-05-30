package frame;

import org.omg.CORBA.portable.ApplicationException;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO 自动生成的方法存根
		StackPane stackPane = new StackPane();
		FlowPane flowPane = new FlowPane();
		
		stackPane.getChildren().addAll(flowPane);
		
		Image image = new Image("/image/login-bg/0.jpg");
		ImageView imageView = new ImageView(image);
		
		flowPane.getChildren().add(imageView);
		
		
		Scene scene = new Scene(stackPane, 600, 500);
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		//MainFrame mf=new MainFrame();
		//mf.setVisible(true);
		Application.launch(args);
	}
}
