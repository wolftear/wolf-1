import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/8/11
 **/
public class IntegerTest {
    public static void main(String[] args) throws ParseException {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println("86".trim());
//        System.out.println("".length());
//        System.out.println(LocalDate.now().toString());
//        Date time = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date clockInTime = formatter.parse("2020-09-03 15:54:09");
//        int days = (int) ((time.getTime() - clockInTime.getTime()) / (1000*3600*24));
//        System.out.println(days);
        for(int i=0; i<= 64;i++) {
            System.out.println(i/64);
        }
        List list = null;
        for(Object obj: list) {
            System.out.println(obj);
        }

    }
}
