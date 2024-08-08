
package model;


public class Elector extends Contract  {

    private String peopleType;
    
    public Elector() {
    }

    public Elector(String nroContract, String date, String description, String peopleType) {
        super(nroContract, date, description);
        
        this.peopleType = peopleType;
    }
    

    @Override
    public boolean register(Contract objContract) {
        return true;
    }
    
}
