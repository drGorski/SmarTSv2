package smarTSv2;

import java.util.ArrayList;
public abstract class AbstractTestConfigSC {
    protected ArrayList<ArrayList<AbstractTransaction>> transactions = new ArrayList<>();
    public AbstractTestConfigSC(){
        initiateTransactions();
    }
    protected abstract void initiateTransactions();
}
