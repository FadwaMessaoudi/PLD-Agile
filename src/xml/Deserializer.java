package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modele.OMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Deserializer {
	
	//Call this method to build the map or to create the delivery order with an xml file
	public static void load(OMap omap) throws ParserConfigurationException, SAXException, IOException, ExceptionXML{
		File xml = XMLFileOpener.getInstance().open(true);
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();	
        Document document = docBuilder.parse(xml);
        Element racine = document.getDocumentElement();
        
        if (racine.getNodeName().equals("reseau")) 
        	buildMap(racine,omap);
        
        else if (racine.getNodeName().equals("demandeDeLivraisons")) 
        	buildDeliveryOrder(racine,omap);
        else
        	throw new ExceptionXML("Document non conforme");
        }
	
	//Private method to build the map
    private static void buildMap(Element nodeDOMRacine, OMap omap) throws ExceptionXML, NumberFormatException{
    	
       	NodeList intersectionList = nodeDOMRacine.getElementsByTagName("noeud");
       	for (int i = 0; i < intersectionList.getLength(); i++) {
       		int id = Integer.parseInt(((Element)intersectionList).getAttribute("id"));
       		int x = Integer.parseInt(((Element)intersectionList).getAttribute("x"));
       		int y = Integer.parseInt(((Element)intersectionList).getAttribute("y"));
        	omap.addIntersection(x,y,id);
       	}
       	
       	NodeList sectionList = nodeDOMRacine.getElementsByTagName("troncon");
       	for (int i = 0; i < sectionList.getLength(); i++) {
       		int start = Integer.parseInt(((Element)sectionList).getAttribute("origine"));
       		int end = Integer.parseInt(((Element)sectionList).getAttribute("destination"));
       		int length = Integer.parseInt(((Element)sectionList).getAttribute("longueur"));
       		int averageSpeed = Integer.parseInt(((Element)sectionList).getAttribute("vitesse"));
       		String name = (String)((Element)sectionList).getAttribute("nomRue");
          	omap.addSection(start, end, length, averageSpeed, name);
       	}
    }
    
    //Private method to build the delivery order
    private static void buildDeliveryOrder(Element nodeDOMRacine, OMap omap) throws ExceptionXML, NumberFormatException{
    	int warehouseAddress = Integer.parseInt(((Element)nodeDOMRacine.getElementsByTagName("entrepot")).getAttribute("adresse"));
        //String warehouseDepartureTime = (String)((Element)nodeDOMRacine.getElementsByTagName("entrepot")).getAttribute("adresse");
        
       	NodeList listDelivery = nodeDOMRacine.getElementsByTagName("livraison");
       	int listDeliveries [][] = new int [listDelivery.getLength()][2];
       	for (int i = 0; i < listDelivery.getLength(); i++) {
       		listDeliveries[i][0] = Integer.parseInt(((Element)listDelivery).getAttribute("adresse"));
       		listDeliveries[i][1] = Integer.parseInt(((Element)listDelivery).getAttribute("duree"));
       	}
       	//Send to the map the warehouse's address and the deliveries of the delivery order
       	omap.buildeDeliveryOrder(warehouseAddress,listDeliveries);
       	
       	
       	
    }
    
    
 
}
