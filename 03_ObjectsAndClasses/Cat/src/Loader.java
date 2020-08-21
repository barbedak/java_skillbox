
public class Loader
{
    public static void main(String[] args)
    {
        System.out.println("Total alive cats : " + Cat.getCount());
        System.out.println("Add cats ...");
        Cat barsik = new Cat();
        Cat murzik = new Cat();
        Cat murka = new Cat();
        Cat kenny = new Cat();
        Cat musya = new Cat();
        Cat chubays = new Cat();
        System.out.println("Total alive cats : " + Cat.getCount());

        System.out.println("Barsik weight: " + barsik.getWeight());
        System.out.println("Murzik weight: " + murzik.getWeight());
        System.out.println("Murka weight: " + murka.getWeight());
        System.out.println("Kenny weight: " + kenny.getWeight());
        System.out.println("Musya weight: " + musya.getWeight());
        System.out.println("Chubays weight: " + chubays.getWeight());

        //feeding cats
        /*
        System.out.println();
        System.out.println("Feeding Barsik and Murzik");
        barsik.feed(100.0);
        murzik.feed(100.0);
        System.out.println("Now Barsik weight: " + barsik.getWeight());
        System.out.println("Now Murzik weight: " + murzik.getWeight());

         */


        //feeding Murka
        System.out.println();
        System.out.println("Murka status: " + murka.getStatus());
        System.out.println("Feeding Murka");
        while (!murka.getStatus().equals("Exploded")){
            murka.feed(100.0);
        }

        System.out.println("Murka status: " + murka.getStatus());

        System.out.println();
        System.out.println("Total alive cats : " + Cat.getCount());
        System.out.println("Barsik status : " + barsik.getStatus());
        System.out.println("Murzik status : " + murzik.getStatus());
        System.out.println("Murka status : " + murka.getStatus());
        System.out.println("Kenny status : " + kenny.getStatus());
        System.out.println("Musya status : " + musya.getStatus());
        System.out.println("Chubays status : " + chubays.getStatus());


        //killing Kenny
        /*
        System.out.println();
        System.out.println("Kenny status: " + kenny.getStatus());

        while (!kenny.getStatus().equals("Dead")){
            System.out.print("Kenny says ");
            kenny.meow();
        }
        System.out.println("Kenny is "+ kenny.getStatus() + " :(");

        System.out.println();
        System.out.println("Chubays weight is " + chubays.getWeight());
        chubays.feed(150.00);
        System.out.println("Chubays weight is " + chubays.getWeight());
        chubays.pee();
        chubays.pee();
        chubays.pee();
        System.out.println("Chubays weight is " + chubays.getWeight());
        System.out.println("Chubays ate " + chubays.getFoodWeight());
        */
    }
}