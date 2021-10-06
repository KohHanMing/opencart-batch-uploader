import java.util.List;
import java.util.ArrayList;

public class ProductOptFormatter extends Formatter {
    private int productOptId;

    public ProductOptFormatter(int maxId, int maxProductOptId) {
        super(maxId);
        this.productOptId = maxProductOptId + 1;
    }

    public List<List<String>> generateDataArray(ProductDataManager productDataManager) {
        List<List<String>> data = new ArrayList<>();
        
        for (int index = 0; index < productDataManager.getSize(); index++) {
        //for (int index = 0; index < 5; index++) {

            String dimensions = productDataManager.getProductDimensionType(index);
            switch (dimensions) {
                case "landscape":
                    data.add(generateDataRow(15));
                    data.add(generateDataRow(37));
                    data.add(generateDataRow(34));
                    break;
                case "square":
                    data.add(generateDataRow(16));
                    data.add(generateDataRow(36));
                    break;
                case "portrait":
                    data.add(generateDataRow(17));
                    data.add(generateDataRow(38));
                    data.add(generateDataRow(35));
                    break;
            }
            super.incrementId();
            
        }

        return data;
    }

    public List<String> generateDataRow(int optId) {
        List<String> dataRow = new ArrayList<>();

            //product option id
            dataRow.add(String.valueOf(productOptId));
            productOptId++;

            //id
            dataRow.add(String.valueOf(super.getId()));
            

            //option id (loop initiated by dimension)
            dataRow.add(String.valueOf(optId));
            

            //value = blank
            dataRow.add("");

            //required = 1
            dataRow.add(String.valueOf(1));

            return dataRow;
    }
}
