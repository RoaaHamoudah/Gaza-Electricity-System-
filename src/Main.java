import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application{
	static CircularSinglyLinkedList<Year> years = new CircularSinglyLinkedList<Year>();
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TabPane tp = new TabPane();	    
		Scene mainScene = new Scene(tp,1000,500);
		
		Tab fileTab = new Tab();
        Label fileL = new Label("File", new ImageView(new Image(getClass().getResourceAsStream("file.png"))));
        fileL.setStyle("-fx-font-family: Arial;-fx-font-size: 18;-fx-text-fill: white;-fx-font-weight: bold;");

        fileTab.setGraphic(fileL);
        
        Tab ManagementTab = new Tab();
        Label ManagementL = new Label("Management", new ImageView(new Image(getClass().getResourceAsStream("Management.png"))));
        ManagementL.setStyle("-fx-font-family: Arial;-fx-font-size: 18;-fx-text-fill: white;-fx-font-weight: bold;");
        ManagementTab.setGraphic(ManagementL);
        
        Tab StatisticsTab = new Tab();
        Label StatisticsL = new Label("Statistics", new ImageView(new Image(getClass().getResourceAsStream("Statistics.png"))));
        StatisticsL.setStyle("-fx-font-family: Arial;-fx-font-size: 18;-fx-text-fill: white;-fx-font-weight: bold;");
        StatisticsTab.setGraphic(StatisticsL);
	        
        Tab SaveTab = new Tab();
        Label SaveL = new Label("Save", new ImageView(new Image(getClass().getResourceAsStream("Save.png"))));
        SaveL.setStyle("-fx-font-family: Arial;-fx-font-size: 18;-fx-text-fill: white;-fx-font-weight: bold;");
        SaveTab.setGraphic(SaveL);
	        
		
		fileTab.setClosable(false);
		ManagementTab.setClosable(false);
		StatisticsTab.setClosable(false);
		SaveTab.setClosable(false);
		
		GridPane gp = new GridPane();
		Label titleL = new Label("    Gaza Electricity Project ");
		titleL.setAlignment(Pos.CENTER);
		titleL.setStyle("-fx-font-size: 25;-fx-text-fill: black;");
		
		
		Button chooseFileBtn = new Button("Choose a CSV Electricity File");
		chooseFileBtn.setAlignment(Pos.CENTER);
		Label statusL = new Label();
		
		
		VBox vb = new VBox(30);
		vb.getChildren().addAll(titleL,chooseFileBtn ,statusL);
		vb.setAlignment(Pos.CENTER);
		
		chooseFileBtn.setOnAction(e->{
			if (readElectricityFile(primaryStage)) {
				statusL.setText("File loaded successfully!!!!!");
			} else {
				statusL.setText("Select a file!!!!");
			}
		
		});
		
		gp.setHgap(15);
		gp.setVgap(15);
		gp.setAlignment(Pos.CENTER);
		gp.add(vb, 0, 0);
		fileTab.setContent(gp);
		
		MangementScreen mangementScreen = new MangementScreen(primaryStage, mainScene);
		ManagementTab.setContent(mangementScreen);
		
		StatisticsScreen1 statisticsScreen = new StatisticsScreen1(primaryStage, mainScene);
		StatisticsTab.setContent(statisticsScreen);

		
		SaveScreen saveScreen = new SaveScreen(primaryStage, mainScene);
		SaveTab.setContent(saveScreen);
		
		tp.getTabs().addAll(fileTab, ManagementTab, StatisticsTab, SaveTab);
		mainScene.getStylesheets().add(getClass().getResource("themes.css").toExternalForm());
		primaryStage.setScene(mainScene);
		primaryStage.show();

	}

	private static boolean readElectricityFile(Stage primaryStage) {
		FileChooser fc = new FileChooser();
		File file = fc.showOpenDialog(primaryStage);
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = "";
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				try {
					String[] arr = line.split(",");
					if (arr.length != 8)
						return false;

					String date1 = arr[0].trim();
					double israeliLinesMWs = Double.parseDouble(arr[1].trim());
					double gazaPowerPlantMWs = Double.parseDouble(arr[2].trim());
					double egyptianLinesMWs = Double.parseDouble(arr[3].trim());
					double totalDailySupplyAvailableInMWs = Double.parseDouble(arr[4].trim());
					double overallDemandInMWs = Double.parseDouble(arr[5].trim());
					double powerCutsHoursDay400mg = Double.parseDouble(arr[6].trim());
					double temperture = Double.parseDouble(arr[7].trim());

					Electricity electricity = new Electricity(date1, israeliLinesMWs, gazaPowerPlantMWs,
							egyptianLinesMWs, totalDailySupplyAvailableInMWs, overallDemandInMWs,
							powerCutsHoursDay400mg, temperture);
					// System.out.println(electricity);

					String[] date = date1.split("/");

					if (date.length != 3)
						return false;

					int month = Integer.parseInt(date[0].trim());
					int day = Integer.parseInt(date[1].trim());
					int year = Integer.parseInt(date[2].trim());

					Month monthObj = new Month(month);
					Day dayObj = new Day(day, electricity);
					Year yearObj = new Year(year);

					Node<Year> nodeY = Main.years.search(yearObj);
					if (nodeY == null) {
						years.insertSorted(yearObj);
						yearObj.getMonths().insertSorted(monthObj);
						monthObj.getDays().insertSorted(dayObj);

					} else if (nodeY != null) {

						yearObj = nodeY.getData();
						Node<Month> nodeM = yearObj.getMonths().search(monthObj);

						Node<Day> nodeD = monthObj.getDays().search(dayObj);
						if (nodeM != null && nodeD != null) {
							System.out.println("Electricity record already exists.");
						}
						if (nodeM == null)
							yearObj.getMonths().insertSorted(monthObj);
						   nodeM = yearObj.getMonths().search(monthObj);

						monthObj = nodeM.getData();
						if (nodeD == null)
							monthObj.getDays().insertSorted(dayObj);
					}

				}

				catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e1) {
			System.out.println("File not found");
			return false;
		}
		return true;

	}
}
