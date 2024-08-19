package com.espacex.decouverte.enginsspatiaux;
public class VaisseauCivil extends Vaisseau {

  public VaisseauCivil(TypeVaisseau type) {
      super(type);
      if (type == TypeVaisseau.CARGO) {
          tonnageMax = 500;
      } else if (type == TypeVaisseau.VAISSEAUMONDE) {
          tonnageMax = 2000;
      }

  }

  public void emporterCargaison(int tonnage) throws DepassementTonnageException{

      int tonnageRestant = tonnageMax - tonnageActuel;
      if (tonnage > tonnageRestant) {
        int tonnageEnExces = tonnage - tonnageRestant;
        throw new DepassementTonnageException(tonnageEnExces);
      }
      tonnageActuel+=tonnage;
  }

}
