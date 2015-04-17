package net.mr_faton.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws IOException {
        String htmlPage = "<tr><td nowrap class=result><a href=\"map.phtml?n=398326&s=1\"> Зберегти</a>\n" +
                "  <a href=\"showmapn.phtml?n=398326\">(PNG)</a>\n" +
                "  </td><td nowrap class=result><a href=\"showmapn.phtml?n=398326\">Микрокольцовка<a/>\n" +
                "  </td><td class=result><a href=\"showmapn.phtml?n=398326\"><tt>QYUA98 UKMS 160900</tt></a></td><td class=result>2015-04-16 09:00:00</td></tr>\n" +
                "<tr><td nowrap class=result><a href=\"map.phtml?n=398429&s=1\"> Зберегти</a>\n" +
                "  <a href=\"showmapn.phtml?n=398429\">(PNG)</a>\n" +
                "  </td><td nowrap class=result><a href=\"showmapn.phtml?n=398429\">Микрокольцовка<a/>\n" +
                "  </td><td class=result><a href=\"showmapn.phtml?n=398429\"><tt>QYUA98 UKMS 161200</tt></a></td><td class=result>2015-04-16 12:00:00</td></tr>";

//        String searchRegExp ="" +
//                ".*class=result><a href=\"(.*?&s=1)\">|" + /*download link*/
//                ".*class=result><a href=\".*?>(.*?)<|" + /*map name*/
//                ".*?tt>(.*?)<|" + /*map header*/
//                ".*class=result>(.*?)<"; /*map term*/

        String searchRegExp = ".*class=result><a href=\\\".*?>(.*?)<a";
        Pattern pattern = Pattern.compile(searchRegExp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlPage);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                System.out.println(matcher.group(1).trim());
            }
//            if (matcher.group(2) != null) {
//                System.out.println(matcher.group(2).trim());
//            }
//            if (matcher.group(3) != null) {
//                System.out.println(matcher.group(3).trim());
//            }
//            if (matcher.group(4) != null) {
//                System.out.println(matcher.group(4).trim());
//            }
        }
    }
}

