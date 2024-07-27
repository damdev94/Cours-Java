public class VaisseauDeGuerre extends Vaisseau {

  boolean armesDesactivees = false;

  void attaque(Vaisseau vaisseauCible, String arme, int duree){
    if(armesDesactivees){
      System.out.println("Attaque impossible, l'armement est désactivé");
    }
    else {
      System.out.println("Un vaisseau de type "+type+" attaque un vaisseau de type "+vaisseauCible.type+" en utilisant l'arme "+arme+" pendant "+duree+" minutes.");
      vaisseauCible.resistanceDuBouclier=0;
      vaisseauCible.blindage=vaisseauCible.blindage/2;
    }
  }

  void desactiverArmes(){
    armesDesactivees = true;
    System.out.printf("Désactivation des armes d'un vaisseau de type %s", type);
  }

  void activerBouclier(){
    this.desactiverArmes();
    super.activerBouclier();
  }

  void emporterCargaison(int tonnage) {
    if(type == "CHASSEUR"){
      System.out.println("le vaiseau de type "+type+" de ne prend pas de cargaison ");
      System.out.println("La quantitée refusée est de "+tonnage);
    }

    if (nbPassagers >= 12){

      int tonnageCapable = nbPassagers * 2;

      if(type.equals("FREGATE")){
        tonnageMax = 50;
        tonnageActuel += tonnage;

        if(tonnageCapable > tonnageMax){
          tonnageCapable = tonnageMax;
        }

        if(tonnageActuel <= tonnageCapable) {
          System.out.printf(" le tonnage actuel est de "+tonnageActuel+"/"+tonnageCapable);
        }
        else {
          System.out.printf(" le tonnage est au dessus de du max de "+tonnageActuel+"/"+tonnageCapable);
          System.out.println(" La quantité rejetée est de " + (tonnageActuel - tonnageCapable));
        }
      }

      if(type.equals("CROISEUR")){
        tonnageMax = 100;
        tonnageActuel += tonnage;

        if(tonnageCapable > tonnageMax){
          tonnageCapable = tonnageMax;
        }

        if(tonnageActuel < tonnageCapable) {
          System.out.printf("le tonnage actuel est de "+tonnageActuel+"/"+tonnageCapable);
        }
        else {
          System.out.printf(" le tonnage est au dessus de du max de "+tonnageActuel+"/"+tonnageCapable);
          System.out.println(" La quantité rejetée est de " + (tonnageActuel - tonnageCapable));
        }
      }
    }

    if(type != "CHASSEUR" && nbPassagers < 12){
      System.out.println(" le vaisseau de ne prend pas de cargaison car son nombre de passagés est inférieur a 12.");
      System.out.println("La quantitée refusée est de "+tonnage);
    }
  }
}
