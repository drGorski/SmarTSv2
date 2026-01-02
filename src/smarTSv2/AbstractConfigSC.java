package smarTSv2;

import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;
/************************************
 *  Author: Tomasz Górski
 *  e-mail: tomasz.gorski@ieee.org
 ************************************/
public abstract class AbstractConfigSC {
    protected List<Predicate<AbstractTransaction>> rulesList = new ArrayList<>();
    protected List<List<Predicate<AbstractTransaction>>> configurations = new ArrayList<>();
    public AbstractConfigSC(){
        configurations.add(new ArrayList<>());
    }
    public boolean checkSC(AbstractTransaction tr){
        boolean correct = false;
        for (Predicate<AbstractTransaction> vR : configurations.get(0)) {
            correct = vR.test(tr);
            if (!correct) break;
        }
        return correct;
    }
}
