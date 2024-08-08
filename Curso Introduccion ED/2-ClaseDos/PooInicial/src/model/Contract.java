package model;

abstract class Contract {

    protected String nroContract;
    protected String date;
    protected String description;

    public Contract() {}

    public Contract(String nroContract, String date, String description) {
        this.nroContract = nroContract;
        this.date = date;
        this.description = description;
    }
    

    abstract boolean register(Contract objContract);

}
