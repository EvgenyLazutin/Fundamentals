package evg.laz;

import java.io.*;
import java.net.URL;
import java.util.*;


/**
 * Console Web Scraper. Search of one or several key words on the internet pages.
 *
 * @author Lazutin Evgeny<e_lazutin@mail.ru>
 *
 */
 class ParserWeb {


    private List  <String> listStrings=new ArrayList<>();
    private List  <String> listURL=new ArrayList<>();
    private List  <String> keyWord=new ArrayList<>();
    private Map<String, Integer> MapKeyWords = new HashMap<>();
    private Set<String> SetKeyWords = new HashSet<>();
    private Map<String, String> MapKeySentence = new HashMap<>();

    /**
     * Private method for use input class ParserWeb.
     *
     * @param urlstr the URL internet page for web scraping.
     */
    private void getHtmlCode(String urlstr) {

        try {
            URL url = new URL(urlstr);
            InputStream io = url.openStream();
            try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(io))) {
                String str = "";
                while ((str = br.readLine()) != null) {
                    listStrings.add(str);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addUrl(String url){
        if(url !=null){
           listURL.add(url);
        }
    }
    /**
     * Method add list of URLs to the field private List  <String> listURL.
     *
     * @param path the path to the list of URLs pages for scraping.
     */
    void readerFileUrl(String path) {
        try (FileReader fileRead = new FileReader(path)) {
            BufferedReader bufferedReader = new BufferedReader(fileRead);
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
               listURL.add(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method add word or lists of words with“,” delimiter to the field private List<String> keyWord.
     *
     * @param keyWord the word to the list of URLs pages for scraping.
     */
   void addKeyWord(String keyWord){
        if(keyWord !=null){
            String[] keyWordMas=(keyWord.split(","));
            for (String key:
                 keyWordMas) {
                this.keyWord.add(key);
            }
        }
    }

    /**
     * The method looks for keywords and counts their number in the
     * private Map<String, Integer> MapKeyWords.
     * Also adds strings with found words in the field
     * Map<String, String> MapKeySentence/
     *
     */
    void findKeyWord(){

      if(!listURL.isEmpty()){
          if(!keyWord.isEmpty()){
              for (String url:
                   listURL) {
                  getHtmlCode(url);
                  for (int i = 0; i < listStrings.size(); i++) {
                      for (String it :
                              keyWord) {
                          boolean flag = false;
                          if (listStrings.get(i).contains(it)) {
                              MapKeySentence.put(listStrings.get(i),it);
                              flag = SetKeyWords.add(it);
                              if (flag) {
                                  MapKeyWords.put(it, 1);
                              }
                              if (!flag) {
                                  int tmpInt;
                                  tmpInt=MapKeyWords.get(it);
                                  MapKeyWords.put(it, tmpInt+1);
                              }
                          }
                      }
                  }
                  listStrings.clear();
              }

          }else{
              System.out.println("Please, input key word!");
          }

      }else{
          System.out.println("Please, input URL!");
      }


    }

    /**
     * The method print to the console keywords and their number.
     *
     */
    void showKeyWord(){

        for (Map.Entry entry : MapKeyWords.entrySet()) {
            System.out.println("Key: " + entry.getKey() + "; Quantity: "
                    + entry.getValue());

            }
        }


    /**
     * The method print to the console keywords and sentences where they come in.
     *
     */
    void showKeySentence() {
        for (Map.Entry entry : MapKeySentence.entrySet()) {
            System.out.println("Key word: " + entry.getValue() + "; Sentence: "
                    + entry.getKey());
        }
    }
}


