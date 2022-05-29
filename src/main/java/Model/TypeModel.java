package Model;

public class TypeModel {
    private int typeid;
    private String type;

    public TypeModel(int typeid, String type) {
        this.typeid = typeid;
        this.type = type;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
