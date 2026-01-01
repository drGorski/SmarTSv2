package testSC;

import concreteConfigSC.ExchangeEnergyContract;
import concreteConfigSC.TransactionIn;
import concreteConfigSC.TransactionCross;
import concreteConfigSC.TransactionGrid;
import smarTSv2.AbstractConfigSC;
import smarTSv2.AbstractTestConfigSC;
import smarTSv2.AbstractTransaction;
import java.util.ArrayList;
public class TestExchangeEnergySC extends AbstractTestConfigSC {
    public void initiateTransactions() {
        transactions.clear();
        for (int i = 0; i <= 2; i++) transactions.add(new ArrayList<>());
        // TransactionIn
        transactions.get(0).add(new TransactionIn(500.0, 1000.0, 2500.0, 0.0, 10.0, 100, 200));
        transactions.get(0).add(new TransactionIn(500.0, 1000.0, 2500.0, 0.0, 10.0, 100, 100));
        transactions.get(0).add(new TransactionIn(0.0, 1000.0, 2500.0, 0.0, 10.0, 100, 200));
        transactions.get(0).add(new TransactionIn(500.0, 100.0, 2500.0, 0.0, 10.0, 100, 200));
        // TransactionGrid
        transactions.get(1).add(new TransactionGrid(500.0, 1000.0, 2500.0, 0.0, 10.0, 100, 2000, 2000));
        transactions.get(1).add(new TransactionGrid(500.0, 1000.0, 2500.0, 0.0, 10.0, 2000, 2000, 2000));
        transactions.get(1).add(new TransactionGrid(0.0, 1000.0, 2500.0, 0.0, 10.0, 100, 2000, 2000));
        transactions.get(1).add(new TransactionGrid(500.0, 100.0, 2500.0, 0.0, 10.0, 100, 2000, 2000));
        transactions.get(1).add(new TransactionGrid(500.0, 1000.0, 2500.0, 0.0, 10.0, 100, 2000, 3000));
        // TransactionCross
        transactions.get(2).add(new TransactionCross(500.0, 1000.0, 2500.0, 0.0, 10.0, 100, 200, 1000, 2000));
        transactions.get(2).add(new TransactionCross(500.0, 1000.0, 2500.0, 0.0, 10.0, 100, 200, 2000, 2000));
        transactions.get(2).add(new TransactionCross(500.0, 1000.0, 2500.0, 0.0, 10.0, 100, 100, 1000, 2000));
        transactions.get(2).add(new TransactionCross(0.0, 1000.0, 2500.0, 0.0, 10.0, 100, 200, 1000, 2000));
        transactions.get(2).add(new TransactionCross(500.0, 100.0, 2500.0, 0.0, 10.0, 100, 200, 1000, 2000));
        transactions.get(2).add(new TransactionCross(500.0, 1000.0, 250.0, 0.0, 10.0, 100, 200, 1000, 2000));
    }
    public void runTest(AbstractConfigSC sC, AbstractTransaction tR, int trNumber, boolean expectedResult){
        boolean result = sC.checkSC(tR);
        boolean correct = result == expectedResult;
        System.out.println("Test no: " + (trNumber + 1) + ", transaction: " + tR.getClass() + ", test result: " + ((correct)?"PASS":"FAIL"));
    }
    public void runTest(ExchangeEnergyContract sC, TransactionGrid tR, int trNumber, boolean expectedResult) {
        boolean result = sC.checkSC(tR);
        boolean correct = result == expectedResult;
        System.out.println("Test no: " + (trNumber + 1) + ", transaction: " + tR.getClass() + ", test result: " + ((correct) ? "PASS" : "FAIL"));
    }
    public void runTest(ExchangeEnergyContract sC, TransactionCross tR, int trNumber, boolean expectedResult) {
        boolean result = sC.checkSC(tR);
        boolean correct = result == expectedResult;
        System.out.println("Test no: " + (trNumber + 1) + ", transaction: " + tR.getClass() + ", test result: " + ((correct) ? "PASS" : "FAIL"));
    }
    public void runTestSuite(ExchangeEnergyContract sC) {
        System.out.println("Smart contract: " + sC.getClass());
        for (ArrayList<AbstractTransaction> list : transactions) {
            if (list.get(0) instanceof TransactionIn) {
                for (int i = 0; i < list.size(); i++) {
                    runTest(sC, list.get(i), i, i == 0);
                }
            } else if (list.get(0) instanceof TransactionGrid) {
                for (int i = 0; i < list.size(); i++) {
                    runTest(sC, (TransactionGrid) list.get(i), i, i == 0);
                }
            } else if (list.get(0) instanceof TransactionCross) {
                for (int i = 0; i < list.size(); i++) {
                    runTest(sC, (TransactionCross) list.get(i), i, i == 0);
                }
            }
        }
    }
}