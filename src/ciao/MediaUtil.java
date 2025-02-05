package ciao;

import java.io.PrintWriter;
import java.util.List;

public class MediaUtil {
    public static <T extends Scaffale> void stampaReport(List<T> scaffali, PrintWriter pw) {
        for (Scaffale s : scaffali) {
            for(Supporto t : s){
                pw.println(t);
            }
        }
        pw.flush();
    }
}
