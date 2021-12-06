package Software1.Model;

public class part_inhouse extends Part{

    // this is just for example currently and is not being used.
    private int machineID;

    public part_inhouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        super(id, name, price, stock, min, max);
        this.machineID = machineID;
    }

    public int getMachineID(){

        return machineID;
    }
    
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}
