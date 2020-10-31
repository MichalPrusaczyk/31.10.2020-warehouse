package warehouse.database;

import warehouse.model.Aluminium;
import warehouse.model.Product;
import warehouse.model.Steel;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private static ProductRepository productRepository = new ProductRepository();

    ProductRepository(){
        this.products.add(new Steel("steel","square",300.00,"50x50"));
        this.products.add(new Steel("steel","round",300.00,"fi30"));
        this.products.add(new Aluminium("aluminium","square",200.00,"30x30"));
        this.products.add(new Aluminium("aluminium","round",50.00,"fi40"));

    }

    public static ProductRepository getInstance(){
        return productRepository;
    }

    public List<Product> getAllProducts(){
        return this.products;
    }
    public boolean deliverProduct(String productName,String productShape, double length,String productSize){
        for(Product currentProduct : this.products){
            if(currentProduct.getName().equals(productName)&& currentProduct.getShape().equals(productShape)
                    && currentProduct.getSize().equals(productSize) && currentProduct.getLength() >= length){
                    currentProduct.setLength(currentProduct.getLength());
                    return true;
                }
            }

        return false;
    }

    public Product findProduct(String productName){
        for(Product currentProduct: this.products){
            if(currentProduct.getName().equals(productName)){
                return currentProduct;
            }
        }

        return null;
    }

    public void addProductToDatabase(Product product){
        this.products.add(product);
    }

}
