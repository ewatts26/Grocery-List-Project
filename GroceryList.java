import java.io.*;
import java.util.*;

public class GroceryList extends GNode {
    private GNode head;
    // private String pathname;

    public GroceryList() {
        this.head = null;
    }

    public GroceryList(GNode head) {
        this.head = head;
    }

    // adds item to the end of the list
    public void add(String item) {
        GNode incoming = new GNode(item);
        if (head == null) {
            head = incoming;
        } else {
            GNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = incoming;
        }
        
    }

    // adds an item to the index indecated
    public void add(String item, int idx) {
        GNode incoming = new GNode(item);
        if (head == null) {
            head = incoming;
        } 
        else if (idx <= size() && idx >= 0){
            if (idx == 0) {
                incoming.next = head;
                head = incoming;
            } else {
                GNode curr = head;
                for (int i=0; i<idx-1; i++) {
                    curr=curr.next;
                }
                incoming.next = curr.next;
                curr.next=incoming;
            }

        }
    }

    // removes the item at specified index
    public void remove(int idx) {
        if (head != null && idx < size() && idx >= 0) {
            if (idx == 0) {
                head = head.next;
            } else {
                GNode curr = head;
                for (int i = 0; i < idx - 1; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
            }
        }
    }

    // returns the number of items in the list
    public int size() {
        int count = 0;
        GNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    // returns the index of specified data
    public int indexOf(String data) {
        int idx = 0;
        GNode curr = head;
        while (curr != null) {
            if (curr.item.equals(data)) {
                return idx;
            }
            idx++;
            curr = curr.next;
        }
        return -1;
    }

    // public String getPathname(String pathname) {
    //     this.pathname = pathname;
    //     return pathname;
    // }

    // returns a map containing a list of items and their respective prices
    Map<String, Double> getGroceryMap(String pathname) throws FileNotFoundException {
        File f = new File(pathname);
        Scanner sc = new Scanner(f);
        Map<String, Double> groceryMap = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String it = line.substring(1, line.indexOf("\" "));
            if (indexOf(it) != -1) {
                double p = Double.parseDouble(line.substring(line.indexOf("\" ") + 2));
                groceryMap.put(it, p);
            }
        }

        return groceryMap;
    }

    // returns the cost of all of the items in the list
    public double getCost(Map<String, Double> groceryMap) {
        double cost = 0.0;
        for (String k: groceryMap.keySet()) {
            cost += groceryMap.get(k); 
        }
        return cost;
    }

    // returns a string containing all of the items in the grocery list and the total
    public String toString() {
        String toRet = "Grocery list: ";
        GNode curr = head;
        while (curr != null) {
            if (curr.next == null) {
                toRet += curr.item;
                break;
            } else {
                toRet += curr.item + ", ";
            }
            curr = curr.next;
        }
        try {
            double value = getCost(getGroceryMap("/Users/ewatts/CS_Seminar/grocery.txt"));
            String formattedValue = String.format(". Total cost: %.2f", value);
            toRet += formattedValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toRet;
    }

    // returns the cost after giving and additional 10% off for ever 10 items
    public double discount(double cost) {
        int count = size();
        while (count > 9) {
            cost = cost * 0.9;
            count /= 10;
        }
        return cost;
    }
}

