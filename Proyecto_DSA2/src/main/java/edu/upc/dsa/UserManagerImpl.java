package edu.upc.dsa;

import edu.upc.dsa.models.Products;
import edu.upc.dsa.models.User;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
public class UserManagerImpl implements UserManager{
    private static UserManager instance;
    protected List<User> users;
    final static Logger logger = Logger.getLogger(UserManagerImpl.class);

    private UserManagerImpl() {
        this.users = new LinkedList<>();
    }

    public static UserManager getInstance() {
        if (instance==null) instance = new UserManagerImpl();
        return instance;
    }

    @Override
    public User Register(User u) {
        this.users.add(u);
        logger.info("new User added: " + u.getDatos());
        return u;
    }

    @Override
    public User Register(String username, String password, String email) {
        User u = new User(email, username,password);
        return this.Register(u);
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public User updateUser(User u) {
        for (int i=0; i<this.users.size(); i++) {
            if (this.users.get(i).getUsername().equals(u.getUsername())) {
                this.users.set(i, u);
                logger.info("updateUser("+u.getUsername()+"): "+u.getDatos());
                return u;
            }
        }
        logger.warn("not found "+u.getUsername());
        return null;
    }

    @Override
    public User deleteUser(String username, String password) {
        logger.info("Trying deleteUser("+username+")");
        for (int i=0; i<this.users.size(); i++) {
            User u = this.users.get(i);
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                logger.info("deleteUser("+username+"): "+u.getDatos());
                this.users.remove(i);
                return u;
            }
        }
        logger.warn("not found "+username);
        return null;
    }

    @Override
    public User IniciarSesion(String user, String password) {
        logger.info("Trying logIn("+user+")");
        for (User u : this.users) {
            if ((u.getUsername().equals(user) || u.getEmail().equals(user))
                    && u.getPassword().equals(password)) {
                logger.info("logIn(" + user + ") succesful: " + u.getDatos());
                return u; //success
            }
        }
        logger.warn("not found "+user);
        return null; //user not found
    }

    @Override
    public int size() {
        int ret = this.users.size();
        logger.info("size " + ret);
        return ret;
    }

    @Override
    public List<Products> getProductsOfUser(User u) {
        return u.getProductos();
    }

    @Override
    public void addProductToUser(User u, Products p) {
        u.addProducto(p);
        logger.info("Producto añadido al usuario " + u.getDatos());
    }

    @Override
    public User getUser(String id) {
        for (User u : this.users) {
            if (u.getId().equals(id)) {
                logger.info("getUser(" + id + "): " + u.getUsername());
                return u;
            }
        }
        logger.warn("not found "+id);
        return null;
    }



}
