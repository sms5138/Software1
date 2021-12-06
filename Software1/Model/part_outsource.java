package Software1.Model;

public class part_outsource extends Part{

    // this overrides the name from the Part model being used.
    private String comapnyName;

    public part_outsource(int id, String name, double price, int stock, int min, int max, String comapnyName) {
        super(id, name, price, stock, min, max);
        this.comapnyName = comapnyName;
    }

    public String getComapnyName(){
        return comapnyName;
    }
    
    public void setCompanyName(String comapnyName) {
        this.comapnyName = comapnyName;
    }
}
