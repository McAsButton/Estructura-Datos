
package Controller;

import Model.Elector;

abstract class ContractController {
    
    abstract boolean register(Elector objElector);
    abstract String seek(String idContract);
}
