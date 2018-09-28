package debug;


import java.text.SimpleDateFormat;
import java.util.Date;

public class debug {
    public static void main(String[] args) {
        System.out.println(String.format("Hello : %s%s%s", "jerry-", "li", ",welcome!"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSSSSSSS");
        System.out.println(simpleDateFormat.format(new Date()));
    }

}
