package edu.upc.dsa.models;

public class Products {
    int id;
    String nameProduct;
    int price;

    public Products(int id, String nameProduct, int price) {
        this();
        this.setId(id);
        this.setNameProduct(nameProduct);
        this.setPrice(price);
    }

    public Products() {
    }

    public String getDatos(){
        return "Product [id="+id+", name=" + nameProduct + ", price=" + price + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
