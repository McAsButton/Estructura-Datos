
package model;

public class Manager extends Contract {

    public Manager() { }

    public Manager(String nroContract, String date, String description) {
        super(nroContract, date, description);
    }
    
    

    @Override
    public boolean register(Contract objContract) {
        return true;
    }
    
}
