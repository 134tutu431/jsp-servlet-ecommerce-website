package Model;

public class ManufacturerModel {
    private int manuid;
    private String manufacturer;

    public ManufacturerModel(int manuid, String manufacturer) {
        this.manuid = manuid;
        this.manufacturer = manufacturer;
    }

    public int getManuid() {
        return manuid;
    }

    public void setManuid(int manuid) {
        this.manuid = manuid;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
