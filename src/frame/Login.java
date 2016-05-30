package frame;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.control.*;
import javafx.geometry.Insets;

public class Login extends Application{
	
	private TextField userName;
	private PasswordField passWordField;
	private Button loginButton, quitButton;

	@Override
	public void start(Stage stage) throws Exception {
		// TODO 自动生成的方法存根
		StackPane stackPane = new StackPane();
		FlowPane flowPane = new FlowPane();
		FlowPane flowPane2 = new FlowPane();
		
		Scene scene = new Scene(stackPane, 1000, 500);
		
		Image image = new Image("images/login-bg/0e.jpg");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(500);
		imageView.setFitWidth(1000);
		
		flowPane2.setStyle("-fx-background-color: #ffffffaa;");
		flowPane2.setTranslateX(200);
		flowPane2.setTranslateY(-200);
		flowPane2.setMaxSize(600, 60);
		Label titleLabel = new Label("信息学院学生党支部人事管理系统");
		titleLabel.setFont(javafx.scene.text.Font.font("黑体",
				FontWeight.BOLD,FontPosture.ITALIC,30));
		titleLabel.setTranslateX(20);
		titleLabel.setTranslateY(10);
		flowPane2.getChildren().add(titleLabel);
		
		flowPane.getChildren().add(imageView);
		
		GridPane loginGridPane = new GridPane();
		loginGridPane.setAlignment(Pos.CENTER);
		loginGridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		loginGridPane.setHgap(5.5);
		loginGridPane.setVgap(5.5);
		loginGridPane.add(new Label("用户名："), 0, 0);
		loginGridPane.add(userName = new TextField(), 1, 0);
		userName.setStyle("-fx-background-color: #ffffffdd;-fx-border:1px");
		loginGridPane.add(new Label("密   码："), 0, 1);
		loginGridPane.add(passWordField = new PasswordField(), 1, 1);
		passWordField.setStyle("-fx-background-color: #ffffffdd;-fx-border:1px");
		loginGridPane.add(quitButton = new Button(), 0, 2);
		loginGridPane.add(loginButton = new Button(), 1, 2);
		loginButton.setText("登陆");
		loginButton.setStyle("-fx-background-color: #ffffffaa;-fx-text-fill:#000000");
		quitButton.setText("退出");
		quitButton.setStyle("-fx-background-color: #ffffffaa;-fx-text-fill:#aa0000");
		quitButton.setOnAction(e->{
			stage.close();
		});
		loginButton.setOnAction(e->login(stage));
		
		
		loginGridPane.setStyle("-fx-background-color: #ffffffaa;");
		loginGridPane.setTranslateX(350);
		loginGridPane.setTranslateY(-110);
		loginGridPane.setMaxSize(300, 100);
		stackPane.getChildren().addAll(flowPane,flowPane2,loginGridPane);
		stage.setScene(scene);
		stage.setAlwaysOnTop(true);
		stage.setTitle("信息学院学生党支部成员管理系统");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();
	}
	
	private void login(Stage stage){
		if(userName.getText().compareTo("admin")==0 && passWordField.getText().compareTo("123456")==0){
			MainFrame mf=new MainFrame();
			mf.setVisible(true);
			stage.close();
		}else{
			userName.setText("用户名或密码错误");
		}
	}
	
	public Login(){
		//MainFrame mf=new MainFrame();
		//mf.setVisible(true);
	}
	
	public static void main(String [] args){
		Application.launch(args);
		//MainFrame mf=new MainFrame();
		//mf.setVisible(true);
	}
}
