package evg.laz;



/**
 * Console Web Scraper. Main class Scraper with supports the data processing commands.
 * Search of one or several key words on the internet pages.
 *
 * @author Lazutin Evgeny<e_lazutin@mail.ru>
 *
 */
public class Scraper {

    private ParserWeb parserWeb;

    private Scraper() {
        this.parserWeb = new ParserWeb();
    }

    public static void main(String[] args) {
        boolean flagUrl=true;
        boolean flagKeyWord=true;
        boolean flagFindKey=true;
        System.out.println("Scraper is run!");
        Scraper scraper = new Scraper();
      for (int i = 0; i < args.length; i++) {

          if (flagUrl) {
              if (args[i].contains("https")) {
                  scraper.parserWeb.addUrl(args[i]);
              } else {
                  scraper.parserWeb.readerFileUrl(args[i]);
              }
              flagUrl=false;
              continue;
          }
          if(flagKeyWord){
              scraper.parserWeb.addKeyWord(args[i]);
              if(!args[i].endsWith(",")){
                  flagKeyWord=false;
              }
              continue;
          }
          if(flagFindKey){
              scraper.parserWeb.findKeyWord();
              flagFindKey=false;
              System.out.println(args[i]);
          }
          if(args[i].equalsIgnoreCase("-w")){
              scraper.parserWeb.showKeyWord();
              continue;
          }
          if(args[i].equalsIgnoreCase("-e")){
              scraper.parserWeb.showKeySentence();
              continue;
          }
      }
   }
}

