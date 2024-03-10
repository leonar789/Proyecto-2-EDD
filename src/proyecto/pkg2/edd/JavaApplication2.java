/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg2.edd;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author Jose Gabriel
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
    URL url=new URL("https://script.googleusercontent.com/macros/echo?user_content_key=8EekM-ZnbTRo_iq-sS1gJ4MbFMlPEKwVSajdternDbqjfI7PJ8bIT0hiGtnauvgmhKCPzJy_VptRrCmSK3YnhH3M0KX8buFPm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnN3yvDBGtFZHFpR5KaB9AwOygNu57-Or8xAksjCvXX3UnLFiR9ncczx2IoUZN6eOGtHgF_de1n7HHVnjuk_tUypOkuz6kmwo3Nz9Jw9Md8uu&lib=MVFvFfFrdsZiLf_CmaSooZvh3h_7zB1Af");
    HttpURLConnection con=(HttpURLConnection)url.openConnection(); 
    con.setRequestMethod("GET");
    int responsecode=con.getResponseCode();
    if(responsecode!=200) {
        System.out.println("Error"+ responsecode);
    }
    else {
        StringBuilder informationstring= new StringBuilder();
        Scanner sc =new Scanner(url.openStream());
        while(sc.hasNext()) {
            informationstring.append(sc.nextLine());
        }
        sc.close();
        JSONObject dataObject=new JSONObject(String.valueOf(informationstring));
        System.out.println(dataObject.getJSONArray("data"));
    }
} catch (Exception e) {
    e.printStackTrace();
}
    }
    
}
