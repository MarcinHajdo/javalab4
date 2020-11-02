package agh.cs.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    public  RectangularMap(int width,int height){
        this.width = width;
        this.height = height;
    }
    List<Animal> animals = new ArrayList<>();
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (isOccupied(position)){
          //  System.out.println("Zwierze nie moze sie ruszyc na to miejsce - jest ono zajete przez inne zwierze");
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())){
           // System.out.println("Nie mozna dodac zwierzecia na tym miejscu - miejsce jest zajete przez inne zwierze");
            return false;
        }
        else {
            animals.add(animal);
            return true;
        }
    }

    @Override
    public void run(MoveDirection[] directions) {
        if(directions.length>=animals.size()) {
            for (int i = 0; i < animals.size(); i++) {
                animals.get(i).move(directions[i]);
                //System.out.println(animals.get(i).toString1());
            }
            if(directions.length>animals.size())
            {
                run(Arrays.copyOfRange(directions, animals.size(), directions.length));
            }
        }
        else {
            for (int i = 0; i < directions.length; i++) {
                animals.get(i).move(directions[i]);
               // System.out.println(animals.get(i).toString1());
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (position.equals(animal.getPosition())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (position.equals(animal.getPosition())) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0,0),new Vector2d(width-1,height-1));
    }

    public int getHeight(){return this.height;}
    public int getWidth(){return  this.width;}
}
