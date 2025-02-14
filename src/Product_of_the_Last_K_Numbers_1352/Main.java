package Product_of_the_Last_K_Numbers_1352;

public class Main {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println(productOfNumbers.getProduct(2)); // Output: 20 (5 * 4)
        System.out.println(productOfNumbers.getProduct(3)); // Output: 40 (2 * 5 * 4)
        System.out.println(productOfNumbers.getProduct(4)); // Output: 0 (0 invalidates earlier numbers)
    }
}
