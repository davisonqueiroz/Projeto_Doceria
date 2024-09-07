package com.mycompany.controller;

import java.io.IOException;
import javafx.fxml.FXML;

public class TelaPrincipalController {

    @FXML
    private void switchToSecondary() throws IOException {
        Main.setRoot("secondary");
    }
}
