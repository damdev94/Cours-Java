public class VaisseauCivil extends Vaisseau{

  void emporterCargaison(int tonnage){

    if(type == "CARGO"){
      tonnageMax = 500;
      tonnageActuel += tonnage;
      if(tonnageActuel < tonnageMax) {
        System.out.printf("le tonnage actuel est de "+tonnageActuel+"/"+tonnageMax);
      }
      else {
        System.out.printf("le tonnage est au dessus de du max de "+tonnageActuel+"/"+tonnageMax);
        System.out.println(" La quentitée rejetée est de "+ (tonnageActuel - tonnageMax));
      }
    }

    if(type == "VAISSEAU-MONDE"){
      tonnageMax = 2000;
      tonnageActuel += tonnage;
      if(tonnageActuel < tonnageMax) {
        System.out.printf("le tonnage actuel est de "+tonnageActuel+"/"+tonnageMax);
      }
      else {
        System.out.printf("le tonnage est au dessus de du max de "+tonnageActuel+"/"+tonnageMax);
        System.out.println(" La quentitée rejetée est de "+ (tonnageActuel - tonnageMax));
      }
    }

  }

}
