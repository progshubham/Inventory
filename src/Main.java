import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
/*from w ww .  jav a 2 s. c o  m*/
public class Main extends Application {
  @Override
  public void start(final Stage stage) {
    stage.setWidth(800);
    stage.setHeight(600);
    Scene scene = new Scene(new Group());

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(browser);

    browser.getEngine().setOnAlert((WebEvent<String> wEvent) -> {
      System.out.println("Alert Event  -  Message:  " + wEvent.getData());
    });

    webEngine.load("http://kineticxtech.com");

    scene.setRoot(scrollPane);
	
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}