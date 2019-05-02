package company.TaskBClasses;

import java.util.ArrayList;

/**
 * Created by Andriy on 25.10.2016.
 */
class Bouquet {

    private ArrayList<Flower> flowers = new ArrayList<>();
    private ArrayList<Accessory> accessories = new ArrayList<>();
    private int price;

    Bouquet(int roses, int chrysanthemums, int dahlias, boolean wrapper, boolean ribbon) {
        for(int i = 0; i < roses; i++){
            flowers.add(new Rose());
        }
        for(int i = 0; i < chrysanthemums; i++){
            flowers.add(new Knapweed());
        }
        for(int i = 0; i < dahlias; i++){
            flowers.add(new Lilac());
        }
        if(wrapper){
            accessories.add(new Wrapper());
        }
        if(ribbon){
            accessories.add(new Ribbon());
        }
    }

    @Override
    public String toString(){
        String result = "My bouquet: \n";
        for(int i = 0; i < flowers.size(); i++){
            result += flowers.get(i);
        }
        for(int i = 0; i < accessories.size(); i++){
            result += accessories.get(i);
        }
        return result;
    }

    public ArrayList getFlowers(){
        return flowers;
    }

    public int getPrice(){
        int result = 0;
        for(int i = 0; i < flowers.size(); i++){
            result += flowers.get(i).getPrice();
        }
        for(int i = 0; i < accessories.size(); i++){
            result += accessories.get(i).getPrice();
        }
        return result;
    }

    public ArrayList sortFlowers() {
        for(int j = flowers.size() - 1; j >= 0; j--){
            for(int i = 0; i < j; i++){
                if(flowers.get(i).getFreshness() > flowers.get(i + 1).getFreshness()){
                    Flower temp = flowers.get(i);
                    flowers.set(i, flowers.get(i + 1));
                    flowers.set(i + 1, temp);
                }
            }
        }
        return flowers;
    }


    public String findStemLength(int minLength, int maxLength){
        String result = "Stem Length: " + minLength + "-" + maxLength + " cm. \n";
        for(int i = 0; i < flowers.size(); i++){
            if(flowers.get(i).getStemLength() >= minLength && flowers.get(i).getStemLength() <= maxLength){
                result += flowers.get(i);
            }
        }
        return result;
    }
}