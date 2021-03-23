public class Dimensions{
    private final double height;
    private final double width;
    private final double depth;

    public Dimensions(){
        height = 0.0;
        width = 0.0;
        depth = 0.0;
    }

    public Dimensions(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public Dimensions setHeight(double height){
        return new Dimensions(height, width, depth);
    }

    public Dimensions setWidth(double width){
        return new Dimensions(height, width, depth);
    }

    public Dimensions setDepth(double depth){
        return new Dimensions(height, width, depth);
    }
    public double volumeCargo(){
        return height * width * depth;
    }
    public String toString(){
        return "\theight - " + height + "\n\twidth - " + width + "\n\tdepth - " + depth;
    }
}