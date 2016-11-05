package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGetter {
    public static String getTime(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        return sdf.format(now);
    }
}
