package com.yazidsistems.app.generaciondevariablesaleatorias.controller;

import java.io.IOException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TransformadaController {

    @FXML
    private TextField lambdaInput;

    @FXML
    private ListView<String> listView;

    private final Random random = new Random();

    @FXML
    private void generarVariables(ActionEvent event) {
        // Limpiamos la lista antes de una nueva generación
        listView.getItems().clear();

        try {
            double lambda = Double.parseDouble(lambdaInput.getText());

            if (lambda <= 0) {
                listView.getItems().add("Error: Lambda debe ser mayor a 0");
                return;
            }

            for (int i = 0; i < 10; i++) {
                // 1. Generar número pseudoaleatorio uniforme U entre (0, 1]
                double u = random.nextDouble();
                if (u == 0) u = 0.0001; // Evitar Log(0) que da indefinido

                // 2. Aplicar la ecuación de la Transformada Inversa: -ln(1-U) / lambda
                double x = -Math.log(1 - u) / lambda;

                // 3. Formatear y mostrar el resultado en la lista
                String item = String.format("U = %.4f  ->  X = %.4f", u, x);
                listView.getItems().add(item);
            }

        } catch (NumberFormatException e) {
            listView.getItems().add("Error: Ingresa un número decimal válido.");
        }
    }

    @FXML
    private void volverMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/yazidsistems/app/generaciondevariablesaleatorias/main-view.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Menú Principal");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
