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

public class ConvolucionController {

    @FXML
    private TextField mediaInput;

    @FXML
    private TextField desviacionInput;

    @FXML
    private ListView<String> listView;

    private final Random random = new Random();

    @FXML
    private void generarVariablesConvolucion(ActionEvent event) {
        listView.getItems().clear();

        try {
            double media = Double.parseDouble(mediaInput.getText());
            double desviacion = Double.parseDouble(desviacionInput.getText());

            if (desviacion < 0) {
                listView.getItems().add("Error: La desviación estándar no puede ser negativa.");
                return;
            }

            for (int j = 0; j < 10; j++) {
                double sumaUniformes = 0.0;

                // 1. Convolución: Sumar 12 variables aleatorias U(0,1)
                for (int i = 0; i < 12; i++) {
                    sumaUniformes += random.nextDouble();
                }

                // 2. Obtener la variable normal estándar Z ~ N(0,1)
                double z = sumaUniformes - 6.0;

                // 3. Transformar a la distribución Normal deseada X ~ N(media, desviacion^2)
                double x = media + (desviacion * z);

                // 4. Mostrar el resultado en el ListView
                String item = String.format("Suma U_i = %.4f  ->  X = %.4f", sumaUniformes, x);
                listView.getItems().add(item);
            }

        } catch (NumberFormatException e) {
            listView.getItems().add("Error: Ingresa números válidos en los parámetros.");
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
