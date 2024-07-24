public class HelloUniverse {

  public static void main(String... args) {
      Planete mercure = new Planete("Mercure");
      mercure.diametre = 4880;
      mercure.matiere = "Tellurique";
      Planete venus = new Planete("Venus");
      venus.diametre = 12100;
      venus.matiere = "Tellurique";
      Planete terre = new Planete("Terre");
      terre.diametre = 12756;
      terre.matiere = "Tellurique";
      Planete mars = new Planete("Mars");
      mars.diametre = 6792;
      mars.matiere = "Tellurique";
      Planete jupiter = new Planete("Jupiter");
      jupiter.diametre = 142984;
      jupiter.matiere = "Gazeuse";
      Planete saturne = new Planete("Saturne");
      saturne.diametre = 120536;
      saturne.matiere = "Gazeuse";
      Planete uranus = new Planete("Uranus");
      uranus.diametre = 51118;
      uranus.matiere = "Gazeuse";
      Planete neptune = new Planete("Neptune");
      neptune.diametre = 49532;
      neptune.matiere = "Gazeuse";
  }

}
