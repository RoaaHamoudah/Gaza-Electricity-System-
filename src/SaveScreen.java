import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveScreen extends BorderPane {

	public SaveScreen(Stage primaryStage, Scene mainScene) {
		Button chooseFileBtn = new Button("Choose an output file");
		Label statusL = new Label("");

		GridPane gp = new GridPane();
		gp.add(chooseFileBtn, 0, 0);
		gp.add(statusL, 1, 1);

		setCenter(gp);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(15);
		gp.setHgap(15);

		chooseFileBtn.setOnAction(e -> {
			FileChooser fc = new FileChooser();
			File file = fc.showOpenDialog(primaryStage);
			if (file != null) {
				try (PrintWriter writer = new PrintWriter(file)) {
					Node<Year> currYear = Main.years.getHead();
					if (currYear != null) {
						do {
							Node<Month> currMonth = currYear.getData().getMonths().getHead();
							if (currMonth != null) {
								do {
									Month month = currMonth.getData();
									Node<Day> currentDay = month.getDays().getHead();
									if (currentDay != null) {
										do {
											Day day = currentDay.getData();
											String date = day.getRecord().getFormattedDate();
											double israeliLines = day.getRecord().getIsraeliLinesMWs();
											double gazaPowerPlant = day.getRecord().getGazaPowerPlantMWs();
											double egyptianLines = day.getRecord().getEgyptianLinesMWs();
											double totalDailySupplyAvailable = day.getRecord()
													.getTotalDailySupplyAvailableInMWs();
											double overallDemand = day.getRecord().getOverallDemandInMWs();
											double powerCutsHoursDay = day.getRecord().getPowerCutsHoursDay400mg();
											double temperature = day.getRecord().getTemperture();

											writer.write(date + ",");
											writer.write(israeliLines + ",");
											writer.write(gazaPowerPlant + ",");
											writer.write(egyptianLines + ",");
											writer.write(totalDailySupplyAvailable + ",");
											writer.write(overallDemand + ",");
											writer.write(powerCutsHoursDay + ",");
											writer.write(temperature + "\n");

											currentDay = currentDay.getNext();
										} while (currentDay != month.getDays().getHead());
									}
									currMonth = currMonth.getNext();
								} while (currMonth != currYear.getData().getMonths().getHead());
							}
							currYear = currYear.getNext();
						} while (currYear != Main.years.getHead());
					}
					writer.flush();
					statusL.setText("The data has been saved successfully!!");
				} catch (IOException ex) {
					ex.printStackTrace();
					statusL.setText("Failed to save data to file!!");
				}
			}
		});

	}

}
