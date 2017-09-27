
package afvink3;


public class Class {
   
    private String naam;
    private int nummer;
    
    public Class(String naam, int nummer) {
        this.naam = naam;
        this.nummer = nummer;
    }
    
    public Class(String studnaam) {
        naam = studnaam;
    }
    
    public Class(int studnummer){
        nummer = studnummer;
    }
    
        public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    
    public void printInfo(){
        System.out.println("Hoihoi " + getNaam()+ " je studentnummer is " + getNummer());
    }   
}