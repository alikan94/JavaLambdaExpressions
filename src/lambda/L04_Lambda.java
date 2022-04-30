package lambda;

import java.util.*;
import java.util.stream.Collectors;

public class L04_Lambda {
    public static void main(String[] args) {
        University bogazici = new University("bogazici", "matematik", 571, 93);
        University itu = new University("istanbul teknik", "matematik", 622, 81);
        University istanbul = new University("istanbul", "hukuk", 1453, 71);
        University marmara = new University("marmara", "bilgisayar muh", 1071, 77);
        University ytu = new University("yıldız teknik", "gemi", 333, 74);
        List<University> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println("Tum okullarda 74'ten buyuk mu ortalamalar? : " + notOrt74denBuyukUniYazdir(unv));
        System.out.println("********************************************");
        System.out.println("Tum okullarda 110'dan az mi ogrenci sayisi? : " + ogrSayisi110AzMi(unv));
        System.out.println("********************************************");
        System.out.println("Any bir okulda matematik bolumu var mi? : " + unideMatBolumVarMi(unv));
        System.out.println("********************************************");
        System.out.println("Ogrenci sayisina göre unileri sirala? : " + unileriOgrSayisinaGoreBKSirala(unv));
        System.out.println("********************************************");
        unileriNotOrtaGoreBK3tanesiniSiralaYazdir(unv);
        System.out.println("********************************************");
        ogrSayisiEnAzOlan2nciUniyiYazdir(unv);
        System.out.println("********************************************");
        System.out.println("notOrt 63 'den buyuk olan unilerin ogr sayisi toplami : " + notOrt63denBuyukUnilerinOgrToplami(unv));
        System.out.println("********************************************");
        System.out.println("ogr Sayisi 571'den buyuk olan unilerin not ort : " + ogrSayisi700denBuyukUnilerinNotOrtu(unv));
        System.out.println("********************************************");
        System.out.println("Mat Bolumlerinin Sayisi : " + matBolSayisiniYazdir(unv));
        System.out.println("********************************************");
        System.out.println("ogr Sayisi 500'den buyuk olan unilerin en buyuk not ort : " + ogr571denFazlaOlanUnilerinEnBuyukNotOrtu(unv));
        System.out.println("********************************************");
        System.out.println("ogr Sayisi 800'den az olan unilerin en kucuk not ort : " + ogr800denAzOlanUnilerinEnKucukNotOrtu(unv));
        System.out.println("********************************************");
        System.out.println("********************************************");


    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

    public static boolean notOrt74denBuyukUniYazdir(List<University> unv) {
        return unv.stream().allMatch(t -> t.getNotOrtalamasi() > 74);
    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrSayisi110AzMi(List<University> unv) {
        return unv.stream().allMatch(t -> t.getOgrSayisi() < 110);
    }


    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean unideMatBolumVarMi(List<University> unv) {
        return unv.stream().anyMatch(t -> t.getBolum().equals("matematik"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<University> unileriOgrSayisinaGoreBKSirala(List<University> unv) {
        return unv.
                stream().
                sorted(Comparator.
                        comparing(University::getOgrSayisi). // methodu direkt call ettik
                                reversed()).
                collect(Collectors.toList()); // liste ekledik
    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.

    public static void unileriNotOrtaGoreBK3tanesiniSiralaYazdir(List<University> unv) {
        System.out.println(unv.
                stream().
                sorted(Comparator.
                        comparing(University::getNotOrtalamasi).
                        reversed()).
                limit(3).
                collect(Collectors.toList())); // collect()-> istenen şarta göre toplar, biz liste ekledik
    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.

    public static void ogrSayisiEnAzOlan2nciUniyiYazdir(List<University> unv) {
        System.out.println(unv.
                stream().
                sorted(Comparator.
                        comparing(University::getOgrSayisi)).
                skip(1).
                limit(1).collect(Collectors.toList()));
    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz

    public static int notOrt63denBuyukUnilerinOgrToplami(List<University> unv) {
        return unv.
                stream().
                filter(t -> t.getNotOrtalamasi() > 63).
                //map(t -> t.getOgrSayisi()).
                mapToInt(t -> t.getOgrSayisi()).
                /*
                *mapToInt yaptigimiz icin cok asagidakilere gerek kalmadı
                reduce(Integer::sum)
                reduce(Math::addExact);
                reduce(0,(t,u)->t+u);
                 */
                sum();

        // mapToInt() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki() degere göre Int data type update eder
    }

    //task 08--> Ogrenci sayisi 700'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble ogrSayisi700denBuyukUnilerinNotOrtu(List<University> unv) {
        return unv.
                stream().
                filter(t->t.getOgrSayisi()>700).
                mapToDouble(t -> t.getNotOrtalamasi()).
                average();

        // mapToDouble() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki degere göre dooble data type update eder

    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.

    public static long matBolSayisiniYazdir(List<University> unv) {
        return unv.
                stream().
                filter(t -> t.getBolum().equals("matematik")).
                count();
    }

    //task 10-->Ogrenci sayilari 500'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static int ogr571denFazlaOlanUnilerinEnBuyukNotOrtu(List<University> unv) {
        return unv.
                stream().
                filter(t -> t.getOgrSayisi() > 571).
                mapToInt(University::getNotOrtalamasi).
                max().getAsInt();
    }

    //task 11-->Ogrenci sayilari 150'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static int ogr800denAzOlanUnilerinEnKucukNotOrtu(List<University> unv) {
        return unv.
                stream().
                filter(t -> t.getOgrSayisi() < 800).
                mapToInt(University::getNotOrtalamasi).
                min().getAsInt();
    }
}
