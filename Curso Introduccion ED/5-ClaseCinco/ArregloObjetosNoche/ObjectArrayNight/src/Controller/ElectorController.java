package Controller;

import Model.Elector;
import java.util.ArrayList;

public class ElectorController extends ContractController {

    ArrayList<Elector> listObjElectors = new ArrayList<Elector>();

    @Override
    public boolean register(Elector objElector) {
        boolean result = true;

        if (objElector != null) {
            listObjElectors.add(objElector);
            return result;
        } else {
            result = false;
            return result;
        }
    }

    @Override
    public String seek(String idContract) {
        String result = "";

        for (int i = 0; i < listObjElectors.size(); i++) {
            if (listObjElectors.get(i).getNro().equals(idContract)) {
                result = listObjElectors.get(i).getNro() + " - "
                        + listObjElectors.get(i).getDate() + " - "
                        + listObjElectors.get(i).getDescription() + " - "
                        + listObjElectors.get(i).getPeopleType();
                
                break;
            }
        }

        return result;
    }

}
