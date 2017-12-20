package yebstore;

import java.util.List;

public interface Controller {

    List<Product> getProducts();

    void buyProduct(int id);
}
