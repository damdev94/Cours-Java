import java.util.Scanner;

public class HelloUniverse {

    public static void main(String... args) {

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;
        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        PlaneteTellurique terre = new PlaneteTellurique("Terre", 100);
        terre.diametre = 12756;

        PlaneteTellurique mars = new PlaneteTellurique("Mars", 5);
        mars.diametre = 6792;
        mars.atmosphere = new Atmosphere();
        mars.atmosphere.constituants.put("CO2", 95f);
        mars.atmosphere.constituants.put("N2", 3f);
        mars.atmosphere.constituants.put("AR", 1.5f);
        mars.atmosphere.constituants.put("NO", 0.013f);

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;


        Galaxie systemeSolaire = new Galaxie("system solaire");
        systemeSolaire.AjouterPlanete(mercure);
        systemeSolaire.AjouterPlanete(venus);
        systemeSolaire.AjouterPlanete(terre);
        systemeSolaire.AjouterPlanete(mars);
        systemeSolaire.AjouterPlanete(jupiter);
        systemeSolaire.AjouterPlanete(saturne);
        systemeSolaire.AjouterPlanete(uranus);
        systemeSolaire.AjouterPlanete(neptune);

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
          System.out.println(pourcentage +"% de " + constituant);
        }
       /*  while (recommencer) {
            System.out.println("Quel vaisseau souhaitez vous manipuler​ : " + TypeVaisseau.CHASSEUR.name() + ", " + TypeVaisseau.FREGATE.name() + ", " + TypeVaisseau.CROISEUR.name() + ", " + TypeVaisseau.CARGO.name() + " ou " + TypeVaisseau.VAISSEAUMONDE.name() + " ?");
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

            System.out.println("Sur quelle planète tellurique du systeme solaire voulez-vous vous poser ?");
            String nomPlanete = sc.nextLine();
            Planete planeteSelectionnee = null;
            planeteSelectionnee = null;
            for (Planete planete : systemeSolaire.planetes) {
              if (planete.nom.equals(nomPlanete)){
                planeteSelectionnee = planete;
              }
            }
            if(planeteSelectionnee == null) {
              System.out.println("aucune planete trouvé");
            }

            if(planeteSelectionnee instanceof PlaneteTellurique){

              System.out.println("Quel tonnage souhaitez-vous emporter ?");
              int tonnageSouhaite = sc.nextInt();
              sc.nextLine();

              if (((PlaneteTellurique) planeteSelectionnee).restePlaceDisponible(vaisseauSelectionne)) {
                ((PlaneteTellurique) planeteSelectionnee).accueillirVaisseaux(vaisseauSelectionne);
                System.out.println("Le vaisseau a rejeté : " + vaisseauSelectionne.emporterCargaison(tonnageSouhaite) + " tonnes.");
              }
              else {
                  System.out.println("Le vaisseau ne peut pas planeteSelectionneese poser sur la planète par manque de place dans la baie.");
              }
            }
            else {
              System.out.println("La planete selectionné n'est pas une planete tellurique ");
            }
              System.out.println("Voulez-vous recommencer oui/non ?");
            recommencer = sc.nextLine().equals("oui");
        } */
    }
}
