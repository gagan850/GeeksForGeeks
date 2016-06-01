    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rod {

        public static void main(String args[]) throws IOException
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder builder = new StringBuilder();


            String str;
            boolean multi=false;
            while ((str=reader.readLine())!=null) {

                if (str.startsWith("/*") && str.endsWith("*/")) {
                    builder.append(str);
                } else


                if (str.startsWith("/*")) {
                    builder.append(str);
                    multi=true;
                } else

                if (str.endsWith("*/")) {
                    builder.append(str);
                    multi=false;
                } else

                if (str.contains("//")) {
                    int index= str.indexOf("//");
                    String str1= str.substring(index, str.length());
                    builder.append(str1);
                } else

                if (multi && !str.endsWith("*/") && !str.startsWith("/*")) {
                    builder.append(str);

                }
                System.out.print(builder.toString());
                builder = new StringBuilder();

            }

        }
    }
