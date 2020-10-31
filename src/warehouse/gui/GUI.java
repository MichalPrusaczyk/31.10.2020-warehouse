package warehouse.gui;

import warehouse.database.ProductRepository;
import warehouse.model.Aluminium;
import warehouse.model.Product;
import warehouse.model.Steel;

import java.util.List;
import java.util.Scanner;

public class GUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu(){
        System.out.println("1. Add product");
        System.out.println("2. Remove product");
        System.out.println("3. Display products");
        System.out.println("4. Exit");

        String choose = scanner.nextLine();

        switch (choose){
            case"1":
                addProduct();
                showMainMenu();
                break;
            case"2":
                deliverProduct();
                showMainMenu();
                break;
            case"3":
                showAllProducts();
                showMainMenu();
                break;
            case"4":
                System.exit(0);
                break;
            default:
                System.out.println("Bad choice");
                showMainMenu();
                break;
        }
    }
    private static void showAllProducts(){
        ProductRepository baza = ProductRepository.getInstance();
        List<Product> products = baza.getAllProducts();
        for(Product currentProduct : products){
            System.out.println(currentProduct);
        }
    }

    private static void deliverProduct(){
        System.out.println("Set name");
        String productToDeliver = scanner.nextLine();

        System.out.println("Set shape");
        String shapeToDeliver = scanner.nextLine();

        System.out.println("Set size");
        String sizeToDeliver = scanner.nextLine();

        System.out.println("Set length");
        double lengthToDeliver = Integer.parseInt(scanner.nextLine());
        boolean success = ProductRepository.getInstance().deliverProduct(
                productToDeliver,
                shapeToDeliver,
                lengthToDeliver,
                sizeToDeliver);

        if(success){
            System.out.println("wydano produkt");
        }else{
            System.out.println("nie udalo sie wydac produktu");
        }
    }

    private static void addProduct(){
        System.out.println("Set product name");
        String productName = scanner.nextLine();
        Product productFromDatabase = ProductRepository.getInstance().findProduct(productName);
        if(productFromDatabase != null){
            System.out.println("Set length");
            double productLength = Integer.parseInt(scanner.nextLine());
            productFromDatabase.setLength(productLength + productFromDatabase.getLength());
            System.out.println("Prodct added ");
        }else {
            System.out.println("Add new product");
            addNewProduct(productName);
            }
        }
        private static void addNewProduct(String productName){
            System.out.println("1. Steel");
            System.out.println("2. Aluminium");
            DataWrapper dataWrapper;
            String choose = scanner.nextLine();

            switch (choose){
                case "1":
                    dataWrapper = readCommonData();
                    Steel steel = new Steel(productName,dataWrapper.shape,dataWrapper.length,dataWrapper.size);
                    ProductRepository.getInstance().addProductToDatabase(steel);
                    System.out.println("Product added");
                    break;
                case "2":
                    dataWrapper = readCommonData();
                    Aluminium aluminium = new Aluminium(productName,dataWrapper.shape,dataWrapper.length,dataWrapper.size);
                    ProductRepository.getInstance().addProductToDatabase(aluminium);
                    System.out.println("Product added");
                    break;
                default:
                    System.out.println("Bad choice");
                    addNewProduct(productName);
                    break;
        }

    }

    private static DataWrapper readCommonData() {
        try {
            System.out.println("Set shape");
            String shape = scanner.nextLine();
            System.out.println("Set length");
            double length = Integer.parseInt(scanner.nextLine());
            System.out.println("Set size");
            String size = scanner.nextLine();

            return new DataWrapper(shape, length, size);
        } catch (NumberFormatException e){
            System.out.println("False number");
            return readCommonData();
        }

    }

    static class DataWrapper{
        String shape;
        double length;
        String size;

        public DataWrapper(String shape, double length, String size) {
            this.shape = shape;
            this.length = length;
            this.size = size;
        }
    }
}
