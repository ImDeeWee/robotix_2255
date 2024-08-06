package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.Model.CPU;
import org.example.Model.Composante;
import org.example.Model.ComposanteType;
import org.example.Model.Compte;
import org.example.Model.Fournisseur;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe utilitaire pour les opérations liées à la lecture et à l'écriture des
 * composantes dans les fichiers JSON.
 */

public class ComposanteUtil {

    /**
     * Lit les composantes depuis un fichier JSON.
     *
     * @param cheminFichier Le chemin vers le fichier JSON.
     * @return Une map contenant les composantes par courriel.
     */

    public static Map<String, List<Composante>> lireComposantesDepuisFichier(String cheminFichier) {
        Map<String, List<Composante>> inventaires = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File(cheminFichier));
            JsonNode inventairesNode = rootNode.get("inventaires");
            if (inventairesNode != null) {
                for (JsonNode inventaireNode : inventairesNode) {
                    String courriel = inventaireNode.get("courriel").asText();
                    List<Composante> composantes = new ArrayList<>();
                    for (JsonNode composanteNode : inventaireNode.get("composantes")) {
                        String nom = composanteNode.get("nom").asText();
                        String description = composanteNode.get("description").asText();
                        double prix = composanteNode.get("prix").asDouble();
                        ComposanteType type = ComposanteType.valueOf(composanteNode.get("type").asText());
                        boolean isDisponible = composanteNode.get("isDisponible").asBoolean();
                        Composante composante;
                        if (type == ComposanteType.CPU) {
                            int numeroDeSerie = composanteNode.get("numeroDeSerie").asInt();
                            composante = new CPU(nom, description, prix, isDisponible, numeroDeSerie);
                        } else {
                            composante = new Composante(nom, description, prix, type, isDisponible);
                        }
                        composantes.add(composante);
                    }
                    inventaires.put(courriel, composantes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventaires;
    }

    /**
     * Écrit les composantes dans un fichier JSON.
     *
     * @param inventaires   Une map contenant les composantes par courriel.
     * @param cheminFichier Le chemin vers le fichier JSON.
     */

    public static void ecrireComposantesDansFichier(Map<String, List<Composante>> inventaires, String cheminFichier) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> inventairesList = new ArrayList<>();
        List<Compte> comptes = JsonUtil.lireComptesDepuisFichier("Application\\src\\main\\java\\Donnees\\Comptes.json");

        for (Map.Entry<String, List<Composante>> entry : inventaires.entrySet()) {
            Map<String, Object> inventaireMap = new HashMap<>();
            inventaireMap.put("courriel", entry.getKey());

            boolean isFournisseur = comptes.stream()
                    .anyMatch(compte -> compte.getCourriel().equals(entry.getKey()) && compte instanceof Fournisseur);
            inventaireMap.put("isFournisseur", isFournisseur);

            List<Map<String, Object>> composantesList = new ArrayList<>();
            for (Composante composante : entry.getValue()) {
                Map<String, Object> composanteMap = new HashMap<>();
                composanteMap.put("nom", composante.getNom());
                composanteMap.put("description", composante.getDescription());
                composanteMap.put("prix", composante.getPrix());
                composanteMap.put("type", composante.getType().toString());
                composanteMap.put("isDisponible", composante.getIsDisponible());
                if (composante instanceof CPU) {
                    composanteMap.put("numeroDeSerie", ((CPU) composante).getNumeroDeSerie());
                }
                composantesList.add(composanteMap);
            }
            inventaireMap.put("composantes", composantesList);
            inventairesList.add(inventaireMap);
        }
        try {
            objectMapper.writeValue(new File(cheminFichier), Map.of("inventaires", inventairesList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lit les composantes des fournisseurs depuis un fichier JSON.
     *
     * @param cheminFichier Le chemin vers le fichier JSON.
     * @return Une map contenant les composantes par courriel des fournisseurs.
     */

    public static Map<String, List<Composante>> lireComposantesFournisseursDepuisFichier(String cheminFichier) {
        Map<String, List<Composante>> inventaires = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File(cheminFichier));
            JsonNode inventairesNode = rootNode.get("inventaires");
            if (inventairesNode != null) {
                for (JsonNode inventaireNode : inventairesNode) {
                    String courriel = inventaireNode.get("courriel").asText();
                    List<Composante> composantes = new ArrayList<>();
                    for (JsonNode composanteNode : inventaireNode.get("composantes")) {
                        String nom = composanteNode.get("nom").asText();
                        String description = composanteNode.get("description").asText();
                        double prix = composanteNode.get("prix").asDouble();
                        ComposanteType type = ComposanteType.valueOf(composanteNode.get("type").asText());
                        boolean isDisponible = composanteNode.get("isDisponible").asBoolean();
                        Composante composante = new Composante(nom, description, prix, type, isDisponible);
                        composantes.add(composante);
                    }
                    inventaires.put(courriel, composantes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventaires;
    }

}
