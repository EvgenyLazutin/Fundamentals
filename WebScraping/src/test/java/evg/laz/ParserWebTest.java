//package evg.laz;

//
//public class ParserWebTest {
//
//
//
//
//    @org.junit.Test
//
//    public void addUrl() throws Exception {
//        ParserWeb parserWeb = new ParserWeb();
//        parserWeb.addUrl("https://habrahabr.ru/post/280238");
//        assertEquals(1, parserWeb.listURL.size());
//
//
//    }
//
//
//    @org.junit.Test
//
//    public void readerFileUrl() throws Exception {
//        ParserWeb parserWeb = new ParserWeb();
//        parserWeb.readerFileUrl("/home/jon/IdeaProjects/JavaFundamentals/WebScraping/src/main/resources/listOfUrls.txt");
//        assertEquals(2, parserWeb.listURL.size());
//    }
//
//
//
//    @org.junit.Test
//
//    public void addKeyWord() throws Exception {
//        ParserWeb parserWeb = new ParserWeb();
//        parserWeb.addKeyWord("полиморфный, Rust");
//        assertEquals(2, parserWeb.keyWord.size());
//    }
//
//}