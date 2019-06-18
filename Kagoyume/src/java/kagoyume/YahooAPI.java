/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
/**
 *
 * @author fukatsu-s
 */
public class YahooAPI implements Serializable {

    private final String urlSearch = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?";
    private final String urlLookup ="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?";
    private final String appid = "appid=dj00aiZpPUNUdEVOVXhLa2dRNiZzPWNvbnN1bWVyc2VjcmV0Jng9ZTg-";
    private String query = "&query=";
    private String code = "&itemcode=";
    
    public YahooAPI(){}
    
    public void setQuery(String search){
        try{
            this.query += URLEncoder.encode(search, "utf-8");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setCode(String code){
        try{            
            this.code += URLEncoder.encode(code, "utf-8");
        }catch(Exception e){
                e.printStackTrace();
        }        
    }
    
    public String queryURL(){
        String createURL = this.urlSearch + this.appid + this.query;
        return createURL;
    }
    
    public String codeURL(){
        String createURL = this.urlLookup + this.appid + this.code + "&responsegroup=large";
        return createURL;
    }
    
    public  String getResult(String urlString){
        String result = "";
        try{
            URL url = new URL(urlString);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(
            con.getInputStream()));
            String tmp = "";
            while ((tmp = in.readLine()) != null) {
                result += tmp;
            }
  
            in.close();
            con.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
            return result;
    }
    
    public JsonNode getJsonNode(String jsonString){
        JsonNode head = null;
    try{
        JsonFactory jfactory = new JsonFactory();
        JsonParser parser = jfactory.createJsonParser(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        head = mapper.readTree(parser);
    }catch(Exception e){
        e.printStackTrace();
    }
        return head;
    }
    
    public ArrayList<SearchDataBeans> search(JsonNode json){
        ArrayList<SearchDataBeans> result = new ArrayList();  
        int count = json.get("ResultSet").get("totalResultsReturned").intValue();
        if(count != 0){count = 10;}        
        
        for (int i = 0; i < count; i++) {
            SearchDataBeans srb = new SearchDataBeans();
            String num = String.valueOf(i);
            srb.setName(json.get("ResultSet").get("0").get("Result").get(num).get("Name").textValue());
            srb.setPrice(json.get("ResultSet").get("0").get("Result").get(num).get("Price").get("_value").textValue());
            srb.setImage(json.get("ResultSet").get("0").get("Result").get(num).get("Image").get("Medium").textValue());
            srb.setCode(json.get("ResultSet").get("0").get("Result").get(num).get("Code").textValue());
            result.add(srb);
        }
        return result;
    }
        
    
        public SearchDataBeans searchItem(JsonNode json){
        SearchDataBeans result = new SearchDataBeans();

            result.setName(json.get("ResultSet").get("0").get("Result").get("0").get("Name").textValue());
            result.setPrice(json.get("ResultSet").get("0").get("Result").get("0").get("Price").get("_value").textValue());
            result.setImage(json.get("ResultSet").get("0").get("Result").get("0").get("Image").get("Small").textValue());
            result.setCode(json.get("ResultSet").get("0").get("Result").get("0").get("Code").textValue());
            result.setDescription(json.get("ResultSet").get("0").get("Result").get("0").get("Description").textValue());
            result.setRate(json.get("ResultSet").get("0").get("Result").get("0").get("Review").get("Rate").textValue());
            
        return result;
    }
    
    
}
