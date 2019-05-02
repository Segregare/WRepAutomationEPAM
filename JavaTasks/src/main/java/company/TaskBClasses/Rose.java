package company.TaskBClasses;

class Rose extends Flower {

    Rose(int freshness, int stemLength, int price) {
        super(freshness, stemLength, price);
    }

    Rose() {
        super(4,(int)(30 + (Math.random() * 20)), 3);
    }

    @Override
    public String toString(){
        String day = " day";
        if(getFreshness() > 1){
            day = " days";
        }
        return "This Rose freshness is " + getFreshness() + day + ", stem length is " + getStemLength() + " cm., " +
                "price:" + " $" + getPrice() + ". \n";
    }
}