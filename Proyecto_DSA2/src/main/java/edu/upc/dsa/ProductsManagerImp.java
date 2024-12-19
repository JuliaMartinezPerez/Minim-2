package edu.upc.dsa;

import edu.upc.dsa.models.Products;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;


public class ProductsManagerImp implements ProductsManager {
    private static ProductsManager instance;
    protected List<Products> products;
    final static Logger logger = Logger.getLogger(ProductsManagerImp.class);

    private ProductsManagerImp() {
        this.products = new LinkedList<>();
    }

    public static ProductsManager getInstance() {
        if (instance==null) instance = new ProductsManagerImp();
        return instance;
    }

    @Override
    public Products addProduct(Products o) {
        //logger.info("new Object added: " + o);
        this.products.add(o);
        return o;
    }

    @Override
    public Products addProduct(String nameProduct, String price) {
        int id = this.size() + 1;
        int priceInt = Integer.parseInt(price); // Convertir el precio a entero
        logger.info("new Object added: " + nameProduct + " with id " + id + " and price " + priceInt);
        return this.addProduct(new Products(id, nameProduct, priceInt));
    }

    @Override
    public Products addProduct(int id, String nameProduct, int price) {
        logger.info("new Object added: " + nameProduct + " with id " + id + " and price " + price);
        return this.addProduct(new Products(id, nameProduct, price));
    }

    @Override
    public List<Products> getProducts() {
        logger.info("Productos recibidos:" + this.products.size());
        return this.products;
    }

    @Override
    public int size() {
        int ret = this.products.size();
        logger.info("size productos " + ret);
        return ret;
    }

    @Override
    public Products getProduct(String name) {
        for (Products p: this.products) {
            if (p.getNameProduct().equals(name)) {
                logger.info("getProduct("+name+"): "+ p.getDatos());
                return p;
            }
        }
        logger.warn("not found "+name);
        return null;
    }

    @Override
    public Products findProduct(int id) {
        for (Products p: this.products) {
            if (p.getId()==id) {
                logger.info("Producto con id "+id+" encontrado: " + p.getDatos());
                return p;
            }
        }
        logger.warn("not found "+id);
        return null;
    }


}
