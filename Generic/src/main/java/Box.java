import java.util.ArrayList;

public class Box<T extends Fruit> {
    private T nameOfFruit;

    private ArrayList<T> box;

    public Box(T fruit) {
        this.nameOfFruit = fruit;
        this.box = new ArrayList();
    }

    public void addFruit(T fruit){
        this.box.add(fruit);
    }

    public float getWeightBox(){
        float result = 0;
        for (int i = 0; i < this.box.size(); i++){
            result+= this.box.get(i).getWeightFruit();
        }
        return  result;
    }
}
