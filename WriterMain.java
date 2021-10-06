import java.util.List;

public class WriterMain {
    public static final int MAX_PRODUCT_ID = 15624;
    public static final int MAX_PRODUCT_OPT_ID = 5897;
    public static final int MAX_PRODUCT_OPT_VAL_ID = 38352;

    public static final int MAX_MODEL_ABSTRACT = 122; 
    public static final int MAX_MODEL_ARTISTIC = 151;
    public static final int MAX_MODEL_CUTE = 48;
    public static final int MAX_MODEL_FENGSHUI = 61;
    public static final int MAX_MODEL_FLORAL = 218;
    public static final int MAX_MODEL_MAP = 0;
    public static final int MAX_MODEL_SEASIDE = 299;
    public static final int MAX_MODEL_NATURE = 240;
    public static final int MAX_MODEL_SINGAPORE = 48;
    public static final int MAX_MODEL_SKYSCAPE = 135;

    public ProductDataManager productDataManager;  //name, category, dimension type
    
    public WriterMain(ProductDataManager productDataManager) {
        this.productDataManager = productDataManager;
    }

    public static void main(String[] args) {
        
        
        String myFilePath = ".\\uploads\\upload - comma delimited.csv";
        String myCatSavePath = ".\\uploads\\cat.csv";
        WriterMain writerMain = createWriter(myFilePath);
        WriterUtils.writeToCsv(writerMain.productDataManager.getProductData(), myCatSavePath); //verifying initial data

        writerMain.runFormatter(new ProductFormatter(MAX_PRODUCT_ID), ".\\uploads\\product.csv");
        writerMain.runFormatter(new ProductDescFormatter(MAX_PRODUCT_ID), ".\\uploads\\product_desc.csv");
        writerMain.runFormatter(new ProductFilterFormatter(MAX_PRODUCT_ID), ".\\uploads\\product_filter.csv");
        writerMain.runFormatter(new ProductOptFormatter(MAX_PRODUCT_ID, MAX_PRODUCT_OPT_ID), ".\\uploads\\product_option.csv");
        writerMain.runFormatter(new ProductOptValFormatter(MAX_PRODUCT_ID, MAX_PRODUCT_OPT_ID, MAX_PRODUCT_OPT_VAL_ID), ".\\uploads\\product_option_value.csv");
        writerMain.runFormatter(new ProductCategoryFormatter(MAX_PRODUCT_ID), ".\\uploads\\product_category.csv");
        writerMain.runFormatter(new ProductLayoutFormatter(MAX_PRODUCT_ID), ".\\uploads\\product_layout.csv");
        writerMain.runFormatter(new ProductStoreFormatter(MAX_PRODUCT_ID), ".\\uploads\\product_store.csv");
    }

    public static WriterMain createWriter(String filePath) {
        List<List<String>> productData = WriterUtils.readFromCsv(filePath);
        DimensionParser dimensionParser = DimensionParser.createDimensionParser("./images/compressed");
        for (int i = 0; i < dimensionParser.getSize(); i++) {
            productData.get(i).add(2, dimensionParser.getDimensionType(i)); // add to index 2, in front of description
        }

        return new WriterMain(new ProductDataManager(productData));
    }

    public void runFormatter(Formatter formatter, String savePath) {
        List<List<String>> formattedData = formatter.generateDataArray(productDataManager);
        for (List<String> row : formattedData) {
            System.out.println(row.toString());
        }
        WriterUtils.writeToCsv(formattedData, savePath);
        productDataManager.reset();
    }
}