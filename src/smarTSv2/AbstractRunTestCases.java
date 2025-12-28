package pl.gdansk.ug.smarTS;

import java.util.ArrayList;
abstract class AbstractRunTestCases {
    private static void runTest(AbstractSmartContract sC, AbstractTransaction tR, int trNumber, boolean expectedResult){
        boolean result = sC.checkSC(tR);
        boolean correct = result == expectedResult;
        System.out.println("Test no: " + (trNumber + 1) + ", test result: " + ((correct)?"PASS":"FAIL"));
    }
    static void runTestSuite(AbstractSmartContract sC, ArrayList<AbstractTransaction> transactions){
        System.out.println("Smart contract class: " + sC.getClass());
        for (int i = 0; i < transactions.size(); i++){
            runTest(sC, transactions.get(i),i, i == 0);
        }
    }
}
