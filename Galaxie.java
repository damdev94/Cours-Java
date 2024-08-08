import java.util.ArrayList;

public class Galaxie {
  String nom;
  ArrayList<Planete> planetes;

  Galaxie(String nom){
    this.nom = nom;
    this.planetes = new ArrayList<>();
  }

  void AjouterPlanete(Planete planete){
    planetes.add(planete);
  }
}
