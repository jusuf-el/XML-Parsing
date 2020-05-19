/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsiranje1;

/**
 *
 * @author jusuf
 */

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.*;

public class Parsiranje1 {

    /**
     * @param args the command line arguments
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse("./src/parsiranje1/books.xml.txt");
        
        Element root = doc.getDocumentElement();
        NodeList books = root.getElementsByTagName("book");
        NodeList cijene = root.getElementsByTagName("price");
        NodeList datumiIzdavanja = root.getElementsByTagName("publish_date");
        
        for(int i = 0; i < books.getLength(); i++) {
            
            String datumIzdavanja = datumiIzdavanja.item(i).getTextContent();
            String godinaIzdavanja = datumIzdavanja.substring(0, 4);
            int godinaIzdavanjaInt = Integer.parseInt(godinaIzdavanja);
            
            String cijena = cijene.item(i).getTextContent();
            double cijenaDouble = Double.parseDouble(cijena);
            
            if (cijenaDouble > 10 && godinaIzdavanjaInt > 2005) {
                System.out.println(books.item(i).getTextContent());
            }
        }
    }    
}
