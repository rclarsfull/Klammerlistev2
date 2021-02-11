public class Klammer {
  private String farbe;
  public Klammer naechste;
  public Klammer (String farbe) {
    this.farbe = farbe;
  }
  
  public String getFarbe() {
    return this.farbe;
  }

  @Override
  public String toString() {
    return "Klammer{" +
            "farbe='" + farbe + '\'' +
            '}';
  }
}
