package agh.cs.lab4;

import org.junit.Assert;
import junit.framework.TestCase;

public class AnimalTest extends TestCase {

    public void testMove() {
        IWorldMap map1 = new RectangularMap(10, 5);
        Animal dog = new Animal(map1,new Vector2d(10,5));
        Animal cat = new Animal(map1,new Vector2d(-1,-1));
        map1.place(dog);
        map1.place(cat);
        Assert.assertEquals(new Vector2d(0,0),dog.getPosition());
        Assert.assertEquals(new Vector2d(9,4),cat.getPosition());
        Animal mouse = new Animal();
        for(int i=0;i<3;i++){
            mouse.move(MoveDirection.FORWARD);
        }
        Assert.assertEquals(new Vector2d(2,0),mouse.getPosition());
    }
}