package test.liugang.com.myframework.model.bean;

/**
 * @ Description:
 * @ Date:2017/7/26
 * @ Author:刘刚
 */

public class JokeBean {
private String head;
private String user;
private String time;
private String title;
private Boolean isCheck;


    public JokeBean() {
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
