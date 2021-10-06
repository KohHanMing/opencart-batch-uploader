package formatter;

import manager.ProductDataManager;

import java.util.List;
import java.util.ArrayList;

public class ProductDescFormatter extends Formatter {
    public ProductDescFormatter(int maxId) {
        super(maxId);
    }

    public List<List<String>> generateDataArray(ProductDataManager productDataManager) {
        List<List<String>> data = new ArrayList<>();
        for (int index = 0; index < productDataManager.getSize(); index++) {
        //for (int index = 0; index < 5; index++) {
            
            List<String> dataRow = new ArrayList<>();

            //product id
            dataRow.add(String.valueOf(super.getId()));
            super.incrementId();

            //language id = 1
            dataRow.add(String.valueOf(1));

            //name
            dataRow.add(productDataManager.getCapitalisedName(index));

            //right desc
            dataRow.add(productDataManager.getProductDescription(index));

            //description
            String blank = "";
            dataRow.add(blank);

            //tag = blank
            dataRow.add(blank);

            //meta-title = model
            dataRow.add(productDataManager.generateModel(index));

            //meta-desc = category
            dataRow.add(productDataManager.getCapitalisedProductCategoryType(index));

            //meta keyword = category
            dataRow.add(productDataManager.getCapitalisedProductCategoryType(index));

            data.add(dataRow);
            productDataManager.incrementModelNum(productDataManager.getProductCategoryType(index));
        }

        return data;
    }
    
}
