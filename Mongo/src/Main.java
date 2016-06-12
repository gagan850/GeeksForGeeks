import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class Main {


        public static void main( final String args[] ) {
         
           try{
             
               
               Properties prop = new Properties();
               InputStream input = null;

                   input = new FileInputStream("resources/DBProp.properties");

                   // load a properties file
                   prop.load(input);

                   // get the property value and print it out
                   System.out.println(prop.getProperty("dbHost"));
                   System.out.println(prop.getProperty("dbPort"));
                   System.out.println(prop.getProperty("dbName"));
              // To connect to mongodb server
              MongoClient mongoClient = new MongoClient( prop.getProperty("dbHost") , Integer.parseInt(prop.getProperty("dbPort")));
                 
              // Now connect to your databases
              DB db = mongoClient.getDB( prop.getProperty("dbName") );
              System.out.println("Connect to database successfully");
              //boolean auth = db.authenticate("gagan", new char[]{'b','a'});
              //System.out.println("Authentication: "+auth);
              DBCollection coll = db.getCollection("Student");
              System.out.println("Collection mycol selected successfully");
                 
              DBCursor cursor = coll.find();
                 
              while (cursor.hasNext()) { 
          
                 DBObject object = cursor.next(); 
                 System.out.println(object.get("rollNumber"));
                 System.out.println(object.get("name"));
                 System.out.println(object.get("address"));
                 System.out.println(object.get("age"));
              }
                 
           }catch(Exception e){
              System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           }
        }
     }
