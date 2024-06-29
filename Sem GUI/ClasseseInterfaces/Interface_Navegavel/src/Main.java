import javax.management.ObjectName;
import java.awt.datatransfer.Clipboard;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Navegavel barco = new Barco();


        Navegavel submarino = new Submarino();
        barco.navegavel(1);


    }
}