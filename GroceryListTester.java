import java.io.*;
import java.util.*;

public class GroceryListTester {
    public static void main(String[] args) throws FileNotFoundException {
        GroceryList list = new GroceryList();
        // add items to list and print list
        list.add("milk");
        list.add("eggs");
        list.add("bread");
        System.out.println(list);
        // add item to certain index and print list
        list.add("butter", 1);
        System.out.println(list);
        // remove item from certain index and print list
        list.remove(2);
        System.out.println(list);
        // print size of list
        System.out.println("Number of items in grocery list: " + list.size());

        // have 10 items in list
        list.add("sugar");
        list.add("flour");
        list.add("salt");
        list.add("ketchup");
        list.add("mustard");
        list.add("chicken");
        list.add("turkey");

        // create a map that accesses grocery.txt
        Map<String, Double> groceryMap = list.getGroceryMap("/Users/ewatts/CS_Seminar/grocery.txt");
        System.out.println("Total cost with no discount: " + list.getCost(groceryMap));
        double cost = list.getCost(groceryMap);
        double disc = list.discount(cost);
        System.out.println("Total cost with discount: " + disc);
    }
}
