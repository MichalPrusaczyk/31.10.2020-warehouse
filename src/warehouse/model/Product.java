package warehouse.model;

public class Product {

    private String name;
    private String shape;
    private double length;
    private String size;

    public Product(String name, String shape, double length,String size) {
        this.name = name;
        this.shape = shape;
        this.length = length;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", shape='" + shape + '\'' +
                ", size='" + size + '\'' +
                ", length=" + length;
    }
}

