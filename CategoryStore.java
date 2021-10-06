/**
 * This class creates a Store object that contains a key-value pair of relevant categories.
 * The pair maps the Category Name to a Category ID as set in the Opencart SQL database.
 */

import java.util.HashMap;

public class CategoryStore {
    private HashMap<String, Integer> store;

    public CategoryStore() {
        HashMap<String, Integer> temp = new HashMap<>();
        temp.put("Cityscape".toLowerCase(), 113);
        temp.put("Floral".toLowerCase(), 114);
        temp.put("Nature".toLowerCase(), 115);
        temp.put("Landscape".toLowerCase(), 116);
        temp.put("Seaside".toLowerCase(), 117);
        temp.put("Waterfall".toLowerCase(), 118);
        temp.put("Pop Art".toLowerCase(), 119);
        temp.put("Abstract".toLowerCase(), 123);
        temp.put("Artistic".toLowerCase(), 124);
        temp.put("Vintage".toLowerCase(), 126);
        temp.put("Wildlife".toLowerCase(), 127);
        temp.put("Singapore".toLowerCase(), 128);
        temp.put("Skyscape".toLowerCase(), 130);
        temp.put("Cute".toLowerCase(), 132);
        temp.put("Oriental".toLowerCase(), 133);
        temp.put("FengShui".toLowerCase(), 142);
        temp.put("Psychedelic".toLowerCase(), 143);
        temp.put("Black and White".toLowerCase(), 207);
        temp.put("Map".toLowerCase(), 208);

        this.store = temp;
    }

    public int getCategoryId(String name) {
        System.out.println("Looking for: " + name);
        return store.get(name);
    }
}
