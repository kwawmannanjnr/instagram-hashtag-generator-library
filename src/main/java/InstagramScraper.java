import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;

public class InstagramScraper {

        public static void main(String[] args) {
            new InstagramScraper().loadPage("sebike").toString();
        }

        public  String[] loadPage(String tag) {
            Document doc = null;
            try {
                System.out.println("Parsing Website");
                doc = Jsoup.connect("https://h.bdir.in/hashtags/search/" + tag).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Element link = doc.getElementById("copy_2000");
            Node body = link.childNode(1);
            String[] tags = body.childNode(0).toString().split("#");

            Element link2 = doc.getElementById("copy_3000");
            Node body2 = link2.childNode(1);
            String[] tags2 = body2.childNode(0).toString().split("#");

            Elements link3 = doc.getElementsByClass("table  table-hover");
            System.out.println("Parsing Website");

            System.out.println(
                    Arrays.toString(tags)
                            + "\n"
                            +                Arrays.toString(tags2)
            );
//        Node body3 = link3.childNode(1);
//        String[] tags3 = body2.childNode(0).toString().split("#");
            return tags;
        }
    }
