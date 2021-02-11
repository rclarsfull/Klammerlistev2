public class TestklasseKlammernkette {
  public static void main(String[] args) {
    
    Klammernkette_Komm liste1 = new Klammernkette_Komm(); 
    
    Klammer k1 = new Klammer("gelb");
    Klammer k2 = new Klammer("rot");
    Klammer k3 = new Klammer("blau");
    Klammer k4 = new Klammer("weiss");
    
    liste1.vorneEinfuegen(k1);
    liste1.vorneEinfuegen(k2);
    liste1.vorneEinfuegen(k3);

    Klammer k5 =new Klammer("aaaaaaaaaaa");
    Klammer k6 =new Klammer("xxxxxxxxxxxxxxx");
    Klammer k7 =new Klammer("xxxxxxxxdfdsxxxxxxx");

    liste1.lexorafischEinfuegen(k5);
    liste1.lexorafischEinfuegen(k6);
    liste1.lexorafischEinfuegen(k7);

    System.out.println(liste1.toString());
    
                //3 ist dann die Position/der Index der neuen Klammer k4
    System.out.println(liste1.einfuegenAnPos(3,k4));
    
    
    System.out.println("Entfernen");
    System.out.println(liste1.toString());

    liste1.enfernenAnPos(3);
    System.out.println(liste1.toString());
    liste1.enfernenAnPos(0);
    System.out.println(liste1.toString());
    liste1.enfernenAnPos(4);
    System.out.println(liste1.toString());
    liste1.enfernenAnPos(6);
    System.out.println(liste1.toString());
    System.out.println("\n\n\n");
    System.out.println(liste1.laenge());
    System.out.println(liste1.getLaengeRekusiv());
    System.out.println("\n\n\n");
    System.out.println(liste1.getLetzteKlammerRek(liste1.getErsteK()).toString());
    System.out.println(liste1.findKlammerReku("rot",liste1.getErsteK()).toString());
  }
}
