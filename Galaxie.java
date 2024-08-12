import java.util.Set;
import java.util.HashSet;


public class Galaxie {
  String nom;
  Set <Planete> planetes;

  Galaxie(String nom){
    this.nom = nom;
    this.planetes = new HashSet<Planete>();
  }

  void AjouterPlanete(Planete planete){
    planetes.add(planete);
  }
}
