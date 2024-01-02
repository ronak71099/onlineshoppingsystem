package shopping;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class Cart extends inventory{
    ArrayList<product> usercart = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    int totalAmount;
    public void addincart(){
//        showinventory();
        char ch;
        do {
            try{
                System.out.println("enter the item name : ");
                String str = s.next();
                product p = find(str);
                if (p != null) {
                    System.out.println("enter the add quantity : ");
                    int quan = s.nextInt();
                    product p1 = new product(p.getProductName(), p.getProductId(), p.getCategory(), quan,p.getPrice());
                    usercart.add(p1);
                    updateValues(str, 'a', quan);
                }
                else{
                    System.out.println("sorry the item you want to buy not inside the inventory");
                }
                System.out.println("you want to continue to add inside the cart press y if don't press n");
                ch = s.next().charAt(0);
            }catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid input.");
                s.nextLine(); // Clear the scanner's buffer to avoid an infinite loop
                ch = 'n'; // Setting 'n' to exit the loop in case of an exception
            }
        }while(ch=='y'||ch=='Y');
    }
    public void removefromcart(){
//        showinventory();
//        display();
        System.out.println();
        char ch;
        System.out.println("you are inside remove function");
        do {
            try {
                System.out.println("enter the item name : ");
                String str = s.next();
                product p = findfromcart(str);
                if (p != null) {
                    System.out.println("enter quantity");
                    int quan = s.nextInt();
                    updateValues(str, 'r', quan);
                    p.setProductQuantity(p.getProductQuantity() - quan);
                } else {
                    System.out.println("the item you are removing from cart is not inside the cart");
                }
                System.out.println("you want to continue to remove item from cart press y if don't press n");
                ch = s.next().charAt(0);

            }catch (Exception e){
                System.out.println("Invalid input. Please enter a valid input.");
                s.nextLine(); // Clear the scanner's buffer to avoid an infinite loop
                ch = 'n';
            }
        }while(ch=='y'||ch=='Y');

    }
    public product findfromcart(String str) throws NullPointerException{
        for(product p : usercart){
            if(p.getProductName().equals(str)){
                return p;
            }
        }
        return null;
    }
    public void getTotalAmount(){
        if(usercart.isEmpty()){
            System.out.println("Cart is empty");
            System.out.println("total amount is : "+totalAmount);
        }
        else {
            for (product p : usercart) {
                totalAmount += p.getPrice() * p.getProductQuantity();
            }
            System.out.println("Total amount is : "+totalAmount);
        }

    }
    public void display(){
        if(usercart.isEmpty()){
            System.out.println("cart is empty");
//            System.out.println("the total amount is : "+this.totalAmount);
        }
        else {
//            int total = 0;
            for (product p : usercart) {
//                this.totalAmount += p.getPrice() * p.getProductQuantity();
                System.out.println(" product name : " + p.getProductName() + " product id : " + p.getProductId() + " quantity : " + p.getProductQuantity() + " price :" + p.getPrice());
            }
//            System.out.println("Total price for the selected items is : ");
//            System.out.print(this.totalAmount);
            System.out.println();
//            setTotalAmount(total);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        product p = new product("chips","1","food",100,10);
        product p1 = new product("cola","1","food",100,25);
        product p2 = new product("chaap","1","food",100,120);
        product p3 = new product("chocolate","1","food",100,70);
        product p4 = new product("choco","1","food",100,125);
        Cart c = new Cart();
        c.add(p);
        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);
        String smiley = "\uD83D\uDE00";
        System.out.println(smiley+"  welcome to the store  "+smiley);
        char str;
        do {
            try {
                System.out.println("What you want to do just press ");
                System.out.println("1 for adding item inside the cart");
                System.out.println("2 for removing item from the cart");
                System.out.println("3 for displaying items inside the cart");
                System.out.println("4 for displaying items inside the inventory");
                System.out.println("5 for displaying total amount of the cart");
                System.out.println("Enter any number that matches the indexing : ");
                int ch = s.nextInt();
                switch (ch) {
                    case 1:
                        c.addincart();
                        break;
                    case 2:
                        c.removefromcart();
                        break;
                    case 3:
                        c.display();
                        break;
                    case 4:
                        c.showinventory();
                        break;
                    case 5:
                        c.getTotalAmount();
                        break;
                    default:
                        System.out.println("please press from the given numbers");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } finally {
                s.nextLine();
            }
            System.out.println("you want to continue press y");
            str=s.next().charAt(0);
        }while(str=='y'||str=='Y');
        s.close();
    }
}
