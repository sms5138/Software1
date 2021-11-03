package Software1.Model;

public class product_inhouse extends Product{
        // this is just for example currently and is not being used.
        private int inhouse_id;

        public product_inhouse(int id, String name, double price, int stock, int min, int max, int inhouse_id) {
            super(id, name, price, stock, min, max);
            this.inhouse_id = inhouse_id;
        }
    
        public int GetInhouseID(){
    
            return inhouse_id;
        }
}
