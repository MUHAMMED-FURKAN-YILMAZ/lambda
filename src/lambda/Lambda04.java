package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda04 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("Ali", "Ali", "Aysima", "Abdurrahman", "Mehmet", "Mustafa", "Bedirhan", "Yüksel", "Süleyman"));

        yazdirBuyuk1(l);
        System.out.println();
        uzunlukSirala(l);
        System.out.println();
        farklionHarfSirala(l);
        System.out.println();
        uzunlukSiralaIlkEleman(l);
        System.out.println();
        yazdirAileBaslayanlari(l);
        System.out.println();
        AbaslaVeyaIBit(l);
        System.out.println();
        siralaBuyut(l);
        System.out.println();
        isimUzunlukSirala(l);
        System.out.println();
        karesiniAlSiralaSil(l);
        System.out.println();
        ebikGabik(l);
        System.out.println();
        sondanIkınciSiralaIlk(l);
        System.out.println();
        terstenSiralaIlkYazdir(l);

    }

    //1-Listin elemanlarini buyuk harfle yazdir
    public static void yazdirBuyuk1(List<String> l) {
        //-->yol 1
        l.stream().map(t -> t.toUpperCase()).forEach(MetodLambda2::bosluklaYazdir);
        //ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN
        System.out.println();
        //-->yol 2
        l.stream().map(String::toUpperCase).forEach(MetodLambda2::bosluklaYazdir);
        //ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN
    }

    //2-elemanları uzunluklarına göre sırala ve yazdır
    //Java, elemanlari varsayilan olarak artan siraya koyar
    public static void uzunlukSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).forEach(MetodLambda2::bosluklaYazdir);
//Ali Ali Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman

        //comparing-> ben belirleyecegim diyorum

        System.out.println();
        // bu da uzundan kisaya
        l.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(MetodLambda2::bosluklaYazdir);
        //Abdurrahman Bedirhan Süleyman Mustafa Aysima Mehmet Yüksel Ali Ali
    }


    //3) farklı elemanlarını son harflerine göre sıralayıp yazdır
    public static void farklionHarfSirala(List<String> l) {
        l.stream().distinct().sorted(Comparator.comparing(t -> t.substring(t.length() - 1))).forEach(MetodLambda2::bosluklaYazdir);
        //Aysima Mustafa Ali Yüksel Abdurrahman Bedirhan Süleyman Mehmet
        // comparing-> yine ben karsilastircam. t'ler gelsin teker teker o t'lerin son harfine gore kes ve sirala
    }

//4) Elemanları uzunluklarına ve ardından (aynı uzunlukta olanları) ilk
//      karakterlerine göre sıralamak için bir yöntem oluşturun
    private static void uzunlukSiralaIlkEleman(List<String> l) {
        l.add("Ata");
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.substring(0,1))).forEach(MetodLambda2::bosluklaYazdir);
        //Ali Ali Ata Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.substring(0,1)).thenComparing(t->t.substring(1,2))).forEach(MetodLambda2::bosluklaYazdir);
        //Ali Ali Ata Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman
       // 2.sinde Ali ve Ata arasinda a ayni ise ardindan 2. harflere baktirdik
    }


    //5)Büyük harflerle, "A" ile başlayan liste öğelerini yazdırmak için bir yöntem oluşturun
    public static void yazdirAileBaslayanlari(List<String> l) {

        l.stream().filter(t->t.startsWith("A")).map(String::toUpperCase).forEach(MetodLambda2::bosluklaYazdir);
    //ALİ ALİ AYSİMA ABDURRAHMAN ATA
    }


