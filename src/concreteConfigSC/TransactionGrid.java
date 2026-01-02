package concreteConfigSC;
/************************************
 *  Author: Tomasz Górski
 *  e-mail: tomasz.gorski@ieee.org
 ************************************/
public final class TransactionGrid extends Transaction {
    private int energySubnetID;
    public TransactionGrid(double quantity, double sSurplus, double tNeed, double targetProduction, double targetBatteryEnergySurplus, int sID, int tID, int energySID) {
        super(quantity, sSurplus, tNeed, targetProduction, targetBatteryEnergySurplus, sID, tID);
        this.energySubnetID = energySID;
    }
    public int getEnergySubnetID() {
        return energySubnetID;
    }
}
