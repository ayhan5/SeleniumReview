package com.techproed.utilities;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigurationReader {
    private static Properties properties;
    //bu dosyayi okuyabilmek icin static block u kullanilir..block sadece bu class ta kullanilir ve diger classlardan buraya erisilir
    //bir nesneyi static yaparsak direk hazifada yer alir ve bir daha nesne uretmeye gerek kalmaz
    static{
        String dosyaYolu = "C:\\Users\\at62a\\IdeaProjects\\SeleniumReviewTestNG\\configuration.properties";
        try{
            // okumak istediğiniz dosyanın, dosya yolunu göndermeniz gerekiyor.
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (Exception e){
        }
    }
    public static String getProperty(String key){
        String deger = properties.getProperty(key);
        return deger;
    }
}


