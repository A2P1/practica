package com.prueba.Practica;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JsonManager {
    private final Gson gson = new Gson();
    public ArrayList<DataRecord> leerFichero(String fichero) {
        try (Reader reader = Files.newBufferedReader(Paths.get(fichero))) {
            // Leer los datos del fichero JSON
            ArrayList<DataRecord> dataRecords = gson.fromJson(reader, new TypeToken<ArrayList<DataRecord>>() {}.getType());

            // Configurar Gson para pretty printing
            Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();

            // Convertir los datos a formato JSON bonito
            String jsonBonito = gsonPretty.toJson(dataRecords);

            // Imprimir los datos en consola
            System.out.println(jsonBonito);

            // Devolver la lista de datos
            return dataRecords;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al leer el fichero.");
            return new ArrayList<>(); // Devolver lista vacía en caso de error
        }
    }
    public Map<String, List<DataRecord>> leerFicheroAgrupado(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(path), new TypeReference<Map<String, List<DataRecord>>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void escribirFichero(String fichero, ArrayList<DataRecord> dataRecords) {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(fichero));
            new GsonBuilder().setPrettyPrinting().create().toJson(dataRecords, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error escribiendo en el fichero");
        }
    }

}
