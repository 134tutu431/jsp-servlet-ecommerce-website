package Dao;

import Model.*;

import java.time.LocalDate;
import java.util.List;

public class test {
    public static void main(String[] args) {
        CommentDao commentDao = new CommentDao();
        System.out.println(commentDao.commentModelsbyproid("1"));
        System.out.println(LocalDate.now());
    }
}
