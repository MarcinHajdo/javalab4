package agh.cs.lab4;

public class World {
    public static void main(String[] args) {
        String x="f b r l f f r r f f f f f f f f";
        String[] a=x.split(" ");
        MoveDirection[] directions = new OptionParser().parse(a);
        MoveDirection[] direction ={MoveDirection.BACKWARD};
        IWorldMap map = new RectangularMap(10, 5);
        //Animal dog =new Animal();
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        System.out.println(map.toString());
        //dog.move(MoveDirection.FORWARD);
        map.run(directions);
        System.out.println(map.toString());
        //System.out.println(dog.toString1());
        //map.run(directions);
        /*IWorldMap map = new RectangularMap(10, 5);
        Animal dog = new Animal(map);
        Animal dog1 = new Animal(map,new Vector2d(2,4));
        map.place(dog);
        System.out.println(dog.toString1());
        map.place(dog1);
        System.out.println(dog1.toString1());
        dog.move(MoveDirection.FORWARD);
        System.out.println(dog.toString1());
        dog.move(MoveDirection.FORWARD);
        System.out.println(dog.toString1());
        System.out.println(map.toString());
        OptionParser a = new OptionParser();
        List<MoveDirection> x=a.parse("f d forward b backward def gefeff l lej left dsa r dfefwwef fefw wef right s");
        System.out.println(dog.toString());
        for(int i=0;i<x.size();i++){
            dog.move(x.get(i));
            System.out.println(dog.toString());
        }*/
    }
}
