package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
//        Integer.valueOf("abc");
//
//        int[] arr={11,22,33,44};
//        System.out.println(arr[6]);


        //1
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date date = sdf.parse("19/12/2016");
//            System.out.println(date);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }

        //2
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse("19/12/2016");
            System.out.println(date);
    }
}
