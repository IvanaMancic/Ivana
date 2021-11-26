import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        Artikal mleko = new Artikal (naziv:"mleko", cena:150, boja:"bela", kolicina:5);
        System.out.println("Artikal br 1: " + mleko.naziv + " sa cenom: " + mleko.cena);

    }
}
