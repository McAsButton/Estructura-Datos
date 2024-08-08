package objectarraynight;

import java.util.Scanner;
import Model.Elector;
import Controller.ElectorController;

public class ObjectArrayNight {

    static Scanner scan = new Scanner(System.in);
    static ElectorController objElectorController = new ElectorController();

    public static void main(String[] args) {
        contractRegister();
        contractSeek();
    }

    private static void contractRegister() {
        char sw;

        do {
            System.out.println("\nIngrese el número de contrato: ");
            String nroContract = scan.next();

            System.out.println("Ingrese la fecha del contrato: ");
            String dateContract = scan.next();

            System.out.println("Ingrese la descripcion del contrato: ");
            String despContract = scan.next();

            System.out.println("Digite A para contratar a un Administrador "
                    + "Digite E para contratar a un Elector"
                    + "Digite D para contratar a un Director de Departamento");
            char opc = scan.next().toUpperCase().charAt(0);

            switch (opc) {
                case 'A': {

                    break;
                }
                case 'E': {
                    System.out.println("Ingrese el tipo de poblacion al que pertenece: ");
                    String peopleType = scan.next();

                    Elector objElector = new Elector(nroContract, dateContract, despContract, peopleType);

                    if (objElectorController.register(objElector)) {
                        System.out.println("\nEl contrato se ha ingresado correctamente!!..");
                    } else {
                        System.out.println("\nEl contrato no se logro registrar. Verifique!!...");
                    }
                    break;
                }
                case 'D': {

                    break;
                }
                default: {
                    System.out.println("No diguito la opción adecuada. Verifique!!...");
                    break;
                }
            }

            System.out.println("Desea ingresar otro contrato (S/N): ");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    private static void contractSeek() {
        System.out.println("\nConsultar contratos");
        System.out.println("Digite A para contratar a un Administrador "
                + " Digite E para contratar a un Elector"
                + " Digite D para contratar a un Director de Departamento");
        char opc = scan.next().toUpperCase().charAt(0);

        switch (opc) {
            case 'A': {

                break;
            }
            case 'E': {
                System.out.println("Ingrese el numero del contrato: ");
                String idContract = scan.next();
                
                String result = objElectorController.seek(idContract);

                if ( result != "" ) {
                    System.out.println("\n" + result);
                } else {
                    System.out.println("\nNO se encontro el contrato. Verifique!!...");
                }
                break;
            }
            case 'D': {

                break;
            }
            default: {
                System.out.println("No diguito la opción adecuada. Verifique!!...");
                break;
            }

        }
    }
}

