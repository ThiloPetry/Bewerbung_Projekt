package com.example.Bewerbungs_Projekt.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class controller {


    @RequestMapping(value = "/hello/{id}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)   //lege den Pfad an
    @ResponseBody
    public ResponseEntity<Map<String, String>> getBetriebBySimplePathWithPathVariable(
            @PathVariable("id") String id) throws IOException {  //Setze die Pfad Variable als ID fest.

        // lade die CSV und speichere Sie in zwei Array's
        //alcompleteline enthält dabei die ganzen Zeilen der Tabelle, alid nur die IDs,
        ArrayList alcompleteline, alid;
        File getCSVFiles = new File("src/main/data/DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv");
        Scanner sc = new Scanner(getCSVFiles);
        sc.useDelimiter(";");
        alcompleteline = new ArrayList();
        alid = new ArrayList();
        while (sc.hasNext()) {
            alid.add(sc.next());
            alcompleteline.add(sc.nextLine());
        }
        sc.close();

        //suche die Stelle im Index an der sich die Pfad Variable befindet.
        int x = alid.indexOf(id);
        String[] arrofStr = (alcompleteline.get(x)).toString().split(";"); //speichere die Zeile als Array getrennt nach Elementen.

        //Erzeuge Jsonobject, mit den gewünschten Inhalten.
        JSONObject json = new JSONObject()
                .put("Name: ", arrofStr[1])
                .put("Kurzname: ", arrofStr[2])
                .put("Typ: ", arrofStr[4]);

        HashMap<String,String> map = new HashMap<>();
                map.put("Name: ", arrofStr[1]);
                map.put("Kurzname: ", arrofStr[2]);
                map.put("Typ: ", arrofStr[4]);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }




}
