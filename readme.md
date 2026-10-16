# Rapport de Travaux Pratiques : Design Patterns — Exercices 1 et 2

**Encadrant :** Mohamed YOUSSFI  
**Étudiant :** Youness HATTABI

---

## Table des Matières

1. [Introduction](#1-introduction)
2. [Exercice 1 — Choix des design patterns](#2-exercice-1--choix-des-design-patterns)
   - 2.1 [Situation 1 : les figures (Composite)](#21-situation-1--les-figures-composite)
   - 2.2 [Situation 2 : le plugin (Template Method et Factory Method)](#22-situation-2--le-plugin-template-method-et-factory-method)
   - 2.3 [Situation 3 : le composant à enrichir (Decorator)](#23-situation-3--le-composant-à-enrichir-decorator)
   - 2.4 [Situation 4 : le joueur et son environnement (Observer)](#24-situation-4--le-joueur-et-son-environnement-observer)

---

## 1. Introduction

Ce rapport comporte deux exercices :

- **Exercice 1 :** à partir de quatre situations, identifier le design pattern approprié et établir le diagramme de classes correspondant.
- **Exercice 2 :** concevoir et développer un framework de traitement d'images (filtrage et compression) en combinant plusieurs patterns, puis écrire une application cliente qui l'utilise.

---

## 2. Exercice 1 — Choix des design patterns

### 2.1 Situation 1 : les figures (Composite)

> Une figure peut être soit un cercle, un rectangle ou un groupe de figures.

**Pattern retenu : Composite.**

Un groupe de figures est lui-même une figure : il peut donc contenir des cercles, des rectangles, mais aussi d'autres groupes. C'est une structure arborescente de type « partie-tout », où le client doit traiter de la même façon une figure simple et un groupe.

| Rôle dans le pattern | Classe                                           |
| -------------------- | ------------------------------------------------ |
| Composant            | `Figure`                                         |
| Feuilles             | `Cercle`, `Rectangle`                            |
| Composite            | `GroupeFigures` (contient une liste de `Figure`) |

**Diagramme de classes :**

<img src="pictures/ex1_composite.png" alt="Diagramme de classes — Composite (figures)" height="400">

---

### 2.2 Situation 2 : le plugin (Template Method et Factory Method)

> Un plugin contient une opération implémentant le squelette d'un algorithme dont deux parties (partie1 et partie2) sont variables. Le développeur doit pouvoir implémenter les deux parties manquantes, et l'application cliente doit pouvoir instancier une implémentation concrète du plugin sans connaître sa classe.

**Patterns retenus : Template Method et Factory Method.**

Le sujet exprime deux besoins distincts, donc deux patterns :

- **Template Method** : l'opération du plugin fixe l'enchaînement de l'algorithme et délègue `partie1` et `partie2`, abstraites, aux sous-classes écrites par le développeur.
- **Factory Method** : le client obtient un plugin via une méthode de fabrication déclarée dans une classe abstraite, sans jamais écrire `new` sur la classe concrète.

| Rôle dans le pattern               | Classe                                                                      |
| ---------------------------------- | --------------------------------------------------------------------------- |
| Classe abstraite (Template Method) | `Plugin` : `operation()` (squelette), `partie1()` et `partie2()` abstraites |
| Classes concrètes                  | `PluginConcret` (écrite par le développeur)                                 |
| Créateur (Factory Method)          | `PluginFactory` : `creerPlugin()` abstraite                                 |
| Créateur concret                   | `PluginConcretFactory` : retourne un `PluginConcret`                        |
| Client                             | Utilise `PluginFactory` et `Plugin` uniquement                              |

**Diagramme de classes :**

<img src="pictures/ex1_plugin.png" alt="Diagramme de classes — Template Method et Factory Method (plugin)" height="450">

---

### 2.3 Situation 3 : le composant à enrichir (Decorator)

> Un composant implémente une interface qui définit une opération `traitement()`. On veut lui rattacher des responsabilités supplémentaires sans modifier son code source, c'est-à-dire envelopper l'exécution de `traitement()` par d'autres traitements avant et après.

**Pattern retenu : Decorator.**

Le décorateur implémente la même interface que le composant et en détient une référence. Il exécute son traitement avant, appelle `traitement()` du composant enveloppé, puis exécute son traitement après. Les décorateurs peuvent être empilés.

| Rôle dans le pattern  | Classe                                                                  |
| --------------------- | ----------------------------------------------------------------------- |
| Composant (interface) | `Composant` avec `traitement()`                                         |
| Composant concret     | `ComposantConcret`                                                      |
| Décorateur (abstrait) | `Decorateur` : implémente `Composant` et détient un `Composant`         |
| Décorateurs concrets  | `DecorateurConcretA`, `DecorateurConcretB` (traitements avant et après) |

**Diagramme de classes :**

<img src="pictures/ex1_decorator.png" alt="Diagramme de classes — Decorator" height="400">

---

### 2.4 Situation 4 : le joueur et son environnement (Observer)

> La classe `Joueur` a un état représenté par un `score` entier. Les objets de l'environnement du jeu (`Couloir`, `Camera`, `Gardien`) doivent être informés à chaque changement du score, en gardant un couplage faible avec `Joueur`.

**Pattern retenu : Observer.**

`Joueur` est le sujet observé. Il ne connaît ses observateurs qu'à travers une interface commune : lorsque son score change, il notifie tous les observateurs inscrits. `Couloir`, `Camera` et `Gardien` implémentent cette interface, ce qui permet d'en ajouter d'autres sans toucher à `Joueur`.

| Rôle dans le pattern      | Classe                                                       |
| ------------------------- | ------------------------------------------------------------ |
| Sujet (abstraction)       | `Observable` : `subscribe`, `unsubscribe`, `notifyObservers` |
| Sujet concret             | `Joueur` : attribut `score`, notifie dans `setScore`         |
| Observateur (abstraction) | `Observateur` : `update`                                     |
| Observateurs concrets     | `Couloir`, `Camera`, `Gardien`                               |

**Diagramme de classes :**

<img src="pictures/ex1_observer.png" alt="Diagramme de classes — Observer (joueur)" height="450">

---
