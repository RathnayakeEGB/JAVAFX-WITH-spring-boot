package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class App extends Application {

	private static String[] savedArgs;
	private ConfigurableApplicationContext context;

	@Override
	public void init() throws Exception {
		this.context=SpringApplication.run(App.class, savedArgs);
	}

	@Override
	public void stop() throws Exception {
		context.close();
		System.gc();
		System.runFinalization();
	}
	private Object createControllerForType(Class type) {
		return this.context.getBean(type);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader=new FXMLLoader(this.getClass().getResource("/views/main.fxml"));
			loader.setControllerFactory(this::createControllerForType);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e) {
			throw new IllegalStateException("Unable to load view:", e);
		}
	}

	public static void main(String[] args) {
		savedArgs=args;
		launch(args);
	}
}
