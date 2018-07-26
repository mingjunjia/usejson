package com.company;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Website w1 = new Website("baidu", "www.baidu.com");
        Website w2 = new Website("hand", "www.hand-china.com");

        List<Website> list = new ArrayList<Website>();
        list.add(w1);
        list.add(w2);

        Jdata jd1 = new Jdata("jmj", 23, "jmj_yc@163.com", list);


        try {   //从json中读出数据
            JsonReader jr = new JsonReader(new FileInputStream("conf/t1.json"));
            Jdata jdate = (Jdata) jr.readObject();
            System.out.println(jdate.getSites().get(0));
            System.out.println(jdate.getEmail());

            //把Java对象写为json数据
//            JsonWriter jw = new JsonWriter(new FileOutputStream("conf/t2.json"));
//            jw.write(jd1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Website {
    private String name;
    private String url;

    public Website(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Website{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

class Jdata {
    private String name;
    private int age;
    private String email;
    private List<Website> sites;

    public Jdata(String name, int age, String email, List<Website> sites) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.sites = sites;
    }

    @Override
    public String toString() {
        return "Jdata{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", sites=" + sites +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public List<Website> getSites() {
        return sites;
    }


}
