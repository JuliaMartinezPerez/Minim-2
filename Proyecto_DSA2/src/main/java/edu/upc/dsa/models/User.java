package edu.upc.dsa.models;

import edu.upc.dsa.models.Products;
import edu.upc.dsa.util.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class User {
    String id;
    String email;
    String username;
    String password;
    int dinero = 20;

    List<Products> productos;


    public User(String email, String username, String password) {
        this();
        this.email = email;
        this.username = username;
        this.password = password;
        if (id != null) this.setId(id);
        this.productos = new LinkedList<>();
    }
    public User() {
        this.setId(RandomUtils.getId());
    }

    public String getDatos(){
        return "User [id="+id+", email=" + email + ", username=" + username +
                ", password="+ password + ", dinero=" + dinero + "]";
    }

    private void setId(String id) {
        this.id=id;
    }

    public String getId(){
        return id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Products> getProductos(){return productos; }
    public void addProducto(Products p){
        productos.add(p);
        dinero = dinero - p.getPrice();
    }

    public int getDinero(){
        return this.dinero;
    }
    public String getEmail(){
        return email;
    }
    public void setDinero(int dinero){
        this.dinero = dinero;
    }


    public void setProductos(List<Products> productos){this.productos = productos; }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}

