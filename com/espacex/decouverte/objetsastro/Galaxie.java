package com.espacex.decouverte.objetsastro;
import java.util.TreeSet;


public class Galaxie {
  String nom;
  public TreeSet <Planete> planetes;

  public Galaxie(String nom){
    this.nom = nom;
    this.planetes = new TreeSet<Planete>();
  }

  public void ajouterPlanete(Planete planete){
    planetes.add(planete);
  }
}
