public class Klammernkette_Komm {
  private Klammer ersteKlammer;
  
  public Klammernkette_Komm() {    
    this.ersteKlammer = null;
  }
    
  public void vorneEinfuegen(Klammer k){
    k.naechste = this.ersteKlammer;
    this.ersteKlammer = k;
  }
  
  public void vorneEntfernen() {
    Klammer merken = this.getErsteK();
    this.ersteKlammer = merken.naechste;
    merken.naechste = null;
  } 
 
  public int laenge() {
    int zaehler = 0;
    Klammer aktuellek = this.ersteKlammer;
    while (aktuellek!= null) { 
      zaehler++; 
      aktuellek = aktuellek.naechste;
    } 
    return zaehler;   
  }

  public int getLaengeRekusiv(){
    if (ersteKlammer==null){
      return 0;
    }
    return getLaengeRekusiv(ersteKlammer);
  }

  private int getLaengeRekusiv(Klammer k){
    if(k.naechste==null){
      return 1;
    }
    return 1+this.getLaengeRekusiv(k.naechste);
  }


  public Klammer getLetzteKlammerRek(Klammer k){
    if (k.naechste!=null) return getLetzteKlammerRek(k.naechste);
    return k;
  }

  public Klammer findKlammerReku(String farbe,Klammer k){
    if (k.naechste!=null  && !farbe.equalsIgnoreCase(k.getFarbe())){
      return findKlammerReku(farbe,k.naechste);
    }
    return k;
  }

  
  public Klammer getErsteK(){
    return this.ersteKlammer;
  } 
  
  public Klammer getAnPos(int i) {    
    Klammer merker = null;
    int zaehler = 0;
    if (i>this.laenge() || i<=0) {
      return merker;
    } else {
      merker = this.ersteKlammer;
      zaehler++;
      while (zaehler<i) { 
        merker = merker.naechste;
        zaehler++;
      } 
      return merker;
    } 
  }  

          //Suche
  public int istEnthaltenAnPos(String farbe){
    int zaehler = 1;
    Klammer merker=this.ersteKlammer;
    for (int i = 1; i < this.laenge(); i++) {
      if (merker.getFarbe().equalsIgnoreCase(farbe)) {
        break;
      } else {
        merker = merker.naechste;
        zaehler = i;
      } 
    }
    return zaehler;
  }
  
  public String toString() {
    String ausgabe;
    Klammer merker=this.ersteKlammer;
    ausgabe = "Laenge: "+this.laenge()+"\n";
    ausgabe=ausgabe+"Erste Klammer: "+merker.getFarbe()+"\n";
    for (int i=1;i<this.laenge();i++) {
      merker = merker.naechste;
      ausgabe =ausgabe+"Naechste Klammer: " + merker.getFarbe()+"\n";
    } 
    return ausgabe;
  }
  //Klammern hintereinander ausgeben: 
  //In for-Schleife einen String aus den Klammerfarben bilden 
  
  
  public boolean einfuegenAnPos(int i, Klammer k){
    if (i<0||i>this.laenge()) {
      return false;                //i auﬂerhalb vom Wertebereich
    } 
    int zaehler=0;
    Klammer merker= this.ersteKlammer;
    if (merker == null|| i==0) {   // Falls die Liste leer ist ( merker also this.ersteKlammer = null) 
      //oder der Parameter i=0, dann wird die Klammer vorne eingefuegt
      this.vorneEinfuegen(k);    
      return true; 
      
    } else {
      while (zaehler < i-1) {     //Der Merker sucht die Klammer vor dem gesuchten Index i und merkt sich diese  
        zaehler++;
        merker = merker.naechste;
      } 
      k.naechste = merker.naechste; //Die restliche Liste wird an k angeh‰ngt
      merker.naechste = k;          //Der vordere Teil der Liste wird mit k verkn¸pft
      //Hiermit kann auch am Ende eingef¸gt werden
      return true;
    }     
  }

  public boolean lexorafischEinfuegen(Klammer k1){
    int pos=0;
    Klammer temp=ersteKlammer;
    while ((temp!=null)&&(temp.getFarbe().compareTo(k1.getFarbe())<0)){
      temp=temp.naechste;
      pos++;
    }
    einfuegenAnPos(pos,k1);
    return true;
  }

  public void enfernenAnPos(int pos){
    Klammer temp=ersteKlammer;
    int counter=0;
    
    if (ersteKlammer==null){
      // nix machen
    } else if (pos>laenge()){
        System.out.println("Fehler falscher index");
      } else if (pos==0){
          ersteKlammer=ersteKlammer.naechste; //Sauber ausketten vergessen
        }else {
          while ((counter < pos - 1)) {
            counter++;
            temp = temp.naechste;
          }
          Klammer speicher = temp;
          speicher.naechste = temp.naechste.naechste;
          
        }
  }
  
  //Methode hinteneinf¸gen implementieren mittels Aufrufen der obigen 
  //Methode f¸r i = this.laenge(), siehe auch Kommentar in Zeile 97

}

