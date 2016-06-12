package abc.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        try
        {

            Map<String, HashMap<String, List<String>>> menuItems = new HashMap<String, HashMap<String, List<String>>>();
            Document document = Jsoup.connect("http://planningwale.com/").get();
            System.out.println(document.title());
            Elements links = document.select("div");
            for (Element link : links)
            {
                //menu
                if (link.id().equalsIgnoreCase("menu")) {

                    Elements lists = link.select("li");
                    for (Element list : lists)
                    {

                        Elements submenu = list.getElementsByTag("a");

                        for (Element sm:submenu) {

                            if (sm.attr("href").contains("path=")) {
                                String s[] = sm.attr("href").split("path=");
                                String s1[] = s[1].split("_");

                                String first = s1[0];
                                String second = s1.length ==1?"-1":s1[1];
                                System.out.println("href : " + sm.attr("href"));

                                System.out.println("id : " + s[1]);
                                System.out.println("text : " + sm.text());

                                    if (menuItems.get(first) != null) {

                                        HashMap<String, List<String>> items = menuItems.get(first);

                                        if (items.get(second) == null) {

                                            List<String> list1 = new ArrayList<String>();
                                            list1.add(sm.text());
                                            items.put(second, list1);
                                            menuItems.put(first, items);

                                        } else {
                                            List<String> lists1 = items.get(second);
                                            lists1.add(sm.text());
                                        }

                                    } else {
                                        HashMap<String, List<String>> subItems = new HashMap<String, List<String>>();
                                        List<String> list1 = new ArrayList<String>();
                                        list1.add(sm.text());
                                        subItems.put(second, list1);

                                        menuItems.put(first, subItems);
                                    }


                            }
                        }



                        //}

                    }
                }

            }

            Set<String> keys = menuItems.keySet();
            for (String key : keys) {
                HashMap<String, List<String>> values = menuItems.get(key);
                Set<String> keys1 = values.keySet();

                for (String key1 : keys1) {
                    List<String> list = values.get(key1)   ;
                    for (String val : list) {
                        System.out.println(val);

                    }
                    }
                System.out.println();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
