import java.util.List;

public abstract class Formatter {
    private int currId;

    public Formatter(int id) {
        this.currId = id + 1;
    }

    public int getId() {
        return currId;
    }

    public void incrementId() {
        currId++;
    }

    public abstract List<List<String>> generateDataArray(ProductDataManager productData);
}
