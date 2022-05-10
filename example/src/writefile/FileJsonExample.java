package writefile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileJsonExample {
    public static void main(String[] args) throws IOException {
        writeJsonToList();

    }

    public static void writeJson() throws IOException {
        Map<String , Object> map = new HashMap<>();
        map.put("name" , "khoi");
        map.put("id" , 1);
        map.put("address" , new String[]{"hà nội" , "hai bà trưng"});
        map.put("email" , "khoi@gmail.com");
        map.put("active" , true);

        Writer writer = new FileWriter("product.json");
        Gson gson = new Gson();
        gson.toJson(map,writer);
        writer.close();
        System.out.println("ghi file json thanh cong ");



    }

    public static void writeJsonObject() throws IOException {

        Account account  = new Account(1 , "minh" , new String[]{"hà nội", "Trung tính"} , "minh@gmail.com" , true);

        ;
        String filename = "product.json";
        Path path = Paths.get(filename);
        Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        JsonElement element = gson.toJsonTree(account);
        gson.toJson(element , writer);

        writer.close();
        System.out.println("ghi file json thành công !");


    }


    public static void writeJsonToList() throws IOException {


        List<Account> accounts = Arrays.asList(new Account(1 , "duc" , new String[]{"ngọc hà , ba đình" }, "duc@gmail.com" , true),
                new Account(2 , "minh" , new String[]{"ngọc hà , ba đình" }, "minh@gmail.com" , true),
                new Account(3 , "khoi" , new String[]{"ngọc hà , ba đình" }, "khoi@gmail.com" , true));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = Files.newBufferedWriter(Paths.get("product.json"),StandardCharsets.UTF_8);
        gson.toJson(accounts , writer);
        writer.close();

        System.out.println("ghi file json thành công !");

    }

    public static void readJson() throws IOException {
//        JSONParser parser = new JSONParser();
//        FileReader reader = new FileReader("product.json");
//        Object obj = parser.parse(reader);
//
//        JSONObject jsonObject = (JSONObject) obj;
//        JSONArray jsonArray = (JSONArray) obj;
//        jsonArray.forEach(System.out::println);



        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("product.json"));
        Account account = gson.fromJson(reader,Account.class);
        System.out.println(account);
        reader.close();
    }
}
