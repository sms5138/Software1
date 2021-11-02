package Software1.Model;

public class part_outsource extends Part{

    // this overrides the name from the Part model being used.
    private String name;

    public part_outsource(int id, String name, double price, int stock, int min, int max, String outsource_name) {
        super(id, name, price, stock, min, max);
        this.name = outsource_name;
    }

    public String getName(){
        return name;
    }
    
}