
# Projet DevOps - Panda lib en java [![Build Status](https://travis-ci.com/SoheibOuad/ProjetDevOps.svg?branch=master)](https://travis-ci.com/SoheibOuad/ProjetDevOps)
![Test Coverage](ProjetDevOps/jacoco.svg)

### Présentation des fonctionnalitées fournies par le service 

#### Choix de la présentation d'un Dataframe

Il existe beaucoup de présentation d'un dataframe dans la documentation officiel de la librairie Panda. J'ai choisi de présenter un dataframe comme une liste des listes , ou chaque liste dans la liste principale est considéré comme une ligne d'une matrice.

#### Création d'un Dataframe

Le constructeur de dataframe il prend deux arguments , une liste qui contient les noms des colonnes et une liste des listes de données.

#### Affichage d'un Dataframe

Il ya 3 types d'affichage possible :

1. Affichage de tout le Dataframe.
2. Affichage seulements les premieres lignes.
3. Affichage seulements les dernieres lignes. 

L'utilisateur a la possibilité d'introduire le nombre de lignes qui veut afficher pour le type 2 et 3.
* Pour bien organiser la conception et faciliter aprés l'implémentation de la solution , j'ai opté pour un design pattern Strategy qui va nous aider de choisir si on veut afficher les premieres ou les dernieres lignes sans réputation du code. 

#### Statistique sur un dataframe

Pour les colonnes qui sont de type Entier , l'utilisateur pourra appliquer sur eux les fonctions suivantes :

1. Maximum
2. Minimum
3. Somme
4. Moyenne

### Choix d'outils

* Le projet a été dévloppé avec le language java en utilisant l'architecture Maven .
* J'ai utilisé GitHub pour mettre en place mon dépot git.
* Pour l'integration et livraison continue , j'ai utilisé Travis CI qui est un service en ligne pour compiler, tester et déployer le code source des logiciels développés, notamment en lien avec GitHub.
* Utilisation de Junit4 pour mettre en place les tests unitaires.
* Pour évaluer la qualité du code , j'ai choisi jacoco comme outil de couverture du code . Jacoco est est une boîte à outils open-source pour mesurer et rapporter la couverture du code Java et c'est un plugin de maven.
* Google catch exception pour tester les exceptions dans des containers , je l'ai ajouté comme une dépendence dans maven.
* Utilisation de Docker Hub pour mettre des images docker que j'ai trouvé utiles pour le projet.
* Générer et ajout des badges qui permettent de :
	- Afficher l'état de construction actuel de mon projet, ce badge on l'obtient grace au Travis CI.
	- Afficher le taux de couverture du code en utilisant jacoco.

### Images docker

1. pandalibjava : Cet image permettent de lancer, a l’exécution du conteneur, tout les tests unitaires du projet.
2. versionautomatiquepanda : Cet image contient la dérniere version de la bibiothéque , et elle est construite de maniére automatique (automated build).
3. back : Cet image correspond à la livraison continu de facon que l'image est mis à jour à chaque fois qu'on mis à jour le dépot (faire push) et que les tests unitaires se passent avec succés (L'intégration continu s'est passé comme prévu). 