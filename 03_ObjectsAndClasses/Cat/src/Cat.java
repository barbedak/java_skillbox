
public class Cat
{
    private double originWeight;
    private double weight;
    private double foodWeight;
    private double minWeight;
    private double maxWeight;
    private boolean isAlive;
    private static int countCats = 0;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        countCats += 1;
        isAlive = true;
    }

    public static int getCount()
    {
        return countCats;
    }

    public void meow()
    {
        if (isAlive)
        {
            weight = weight - 1;
            System.out.println("Meow");
        }
    }

    public void feed(Double amount)
    {
        if (isAlive)
        {
            weight = weight + amount;
            foodWeight = foodWeight + amount;
        }
    }

    public double getFoodWeight() { return foodWeight; }

    public void drink(Double amount)
    {
        if (isAlive) { weight = weight + amount; }
    }

    public Double getWeight() { return weight; }

    public void getLiveStatus()
    {
        if ((weight < minWeight) || (weight > maxWeight))
        {
            isAlive = false;
            countCats -= 1;
        }
    }

    public String getStatus()
    {
        if(weight < minWeight)
        {
            if (isAlive) { getLiveStatus(); } //для корректного подсчета живых котов
            return "Dead";
        }
        else if(weight > maxWeight)
        {
            if (isAlive) { getLiveStatus(); } //для корректного подсчета живых котов
            return "Exploded";
        }
        else if(weight > originWeight)
        {
            return "Sleeping";
        }
        else
            {
            return "Playing";
            }
    }
    public void pee(){
        if (isAlive) {
            weight = weight - (weight / 50);
            System.out.println("pi-pi");
        }
    }
}