
package Model;

public class Elector extends Contract {
    
    private String peopleType;

    public String getPeopleType() {
        return peopleType;
    }
    
    public Elector(String nro, String date, String description, String peopleType) {
        super(nro, date, description);
        
        this.peopleType = peopleType;
    }
}
