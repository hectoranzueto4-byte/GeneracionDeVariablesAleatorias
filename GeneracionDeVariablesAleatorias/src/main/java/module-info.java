module com.yazidsistems.app.generaciondevariablesaleatorias {
    requires javafx.controls;
    requires javafx.fxml;

    // 1. Permite que JavaFX acceda a MainApplication para iniciar la app
    exports com.yazidsistems.app.generaciondevariablesaleatorias.applications;
    opens com.yazidsistems.app.generaciondevariablesaleatorias.applications to javafx.graphics, javafx.fxml;

    // 2. Permite que JavaFX FXML acceda a tus controladores (MainController, TransformadaController, etc.)
    exports com.yazidsistems.app.generaciondevariablesaleatorias.controller;
    opens com.yazidsistems.app.generaciondevariablesaleatorias.controller to javafx.fxml;
}
