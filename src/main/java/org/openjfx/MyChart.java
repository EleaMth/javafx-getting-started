package org.openjfx;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

public class MyChart extends VBox {
    public LineChart buildSampleLineChart() {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(0.0, 0.0));
        series.getData().add(new XYChart.Data<>(0.7, 0.5));
        series.getData().add(new XYChart.Data<>(1.0, 0.632));
        series.getData().add(new XYChart.Data<>(2.0, 0.865));
        series.getData().add(new XYChart.Data<>(3.0, 0.95));
        series.getData().add(new XYChart.Data<>(4.0, 0.982));
        series.getData().add(new XYChart.Data<>(5.0, 0.993));
        LineChart lc = new LineChart(
                new NumberAxis(" Time Constant ", 0.0, 5.0, 1),
                new NumberAxis(" V ol t a ge ( Vs ) ", 0.0, 1.0, 0.1)
        );
        //creation of axes

        lc.getData().add(series);
        return lc;
    }

    public MyChart() {
        getChildren().add(buildSampleLineChart());
    }
}


//In this example, the MyChart() function is the constructor of the MyChart class.
// This function is called each time you create a new instance.
