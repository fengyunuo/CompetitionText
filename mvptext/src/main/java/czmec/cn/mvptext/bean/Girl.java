package czmec.cn.mvptext.bean;

/**
 * Created by 风雨诺 on 2019/1/23.
 */

public class Girl {
    private String level;


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;
    private int img;

    public int getimg() {
        return img;
    }

    public void setGirlimg(int girlimg) {
        this.img = girlimg;
    }

    public Girl(int girlimg,String level, String info) {
        this.level = level;
        this.info = info;
        this.img = girlimg;
    }
}
