package net.mr_faton.Test;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String regExp = "(.*title-full\">)(\\s*+)(.*?)\\s+<|(.*vote-positive\">)([0-9]*?)<|(.*vote-negative\">)([0-9]*?)<";
        StringBuilder page = new StringBuilder("");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new URL("http://fs.to/video/films/").openStream(), "UTF-8"));
            int ch;
            while ((ch = in.read()) != -1) {
                page.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(page);

        while (matcher.find()) {
            if (matcher.group(3) != null) {
                String name = matcher.group(3);
                System.out.print(name + " ");
            }
            if (matcher.group(5) != null) {
                int positiveVotes = Integer.parseInt(matcher.group(5));
                System.out.print(positiveVotes + " = позитивных| ");
            }

            if (matcher.group(7) != null) {
                int negativeVotes = Integer.parseInt(matcher.group(7));
                System.out.println(negativeVotes + " = негативных");
            }
        }
    }
}