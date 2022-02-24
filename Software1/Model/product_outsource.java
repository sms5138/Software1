package Software1.Model;

public class product_outsource extends Product{
        // this overrides the name from the Product model being used.
        private String name;

        public product_outsource(int id, String name, double price, int stock, int min, int max, String outsource_name) {
            super(id, name, price, stock, min, max);
            this.name = outsource_name;
        }
    

        /**
         * 
         * @return the name
         */
        public String getName(){
            return name;
        }

        /**
         *  The name to be set
         * @param
         */
        public void setName(String name){
            this.name = name;
        }
}
