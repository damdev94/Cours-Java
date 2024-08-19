package com.espacex.decouverte;
import java.util.Scanner;

import com.espacex.decouverte.enginsspatiaux.DepassementTonnageException;
import com.espacex.decouverte.enginsspatiaux.TypeVaisseau;
import com.espacex.decouverte.enginsspatiaux.Vaisseau;
import com.espacex.decouverte.enginsspatiaux.VaisseauCivil;
import com.espacex.decouverte.enginsspatiaux.VaisseauDeGuerre;
import com.espacex.decouverte.objetsastro.Atmosphere;
import com.espacex.decouverte.objetsastro.Galaxie;
import com.espacex.decouverte.objetsastro.Planete;
import com.espacex.decouverte.objetsastro.PlaneteGazeuse;
import com.espacex.decouverte.objetsastro.PlaneteTellurique;

public class HelloUniverse {

    public static void main(String... args) {

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;
        mercure.distanceEtoile = 57.9f;
        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        venus.distanceEtoile = 108.2f;
        PlaneteTellurique terre = new PlaneteTellurique("Terre", 100);
        terre.diametre = 12756;
        terre.distanceEtoile = 149.6f;
        PlaneteTellurique mars = new PlaneteTellurique("Mars", 5);
        mars.diametre = 6792;
        mars.distanceEtoile = 227.9f;
        Atmosphere atmospherMars = new Atmosphere();
        atmospherMars.constituants.put("CO2", 95f);
        atmospherMars.constituants.put("N2", 3f);
        atmospherMars.constituants.put("AR", 1.5f);
        atmospherMars.constituants.put("NO", 0.013f);
        mars.atmosphere = atmospherMars;


        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        jupiter.distanceEtoile = 778.3f;
        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.distanceEtoile = 1427f;
        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.distanceEtoile = 2877.38f;
        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.distanceEtoile = 4497.07f;


        Galaxie systemeSolaire = new Galaxie("systeme solaire");
        systemeSolaire.ajouterPlanete(neptune);
        systemeSolaire.ajouterPlanete(venus);
        systemeSolaire.ajouterPlanete(terre);
        systemeSolaire.ajouterPlanete(mars);
        systemeSolaire.ajouterPlanete(jupiter);
        systemeSolaire.ajouterPlanete(saturne);
        systemeSolaire.ajouterPlanete(uranus);
        systemeSolaire.ajouterPlanete(mercure);

        for (Planete nextPlanete : systemeSolaire.planetes) {
            System.out.println("La planète suivante en partant du soleil est " + nextPlanete.nom);
        }

        Vaisseau chasseur = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur.nbPassagers = 3;
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau croiseur = new VaisseauDeGuerre(TypeVaisseau.CROISEUR);
        croiseur.nbPassagers = 35;
        croiseur.blindage = 851;
        croiseur.resistanceDuBouclier = 25;

        Vaisseau fregate = new VaisseauDeGuerre(TypeVaisseau.FREGATE);
        fregate.nbPassagers = 100;
        fregate.blindage = 542;
        fregate.resistanceDuBouclier = 50;

        Vaisseau cargo = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo.nbPassagers = 10000;
        cargo.blindage = 1520;
        cargo.resistanceDuBouclier = 20;

        Vaisseau vaisseauMonde = new VaisseauCivil(TypeVaisseau.VAISSEAUMONDE);
        vaisseauMonde.nbPassagers = 10000;
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;

        Scanner sc = new Scanner(System.in);
        boolean recommencer = true;

        for (String constituant : mars.atmosphere.constituants.keySet()) {
            Float pourcentage = mars.atmosphere.constituants.get(constituant);
            System.out.println(pourcentage + "% de " + constituant);
        }

        while (recommencer) {
            System.out.println("Quel vaisseau souhaitez-vous manipuler : " + TypeVaisseau.CHASSEUR.name() + ", " + TypeVaisseau.FREGATE.name() + ", " + TypeVaisseau.CROISEUR.name() + ", " + TypeVaisseau.CARGO.name() + " ou " + TypeVaisseau.VAISSEAUMONDE.name() + " ?");
            String typeVaisseauString = sc.nextLine();
            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(typeVaisseauString);
            Vaisseau vaisseauSelectionne = null;
            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseauSelectionne = chasseur;
                    break;
                case FREGATE:
                    vaisseauSelectionne = fregate;
                    break;
                case CROISEUR:
                    vaisseauSelectionne = croiseur;
                    break;
                case CARGO:
                    vaisseauSelectionne = cargo;
                    break;
                case VAISSEAUMONDE:
                    vaisseauSelectionne = vaisseauMonde;
                    break;
            }

            System.out.println("Sur quelle planète tellurique du système solaire voulez-vous vous poser ?");
            String nomPlanete = sc.nextLine();
            Planete planeteSelectionnee = null;

            for (Planete planete : systemeSolaire.planetes) {
                if (planete.nom.equals(nomPlanete)) {
                    planeteSelectionnee = planete;
                }
            }

            if (planeteSelectionnee == null) {
                System.out.println("Aucune planète trouvée");
            }

            if (planeteSelectionnee instanceof PlaneteTellurique) {
                System.out.println("Quel tonnage souhaitez-vous emporter ?");
                int tonnageSouhaite = sc.nextInt();
                sc.nextLine();

                if (((PlaneteTellurique) planeteSelectionnee).restePlaceDisponible(vaisseauSelectionne)) {
                    ((PlaneteTellurique) planeteSelectionnee).accueillirVaisseaux(vaisseauSelectionne);
                    try {
                      vaisseauSelectionne.emporterCargaison(tonnageSouhaite);
                    } catch (DepassementTonnageException dte) {
                      System.out.println("Le vaisseau a rejeté : " + dte.tonnageEnExces + " tonnes.");
                      System.out.println("Voulez-vous emporter un tonnage partiel à hauteur de " + tonnageSouhaite - dte.tonnageEnExces+ "oui / non ");
                    }
                    System.out.println("Le vaisseau a rejeté : " + vaisseauSelectionne.emporterCargaison(tonnageSouhaite) + " tonnes.");
                } else {
                    System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie.");
                }
            } else {
                System.out.println("La planète sélectionnée n'est pas une planète tellurique");
            }
            System.out.println("Voulez-vous recommencer oui/non ?");
            recommencer = sc.nextLine().equalsIgnoreCase("oui");
        }
        sc.close();
    }
}
