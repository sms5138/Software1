package Software1.Model;

public class part_outsource extends Part{

    // this overrides the name from the Part model being used.
    private String ThirdPartyName;

    public part_outsource(int id, String name, double price, int stock, int min, int max, String ThirdPartyName) {
        super(id, name, price, stock, min, max);
        this.ThirdPartyName = ThirdPartyName;
    }

    public String get3rdPartyName(){
        return ThirdPartyName;
    }
    
}
