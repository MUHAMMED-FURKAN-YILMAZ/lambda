package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(7, 12, 14, 4, 9, 2, 4, 12, 16));

        ilkDortEleman(l);
        System.out.println();
        ilkDortElemanGec(l);
        System.out.println();
        ucEleman(l);
    }

    //1) Kucukten buyuge sirala sonra ilk 4 elemani yazdir.
    public static void ilkDortEleman(List<Integer> l) {
        l.stream().sorted().limit(4).forEach(MetodLambda2::bosluklaYazdir);//2 4 4 7
        //limit-> icine yazdiginiz sayi kadar eleman getirir
    }

    //2)kucukten buyuge sirala ilk 4 elemani atla
    public static void ilkDortElemanGec(List<Integer> l) {
        l.stream().sorted().skip(4).forEach(MetodLambda2::bosluklaYazdir);//9 12 12 14 16
        //skip--> gec demek. icinde yazdigi kadar geciyor
    }

        //3) küçükten büyüğe sıralı, 4. 5. 6. elemanı yazdır
        public static void ucEleman(List<Integer> l) {
            l.stream().sorted().skip(3).limit(3).forEach(MetodLambda2::bosluklaYazdir);// 7 9 12

    }


}
