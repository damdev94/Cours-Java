import java.util.Scanner;

import javax.xml.catalog.CatalogResolver;

public class HelloUniverse {

  static boolean exit = false;

    public static void main(String... args) {

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 4);
        mercure.diametre = 4880;
        PlaneteTellurique venus = new PlaneteTellurique("Venus", 5);
        venus.diametre = 12100;
        PlaneteTellurique terre = new PlaneteTellurique("Terre", 1);
        terre.diametre = 12756;
        PlaneteTellurique mars = new PlaneteTellurique("Mars", 0);
        mars.diametre = 6792;
        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;

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


        while (!exit) {

          System.out.println("Quel vaisseau souhaitez vous manipuler​ : CHASSEUR, FREGATE, CROISEUR, CARGO ou VAISSEAUMONDE ?");
          String vaisseauSelectionne = sc.nextLine();
          TypeVaisseau typevaisseau =  TypeVaisseau.valueOf(vaisseauSelectionne);
          Vaisseau vaisseau = null;
          switch (typevaisseau) {
              case CHASSEUR:
                  vaisseau = chasseur;
                  break;
              case FREGATE:
                  vaisseau = fregate;
                  break;
              case CROISEUR:
                  vaisseau = croiseur;
                  break;
              case CARGO:
                  vaisseau = cargo;
                  break;
              case VAISSEAUMONDE:
                  vaisseau = vaisseauMonde;
                  break;
          }

          System.out.println("Sur quelle planète tellurique du systeme solaire voulez-vous vous poser : Mercure, Venus, Terre ou Mars ?");
          String nomPlanete = sc.nextLine();
          PlaneteTellurique planeteSelectionnee = null;
          switch (nomPlanete) {
              case "Mercure":
                  planeteSelectionnee = mercure;
                  break;
              case "Venus":
                  planeteSelectionnee = venus;
                  break;
              case "Terre":
                  planeteSelectionnee = terre;
                  break;
              case "Mars":
                  planeteSelectionnee = mars;
                  break;

          }

          System.out.println("Quel tonnage souhaitez-vous emporter ?");
          int tonnageSouhaite = Integer.parseInt(sc.nextLine());

          planeteSelectionnee.accueillirVaisseau(vaisseau);
          System.out.println("Le vaisseau a rejeté : " + vaisseau.emporterCargaison(tonnageSouhaite) + " tonnes.");

          System.out.println("Voulez-vous recomencer ? oui ou non");
          String reponse = sc.nextLine();
          if (reponse.equals("non")) {
            exit = true;
          }
      }
      sc.close();
  }
}
