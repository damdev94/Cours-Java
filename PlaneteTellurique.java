
public class PlaneteTellurique extends Planete implements Habitable{

  Vaisseau vaisseauAccoste;
  int totalVisiteurs;
  Vaisseau [] baie;

  public PlaneteTellurique(String nom, int tailleDeLaBaie) {
      super(nom);
      this.baie = new Vaisseau[tailleDeLaBaie];
  }

  boolean restePlaceDisponible(){
    for(int i = 0; i < baie.length; i++){
      if(baie[i] == null){
        return true;
      }
    }
    return false;
  }

  public void accueillirVaisseau(Vaisseau nouveauVaisseau) {

    if (nouveauVaisseau instanceof VaisseauDeGuerre) {
        ((VaisseauDeGuerre) nouveauVaisseau).desactiverArmes();
    }

    totalVisiteurs += nouveauVaisseau.nbPassagers;

    if (restePlaceDisponible()) {
        for (int i = 0; i < baie.length; i++) {
            if (baie[i] == null) {
                baie[i] = nouveauVaisseau;
                break;
            }
        }
    }
    else {
      System.out.println("Le vaisseau " + nouveauVaisseau.type.nom + " ne peut pas se poser sur la planète par manque de place dans la baie.");
    }
}

}
