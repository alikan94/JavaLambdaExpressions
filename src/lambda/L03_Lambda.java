package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class L03_Lambda {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokareç", "arabAşı", "güveç", "trileçe", "trileçe", "trileçe"));

        alfBykTekrrsz(menu);
        System.out.println("\n   ***   ");
        chrSayisiTersSirali(menu);
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menu);
        System.out.println("\n   ***   ");
        sonHrfBkSirala(menu);
        System.out.println("\n   ***   ");
        charKaresiCiftElSirala(menu);
        System.out.println("\n   ***   ");
        harfSayisi7denAzKontol(menu);
        System.out.println("\n   ***   ");
        elWIleBasKontrol(menu);
        System.out.println("\n   ***   ");
        elXIleBitKontrol(menu);
        System.out.println("\n   ***   ");
        charSayisiEnBuyukElYazdir(menu);
        System.out.println("\n   ***   ");
        sonHarfSiralaIlkHaricYazdir(menu);


    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> yemek) {
        yemek.
                stream().
                // map(t->t.toUpperCase()).//Jamb.Ex  elemanlar buyuk harf update edildi
                        map(String::toUpperCase). //Meth.Ref elemanlar buyuk harf update edildi
                sorted().           // alafabetik(natural dogal) sıra yapıldı
                distinct().         // benzersiz: tekrarsız hale getirildi
                forEach(t -> System.out.print(t + " "));

    }
    //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
    // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
    // Sıralı akışlar için, farklı elemanın seçimi sabittir
    // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
    // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.


    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    private static void chrSayisiTersSirali(List<String> menü) {

        menü.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(L01_Lambda::yazdir);

    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    private static void chrSayisiBkSirala(List<String> menü) {
        menü.
                stream().
                sorted(Comparator.comparing(String::length)).
                distinct().
                map(String::toUpperCase).
                forEach(t -> System.out.print(t + " "));
    }


    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.

    private static void sonHrfBkSirala(List<String> menü) {

        menü.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).
                        reversed()).
                map(String::toUpperCase).
                distinct().
                forEach(t -> System.out.print(t + " "));
    }


    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,
    // ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..

    public static void charKaresiCiftElSirala(List<String> menü) {
        menü.
                stream().
                map(String::length).
                filter(L01_Lambda::ciftBul).
                map(t -> (t * t)).
                distinct().
                sorted(Comparator.reverseOrder()).
                forEach(L01_Lambda::yazdir);
    }


    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontol(List<String> menü) {
        // amele kod
        boolean kontrol = menü.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("List elemanlari 7 harften az");
        } else System.out.println("List elemanlari 7 harften fazla");

        // clean code
        System.out.println(menü.stream().allMatch(t -> t.length() <= 7) ? "List elemanlari 7 harften az harften olusuyor" : "List elemanlari 7 harften fazla harften olusuyor");

    }

    //anyMatch()  --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch()  --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch() --> hicbiri sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void elWIleBasKontrol(List<String> menü) {

        System.out.println(menü.stream().anyMatch(t -> t.toUpperCase().startsWith("W")) ? "List elemanlarindan W ile baslayan var" : "List elemanlarindan hic W ile baslayan yok");
    }


    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.

    public static void elXIleBitKontrol(List<String> menü) {

        System.out.println(menü.stream().anyMatch(t -> t.toUpperCase().endsWith("X")) ? "List elemanlarindan X ile biten var" : "List elemanlarindan hic X ile biten yok");
    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void charSayisiEnBuyukElYazdir(List<String> menü) {

        System.out.println(menü.stream().reduce((a, b) -> a.length() > b.length() ? a : b));
        System.out.print("limitli kod : ");
        menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                // findFirst()); ilk elemanı alır
                limit(1).
                forEach(L01_Lambda::yazdir);
        System.out.println("");

        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.

        //limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır

        // limit akişa cevirir !!!!

        Stream<String> sonIsim = menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                // findFirst()); ilk elemanı alır
                        limit(5);

        System.out.println("Array hali : " + Arrays.toString(sonIsim.toArray()));

        /*
        TRİCK : •       Stream'ler ekrana direk yazdırılamaz.
                        Stream'i toArray() ile Array'e çeviririz.
                        Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
                        Ör; System.out.println(Arrays.toString(***.toArray()));
                •       veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.

   */

    }

        // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void sonHarfSiralaIlkHaricYazdir(List<String> menu) {

        menu.
                stream().
                sorted(Comparator.
                comparing(t -> t.toString().
                        charAt(t.toString().length() - 1))).
                skip(1).
                map(String::toUpperCase).
                forEach(t-> System.out.print(t + " "));

        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.

    }


}
