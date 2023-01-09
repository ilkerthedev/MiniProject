package biletFiyatHesaplama;

public class Bilet {

    public int distance;

    public int typeNo;

    public double price;

    public int seatNo;

    public void printBilet(Bus bus){
        System.out.printf("Toplam Tutar: "+"%.2f",price);
        System.out.println();
        System.out.println("---Bilet Detay---");
        System.out.println("Otobüs plakası: "+bus.numberPlate);
        System.out.println("Mesafe: "+distance+"km");
        System.out.println("Yolculuk tipi: "+((typeNo==1) ? "Tek Yön" : "Gidiş-Dönüş"));
        System.out.println("Koltuk numarası: "+seatNo);
        System.out.println("Keyifli yolculuklar dileriz");
    }

}
