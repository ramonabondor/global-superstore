import java.util.List;
import java.util.ArrayList;

import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.repository;

public class StoreRepository {

    List<Item> items = new ArrayList<>();

    public Item getItem(int index) {
        return items.get(index);
    }

    public void addItem(int index) {
        items.add(index);
    }

    public void updateItem(Item item, int index) {
        items.set(index, item);
    }

    public List<Item> getItems() {
        return items;
    }
}