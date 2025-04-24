# Système de Notification avec Java RMI
## Aperçu
Ce projet est un système de notification distribué utilisant Java RMI. Les clients peuvent s'abonner à des canaux (comme "sport") et recevoir des messages envoyés par un serveur, suivant un modèle de publication-abonnement.
Fonctionnalités

Abonnement/désabonnement des clients à des canaux.
Envoi de messages par le serveur aux clients abonnés.
Gestion des déconnexions (suppression des clients inactifs).

## Prérequis

JDK 8 ou supérieur.
Terminal ou IDE pour compiler/exécuter des fichiers Java.

## Structure

client : Classes pour les clients (ClientNotification, ClientNotificationImp, ClientApp).
server : Classes pour le serveur (NotificationServer, NotificationServerImp, ServerApp, BatchTrigger).

## Exécution

Compiler :cd src
javac client/*.java server/*.java


Lancer le serveur :java server.ServerApp


Lancer un client :java client.ClientApp [Nom]

Exemple : java client.ClientApp Alice
Envoyer un message :java server.BatchTrigger



## Fonctionnement

Le serveur (ServerApp) démarre et attend des clients.
Les clients (ClientApp) s'abonnent au canal "sport".
BatchTrigger envoie un message au canal "sport", reçu par tous les clients abonnés.

## Limitations

Canaux codés en dur ("sport").
Message affiché incorrect dans ClientApp ("general" au lieu de "sport").
