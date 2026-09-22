package com.yazidsistems.app.generaciondevariablesaleatorias.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController{

    @FXML
    void OnComposicion(ActionEvent event) {
        cambiarEscena1(event, "/com/yazidsistems/app/generaciondevariablesaleatorias/composicion-view.fxml", "Ventana 3");

    }

    @FXML
    void OnConvolucion(ActionEvent event) {
        cambiarEscena2(event, "/com/yazidsistems/app/generaciondevariablesaleatorias/convolucion-view.fxml", "Ventana 2");

    }

    @FXML
    void OnTransformada(ActionEvent event) {
        cambiarEscena3(event, "/com/yazidsistems/app/generaciondevariablesaleatorias/transformada-view.fxml", "Ventana 1");

    }

    // Método genérico para reutilizar la lógica de cambio de ventana
    private void cambiarEscena1(ActionEvent event, String fxmlPath, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root, 400, 300));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cargar la vista: " + fxmlPath);
            e.printStackTrace();
        }
    }
    private void cambiarEscena2(ActionEvent event, String fxmlPath, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root, 400, 300));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cargar la vista: " + fxmlPath);
            e.printStackTrace();
        }
    }
    private void cambiarEscena3(ActionEvent event, String fxmlPath, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root, 400, 300));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cargar la vista: " + fxmlPath);
            e.printStackTrace();
        }
    }

}
