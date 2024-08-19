package com.espacex.decouverte.enginsspatiaux;

public class DepassementTonnageException extends Exception  {

  public int tonnageEnExces;

  public DepassementTonnageException(int tonnageEnExces) {
    this.tonnageEnExces = tonnageEnExces;
    System.err.println("La cargaison ne peut être chargée car elle présente un excès de " + tonnageEnExces);
  }

}
