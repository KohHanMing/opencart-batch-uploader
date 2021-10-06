import java.util.List;
import java.util.ArrayList;

public class ProductFilterFormatter extends Formatter {
    public ProductFilterFormatter(int maxId) {
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

            //filter_id
            dataRow.add(String.valueOf(20));
            data.add(dataRow);
        }

        return data;
    }
}
