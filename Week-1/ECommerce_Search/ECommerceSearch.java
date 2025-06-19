package SearchingExample;

import java.util.Arrays;

public class ECommerceSearch {
    private Product[] productsArray; // For linear search
    private Product[] sortedProductsArray; // For binary search

    public ECommerceSearch(Product[] products) {
        this.productsArray = Arrays.copyOf(products, products.length);
        this.sortedProductsArray = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProductsArray); 
    }

    // Linear Search - O(n)
    public Product linearSearchById(String productId) {
        for (Product product : productsArray) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search - O(log n)
    public Product binarySearchById(String productId) {
        int left = 0;
        int right = sortedProductsArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedProductsArray[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return sortedProductsArray[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Sample products
        Product[] products = {
            new Product("P100", "Laptop", "Electronics", 999.99),
            new Product("P200", "Smartphone", "Electronics", 699.99),
            new Product("P300", "Headphones", "Electronics", 149.99),
            new Product("P400", "Desk Chair", "Furniture", 199.99),
            new Product("P500", "Coffee Maker", "Appliances", 79.99)
        };

        ECommerceSearch search = new ECommerceSearch(products);

        // Test searches
        String searchId = "P300";
        
        System.out.println("Linear Search Results:");
        Product linearResult = search.linearSearchById(searchId);
        System.out.println(linearResult != null ? linearResult : "Product not found");

        System.out.println("\nBinary Search Results:");
        Product binaryResult = search.binarySearchById(searchId);
        System.out.println(binaryResult != null ? binaryResult : "Product not found");

        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        long startTime, endTime;
        
        // Linear search timing
        startTime = System.nanoTime();
        search.linearSearchById(searchId);
        endTime = System.nanoTime();
        System.out.println("Linear search time: " + (endTime - startTime) + " ns");

        // Binary search timing
        startTime = System.nanoTime();
        search.binarySearchById(searchId);
        endTime = System.nanoTime();
        System.out.println("Binary search time: " + (endTime - startTime) + " ns");
    }
}
