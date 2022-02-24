package Software1.Model;

public class part_outsource extends Part{

    // this overrides the name from the Part model being used.
    private String companyName;

    public part_outsource(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * 
     * @return the companyName
     */
    public String getComapnyName(){
        return companyName;
    }
    
    /**
     * 
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
