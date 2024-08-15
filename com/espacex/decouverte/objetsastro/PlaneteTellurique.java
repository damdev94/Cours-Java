package com.espacex.decouverte.objetsastro;
import com.espacex.decouverte.enginsspatiaux.Vaisseau;
import com.espacex.decouverte.enginsspatiaux.VaisseauCivil;
import com.espacex.decouverte.enginsspatiaux.VaisseauDeGuerre;

public class PlaneteTellurique extends Planete implements Habitable{

  Vaisseau[][] vaisseauxAccostes;
  int totalVisiteurs;

  public PlaneteTellurique(String nom, int nbPlacesBaie) {
      super(nom);
      vaisseauxAccostes=new Vaisseau[2][nbPlacesBaie];
  }

  public boolean restePlaceDisponible(Vaisseau typeOfVaisseau){

    if(typeOfVaisseau instanceof VaisseauDeGuerre)
      for (int i=0 ; i<vaisseauxAccostes.length ; i++){
          if (vaisseauxAccostes[0][i]==null){
              return true;
          }
      }
      else if (typeOfVaisseau instanceof VaisseauCivil){
        for (int i=0 ; i<vaisseauxAccostes.length ; i++){
          if (vaisseauxAccostes[1][i]==null){
              return true;
          }
        }
      }
      return false;
  }

  public void accueillirVaisseaux(Vaisseau... nouveauVaisseaux){

    for(int i=0; i < nouveauVaisseaux.length; i++){
      if (nouveauVaisseaux[i] instanceof VaisseauDeGuerre){
        ((VaisseauDeGuerre)nouveauVaisseaux[i]).desactiverArmes();
        totalVisiteurs+=nouveauVaisseaux[i].nbPassagers;

        for (int index=0 ; index<vaisseauxAccostes[0].length ; index++){
          if (vaisseauxAccostes[0][index]==null){
              vaisseauxAccostes[0][index]=nouveauVaisseaux[i];
              break;
            }
          }
    }
    else {

      totalVisiteurs+=nouveauVaisseaux[i].nbPassagers;

      for (int index=0 ; index<vaisseauxAccostes[1].length ; index++){
        if (vaisseauxAccostes[1][index]==null){
            vaisseauxAccostes[1][index]=nouveauVaisseaux[i];
            break;
          }
        }
    }

    }
  }
}
