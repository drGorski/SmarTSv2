package smarTSv2;

import concreteConfigSC.ExchangeEnergyContract;

import java.util.ArrayList;
public abstract class AbstractTestConfigSC {
    protected ArrayList<ArrayList<AbstractTransaction>> transactions = new ArrayList<>();
    public AbstractTestConfigSC(){
        initiateTransactions();
    }
    protected abstract void initiateTransactions();
    protected void runTest(AbstractConfigSC sC, AbstractTransaction tR, int trNumber, boolean expectedResult){
        boolean result = sC.checkSC(tR);
        boolean correct = result == expectedResult;
        System.out.println("Test no: " + (trNumber + 1) + ", transaction: " + tR.getClass() + ", test result: " + ((correct)?"PASS":"FAIL"));
    }
    public abstract void runTestSuite(AbstractConfigSC sC);
}
