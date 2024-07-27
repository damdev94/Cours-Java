


public class HelloUniverse {

  public static void main(String... args) {

      PlaneteTellurique mercure = new PlaneteTellurique("Mercure");
      mercure.diametre = 4880;
      PlaneteTellurique venus = new PlaneteTellurique("Venus");
      venus.diametre = 12100;
      PlaneteTellurique terre = new PlaneteTellurique("Terre");
      terre.diametre = 12756;
      PlaneteTellurique mars = new PlaneteTellurique("Mars");
      mars.diametre = 6792;
      PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
      jupiter.diametre = 142984;
      PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
      saturne.diametre = 120536;
      PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
      uranus.diametre = 51118;
      PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
      neptune.diametre = 49532;

      Vaisseau chasseur = new VaisseauDeGuerre();
      chasseur.type = "CHASSEUR";
      terre.accueillirVaisseau(chasseur);
      chasseur.emporterCargaison(20);

      Vaisseau fregate1 = new VaisseauDeGuerre();
      fregate1.type = "FREGATE";
      fregate1.nbPassagers = 100;
      terre.accueillirVaisseau(fregate1);
      fregate1.emporterCargaison(45);
      fregate1.emporterCargaison(12);

      Vaisseau fregate2 = new VaisseauDeGuerre();
      fregate2.type = "FREGATE";
      fregate2.nbPassagers = 14;
      terre.accueillirVaisseau(fregate2);
      fregate2.emporterCargaison(30);

      Vaisseau vaisseau_monde = new VaisseauCivil();
      vaisseau_monde.type = "VAISSEAU-MONDE";
      terre.accueillirVaisseau(vaisseau_monde);
      vaisseau_monde.emporterCargaison(1560);
      vaisseau_monde.emporterCargaison(600);

  }

}
