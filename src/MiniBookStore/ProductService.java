package MiniBookStore;
//2-tüm productların işlemleri
public interface ProductService {

    void processMenu();
    void listProduct();
    void addProduct();
    void removeProduct();
    void filterProduct(String filter);

}
