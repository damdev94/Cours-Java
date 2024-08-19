package com.espacex.decouverte.enginsspatiaux;

public abstract class Vaisseau {
  public final TypeVaisseau type;
  public int nbPassagers;
  public int resistanceDuBouclier;
  public int blindage;
  public int tonnageMax;
  protected int tonnageActuel;

  void activerBouclier(){
      System.out.println("Activation du bouclier d'un vaisseau de type "+type.nom+".");
  }

  void desactiverBouclier(){
      System.out.println("Désactivation du bouclier d'un vaisseau de type "+type.nom+".");
  }

  public abstract void emporterCargaison(int tonnage) throws DepassementTonnageException;

  public Vaisseau (TypeVaisseau type){
    this.type =  type;
  }
}
