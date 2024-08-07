## Description

Le projet Robotix est une application complète de gestion de robots et de composantes. Elle permet aux utilisateurs de s'inscrire, de gérer leurs profils, d'enregistrer et de suivre leurs robots, d'acheter des composantes essentielles, et de participer à diverses activités. Les fournisseurs peuvent également s'inscrire, gérer leur inventaire de composantes, et interagir avec les utilisateurs pour faciliter l'acquisition des éléments nécessaires à la construction et à l'amélioration des robots.

## Fonctionnalités

### Pour les Utilisateurs
1. **S'inscrire** : Créer un compte utilisateur ou fournisseur.
2. **Se connecter** : Accéder à son compte existant.
3. **Gérer son Profil** : Modifier les informations de son profil.
4. **Gérer ses robots** : Ajouter un nouveau robot à sa flotte.
5. **Gérer ses composantes** : Acheter des composantes pour construire ou améliorer des robots.
7. **Gérer les Activités** : Créer, consulter, et assigner des activités aux robots.
8. **Modifier son profil** : Modifier les données du profil.
9. **Voir ses notifications** : Problèmes avec ses robots, nouvelle activité lié avec les intérêts.
10. **Gérer ses abonnements** : Système de following entre utilisateur.
11. **Trouver un fournisseur**: Pour acheter les composantes pour robots

### Pour les Fournisseurs
1. **Gérer son Inventaire** : Ajouter, supprimer, et consulter les composantes disponibles à la vente.
2. **Modifier son profil** : Modifier les données du profil.
3. **Gestion de composantes** : Enregistrer, modifier ou supprimer des composantes.


## Organisation des fichiers
├── exigences/ -- Dossier contenant les artefacts de l'exigence (diagramme de cas d'utilisation) 
├── analyse/ -- Dossier contenant les artefacts de l'analyse (diagramme d'activités) 
├── conception/ -- Dossier contenant les artefacts de la conception (diagramme de classes et diagramme de séquence) 
├── application/ -- Dossier contenant tous les artefacts de l'implémentation 
│   ├── doc/ -- Dossier contentant la documentation de l'application générée avec Javadoc 
│   ├── src/ -- Dossier contentant le code source de l'application
│   ├── test/ -- Dossier contentant les tests unitaires JUnit
│   └── robotix.jar
└── README.md  -- Manuel d'instruction
└── rapport.html  -- Rapport des changements depuis la dernière version.
|-- Implementation/ -- Dossier contenant le prototype nom complet

## Description des données de bases

Chaque utilisateur et fournisseur possèdent leurs propres données. Tous comptes doivent se connecter avec leur **courriel** et **mot de passe**:

## UTILISATEUR

1. Nom
2. Prénom
3. Pseudo
4. Type de compte (Utilisateur)
5. Numéro de téléphone
6. Nom de compagnie (Optionnel)
7. Liste d'intérêts
8. Ses followers
9.  Les comptes qu'il follow.

Ex d'un compte d'utilisateur de la plateforme utilisable (pseudo: CR7):
courriel: cristiano.ronaldo@example.com
mot de passe: password123

## FOURNISSEUR

1. Type de compte (Fournisseur)
2. Pseudo
3. Numéro de téléphone
4. Capacité de fabrication


Ex d'un compte de fournisseur de la plateforme utilisable (pseudo: TechSupplier1):
courriel: supplier1@techcorp.com
mot de passe: password123

## Instruction pour installer le projet

Avoir Java JDK 21 minimum.

Après le téléchargement du projet, dirigez vous au repertoire du projet nommé _robotix_2255_ l'aide du terminal et exécuter ces commandes:
1. cd Application
2. java -jar robotix_255.jar


