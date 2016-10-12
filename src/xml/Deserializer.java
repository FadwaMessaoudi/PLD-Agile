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
        /*if (racine.getNodeName().equals("reseau")) {
           construireAPartirDeDOMXML(racine, plan);
        }
        else if(racine.getNodeName().equals("demandeDeLivraisons"))
        	construireAPartirDeDOMXML(racine, deliveryOrder);
        }else
        	throw new ExceptionXML("Document non conforme");
        */
	}

    private static void construireAPartirDeDOMXML(Element noeudDOMRacine, Plan plan) throws ExceptionXML, NumberFormatException{
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
    
    private static void construireAPartirDeDOMXML(Element noeudDOMRacine, DeliveryOrder deliveryOrder) throws ExceptionXML, NumberFormatException{
    	int warehouseAddress = Integer.parseInt(((Element)noeudDOMRacine.getElementsByTagName("entrepot")).getAttribute("adresse"));
        /*if (entrepot <= 0)
        	throw new ExceptionXML("Erreur lors de la lecture du fichier : La hauteur du plan doit etre positive");*/
        
       	NodeList listDelivery = noeudDOMRacine.getElementsByTagName("livraison");
       	for (int i = 0; i < listDelivery.getLength(); i++) {
        	deliveryOrder.add(createDelivery((Element) listDelivery.item(i)));
       	}	
    }
    
    private static Delivery createDelivery(Element elt) throws ExceptionXML{
    	int address = Integer.parseInt(elt.getAttribute("adresse"));
   		int duration = Integer.parseInt(elt.getAttribute("duree"));
   		
   		return new Delivery(address, duration);
    }
 
}

