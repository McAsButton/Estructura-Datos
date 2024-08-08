
package Model;

abstract class Contract {
    protected String nro;
    protected String date;
    protected String description;
 
    public String getNro() {
        return nro;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Contract(String nro, String date, String description) {
        this.nro = nro;
        this.date = date;
        this.description = description;
    }
}
