package lambda;

import java.util.stream.IntStream;

public class L05_Lambda {
    public static void main(String[] args) {
        System.out.println("TASK 01 -->");

        System.out.println("Task01 Amele: " + toplaAmele(10));
        System.out.println("Task01 Cincix: " + toplaCincix(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->");
        System.out.println("TASK 02 cift topla-->" + toplaCiftCincix(10));
        System.out.println("   ***   ");


        System.out.println("TASK 03 -->");
        System.out.println("TASK 03 ilk x cift sayiyi topla-->" + toplailkXCiftSayiCincix(10));
        System.out.println("   ***   ");


        System.out.println("TASK 04 -->");
        System.out.println("TASK 04 ilk x tek sayiyi topla-->" + toplailkXTekSayiCincix(10));
        System.out.println("   ***   ");


        System.out.println("TASK 05 -->");
        ikininilkXkuvetiniYazdir(30);
        System.out.print("\n");
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        birSayininIlkXkuvetiniYazdir(5, 10);
        System.out.print("\n");
        birSayininIlkXkuvetiniYazdir(10, 5);
        System.out.print("\n");
        birSayininIlkXkuvetiniYazdir(7, 2);
        System.out.print("\n");
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->");
        System.out.println(birSayininFaktoriyeliniBul(6));
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->");
        birSayininXinciKuvetiniYazdir(2,7);
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming

    public static int toplaAmele(int x) {

        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum += i;
        }
        return sum;
    }


    //Functional(cincix Programming

    public static int toplaCincix(int x) {

        return IntStream.
                range(1, x + 1).  // birden x+1e kadar toplar, x+1i almaz xi alır, EXCLUSIVE
                        sum(); // toplar
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCiftCincix(int x) {

        return IntStream.
                rangeClosed(1, x). // birden x'e kadar toplar, x'i de alır, INCLUSIVE
                        filter(L01_Lambda::ciftBul).
                sum();

    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplailkXCiftSayiCincix(int x) {

        return IntStream.
                iterate(2, t -> t + 2).      // 2den sonsuza kadar elemanlari 2 artirarak elemanlari akışa alır
                        limit(x).
                sum();

        /*
        iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy
         */
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplailkXTekSayiCincix(int x) {

        return IntStream.
                iterate(1, t -> t + 2).      // 1den sonsuza kadar elemanlari 2 artirarak elemanlari akışa alır
                        limit(x).
                sum();

        /*
        iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy
         */
    }


    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikininilkXkuvetiniYazdir(int x) {

        IntStream.
                iterate(2, t -> t * 2).
                limit(x).
                forEach(L01_Lambda::yazdir);
    }


    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void birSayininIlkXkuvetiniYazdir(int istenenSayi, int kacKereCarpilacak) {

        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).
                limit(kacKereCarpilacak).
                forEach(L01_Lambda::yazdir);
    }


    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int birSayininFaktoriyeliniBul(int x) {

        return IntStream.
                rangeClosed(1, x).
                //reduce(1,(t,u)->t*u).
                        reduce(1, Math::multiplyExact);
    }


    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.

    public static void birSayininXinciKuvetiniYazdir(int istenenSayi, int kuvvet) {

        System.out.println(IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).
                limit(kuvvet).
        //        skip(kuvvet - 1).
                reduce(1, (t, u) -> t = u));
        //forEach(L01_Lambda::yazdir);

       // System.out.println("Math.pow"+ Math.pow(istenenSayi,kuvvet)); referans dondurdu
    }


}
