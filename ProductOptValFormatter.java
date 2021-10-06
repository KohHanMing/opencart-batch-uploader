import java.util.List;
import java.util.ArrayList;

public class ProductOptValFormatter extends Formatter{
    private int productOptId;
    private int productOptValId;
    private OptionStore store;

    public ProductOptValFormatter(int maxId, int maxProductOptId, int maxProductOptValId) {
        super(maxId);
        this.productOptId = maxProductOptId + 1;
        this.productOptValId = maxProductOptValId + 1;
        this.store = new OptionStore();
    }

    public List<List<String>> generateDataArray(ProductDataManager productDataManager) {
        List<List<String>> data = new ArrayList<>();
        
        for (int index = 0; index < productDataManager.getSize(); index++) {
        //for (int index = 0; index < 5; index++) {

            String dimensions = productDataManager.getProductDimensionType(index);
            switch (dimensions) {
                case "landscape":
                    addRowsToData(data, generateValDataRows(15));
                    addRowsToData(data, generateValDataRows(37));
                    addRowsToData(data, generateValDataRows(34));
                    break;
                case "square":
                    addRowsToData(data, generateValDataRows(16));
                    addRowsToData(data, generateValDataRows(36));
                    break;
                case "portrait":
                    addRowsToData(data, generateValDataRows(17));
                    addRowsToData(data, generateValDataRows(38));
                    addRowsToData(data, generateValDataRows(35));
                    break;
            }
            super.incrementId();
            
        }

        return data;
    }

    public List<List<String>> generateValDataRows(int optId) {
        List<HashEntry<Integer,Integer>> optValEntries = store.getOpts(optId);
        List<List<String>> data = new ArrayList<>();

        for (HashEntry<Integer,Integer> optValEntry : optValEntries) {
            List<String> dataRow = new ArrayList<>();

            //product option value id
            dataRow.add(String.valueOf(productOptValId));
            productOptValId++;

            //product option id
            dataRow.add(String.valueOf(productOptId));
            
            //id
            dataRow.add(String.valueOf(super.getId()));

            //option id
            dataRow.add(String.valueOf(optId));
            
            //option value id use optVal here
            dataRow.add(String.valueOf(optValEntry.getKey()));

            //quantity
            dataRow.add(String.valueOf(100));

            //subtract = 0
            dataRow.add(String.valueOf(0));

            //price
            dataRow.add(String.valueOf(optValEntry.getValue()));

            //price prefix
            dataRow.add("+");

            //points = 0
            dataRow.add(String.valueOf(0));

            //points prefix
            dataRow.add("+");

            //weight = 0
            dataRow.add(String.valueOf(0));

            //weight prefix
            dataRow.add("+");

            data.add(dataRow);
        }

        productOptId++;
        return data;
    }

    public void addRowsToData(List<List<String>> data, List<List<String>> dataRows) {
        for (List<String> row : dataRows) {
            data.add(row);
        }
    }
}
