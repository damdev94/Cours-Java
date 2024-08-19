package com.espacex.decouverte.enginsspatiaux;
public class VaisseauDeGuerre extends Vaisseau {

  private boolean armesDesactivees;

  public VaisseauDeGuerre(TypeVaisseau type){
      super(type);
      if (type == TypeVaisseau.CHASSEUR){
          tonnageMax=0;
      }
      else if (type ==  TypeVaisseau.FREGATE){
          tonnageMax=50;
      }
      else if (type == TypeVaisseau.CROISEUR){
          tonnageMax=100;
      }

  }

  void attaque(Vaisseau vaisseauCible, String arme, int duree) {
      if (armesDesactivees) {
          System.out.println("Attaque impossible, l'armement est désactivé");
      } else {
          System.out.println("Un vaisseau de type " + type + " attaque un vaisseau de type " + vaisseauCible.type + " en utilisant l'arme " + arme + " pendant " + duree + " minutes.");
          vaisseauCible.resistanceDuBouclier = 0;
          vaisseauCible.blindage = vaisseauCible.blindage / 2;
      }
  }

  public void desactiverArmes() {
      System.out.println("Désactivation des armes d'un vaisseau de type " + type);
      armesDesactivees = true;
  }

  public void activerArmes() {
    System.out.println(("Activation des armes d'un vaisseau de type " + type));
    armesDesactivees = false ;
  }

  void activerBouclier(){
      System.out.println("Activation du bouclier d'un vaisseau de type "+type+".");
      desactiverArmes();
  }

  public void emporterCargaison (int cargaison) throws DepassementTonnageException{
if (type.equals("CHASSEUR")){
          return;
      }
      else {
          if (nbPassagers<12){
              return;
          }
          else {
              int tonnagePassagers=nbPassagers*2;
              int tonnageRestant=tonnageMax-tonnageActuel;
              int tonnageAConsiderer=(tonnagePassagers<tonnageRestant ? tonnagePassagers : tonnageRestant);
              if (cargaison>tonnageAConsiderer){
                  int tonnageEnExces = cargaison - tonnageAConsiderer;
                  throw new DepassementTonnageException(tonnageEnExces);
              }
              else {
                  tonnageActuel+=cargaison;
                  return;
              }
          }
      }
}
}
