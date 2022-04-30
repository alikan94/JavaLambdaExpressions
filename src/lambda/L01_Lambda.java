package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L01_Lambda {
    public static void main(String[] args) {
        /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma program dilidir.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/


        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 35, 20, 63, 21, 65, 44, 66, 64, 80, 15, 38));
        //Task : Structed Programming kullanarak list elemanlarını aralarında bosluk olacak şekilde print ediniz.   


        printElStructured(sayi);
        System.out.println("\n**********");

        printElFunctional(sayi);
        System.out.println("\n**********");

        printElFunctional1(sayi);
        System.out.println("\n**********");

        printCiftElStructured(sayi);
        System.out.println("\n********** 2 ye bolunenler");
        yazdirTamBolunenleriElFunctional(sayi);
        System.out.println("\n********** 2 ye bolunenler ve 34ten kucuk olan");

        yazdirCiftVe34tenKucukleriYazdir(sayi);
        System.out.println("\n********** 2 ye bolunenler veya 34ten buyuk olan");

        yazdirCiftVeya34tenBuyukleriYazdir(sayi);

    }

    //Task : Structed Programming kullanarak list elemanlarını aralarında bosluk olacak şekilde print ediniz.   

    public static void printElStructured(List<Integer> sayi) {
        for (Integer each : sayi) {

            System.out.print(each + " ");
        }
    }

    public static void printElFunctional(List<Integer> sayi) {
        sayi.stream().forEach(t -> System.out.print(t + " "));
    }

    /*
 stream() : datalari yukaridan asagiya akis sekline getirir.
 Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
  Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

 */
    /*

     */
    public static void printElFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(L01_Lambda::birBoslukluYazdir); // method reference
    }

    public static void birBoslukluYazdir(int sayi) {
        System.out.print(sayi + " ");
    }

    //structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElStructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    public static void yazdirTamBolunenleriElFunctional(List<Integer> sayi) {
        sayi.stream().filter(L01_Lambda::ciftBul).forEach(L01_Lambda::birBoslukluYazdir);
    }

    public static boolean ciftBul(int bolunen) {

        return bolunen % 2 == 0;
    }

    //Task : functional Programming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static boolean kucukleriBul(int a) {

        return a < 34;
    }

    public static void yazdirCiftVe34tenKucukleriYazdir(List<Integer> sayi) {
        sayi.
                stream().
                filter(L01_Lambda::ciftBul).
                filter(L01_Lambda::kucukleriBul).
                forEach(L01_Lambda::birBoslukluYazdir);

    }

    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void yazdirCiftVeya34tenBuyukleriYazdir(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 0 || t > 34).
                forEach(L01_Lambda::birBoslukluYazdir);

    }

    public static void yazdir(int a) {// verilen int degeri aynı satırda bosluk bırakarak yazdırma action yapan seed(tohum) method create edildi
        System.out.print(a + " ");
    }

    public static void yazdir(String a) {// verilen int degeri aynı satırda bosluk bırakarak yazdırma action yapan seed(tohum) method create edildi
        System.out.print(a + " ");
    }
}