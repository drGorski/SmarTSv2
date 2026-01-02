package smarTSv2;

import java.util.List;
import java.util.function.Predicate;
/************************************
 *  Author: Tomasz Górski
 *  e-mail: tomasz.gorski@ieee.org
 ************************************/
public abstract class AbstractSC {
    // list of verification rules
    protected List<Predicate<AbstractTransaction>> rulesList;
    // checking the smart contract
    public final boolean checkSC(AbstractTransaction tr){
        boolean correct = false;
        for (Predicate<AbstractTransaction> vR : rulesList) {
            correct = vR.test(tr);
            if (!correct) break;
        }
        return correct;
    }
}
