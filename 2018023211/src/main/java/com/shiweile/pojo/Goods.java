package com.shiweile.pojo;

public class Goods {
    private Integer id;
    private String name;
    //库存数量
    private int number;
    //待入库
    private int wait;
    //仓库
    private String storeHouse;
    //种类
    private String type;
    //制造厂商
    private String company;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", wait=" + wait +
                ", storeHouse='" + storeHouse + '\'' +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getwait() {
        return wait;
    }

    public void setwait(int wait) {
        this.wait = wait;
    }

    public String getStoreHouse() {
        return storeHouse;
    }

    public void setStoreHouse(String storeHouse) {
        this.storeHouse = storeHouse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Goods() {
    }

    public Goods(Integer id, String name, int number, int wait, String storeHouse, String type, String company) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.wait = wait;
        this.storeHouse = storeHouse;
        this.type = type;
        this.company = company;
    }
}
