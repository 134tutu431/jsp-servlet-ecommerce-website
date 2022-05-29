package Model;

import java.util.Date;

public class ArticlesModel {
    private int id;
    private String title;
    private String noidungtg;
    private String noidung;
    private String date;
    private String image;
    private String imagect;

    public ArticlesModel(int id, String image,String title, String noidungtg, String noidung, String date, String imagect) {
        this.id = id;
        this.title = title;
        this.noidungtg = noidungtg;
        this.noidung = noidung;
        this.date = date;
        this.image = image;
        this.imagect = imagect;
    }

    public String getImagect() {
        return imagect;
    }

    public void setImagect(String imagect) {
        this.imagect = imagect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoidungtg() {
        return noidungtg;
    }

    public void setNoidungtg(String noidungtg) {
        this.noidungtg = noidungtg;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ArticlesModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", noidungtg='" + noidungtg + '\'' +
                ", noidung='" + noidung + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
