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

    @PostMapping(value = "/agregarDatos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> agregarDatos(@RequestBody DataRecord newData) {
        // Leer los datos actuales desde el archivo
        ArrayList<DataRecord> dataRecords = jsonManager.leerFichero(fichero);

        // Agregar el nuevo dato
        dataRecords.add(newData);

        // Escribir los datos actualizados al archivo
        jsonManager.escribirFichero(fichero, dataRecords);

        // Responder con mensaje de éxito
        return ResponseEntity.ok("Datos agregados correctamente");
    }

}
