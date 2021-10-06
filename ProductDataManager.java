import java.util.List;
import java.util.HashMap;

public class ProductDataManager {
    private List<List<String>> productData;
    private HashMap<String, Integer> modelNums;



    public ProductDataManager(List<List<String>> productData) {
        this.productData = productData;
        modelNums = new HashMap<>(); // next model num, which is curr max + 1
        modelNums.put("abstract", WriterMain.MAX_MODEL_ABSTRACT + 1);
        modelNums.put("artistic", WriterMain.MAX_MODEL_ARTISTIC + 1);
        modelNums.put("cute", WriterMain.MAX_MODEL_CUTE + 1);
        modelNums.put("fengshui", WriterMain.MAX_MODEL_FENGSHUI + 1);
        modelNums.put("floral", WriterMain.MAX_MODEL_FLORAL + 1);
        modelNums.put("map", WriterMain.MAX_MODEL_MAP + 1);
        modelNums.put("seaside", WriterMain.MAX_MODEL_SEASIDE + 1);
        modelNums.put("nature", WriterMain.MAX_MODEL_NATURE + 1);
        modelNums.put("singapore", WriterMain.MAX_MODEL_SINGAPORE + 1);
        modelNums.put("skyscape", WriterMain.MAX_MODEL_SKYSCAPE + 1);

    }

    public String generateModel(int index) {
        String category = getProductCategoryType(index);
        int modelNum = getProductModelNum(category);
        return "LWA-AP-" + category.toUpperCase() + "-" + String.format("%03d", modelNum);
    }

    public String generateImagePath(int index) {
        String model = generateModel(index);
        String category = getProductCategoryType(index);
        if (category.equals("fengshui")) {
            category = "Feng-Shui-Art";
        } else if (category.equals("floral")) {
            category = "Florals";
        } else if (category.equals("skyscape")) {
            category = "Sky";
        } else {
            category = category.substring(0, 1).toUpperCase() + category.substring(1);
        }

        return "catalog/Products/Art Print/AP-" + category + "/" + getProductName(index) + ".jpg";
        //return "catalog/Products/Art Print/AP-" + category + "/" + model + "-min.jpg";
    }

    public int generatePrice(int index) {
        String dimensionType = getProductDimensionType(index);
        int price = 0;
        switch (dimensionType) {
            case "landscape":
                price = 161;
                break;
            case "portrait":
                price = 161;
                break;
            case "square":
                price = 235;
                break;
        }
        return price;
    }

    public String getCapitalisedName(int index){  
        String name = getProductName(index);
        String nameSplit[] = name.split("\\s");  
        String capitalisedName = "";  
        for(String str : nameSplit){  
            String first = str.substring(0,1);  
            String second = str.substring(1);  
            capitalisedName += first.toUpperCase() + second + " ";  
        }  
        return capitalisedName.trim();  
    }

    public List<String> getProduct(int index) {
        return productData.get(index);
    }

    public int getProductModelNum(String category) {
        int modelNum = modelNums.get(category);
        return modelNum;
    }

    public void incrementModelNum(String category) {
        int modelNum = getProductModelNum(category);
        modelNums.put(category, modelNum + 1);
    }

    public String getProductName(int index) {
        return productData.get(index).get(0);
    }

    public String getProductCategoryType(int index) {
        return productData.get(index).get(1).toLowerCase().trim();
    }

    public String getCapitalisedProductCategoryType(int index) {
        String temp = productData.get(index).get(1).toLowerCase().trim();
        return temp.substring(0, 1).toUpperCase() + temp.substring(1);
    }

    public String getProductDimensionType(int index) {
        return productData.get(index).get(2);
    }

    public String getProductDescription(int index) {
        return productData.get(index).get(3);
    }

    public int getSize() {
        return productData.size();
    }

    public void reset() {
        modelNums.put("abstract", WriterMain.MAX_MODEL_ABSTRACT + 1);
        modelNums.put("artistic", WriterMain.MAX_MODEL_ARTISTIC + 1);
        modelNums.put("cute", WriterMain.MAX_MODEL_CUTE + 1);
        modelNums.put("fengshui", WriterMain.MAX_MODEL_FENGSHUI + 1);
        modelNums.put("floral", WriterMain.MAX_MODEL_FLORAL + 1);
        modelNums.put("seaside", WriterMain.MAX_MODEL_SEASIDE + 1);
    }

    public List<List<String>> getProductData() {
        return productData;
    }
}
