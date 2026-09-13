import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.service;
import com.ltp.globalsuperstore.repository.StoreRepository;

import java.util.concurrent.TimeUnit;
import java.util.Date;

public class StoreService {

    StoreRepository storeRepository = new StoreRepository();

    public Item getItem(int index) {
        return storeRepository.getItem(index);
    }

    public void addItem(int index) {
        storeRepository.addItem(index);
    }

    public void updateItem(Item item, int index) {
        storeRepository.updateItem(item, index);
    }

    public List<Item> getItems() {
        return storeRepository.getItems();
    }

    public int getItemIndex(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (getItem().get(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;
    }

     public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

}