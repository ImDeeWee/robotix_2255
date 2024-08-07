package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.Model.Compte;
import org.example.Model.Email;
import org.example.Model.Fournisseur;
import org.example.Model.Utilisateur;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe utilitaire pour les opérations liées à la lecture et à l'écriture des comptes et des emails dans les fichiers JSON.
 */

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Lit les comptes depuis un fichier JSON.
     *
     * @param chemin Le chemin vers le fichier JSON.
     * @return Une liste de comptes.
     */

    public static List<Compte> lireComptesDepuisFichier(String chemin) {
        List<Compte> comptes = new ArrayList<>();
        try {
            File file = new File(chemin);
            if (!file.exists()) {
                throw new IOException("Le fichier n'existe pas à l'emplacement spécifié : " + file.getAbsolutePath());
            }
            JsonNode root = objectMapper.readTree(file);
            if (root.has("comptes")) {
                Iterator<JsonNode> elements = root.get("comptes").elements();
                while (elements.hasNext()) {
                    JsonNode compteNode = elements.next();
                    String type = compteNode.has("type") ? compteNode.get("type").asText() : "";
                    if (type.equals("Utilisateur")) {
                        Utilisateur utilisateur = objectMapper.treeToValue(compteNode, Utilisateur.class);
                        comptes.add(utilisateur);
                    } else if (type.equals("Fournisseur")) {
                        Fournisseur fournisseur = objectMapper.treeToValue(compteNode, Fournisseur.class);
                        comptes.add(fournisseur);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return comptes;
    }

     /**
     * Lit les emails depuis un fichier JSON.
     *
     * @param chemin Le chemin vers le fichier JSON.
     * @return Une liste d'emails.
     */

    public static List<Email> lireEmailsDepuisFichier(String chemin) {
        List<Email> emails = new ArrayList<>();
        try {
            File file = new File(chemin);
            if (!file.exists()) {
                throw new IOException("Le fichier n'existe pas à l'emplacement spécifié : " + file.getAbsolutePath());
            }
            JsonNode root = objectMapper.readTree(file);
            if (root.has("emails")) {
                Iterator<JsonNode> elements = root.get("emails").elements();
                while (elements.hasNext()) {
                    JsonNode emailNode = elements.next();
                    Email email = objectMapper.treeToValue(emailNode, Email.class);
                    emails.add(email);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return emails;
    }


    /**
     * Écrit une liste de comptes dans un fichier JSON.
     *
     * @param comptes La liste de comptes à écrire.
     * @param chemin  Le chemin vers le fichier JSON.
     */

    public static void ecrireComptesDansFichier(List<Compte> comptes, String chemin) {
        try {
            File file = new File(chemin);

            List<ObjectNode> comptesAvecType = new ArrayList<>();
            for (Compte compte : comptes) {
                ObjectNode compteNode = objectMapper.createObjectNode();
                if (compte instanceof Utilisateur) {
                    Utilisateur utilisateur = (Utilisateur) compte;
                    compteNode.put("type", "Utilisateur");
                    compteNode.put("courriel", utilisateur.getCourriel());
                    compteNode.put("pseudo", utilisateur.getPseudo());
                    compteNode.put("motDePasse", utilisateur.getMotDePasse());
                    compteNode.put("telephone", utilisateur.getTelephone());
                    compteNode.put("nom", utilisateur.getNom());
                    compteNode.put("prenom", utilisateur.getPrenom());
                    compteNode.put("nomDeCompagnie", utilisateur.getNomDeCompagnie());
                    compteNode.putPOJO("interets", utilisateur.getInterets());
                    compteNode.putPOJO("followers", utilisateur.getFollowers());
                    compteNode.putPOJO("following", utilisateur.getFollowing());
                } else if (compte instanceof Fournisseur) {
                    Fournisseur fournisseur = (Fournisseur) compte;
                    compteNode.put("type", "Fournisseur");
                    compteNode.put("courriel", fournisseur.getCourriel());
                    compteNode.put("pseudo", fournisseur.getPseudo());
                    compteNode.put("motDePasse", fournisseur.getMotDePasse());
                    compteNode.put("telephone", fournisseur.getTelephone());
                    compteNode.put("capaciteFabrication", fournisseur.getCapaciteFabrication());
                }
                comptesAvecType.add(compteNode);
            }

            ObjectNode rootNode = objectMapper.createObjectNode();
            rootNode.set("comptes", objectMapper.valueToTree(comptesAvecType));
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
     * Écrit une liste d'emails dans un fichier JSON.
     *
     * @param emails La liste d'emails à écrire.
     * @param chemin Le chemin vers le fichier JSON.
     */
    
    public static void ecrireEmailsDansFichier(List<Email> emails, String chemin) {
        try {
            File file = new File(chemin);
    
            List<ObjectNode> emailsAvecType = new ArrayList<>();
            for (Email email : emails) {
                ObjectNode emailNode = objectMapper.createObjectNode();
                emailNode.put("type", email.getType());
                emailNode.put("courriel", email.getCourriel());
                emailNode.put("pseudo", email.getPseudo());
                emailNode.put("motDePasse", email.getMotDePasse());
                emailNode.put("telephone", email.getTelephone());
                emailNode.put("nom", email.getNom());
                emailNode.put("prenom", email.getPrenom());
                emailNode.put("nomDeCompagnie", email.getNomDeCompagnie());
                emailNode.putPOJO("interets", email.getInterets());
                emailNode.put("confirmed", email.isConfirmed());
                emailNode.put("capaciteFabrication", email.getCapaciteFabrication());
                emailsAvecType.add(emailNode);
            }
    
            ObjectNode rootNode = objectMapper.createObjectNode();
            rootNode.set("emails", objectMapper.valueToTree(emailsAvecType));
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
