package com.tatlicilar.downtoup;

/**
 * Created by sezinkokum on 2.09.2017.
 */

public class Show_Chat_Activity_Data_Items {
    private String Email;
    private String Image_Url;
    private String Name;

    public Show_Chat_Activity_Data_Items()
    {
    }

//    public Show_Chat_Activity_Data_Items(String email, String image_Url, String name) {
public Show_Chat_Activity_Data_Items(String email, String name) {

    Email = email;
//        Image_Url = image_Url;
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

//    public String getImage_Url() {
//        return Image_Url;
//    }

//    public void setImage_Url(String image_Url) {
//        Image_Url = image_Url;
//    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
