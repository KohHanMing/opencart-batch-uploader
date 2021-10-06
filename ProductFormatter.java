import java.util.List;
import java.util.ArrayList;

public class ProductFormatter extends Formatter {
    public ProductFormatter(int maxId) {
        super(maxId);
    }

    public List<List<String>> generateDataArray(ProductDataManager productDataManager) {
        List<List<String>> data = new ArrayList<>();
        
        for (int index = 0; index < productDataManager.getSize(); index++) {
        //for (int index = 0; index < 5; index++) {
            List<String> dataRow = new ArrayList<>();

            //id
            dataRow.add(String.valueOf(super.getId()));
            super.incrementId();

            //model
            dataRow.add(productDataManager.generateModel(index));

            //the following are blank: sku, upc, ean, jan, isbn, mpn, location
            String blank = "";

            for (int i = 0; i < 7; i++) {
                    dataRow.add(blank);
                }

            //quantity = 0
            dataRow.add(String.valueOf(0));

            //stock status = 8 (out of stock)
            dataRow.add(String.valueOf(8));

            //image path
            dataRow.add(productDataManager.generateImagePath(index));
            
            //manufacturer id = 0
            dataRow.add(String.valueOf(0));
            
            //shipping id = 1
            dataRow.add(String.valueOf(1));

            //price
            int price = productDataManager.generatePrice(index);
            dataRow.add(String.valueOf(price));

            //points = 0
            dataRow.add(String.valueOf(0));

            //tax_class_id
            dataRow.add(String.valueOf(0));

            //date available some arbitrary date
            String dateAvailable = "2021-06-01";
            dataRow.add(dateAvailable);

            //weight = 0
            dataRow.add(String.valueOf(0));

            //weight_class_id = 1
            dataRow.add(String.valueOf(1));

            //length, width, height = 0
            for (int i = 0; i < 3; i++) {
                dataRow.add(String.valueOf(0));
            }

            //length class id = 1
            dataRow.add(String.valueOf(1));

            //subtract = 0
            dataRow.add(String.valueOf(0));

            // minimum = 1
            dataRow.add(String.valueOf(1));

            //sort order = 1
            dataRow.add(String.valueOf(1));

            //status = 1
            dataRow.add(String.valueOf(1));

            //viewed = 0
            dataRow.add(String.valueOf(0));

            //date added= today
            String dateAdded = "2021-06-01";
            dataRow.add(dateAdded);

            //date modified =today
            String dateModified = "2021-06-01";
            dataRow.add(dateModified);

            data.add(dataRow);
            productDataManager.incrementModelNum(productDataManager.getProductCategoryType(index));

        }

        productDataManager.reset();
        return data;
    }
}
