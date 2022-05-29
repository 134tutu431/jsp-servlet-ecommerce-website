package Model;

public class ProductsModel {
    private int id;
    private String proname;
    private String proprice;
    private String pricethrough;
    private String type;
    private String image;
    private String description;
    private String manuid;
    public ProductsModel() {
    }

    public ProductsModel(int id, String proname, String proprice,String pricethrough, String type, String image, String description) {
        this.id = id;
        this.proname = proname;
        this.proprice = proprice;
        this.pricethrough = pricethrough;
        this.type = type;
        this.image = image;
        this.description = description;
    }

    public ProductsModel(int id, String proname, String proprice, String pricethrough, String type, String image, String description, String manuid) {
        this.id = id;
        this.proname = proname;
        this.proprice = proprice;
        this.pricethrough = pricethrough;
        this.type = type;
        this.image = image;
        this.description = description;
        this.manuid = manuid;
    }

    public String getManuid() {
        return manuid;
    }

    public void setManuid(String manuid) {
        this.manuid = manuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPricethrough() {
        return pricethrough;
    }

    public void setPricethrough(String pricethrough) {
        this.pricethrough = pricethrough;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProprice() {
        return proprice;
    }

    public void setProprice(String proprice) {
        this.proprice = proprice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
