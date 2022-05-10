package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L06_Lambda {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");

        Path girdiMetin = Path.of("src/lambda/haluk.txt"); // url path objesine atandı
        Stream<String> akis = Files.lines(girdiMetin); // haluk.txt datası akış streamine atandı

        //1. yol
        System.out.println("1.yol");
        Files.
                lines(Paths.get("src/lambda/haluk.txt")).
                forEach(System.out::println);

        //2. yol
        System.out.println("2.yol");
        akis.forEach(System.out::println);


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

        Files.lines(Paths.get("src/lambda/haluk.txt")).map(String::toUpperCase).forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");

        Files.lines(Paths.get("src/lambda/haluk.txt")).
                map(String::toLowerCase).
                limit(1).
                forEach(System.out::println);


        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");

        System.out.println(Files.lines(girdiMetin).
                filter(t -> t.toLowerCase().contains("basari")).
                count());


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");

        /*
   Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
   fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
   Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.
   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.
 */

        Files.lines(girdiMetin).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                distinct().
                forEach(L01_Lambda::yazdir);


        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");

        Files.lines(girdiMetin).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                sorted().
                forEach(L01_Lambda::yazdir);


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");

        System.out.println(
                Files.lines(girdiMetin).
                        map(t -> t.split(" ")).
                        flatMap(Arrays::stream).
                        filter(t -> t.equalsIgnoreCase("basari")).
                        count()
        );


        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");

        System.out.println(
                Files.lines(girdiMetin).
                        map(t -> t.toLowerCase().
                                split(" ")).
                        flatMap(Arrays::stream).
                        filter(t -> t.contains("a")).
                        count()
        );

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");

        Files.lines(girdiMetin).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.toLowerCase().contains("a")).
                forEach(L01_Lambda::yazdir);


        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");

        System.out.println(
                Files.lines(girdiMetin).
                        map(t -> t.
                                replaceAll("\\W", "").
                                replaceAll("\\d", "").
                                split("")).
                        flatMap(Arrays::stream).
                        distinct().
                        count()
        );

        Files.lines(girdiMetin).
                map(t -> t.
                        replaceAll("\\W", "").
                        replaceAll("\\d", "").
                        split("")).
                flatMap(Arrays::stream).
                distinct().forEach(L01_Lambda::yazdir);

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

        System.out.println(
                Files.lines(girdiMetin).
                        map(t -> t.
                                replaceAll("\\W", "").
                                replaceAll("\\d", "").
                                split(" ")).
                        flatMap(Arrays::stream).
                        distinct().
                        count()
        );

        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda farkli kelimeleri print ediniz -->  ");
/*
        Files.lines(girdiMetin).
                map(t -> t.
                        replaceAll("\\W", "").
                        split(" ")).
                flatMap(Arrays::stream).
                distinct().
                forEach(L01_Lambda::yazdir);

 */

        Files.lines(girdiMetin).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        split(" ")).//kelime akısı saglanır
                flatMap(Arrays::stream).
                distinct().forEach(L01_Lambda::yazdir);

    }
}
