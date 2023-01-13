package com.example.helloworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox componentGroup = new VBox();
        TextArea main = new TextArea();
        componentGroup.getChildren().add(main);

        HBox stats = new HBox();
        stats.setSpacing(20);

        HBox ltr = new HBox();
        ltr.setSpacing(2);
        Label lettercount = new Label();
        Label foreletter = new Label("Letters: ");
        ltr.getChildren().addAll(foreletter, lettercount);

        HBox wrd = new HBox();
        wrd.setSpacing(2);
        Label wordcount = new Label();
        Label foreword = new Label("Words: ");
        wrd.getChildren().addAll(foreword, wordcount);

        HBox lng = new HBox();
        lng.setSpacing(2);
        Label longalong = new Label();
        Label forelong = new Label("The longest word is: ");
        lng.getChildren().addAll(forelong, longalong);

        main.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            lettercount.setText(String.valueOf(characters));
            wordcount.setText(String.valueOf(words));
            longalong.setText(longest);
        });

        stats.getChildren().addAll(ltr, wrd, lng);

        componentGroup.getChildren().addAll(stats);

        Scene viewport = new Scene(componentGroup);

        stage.setScene(viewport);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
