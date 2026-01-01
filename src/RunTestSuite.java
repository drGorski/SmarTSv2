import concreteSC.InsuranceConclusionSC;
import concreteConfigSC.ExchangeEnergyContract;
import testSC.TestExchangeEnergySC;
import testSC.TestInsuranceConclusionSC;

public class RunTestSuite {
    public static void main(String[] args){
        // smart contracts and test classes
        TestExchangeEnergySC testEnergy = new TestExchangeEnergySC();
        ExchangeEnergyContract energySC = new ExchangeEnergyContract();
        TestInsuranceConclusionSC testInsurance = new TestInsuranceConclusionSC();
        InsuranceConclusionSC insuranceSC = new InsuranceConclusionSC();
        // tests for energy exchange smart contract (with configurations)
        testEnergy.runTestSuite(energySC);
        // tests for insurance smart contract
        testInsurance.runTestSuite(insuranceSC);
    }
}
