import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DLR0_Design_A_Respon extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Responsive Web App Monitor");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        grid.getColumnConstraints().addAll(column1, column2);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(20);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(40);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(40);
        grid.getRowConstraints().addAll(row1, row2, row3);

        Label headerLabel = new Label("Responsive Web App Monitor");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        GridPane.setConstraints(headerLabel, 0, 0, 2, 1);
        grid.getChildren().add(headerLabel);

        Button refreshButton = new Button("Refresh");
        refreshButton.setPrefWidth(100);
        GridPane.setConstraints(refreshButton, 0, 1);
        grid.getChildren().add(refreshButton);

        Button settingsButton = new Button("Settings");
        settingsButton.setPrefWidth(100);
        GridPane.setConstraints(settingsButton, 1, 1);
        grid.getChildren().add(settingsButton);

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setPrefWidth(800);
        chart.setPrefHeight(400);
        GridPane.setConstraints(chart, 0, 2, 2, 1);
        grid.getChildren().add(chart);

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(1, 10));
        series.getData().add(new XYChart.Data(2, 20));
        series.getData().add(new XYChart.Data(3, 30));
        chart.getData().add(series);

        VBox vBox = new VBox(10);
        vBox.getChildren().add(grid);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}