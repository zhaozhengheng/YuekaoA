package com.bawei.yuekaoA;

/**
 * Created by 1 on 2017/3/29.
 */
public class Bean
{
    private String image;
    private String jieshao;
    private String diqu;
    private String jiage;
    private String dizongjia;
    private String fangzi;

    public Bean(String image, String jieshao, String diqu, String jiage, String dizongjia, String fangzi) {
        this.image = image;
        this.jieshao = jieshao;
        this.diqu = diqu;
        this.jiage = jiage;
        this.dizongjia = dizongjia;
        this.fangzi = fangzi;
    }

    public Bean() {
        super();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJieshao() {
        return jieshao;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }

    public String getDiqu() {
        return diqu;
    }

    public void setDiqu(String diqu) {
        this.diqu = diqu;
    }

    public String getJiage() {
        return jiage;
    }

    public void setJiage(String jiage) {
        this.jiage = jiage;
    }

    public String getDizongjia() {
        return dizongjia;
    }

    public void setDizongjia(String dizongjia) {
        this.dizongjia = dizongjia;
    }

    public String getFangzi() {
        return fangzi;
    }

    public void setFangzi(String fangzi) {
        this.fangzi = fangzi;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "image='" + image + '\'' +
                ", jieshao='" + jieshao + '\'' +
                ", diqu='" + diqu + '\'' +
                ", jiage='" + jiage + '\'' +
                ", dizongjia='" + dizongjia + '\'' +
                ", fangzi='" + fangzi + '\'' +
                '}';
    }
}
