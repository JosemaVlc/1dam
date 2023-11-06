import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class TratamientoXML {
	
	public static void CreateXML(ArrayList<Pizzas> arCarta, String stPath, String stName) throws DOMException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		//Creamos un DocumentBuilderFactory
		DocumentBuilderFactory dbfPizzas = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbPizzas = dbfPizzas.newDocumentBuilder();
		/* Creamos un documento vacío
		 * Nodo raiz --> Carta
		 */		
		DOMImplementation domImplement = dbPizzas.getDOMImplementation();
		Document docPizzas = domImplement.createDocument(null, "Carta", null);
		docPizzas.setXmlVersion("1.0");		
		//Creamos el elemento de nodo
		Element objPizzas = docPizzas.createElement("pizzas");
		//Lo agregamos como hijo de Carta
		docPizzas.getDocumentElement().appendChild(objPizzas);
		AddPizzasXML(arCarta, docPizzas, objPizzas);		
		CloseXML(stPath, stName, docPizzas);
	}
	
	public static void AddPizzasXML(ArrayList<Pizzas> arCarta, Document docPizzas, Element objPizzas) throws DOMException {
		for (Pizzas pizza : arCarta) {
			//Creamos el nodo Pizza
			Element eNodePizza = docPizzas.createElement("pizza");
			//Lo agregamos como hijo de Pizzas
			objPizzas.appendChild(eNodePizza);
			
			//Creamos el nodo Name
			Element eNodeName = docPizzas.createElement("name");
			//Creamos el valor de elemento name
			Text txtNode = docPizzas.createTextNode(pizza.getStName());
			//Enlazamos el valor con el elemento 
			eNodeName.appendChild(txtNode);
			//Enlazamos el elemento hijo con su padre
			eNodePizza.appendChild(eNodeName);
			
			//Creamos el nodo ID
			Element eNodeId = docPizzas.createElement("id");
			//Creamos el valor de elemento name
			txtNode = docPizzas.createTextNode(Integer.toString(pizza.getiId()));
			//Enlazamos el valor con el elemento 
			eNodeId.appendChild(txtNode);
			//Enlazamos el elemento hijo con su padre
			eNodePizza.appendChild(eNodeId);
			
			//Creamos el nodo Price
			Element eNodePrice = docPizzas.createElement("price");
			//Creamos el valor de elemento name
			txtNode = docPizzas.createTextNode(Double.toString(pizza.getDbPrice()));
			//Enlazamos el valor con el elemento 
			eNodePrice.appendChild(txtNode);
			//Enlazamos el elemento hijo con su padre
			eNodePizza.appendChild(eNodePrice);				
		}
	}
	
	public static void CloseXML(String stPath,String stName,Document docPizzas) throws TransformerFactoryConfigurationError, TransformerException {
		/* 
		 * cierra documento
		 * 1 Crea el source()
		 * 2 crea el result()
		 * 3 crea transform()
		 * 4 realiza la transformación 
		 */
		Source srcPizzas = new DOMSource(docPizzas);
		Result resultFile = new StreamResult(new File(stName));
		Transformer transfPizzas = TransformerFactory.newInstance().newTransformer();
		transfPizzas.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transfPizzas.setOutputProperty(OutputKeys.INDENT, "yes");
		transfPizzas.setOutputProperty(OutputKeys.METHOD, "xml");
		transfPizzas.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transfPizzas.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		transfPizzas.transform(srcPizzas, resultFile);
		
	}
	
	public static void PizzasReaderSax(String stName) throws ParserConfigurationException, SAXException, IOException {
		String XML_FILENAME = stName;
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxFactory.newSAXParser();
		PrintAllHandlerSax saxHandler = new PrintAllHandlerSax();
		saxParser.parse(XML_FILENAME, saxHandler);
	}

}
