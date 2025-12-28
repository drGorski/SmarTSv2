package pl.gdansk.ug.smarTS;

import java.util.ArrayList;
public abstract class AbstractTestSC {
    protected ArrayList<AbstractTransaction> transactions = new ArrayList<>();
    public AbstractTestSC(){
        initiateTransactions();
    }
    protected abstract void initiateTransactions();
    public final void runTestSuite(AbstractSmartContract sC){
        AbstractRunTestCases.runTestSuite(sC, transactions);
    }
}
