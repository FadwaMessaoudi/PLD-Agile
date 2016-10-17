package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modele.Delivery;
import modele.DeliveryOrder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Deserializer {
	
	public static void load() throws ParserConfigurationException, SAXException, IOException, ExceptionXML{
		File xml = XMLFileOpener.getInstance().open(true);
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();	
        Document document = docBuilder.parse(xml);
        Element racine = document.getDocumentElement();
        if (racine.getNodeName().equals("reseau")) {
        	//buildMap(racine);
        }
        else if(racine.getNodeName().equals("demandeDeLivraisons"))
        	buildDeliveryOrder(racine);
        }/*else{
        	throw new ExceptionXML("Document non conforme");
        }*/

<<<<<<< HEAD
	/**
    private static void construireAPartirDeDOMXML(Element noeudDOMRacine, Plan plan) throws ExceptionXML, NumberFormatException{
=======
    private static void buildMap(Element noeudDOMRacine, Plan plan) throws ExceptionXML, NumberFormatException{
>>>>>>> branch 'master' of https://github.com/FadwaMessaoudi/PLD-Agile.git
    	int hauteur = Integer.parseInt(noeudDOMRacine.getAttribute("hauteur"));
        if (hauteur <= 0)
        	throw new ExceptionXML("Erreur lors de la lecture du fichier : La hauteur du plan doit etre positive");
        int largeur = Integer.parseInt(noeudDOMRacine.getAttribute("largeur"));
        if (largeur <= 0)
        	throw new ExceptionXML("Erreur lors de la lecture du fichier : La largeur du plan doit etre positive");
       	plan.reset(largeur,hauteur);
       	NodeList listeCercles = noeudDOMRacine.getElementsByTagName("cercle");
       	for (int i = 0; i < listeCercles.getLength(); i++) {
        	//plan.ajoute(creeCercle((Element) listeCercles.item(i)));
       	}
       	NodeList listeRectangles = noeudDOMRacine.getElementsByTagName("rectangle");
       	for (int i = 0; i < listeRectangles.getLength(); i++) {
          	//plan.ajoute(creeRectangle((Element) listeRectangles.item(i)));
       	}
    }
    */
    
<<<<<<< HEAD
    /**
    private static void construireAPartirDeDOMXML(Element noeudDOMRacine, DeliveryOrder deliveryOrder) throws ExceptionXML, NumberFormatException{
=======
    private static void buildDeliveryOrder(Element noeudDOMRacine) throws ExceptionXML, NumberFormatException{
>>>>>>> branch 'master' of https://github.com/FadwaMessaoudi/PLD-Agile.git
    	int warehouseAddress = Integer.parseInt(((Element)noeudDOMRacine.getElementsByTagName("entrepot")).getAttribute("adresse"));
<<<<<<< HEAD
        if (entrepot <= 0)
        	throw new ExceptionXML("Erreur lors de la lecture du fichier : La hauteur du plan doit etre positive");
=======
        //String warehouseDepartureTime = (String)((Element)noeudDOMRacine.getElementsByTagName("entrepot")).getAttribute("adresse");
>>>>>>> branch 'master' of https://github.com/FadwaMessaoudi/PLD-Agile.git
        
       	NodeList listDelivery = noeudDOMRacine.getElementsByTagName("livraison");
       	int listDeliveries [][] = new int [listDelivery.getLength()][2];
       	for (int i = 0; i < listDelivery.getLength(); i++) {
       		listDeliveries[i][0] = Integer.parseInt(((Element)listDelivery).getAttribute("adresse"));
       		listDeliveries[i][1] = Integer.parseInt(((Element)listDelivery).getAttribute("duree"));
       	}
       	//Send to DeliveryOrder warehouse's address and the deliveries
       	//DeliveryOrder.create(warehouseAddress,listDeliveries);
       	
       	
       	
    }
	*/
    
<<<<<<< HEAD
    /**
     private static Delivery createDelivery(Element elt) throws ExceptionXML{
    	int address = Integer.parseInt(elt.getAttribute("adresse"));
   		int duration = Integer.parseInt(elt.getAttribute("duree"));
   		
   		return new Delivery(address, duration);
    }
    */
=======
    
>>>>>>> branch 'master' of https://github.com/FadwaMessaoudi/PLD-Agile.git
 
}

