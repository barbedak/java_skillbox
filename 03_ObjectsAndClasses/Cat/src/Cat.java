
public class Cat
{
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    public static final int NUMBER_OF_EYES = 2;

    private double originWeight;
    private double weight;
    private double foodWeight;
    private boolean Alive;
    private static int countCats;
    private Color color;
    private String name;

    public Cat()
    {
        setWeight(1500.0 + 3000.0 * Math.random());
        setOriginWeight(getWeight());
        setCountCats(getCountCats() + 1);
        setAlive(true);
    }

    public Cat(double weight)
    {
        this();
        setWeight(weight);
        setOriginWeight(getWeight());
    }


    public Cat (Cat cat){
        this.setName(cat.getName());
        this.setColor(cat.getColor());
        this.setWeight(cat.getWeight());
        this.setOriginWeight(cat.getOriginWeight());
        this.setFoodWeight(cat.getFoodWeight());
        this.setAlive(cat.isAlive());
    }

    public void copyCat (Cat cat)
    {
        setName(cat.getName());
        setColor(cat.getColor());
        setWeight(cat.getWeight());
        setOriginWeight(cat.getOriginWeight());
        setFoodWeight(cat.getFoodWeight());
        setAlive(cat.isAlive());
    }

    public double getOriginWeight() {
        return originWeight;
    }

    public void setOriginWeight(double originWeight) {
        this.originWeight = originWeight;
    }

    public double getFoodWeight() {
        return foodWeight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFoodWeight(double foodWeight) {
        this.foodWeight = foodWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }

    public static double getMinWeight() {
        return MIN_WEIGHT;
    }

    public static double getMaxWeight() {
        return MAX_WEIGHT;
    }

    public static int getNumberOfEyes() {
        return NUMBER_OF_EYES;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    public static void setCountCats(int countCats) {
        Cat.countCats = countCats;
    }

    public static int getCountCats() {
        return countCats;
    }

    public static int getCount()
    {
        return countCats;
    }

    public void meow()
    {
        if (isAlive())
        {
            setWeight(getWeight() - 1);
            System.out.println("Meow");
            checkLiveStatus();
        }
    }

    public void feed(Double amount)
    {
        if (isAlive())
        {
            setWeight(getWeight() + amount);
            setFoodWeight(getFoodWeight() + amount);
            checkLiveStatus();
        }
    }

    public void drink(Double amount)
    {
        if (isAlive())
        {
            setWeight(getWeight() + amount);
            checkLiveStatus();
        }
    }

    public Double getWeight() { return weight; }

    public void checkLiveStatus()
    {
        if ((getWeight() < getMinWeight()) || (getWeight() > getMaxWeight()))
        {
            setAlive(false);
            setCountCats(getCountCats() - 1);
        }
    }

    public String getStatus()
    {
        if(getWeight() < getMinWeight())
        {
            return "Dead";
        }
        else if(getWeight() > getMaxWeight())
        {
            return "Exploded";
        }
        else if(getWeight() > getOriginWeight())
        {
            return "Sleeping";
        }
        else
            {
            return "Playing";
            }
    }

    public void pee(){
        if (isAlive()) {
            setWeight(getWeight() - (getWeight() / 50));
            System.out.println("pi-pi");
            checkLiveStatus();
        }
    }
}