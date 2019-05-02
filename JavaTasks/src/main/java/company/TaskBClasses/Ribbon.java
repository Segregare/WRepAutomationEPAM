package company.TaskBClasses;

class Ribbon extends Accessory {

    Ribbon(int price) {
        super(price);
    }

    Ribbon(){
        super(1);
    }

    @Override
    public String toString(){
        return "Ribbon. Price: $" + getPrice();
    }


}