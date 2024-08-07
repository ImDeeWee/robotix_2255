package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Activite;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * Classe utilitaire pour les opérations liées à la lecture et à l'écriture des
 * activités dans les fichiers JSON.
 */
public class ActiviteUtil {

    /**
     * Lit les activités depuis un fichier JSON.
     *
     * @param cheminFichier Le chemin vers le fichier JSON.
     * @return Une map contenant les activités par courriel.
     */
    public static Map<String, List<Activite>> lireActivitesDepuisFichier(String cheminFichier) {
        Map<String, List<Activite>> activites = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File(cheminFichier));
            JsonNode activitesNode = rootNode.get("activites");
            if (activitesNode != null && activitesNode.isArray()) {
                for (JsonNode activiteNode : activitesNode) {
                    String courriel = activiteNode.get("courriel").asText();
                    List<Activite> activitesUtilisateur = new ArrayList<>();
                    JsonNode activitesArray = activiteNode.get("activites");
                    if (activitesArray != null && activitesArray.isArray()) {
                        for (JsonNode node : activitesArray) {
                            String nom = node.get("nom").asText();
                            Integer points = node.get("points").asInt();
                            LocalDate dateDebut = LocalDate.parse(node.get("dateDebut").asText());
                            LocalDate dateFin = LocalDate.parse(node.get("dateFin").asText());
                            Activite activite = new Activite(nom, points, dateDebut, dateFin);
                            JsonNode robotsNode = node.get("robots");
                            if (robotsNode != null && robotsNode.isArray()) {
                                for (JsonNode robotNode : robotsNode) {
                                    Integer numeroDeSerie = robotNode.asInt();
                                    activite.addNumeroDeSerieRobot(numeroDeSerie);
                                }
                            }
                            activitesUtilisateur.add(activite);
                        }
                    }
                    activites.put(courriel, activitesUtilisateur);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activites;
    }

    /**
     * Écrit les activités dans un fichier JSON.
     *
     * @param activites     Une map contenant les activités par courriel.
     * @param cheminFichier Le chemin vers le fichier JSON.
     */
    public static void ecrireActivitesDansFichier(Map<String, List<Activite>> activites, String cheminFichier) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> activitesList = new ArrayList<>();
        for (Map.Entry<String, List<Activite>> entry : activites.entrySet()) {
            Map<String, Object> activiteMap = new HashMap<>();
            activiteMap.put("courriel", entry.getKey());
            List<Map<String, Object>> activitesUtilisateurList = new ArrayList<>();
            for (Activite activite : entry.getValue()) {
                Map<String, Object> activiteDetails = new HashMap<>();
                activiteDetails.put("nom", activite.getNom());
                activiteDetails.put("points", activite.getPoints());
                activiteDetails.put("dateDebut", activite.getDateDebut().toString());
                activiteDetails.put("dateFin", activite.getDateFin().toString());
                activiteDetails.put("robots", activite.getNumeroDeSerieRobots());
                activitesUtilisateurList.add(activiteDetails);
            }
            activiteMap.put("activites", activitesUtilisateurList);
            activitesList.add(activiteMap);
        }
        try {
            objectMapper.writeValue(new File(cheminFichier), Map.of("activites", activitesList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