//6)  Küçük harflerle, "A" ile başlayan veya "i" ile biten liste
//      öğelerini yazdırmak için bir yöntem oluşturun
    private static void AbaslaVeyaIBit(List<String> l) {

        l.stream().filter(t->t.startsWith("A") || t.endsWith("i")).forEach(MetodLambda2::bosluklaYazdir);
    //Ali Ali Aysima Abdurrahman Ata

        //method reference ile yaparsak komutlarin icine sadece bir islem alabiliriz.
        //Ama (t->) function'da &&-|| 'larla istedigimiz kadar islem alabiliriz
    }


    //7) Öğeleri uzunluklarına göre sıraladıktan sonra büyük harflerle
    //      yazdırmak için bir yöntem oluşturun
    public static void siralaBuyut(List<String> l) {
        l.stream().map(String::toUpperCase).sorted(Comparator.comparing(String::length)).forEach(MetodLambda2::bosluklaYazdir);
 //ALİ ALİ ATA AYSİMA MEHMET YÜKSEL MUSTAFA BEDİRHAN SÜLEYMAN ABDURRAHMAN
    }


    //8) Elemanları uzunluklarına göre sıralayın önce elemanı sonra uzunluğunu yazdırın
    // Ali:3 Aysima:6 vs gibi
    public static void isimUzunlukSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).map(t->t+":"+t.length()).forEach(MetodLambda2::bosluklaYazdir);
//Ali:3 Ali:3 Ata:3 Aysima:6 Mehmet:6 Yüksel:6 Mustafa:7 Bedirhan:8 Süleyman:8 Abdurrahman:11
//--> ayni sout gibi (t->) function'da da icine biseyler yazabiliyoruz.. burada map icine yazdik
    }


    //9) Her elemanın uzunluğunun karesini alıp tekrarlıları sil,
    //      bunların 20'den büyük olanlarını ters sırada  yazdırın
    public static void karesiniAlSiralaSil(List<String> l) {
        l.stream().map(t -> t.length() * t.length()).distinct().filter(t -> t > 20).sorted(Comparator.reverseOrder()).forEach(MetodLambda2::bosluklaYazdir);
        //121 64 49 36
    }


//10) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol etmek için bir metod oluşturun
//bütün elemanların "x" ile başlamadığını kontrol etmek için bir yöntem oluşturun
//en az 1 tane "R" ile biten eleman olup olmadığını kontrol etmek için bir metod oluşturun.
        public static void ebikGabik(List<String> l) {

      boolean resul1=l.stream().allMatch(t->t.length()<12);
            System.out.println("elemanlarin uzunluklari 12'den kucuk mu?-> "+resul1);
//elemanlarin uzunluklari 12'den kucuk mu?-> true

      boolean result2=l.stream().noneMatch(t->t.startsWith("X"));
            System.out.println("X ile baslayan oge var mi?->"+result2);
//X ile baslayan oge var mi?->true

      boolean result3=l.stream().anyMatch(t->t.endsWith("R"));
            System.out.println("Elemanlardan herhangi biri R ile bitiyor mu?->"+result3);
//Elemanlardan herhangi biri R ile bitiyor mu?->false
    }


   //11) elemanları sondan 2. elemanlarına göre sıralayıp ilk elemanı yazdır
   public static void sondanIkınciSiralaIlk(List<String> l) {

       System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 2))).findFirst());
   //Optional[Abdurrahman]
    }


    // 12)elemanlari uzunluklarina gore tersten siralayip ilk elemani yazdir
    private static void terstenSiralaIlkYazdir(List<String> l) {

        l.stream().sorted(Comparator.comparing(String::length).reversed()).limit(1).forEach(MetodLambda2::bosluklaYazdir);
        //Abdurrahman
        System.out.println();


        //12)Eleman 'A', 'a' ile başlıyor veya 'N', 'n' ile bitiyorsa o elemanı silin
        l.removeIf(t->t.toUpperCase().startsWith("A") || t.toUpperCase().endsWith("N"));
        System.out.println(l);// [Mehmet, Mustafa, Yüksel]
        // burada kalici olarak degistirdik. lambda kullanmadik aslinda yardim aldik.

    }

}