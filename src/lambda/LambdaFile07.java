package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class LambdaFile07 {
    public static void main(String[] args) {

    //functional programming kullanarak bir dosya nasıl okunur

        try {
            Files.lines(Paths.get("C:\\Users\\Muhammed Furkan Yılm\\eclipse-workspace\\lambda\\src\\lambda\\LambdaFile"))
                    .forEach(t->System.out.println(t));
        } catch (IOException e) {
            System.out.println(e);
        }
/*
Java kolaydır, lambda daha kolaydır.
Lambda öğrenirseniz kodlama daha az zaman alacaktır.
Kursumuzdaki her ders ceketin cepleriyse, java iç cep, lambda da iç cebin bozuk para  kısmı
 */


//Tüm karakterleri büyük harfe dönüştürün ve okuyun
        try {
            Files.lines(Paths.get("C:\\Users\\Muhammed Furkan Yılm\\eclipse-workspace\\lambda\\src\\lambda\\LambdaFile"))
                    .map(String::toUpperCase).forEach(t->System.out.println(t));
        } catch (IOException e) {
            System.out.println(e);
        }
/*
JAVA KOLAYDIR, LAMBDA DAHA KOLAYDIR.
LAMBDA ÖĞRENİRSENİZ KODLAMA DAHA AZ ZAMAN ALACAKTIR.
KURSUMUZDAKİ HER DERS CEKETİN CEPLERİYSE, JAVA İÇ CEP, LAMBDA DA İÇ CEBİN BOZUK PARA  KISMI

 */



        //metindeki farklı kelimeleri yazdır
        try {
            Files.lines(Paths.get("C:\\Users\\Muhammed Furkan Yılm\\eclipse-workspace\\lambda\\src\\lambda\\LambdaFile"))
 .map(t->t.split(" ")).flatMap(Arrays::stream).map(t->t.replaceAll("\\W","")).distinct().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }



// metinde "e" içeren tüm kelimeleri yazdırın. (sayısınıda yazdırabilirsin)

        try {
            Files.lines(Paths.get("C:\\Users\\Muhammed Furkan Yılm\\eclipse-workspace\\lambda\\src\\lambda\\LambdaFile"))
                    .map(t->t.split(" ")).flatMap(Arrays::stream).filter(t->t.contains("e")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }


    }
}
