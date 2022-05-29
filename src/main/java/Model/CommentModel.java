package Model;

public class CommentModel {
    private int id;
    private String comment;
    private String name;
    private String proid;
    private String date;

    public CommentModel(int id, String comment, String name, String proid, String date) {
        this.id = id;
        this.comment = comment;
        this.name = name;
        this.proid = proid;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
