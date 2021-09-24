import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lambda01 {
    public static void main(String[] args) {

        List<Integer> l= new ArrayList<>(Arrays.asList(14,9,13,4,9,2,4,14,15));

        yazdirSJava(l);
        System.out.println();
        yazdirLambda(l);
        System.out.println();
        ciftSayiJava(l);
        System.out.println();
        ciftSayiLambda(l);
        System.out.println();

        tekSayiKare(l);
        System.out.println();

        farkliTekKup(l);
        System.out.println();

        ciftSayiKareToplam(l);

        tekrarsizCiftKupCarpim(l);

        tersDuzSira(l);


    }



    //1) List'in elemanlarini yan yana yazdir (Java structured)
    public static void yazdirSJava(List<Integer> list) {

        for (Integer w:list) {
            System.out.print(w+" ");//14 9 13 4 9 2 4 14 15
        }

    }

        //lambda (functional)
    public static void yazdirLambda(List<Integer> l){
        l.stream().forEach(t-> System.out.print(t+" "));// 14 9 13 4 9 2 4 14 15

        // forEach--> yazdirma islemi
    }


//2)List in elemanlarindan CIFT olanlari aralarinda bosluk birakarak yazdiran method olustur(Structured)

    public static void ciftSayiJava(List<Integer> l) {

        for (Integer w:l) {
            if (w % 2 == 0) {
                System.out.print(w+" ");//14 4 2 4 14
            }
        }
    }

    // lambda (functional)
    public static void ciftSayiLambda(List<Integer> l) {

        l.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));//14 4 2 4 14
       //lambda expression(lambda ile yazmaya denir)             (-> arrow function)
        //.filter-> filtreleme yapar elemanlari istedigimiz gibi aliriz. parantez icine kodunu yazariz
    }



    // 3) List teki tek sayilarin karelerini yazdiran metod olusturun
    public static void tekSayiKare(List<Integer> l) {

       l.stream().filter(t->t%2==1).map(t->t*t).forEach(t-> System.out.print(t+" "));//81 169 81 225
//map arada islem yapiyor ve t'leri degistiriyor
    }


    // 4) List'teki tekrarli elemanlari silip tek sayi olanlarin kuplerini yazdiran methodu yaziniz.
    public static void farkliTekKup(List<Integer> l) {
        /*  normalde bu sekilde yapmistik
        List<Integer> yeni = new ArrayList<>();
 for (Integer w:l) {if (!yeni.contains(w))
     yeni.add(w);*/

        l.stream().distinct().filter(t->t%2==1).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
                                        //729 2197 3375
        //.distinct--> bu method tekrarlilari siler
    }

    // 5)Listedeki tekrarli elemanlari silip cift sayi olanlarin karelerinin toplamini yazdiran method olustur
    public static void ciftSayiKareToplam(List<Integer> l) {
        /*  --java structure cözümü--
        List<Integer> yeni = new ArrayList<>();
for (Integer w:l) {
   if (!yeni.contains(w)&&w%2==0)
    yeni.add(w);  //*************
    } int toplam = 0;

    for (Integer w:yeni) {
        toplam=toplam+w*w;
}
System.out.println("uzun yol"+toplam);
         */

        //reduce()-> syntex'i asagidaki method gibidir TERMINAL'dir. Ya sona yazariz ya da bunun hepsini sout icine atariz
        // "x ve y" yerine istedigimizi yazariz.
        //0-> ilk deger
        //x-> toplam
        //y-> yandan gelen eleman (t)
        //x+y-> geleni topla demek
        System.out.println(l.stream().distinct().filter(t -> t %2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y));
                // 216
        //basina int sayi= yapip assign'da edebilirdik
    }


    //6) Listedeki tekrarli elemanlari silip cift sayı olanlarin kuplerinin carpimini yazdiran metod olustur.
    public static void tekrarsizCiftKupCarpim(List<Integer> l) {
        int sayi=l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (x, t) -> x * t);
        System.out.println(sayi); //1404928
    }


    //7)Listedeki elemanlari siralayarak ve ters siralayarak yazdir
    public static void tersDuzSira(List<Integer> l) {
        l.stream().sorted().forEach(t-> System.out.print(t+" "));// 2 4 4 9 9 13 14 14 15
        //sorted()-> kucukten buyuge siralar
        System.out.println();
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));//15 14 14 13 9 9 4 4 2
              //sorted(Comparator.reverseOrder())--> kucukten buyuge ..
        // Comparatordan (karsilastirma) faydalanmak gerekiyo
    }


}
