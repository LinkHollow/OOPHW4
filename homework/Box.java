package homework;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private static int count = 0;

    private final int id = ++count;

    private final ArrayList<T> fruits = new ArrayList<>();
    /** Метод добавления фруктов в коробку */
    public void addFruit(T fruit){
        fruits.add(fruit);

    }


    /** Метод вычесления веса коробки */
    public double getWeight(){
        double sum = 0;
        for (T fruit: fruits){
            sum += fruit.getWeight();
        }
        return sum;
    }
    /** Сравнение коробок */
    public boolean compare(Box<? extends Fruit> box){
        if (this.getWeight() == box.getWeight()){
            System.out.println("Вес коробок равен");
            return true;
        } else if (this.getWeight() > box.getWeight()){
            System.out.printf("%s тяжеле чем %s\n", this, box);
            return false;
        } else {
            System.out.printf("%s тяжелее чем %s\n", box, this);
            return false;
        }
    }
    /** Пересыпка фруктов из коробки в коробку */
    public void sprinkleFruits(Box<T> box){
        this.fruits.addAll(box.fruits);
        box.fruits.clear();
        System.out.println("Фрукты высыпаны из " + box + " в " + this);
    }

    public void showBox(){
        System.out.printf("В %s %d Фруктов\n", this, fruits.size());
    }

    @Override
    public String toString() {
        return "Коробка" + id;
    }
}
