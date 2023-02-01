package MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a-ProductService i implemente et ve metodları book a uygun şekilde doldur
public class BookService implements ProductService {
    //3-bookları saklamak için list oluştur

    List<Book> bookList = new ArrayList<>();

    //4-başlangıçta kayıtlı kitaplar olsun
    public BookService() {
        Book book1 = new Book(1, "Vadideki Zambak", "150 Lira", 25, "Balzac", "Penguin");
        Book book2 = new Book(2, "Suç ve Ceza", "150 Lira", 12, "Dostoyevski", "Penguin");
        Book book3 = new Book(3, "Sefiller", "125 Lira", 15, "V.Hugo", "Dream");
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }

    //5-bookla ilgili işlemleri gösteren menü

    @Override
    public void processMenu() {
        Scanner inp = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("1-Kitapları Listele");
            System.out.println("2-Kitap ekle");
            System.out.println("3-Kitap sil");
            System.out.println("4-Yayınevine göre filtrele");
            System.out.println("0-Geri dön");
            System.out.println("Seçiminiz:");
            choice = inp.nextInt();
            switch (choice) {
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    System.out.println("Yayınevi :");
                    String pub = inp.next();
                    filterProduct(pub);
                    break;
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz.");
                    break;
                default:
                    System.out.println("Hatalı giriş.");
                    break;
            }

        }

    }

    //6-bookları formatla yazdır
    @Override
    public void listProduct() {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n", "ID", "Kitap Adı", "Yazar Adı", "Yayınevi", "Birim Fiyat", "Stok");
        for (Book book : this.bookList) {
            System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",
                    book.getId(), book.getName(), book.getAuthorName(), book.getPublisher(), book.getPrice(), book.getStock());
        }
        System.out.println("------------------------------------------------------------------------");
    }

    //7-kullanıcıdan alınan bilgilerle book oluştur, listeye ekle
    @Override
    public void addProduct() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Kitap adı:");
        String bookName = inp.nextLine();
        System.out.println("Yazar adı: ");
        String authorname = inp.nextLine();
        System.out.println("Yayınevi :");
        String pub = inp.nextLine();
        System.out.println("Birim Fiyat :");
        String price = inp.nextLine();
        System.out.println("Stok : ");
        int stock = inp.nextInt();

        Book newBook = new Book(this.bookList.get(this.bookList.size() - 1).getId() + 1, bookName, price, stock, authorname, pub);
        this.bookList.add(newBook);
    }

    //8-kullanıcıdan id al, id ile book bul, listeden kaldır
    @Override
    public void removeProduct() {
        Scanner inp = new Scanner(System.in);
        boolean isExist = true;
        System.out.println("Kitap id: ");
        int id = inp.nextInt();
        for (Book book : this.bookList) {
            if (book.getId() == id) {
                isExist = true;
                this.bookList.remove(book);
                System.out.println("Kitap silindi.");
                break;
            } else {
                isExist = false;
            }
        }
        if (!isExist) {
            System.out.println("Kitap bulunamadı.");
        }
    }

    //9-tüm kitapların yayınevine bak, filter ile aynı ise yazdır
    @Override
    public void filterProduct(String filter) {
        for (Book book : this.bookList) {
            if (book.getPublisher().equalsIgnoreCase(filter)) {//Penguin
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-5s \n",
                        book.getId(), book.getName(), book.getAuthorName(), book.getPublisher(), book.getPrice(), book.getStock());
            }
        }
    }
}