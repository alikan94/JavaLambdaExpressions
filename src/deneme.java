import java.util.Arrays;

public class deneme {
    public static void main(String[] args) {
        System.out.println(camelcase());
    }

    public static String camelcase() {
        String s1 = "  ali    live     In Usa ";
        s1=s1.trim().replaceAll("[ ]+", " ");
        String[] dizi = s1.trim().split(" ");
        Arrays.toString(dizi);
        String strDonen = "";
        for (String str : dizi) {
            strDonen += str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase() + " ";
        }
        return strDonen.trim();
    }
}
