package shopping;
import java.util.ArrayList;
import java.util.Scanner;

public class inventory {
    ArrayList<product> inventoryArray = new ArrayList<>();

    void add(product p) {
        inventoryArray.add(p);
    }

    public product find(String str) throws NullPointerException{
//        showinventory();
        for (product p : inventoryArray) {
            if (p.getProductName().equals(str)) {
                return p;
            }
        }
        return null;
    }

    public void showinventory() {
//        System.out.println("open");
        for (product p : inventoryArray) {
            System.out.println("product name : " + p.getProductName() + "product id : " + p.getProductId() + "quantity : " + p.getProductQuantity());
        }
    }

    public void updateValues(String name, char ch, int quantity) {
        product p = find(name);
        if (name != null) {
            if (ch == 'a') {
//                System.out.println("the product quantity " +p.getProductQuantity());
                p.setProductQuantity((p.getProductQuantity() - quantity));
            } else if (ch == 'r') {
                p.setProductQuantity(p.getProductQuantity() + quantity);
            }
        }
    }
}

