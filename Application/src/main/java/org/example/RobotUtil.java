package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.CPU;
import org.example.Model.Robot;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Utilitaire pour lire et écrire des informations de robots dans des fichiers
 * JSON.
 */

public class RobotUtil {

    /**
     * Lit les robots depuis un fichier JSON et les charge dans une map.
     * 
     * @param cheminFichier Le chemin vers le fichier JSON contenant les robots.
     * @return Une map associant chaque courriel à une liste de robots.
     */

    public static Map<String, List<Robot>> lireRobotsDepuisFichier(String cheminFichier) {
        Map<String, List<Robot>> robotsInventaires = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File(cheminFichier));
            JsonNode robotsNode = rootNode.get("inventaires");
            if (robotsNode != null) {
                for (JsonNode robotNode : robotsNode) {
                    String courriel = robotNode.get("courriel").asText();
                    List<Robot> robots = new ArrayList<>();
                    for (JsonNode robotDetailNode : robotNode.get("robots")) {
                        CPU cpu = new CPU(
                                robotDetailNode.get("cpu").get("nom").asText(),
                                robotDetailNode.get("cpu").get("description").asText(),
                                robotDetailNode.get("cpu").get("prix").asDouble(),
                                robotDetailNode.get("cpu").get("isDisponible").asBoolean(),
                                robotDetailNode.get("cpu").get("numeroDeSerie").asInt());
                        Robot robot = new Robot(
                                cpu,
                                robotDetailNode.get("nom").asText(),
                                robotDetailNode.get("type").asText(),
                                robotDetailNode.get("position").asText(),
                                robotDetailNode.get("vitesse").asText(),
                                robotDetailNode.get("niveauBatterie").asText(),
                                robotDetailNode.get("consoCPU").asText(),
                                robotDetailNode.get("memoire").asText());
                        robots.add(robot);
                    }
                    robotsInventaires.put(courriel, robots);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return robotsInventaires;
    }

    /**
     * Écrit les robots dans un fichier JSON.
     * 
     * @param robotsInventaires Une map associant chaque courriel à une liste de
     *                          robots.
     * @param cheminFichier     Le chemin vers le fichier JSON où les robots seront
     *                          écrits.
     */

    public static void ecrireRobotsDansFichier(Map<String, List<Robot>> robotsInventaires, String cheminFichier) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> inventairesList = new ArrayList<>();
        for (Map.Entry<String, List<Robot>> entry : robotsInventaires.entrySet()) {
            Map<String, Object> inventaireMap = new HashMap<>();
            inventaireMap.put("courriel", entry.getKey());

            List<Map<String, Object>> robotsList = new ArrayList<>();
            for (Robot robot : entry.getValue()) {
                Map<String, Object> robotMap = new HashMap<>();
                robotMap.put("cpu", Map.of(
                        "nom", robot.getCpu().getNom(),
                        "description", robot.getCpu().getDescription(),
                        "prix", robot.getCpu().getPrix(),
                        "isDisponible", robot.getCpu().getIsDisponible(),
                        "numeroDeSerie", robot.getCpu().getNumeroDeSerie()));
                robotMap.put("nom", robot.getNom());
                robotMap.put("type", robot.getType());
                robotMap.put("position", robot.getPosition());
                robotMap.put("vitesse", robot.getVitesse());
                robotMap.put("niveauBatterie", robot.getNiveauBatterie());
                robotMap.put("consoCPU", robot.getConsoCPU());
                robotMap.put("memoire", robot.getMemoire());
                robotsList.add(robotMap);
            }
            inventaireMap.put("robots", robotsList);
            inventairesList.add(inventaireMap);
        }
        try {
            objectMapper.writeValue(new File(cheminFichier), Map.of("inventaires", inventairesList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
