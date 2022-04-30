package lambda;

import java.util.*;

public class L02_Lambda {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftKarePrint(sayi);
        System.out.println("\n**********");
        ciftKupBirFazlaPrint(sayi);
        System.out.println("\n**********");
        ciftKarekokPrint(sayi);
        System.out.println("\n**********");
        maxElBul(sayi);
        System.out.println("\n**********");
        ciftKarteMaxBul(sayi);
        System.out.println("\n**********");
        elTopla(sayi);
        System.out.println("\n**********");
        ciftCarp(sayi);
        System.out.println("\n**********");
        minBul(sayi);
        System.out.println("\n**********");
        bestenBuyukEnKucukYazdir(sayi);
        System.out.println("\n**********");
        ciftKareKbPrint(sayi);
        System.out.println("\n**********");
        tekKareBkPrint(sayi);

    }
    // Task : Functional Programming ile listin cift elemanlarinin
    // karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    private static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(L01_Lambda::ciftBul).
                map(t -> t * t). //map()--> Stream içerisindeki elemanları başka tiplere
                // dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
                        forEach(L01_Lambda::yazdir);
    }

    // Task : Functional Programming ile listin tek elemanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi

    private static void ciftKupBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream().                       //sayilar akısa  alındı
                filter(t -> t % 2 != 0).        //tek elemnalar fitrelendi
                map(t -> (t * t * t) + 1).             // tek elemanları küplerinin 1 fazlasına udate edildi
                forEach(L01_Lambda::yazdir);    //print edildi
    }
    // Task : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    private static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(L01_Lambda::ciftBul).
                map(Math::sqrt).forEach(t -> System.out.print(t + " "));
    }

    // Task : list'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max);

        System.out.println(maxSayi);
        System.out.println("halukca :" + sayi.stream().reduce(Math::max));//halukca : 15

    }

    /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde)
        cevirmek icin kullanilir. kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir.
        Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
        bir sonraki adıma girdi olarak sunulmaktadır.
        Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri,
        ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
        */


    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKarteMaxBul(List<Integer> sayi) {
        Optional<Integer> maxSayi;

        maxSayi = sayi.
                stream().
                filter(L01_Lambda::ciftBul).
                map(t -> t * t).
                reduce(Math::max);

        System.out.println(maxSayi);
        System.out.println("halukca :" + sayi.stream().reduce(Math::max));//halukca : 36

        System.out.println("daha hızlı specific ınteger class : ");
        maxSayi = sayi.
                stream().
                filter(L01_Lambda::ciftBul).
                map(t -> t * t).
                reduce(Integer::max);

        System.out.println(maxSayi);
        System.out.println("halukca :" + sayi.stream().reduce(Math::max));//halukca : 36

    }
    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...

    public static void elTopla(List<Integer> sayi) {

        int toplam = sayi.stream().reduce(0, (a, b) -> (a + b));

        /*
        a ilk degerini her zaman atanan degerden (identity) alır
        b degerini her zamana  stream()'dan akısdan alır
        a ilk degerinden sonraki her değeri action(işlem)'dan alır
         */

        System.out.println(toplam);

        System.out.println(sayi.stream().reduce(Integer::sum));
    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarp(List<Integer> sayi) {

        // method ref
        System.out.println("Method ref : " + sayi.
                stream().
                filter(L01_Lambda::ciftBul).
                reduce(Math::multiplyExact));

        // lambda expression

        System.out.println("Lambda exp : " + sayi.
                stream().
                filter(L01_Lambda::ciftBul).
                reduce(1, (a, b) -> (a * b)));

    }
    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.

    public static void minBul(List<Integer> sayi) {

        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println(minSayiInteger);

        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath);

        //3. yontem Lambda Expression
        int minSayiLJambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println(minSayiLJambda);

        //4. yontem Method Reference --> Haluk class
        Optional<Integer> minSayiHaluk = sayi.stream().reduce(L02_Lambda::byAlikanMinBul);
        System.out.println(minSayiHaluk);

    }

    public static int byAlikanMinBul(int a, int b) {
        //bu method kendisine verilen iki int degerin en kücügunu return eder

        return a < b ? a : b;
    }

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBuyukEnKucukYazdir(List<Integer> sayi) {

        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(L02_Lambda::byAlikanMinBul));

    }

    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbPrint(List<Integer> sayi) {
        sayi.
                stream().//akısa alındı
                filter(L01_Lambda::ciftBul).//cift elemnlar fitrlenedi
                map(t -> t * t).//fitrelenen cift sayı karesi alındı
                sorted().//karesi alınan elemanlar dogal(k->b) sıralandı
                forEach(L01_Lambda::yazdir);//print edildi

        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
        //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.
    }

    public static void tekKareBkPrint(List<Integer> sayi) {
        sayi.//akıs kaynagı
                stream().//akısa alındı
                filter(t -> t % 2 != 0).//tek elemnlar fitrlenedi
                map(t -> t * t).//fitrelenen cift sayı karesi alındı
                sorted(Comparator.reverseOrder()).//karesi alınan elemanlar ters(b->k) sıralandı
                forEach(L01_Lambda::yazdir);//print edildi

    }


}
