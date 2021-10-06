import java.util.List;
import java.util.ArrayList;

public class ProductCategoryFormatter extends Formatter {
    private CategoryStore store;
    public ProductCategoryFormatter(int maxId) {
        super(maxId);
        this.store = new CategoryStore();
    }

    public List<List<String>> generateDataArray(ProductDataManager productDataManager) {
        List<List<String>> data = new ArrayList<>();
        
        for (int index = 0; index < productDataManager.getSize(); index++) {
        //for (int index = 0; index < 5; index++) {
            List<String> dataRow = new ArrayList<>();

            //id
            dataRow.add(String.valueOf(super.getId()));
            super.incrementId();

            //category id
            int categoryId = store.getCategoryId(productDataManager.getProductCategoryType(index));
            dataRow.add(String.valueOf(categoryId));
            data.add(dataRow);
        }

        return data;
    }
    
}
