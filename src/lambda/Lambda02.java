package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {

        // Method Reference'da bizim oluşturduğumuz metodları  veya Java metodlarını kullanırız.
        //Method Reference Syntax ı ==> ClassName::MethodName
        // System.out.println();  ==  System.out::println;

        List<Integer> l=new ArrayList<>(Arrays.asList(15,14,9,13,4,9,2,4,14,6));

        elemanYazdir(l);
        System.out.println();
        ciftleriYazdir(l);
        System.out.println();
        tekSayiKare(l);
        System.out.println();
        tekrarsizTekKup(l);
        System.out.println();
        farkliCiftSayiKareToplam(l);
        System.out.println();
        farkliCiftSayiKupCarpim(l);
        System.out.println();
        farkliTersSirala(l);
        System.out.println();
        maxDeger(l);


    }



    //1)List in elemanlarını aralarında boşluk bırakarak yanyana yazdır.(Method Reference- kendi metodumuz)
    public static void elemanYazdir(List<Integer> l) {
    l.stream().forEach(MetodLambda2::bosluklaYazdir);// kendi methodumuz
        //   l.stream().forEach(System.out::println);// java'nin methodu
    }


    //2)List in elemanlarından çift olanları aralarında boşluk bırakarak yanyana yazdır..(Method Reference)
    public static void ciftleriYazdir(List<Integer> l) {
        l.stream().filter(MetodLambda2::ciftMi).forEach(MetodLambda2::bosluklaYazdir);
        //14 4 2 4 14 6
    }


    //3)List'teki tek sayıların karelerini alıp aralarında bosluk bırakarak yanyana yazdır
    public static void tekSayiKare(List<Integer> l) {
        l.stream().filter(MetodLambda2::tekMi).map(MetodLambda2::kareAl).forEach(System.out::print);
        //      2258116981 --> System'in methdodu
    }


    //4)List'teki tekrarlı olanları silip tek sayıların küplerini alıp aralarında boşluk bırakarak yanyana yazdır.
    public static void tekrarsizTekKup(List<Integer> l) {
        l.stream().distinct().filter(MetodLambda2::tekMi).map(MetodLambda2::kupAl).forEach(MetodLambda2::bosluklaYazdir);
            // 3375 729 2197
    }


    //5)Farklı çift sayıların karelerinin toplamını yazdır (Use Method Reference)
    public static void farkliCiftSayiKareToplam(List<Integer> l) {
        System.out.println(l.stream().distinct().filter(MetodLambda2::ciftMi).map(MetodLambda2::kareAl).reduce(0, Math::addExact));
                    //252
        //***** Math::addExact--> toplama, Multiply-> carpma
    }


    //6)Farklı çift sayıların küplerinin çarpımını yazdır .(Use Method Reference)
    public static void farkliCiftSayiKupCarpim(List<Integer> l) {
        System.out.println(l.stream().distinct().filter(MetodLambda2::ciftMi).map(MetodLambda2::kupAl).reduce(1,Math::multiplyExact));
        //303464448
    }


    //7)List teki farklı ve 5 ten büyük ve cift elemanlarının yarısını alıp ters sıralayarak list olarak yazdır.
    public static void farkliTersSirala(List<Integer> l) {
        System.out.println(l.stream().distinct().filter(t -> t > 5 && t % 2 == 0).map(t -> t / 2).sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
       //[7, 3]
        //collect-> collection gibi yazdir.. Collectors.toList-> list gibi yazdir
}


    //8) List teki en kucuk elemanı bul, en buyuk elemani bul
    public static void maxDeger(List<Integer> l) {
        System.out.println(l.stream().reduce(Integer.MAX_VALUE, Math::min));//2
        System.out.println(l.stream().reduce(Integer.MIN_VALUE, Math::max));//15

        l.stream().sorted(Comparator.reverseOrder()).limit(1).forEach(MetodLambda2::bosluklaYazdir);//15
        System.out.println(l.stream().sorted().limit(1));//15 java.util.stream.SliceOps$1@7225790e
        //--> terminal islemi olmadan yazdirirsan boyle garip sonuc alirsin
    }



}
