package wyszukiwarka.najpopularniejszych.słów;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zadanie5 {

    private final static String[] EXCLUDED_ITEMS = {"burger", "wiedzą", "koronawirus", "robaki", "czas", "size"};

    public Zadanie5() {
        game();
    }

    public static void getTitles() {
        org.jsoup.Connection connect = Jsoup.connect("http://www.onet.pl/");
        try (FileWriter fw = new FileWriter("src/popular_words.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                out.println(elem.text());
            }
        } catch (IOException e) {
        }
    }

    public static void game() {
        System.out.println("Gra wyszukuje najpopularmiejszy słowa, prosze zaczekać :)");
        getTitles();
        try (FileWriter fw = new FileWriter("src/filtered_popular_words.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            String content = new String(Files.readAllBytes(Paths.get("src/popular_words.txt"))).toLowerCase().replaceAll("\"", "").replaceAll("\\.", "").replaceAll(",", "").replaceAll("\\?", "");
            String[] afterFister = content.split(" ");
            List<String> list = new ArrayList();
            for (String wordFromFile : afterFister) {
                for (String excluded : EXCLUDED_ITEMS) {
                    if (wordFromFile.length() > 3 && !wordFromFile.equalsIgnoreCase(excluded))
                        list.add(wordFromFile);
                }
            }
            List<String> listWithoutDuplicate = list.stream().distinct().collect(Collectors.toList());
            for (String word : listWithoutDuplicate) {
                out.println(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("All complete");
    }
}
