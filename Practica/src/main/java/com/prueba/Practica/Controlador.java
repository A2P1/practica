package com.prueba.Practica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@RestController
public class Controlador {

    private final String fichero = "./src/main/resources/TurismoComunidades.json";
    @Autowired
    private JsonManager jsonManager;

    @GetMapping("/datosjson")
    public ResponseEntity<ArrayList<DataRecord>> obtenerDatos() {
        ArrayList<DataRecord> dataRecords = jsonManager.leerFichero(fichero);
        return new ResponseEntity<>(dataRecords, HttpStatus.OK);
    }

}
