package main;
import java.util.List;

import formatter.Formatter;
import formatter.ProductCategoryFormatter;
import formatter.ProductDescFormatter;
import formatter.ProductFilterFormatter;
import formatter.ProductFormatter;
import formatter.ProductLayoutFormatter;
import formatter.ProductOptFormatter;
import formatter.ProductOptValFormatter;
import formatter.ProductStoreFormatter;
import manager.ImageManager;
import manager.ProductDataManager;
import utils.WriterUtils;

public class WriterMain {
    public static final int MAX_PRODUCT_ID = 15666;
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
    public static final int MAX_MODEL_AARON = 122;
    public static final int MAX_MODEL_JAYS = 23;

    public static final boolean hasPriceStored = true;
    public static final boolean hasEncodingInDesc = false;
    public static final boolean hasOptions = false;

    public ProductDataManager productDataManager;  //name, category, dimension type, description (concatenation of year, dimension detalis and text desc), price(if applicable)
    
    public WriterMain(ProductDataManager productDataManager) {
        this.productDataManager = productDataManager;
    }

    public static void main(String[] args) {
        
        
        String myFilePath = ".\\.data\\source\\product-info.csv";
        String myCatSavePath = ".\\.data\\target\\cat.csv";
        WriterMain writerMain = createWriter(myFilePath);
        WriterUtils.writeToCsv(writerMain.productDataManager.getProductData(), myCatSavePath); //verifying initial data

        writerMain.runFormatter(new ProductFormatter(MAX_PRODUCT_ID), ".\\.data\\target\\product.csv");
        writerMain.runFormatter(new ProductDescFormatter(MAX_PRODUCT_ID), ".\\.data\\target\\product_desc.csv");
        writerMain.runFormatter(new ProductFilterFormatter(MAX_PRODUCT_ID), ".\\.data\\target\\product_filter.csv");
        if (hasOptions) {
            writerMain.runFormatter(new ProductOptFormatter(MAX_PRODUCT_ID, MAX_PRODUCT_OPT_ID), ".\\.data\\target\\product_option.csv");
            writerMain.runFormatter(new ProductOptValFormatter(MAX_PRODUCT_ID, MAX_PRODUCT_OPT_ID, MAX_PRODUCT_OPT_VAL_ID), ".\\.data\\target\\product_option_value.csv");
        }
        writerMain.runFormatter(new ProductCategoryFormatter(MAX_PRODUCT_ID), ".\\.data\\target\\product_category.csv");
        writerMain.runFormatter(new ProductLayoutFormatter(MAX_PRODUCT_ID), ".\\.data\\target\\product_layout.csv");
        writerMain.runFormatter(new ProductStoreFormatter(MAX_PRODUCT_ID), ".\\.data\\target\\product_store.csv");
    }

    public static WriterMain createWriter(String filePath) {
        List<List<String>> productData = WriterUtils.readFromCsv(filePath);
        ImageManager imageManager = ImageManager.createImageManager("./.data/images");
        try {
            for (int i = 0; i < imageManager.getSize(); i++) {
                productData.get(i).add(2, imageManager.getDimensionType(i)); // add to index 2, in front of description
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println();
            System.out.println("=========== CUSTOM DEBUG MESSAGE =============");
            System.out.println("Index out of bounds! Make sure that the number of rows in the csv matches the number of images in the images folder.");
            System.out.println("=========== CUSTOM DEBUG MESSAGE =============");
            System.out.println();
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