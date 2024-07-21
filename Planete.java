public class Planete {
  String nom;
  int diametre;
  String matiere;
  int totalVisiteurs;
  String typeDeVaisseauSurSite;
  Atmosphere atmosphere;
  Vaisseau vaisseau;
  boolean vaisseauSurSite = false;

  int revolution(int degres){
      System.out.println("Je suis la planète "+nom+" et je tourne autour de mon étoile de "+degres+" degrés.");
      return degres/360;
  }

  int rotation(int degres){
      System.out.println("Je suis la planète "+nom+" et je tourne sur moi-même de "+degres+" degrés.");
      return degres/360;
  }

  void accueillirVaisseau(Vaisseau vaisseau){

    if(vaisseauSurSite == false) {
      if (vaisseau.typeDeVaisseau.equals("CHASSEUR")){
        totalVisiteurs += vaisseau.NbPassagers;
        typeDeVaisseauSurSite = "CHASSEUR";
        vaisseauSurSite = true;
      }
      else if (vaisseau.typeDeVaisseau.equals("FREGATE")){
        totalVisiteurs += vaisseau.NbPassagers;
        typeDeVaisseauSurSite = "FREGATE";
        vaisseauSurSite = true;
      }
      else if (vaisseau.typeDeVaisseau.equals("CROISEUR")){
        totalVisiteurs += vaisseau.NbPassagers;
        typeDeVaisseauSurSite = "CROISEUR";
        vaisseauSurSite = true;
      }
    }else {
      System.out.printf("Un vaisseau de type %s est déjà sur site.", typeDeVaisseauSurSite);
    }
  }

  void departVaisseau() {
    vaisseauSurSite = false;
    System.err.printf("Le vaisseau de type %s a quitté le site.", typeDeVaisseauSurSite);
    typeDeVaisseauSurSite = null;
  }
}
