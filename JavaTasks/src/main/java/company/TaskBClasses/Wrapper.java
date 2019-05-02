package company.TaskBClasses;

class Wrapper extends Accessory {

    Wrapper(int price) {
        super(price);
    }

    Wrapper(){
        super(1);
    }

    @Override
    public String toString(){
        return "Wrapper. Price: $" + getPrice() + ". \n";
    }
}