package org.openjfx;

import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Random;

public class MyChart extends VBox {
    XYChart.Series<Double, Double> series = new XYChart.Series<>();
    private NumberAxis xAxis;
    private double x = 0;
    double x_max = 10;

    public LineChart buildSampleLineChart() { //constructor
        series.getData().add(new XYChart.Data<>(0.0, 0.0));
        series.getData().add(new XYChart.Data<>(0.7, 0.5));
        series.getData().add(new XYChart.Data<>(1.0, 0.632));
        series.getData().add(new XYChart.Data<>(2.0, 0.865));
        series.getData().add(new XYChart.Data<>(3.0, 0.95));
        series.getData().add(new XYChart.Data<>(4.0, 0.982));
        series.getData().add(new XYChart.Data<>(5.0, 0.993));
        xAxis = new NumberAxis(" Time Constant ", 0.0, x_max, 1);
        LineChart lc = new LineChart(
                xAxis,
                new NumberAxis(" V ol t a ge ( Vs ) ", 0.0, 1.0, 0.1)
        );
        //creation of axes

        lc.getData().add(series);
        return lc;
    }

    public MyChart() {
        getChildren().add(buildSampleLineChart());
        Button myButton = new Button("Add random value");
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Random rand = new Random();
                double randomT = 5 * rand.nextDouble();
                double randomV = rand.nextDouble();
                series.getData().add(new XYChart.Data<>(randomT, randomV));
            }
        });
        getChildren().add(myButton);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                        series.getData().add(new XYChart.Data<>(x++, Math.random()));

                        if (series.getData().size() > x_max) {
                            series.getData().remove(0);
                            xAxis.setLowerBound(series.getData().get(0).getXValue());
                            xAxis.setUpperBound(series.getData().get(series.getData().size() - 1).getXValue());
                        }
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                    }
// UI update i s run on the A p pli c a ti o n th re ad

                    Platform.runLater(updater);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();


    }
}


//In this example, the MyChart() function is the constructor of the MyChart class.
// This function is called each time you create a new instance.
