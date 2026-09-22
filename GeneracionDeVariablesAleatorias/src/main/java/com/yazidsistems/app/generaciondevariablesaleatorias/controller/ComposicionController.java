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

public class ComposicionController {

    @FXML
    private TextField cantidadInput;

    @FXML
    private ListView<String> listView;

    private final Random random = new Random();

    @FXML
    private void generarVariablesComposicion(ActionEvent event) {
        listView.getItems().clear();

        try {
            int cantidad = Integer.parseInt(cantidadInput.getText());

            if (cantidad <= 0) {
                listView.getItems().add("Error: La cantidad debe ser mayor a 0.");
                return;
            }

            for (int i = 0; i < cantidad; i++) {
                // 1. Generar los componentes independientes requeridos por la composición
                double u1 = random.nextDouble();
                double u2 = random.nextDouble();

                // 2. Composición por adición/combinación (genera densidad triangular)
                double x = u1 + u2;

                // 3. Mostrar los subcomponentes uniformes y el resultado final X
                String item = String.format("U1 = %.4f | U2 = %.4f  ->  X = %.4f", u1, u2, x);
                listView.getItems().add(item);
            }

        } catch (NumberFormatException e) {
            listView.getItems().add("Error: Ingresa una cantidad entera válida.");
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
