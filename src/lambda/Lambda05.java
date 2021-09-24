package lambda;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda05 {
    public static void main(String[] args) {
        //1) 1'den 20'ye kadar olan sayilari yazdir
        IntStream.rangeClosed(1,20).forEach(MetodLambda2::bosluklaYazdir);
        //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
//-> range(1,20) olsaydi bunda 1'i alir 20'yi almazdi. reangeClosed() ile sonu da dahil ederiz
        System.out.println();


        //2) functional programlamayı kullanarak 3 den ile 98 e
        //  kadar olan çift tam sayıların toplamını bulun
        System.out.println(IntStream.rangeClosed(3, 98).filter(t -> t % 2 == 0).sum());//2448



        //3) functional programming kullanarak 9! i bul (9!=1*2*3...*9)
        System.out.println(IntStream.rangeClosed(1, 9).reduce(1, Math::multiplyExact));
                            //362880


    // 4) İlk 7 çift sayma sayısının çarpımını bulun (2,4,6,8,10,12,14)
        System.out.println(IntStream.rangeClosed(1, 2*7).filter(MetodLambda2::ciftMi).reduce(1, Math::multiplyExact));
        //645120



        //5)  6'dan büyük ilk 150 tek sayma sayısının toplamını bulun ==> 7, 9, 11, 13, 15, 17, 19
        System.out.println(IntStream.iterate(7, t -> t + 2).limit(150).sum());
            //23400


        //6) İlk 23 cift sayma sayısının toplamını bulun
        System.out.println(IntStream.iterate(2, t -> t + 2).limit(23).sum());
            //552

       // Fibonacci sayilarini yazdiran lambda formulu
       /* Stream.iterate(new Integer[] {0,1}, s -> new Integer[]{s[1], s[0] + s[1]})
                .limit(20) // ilk kacini istiyorsak
                .map(s -> s[0])
               .forEach(System.out::println);
 */

        //7)  11'den 33'e kadar  her tam sayının rakamlarının toplamını hesaplamak için bir metod oluşturun
        IntStream.rangeClosed(11,33).map(MetodLambda2::rakamlarToplami).forEach(MetodLambda2::bosluklaYazdir);
            //2 3 4 5 6 7 8 9 10 2 3 4 5 6 7 8 9 10 11 3 4 5 6
    }
}
