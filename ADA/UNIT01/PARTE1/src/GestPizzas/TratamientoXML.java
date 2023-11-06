

import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;
import java.io.*;

public class TratamientoXML {

	public void CreateXML() {
		//Creamos un DocumentBuilderFactory
		DocumentBuilderFactory dbfPizzas = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbPizzas = dbfPizzas.newDocumentBuilder();
		/* Creamos un documento vacío
		 * Nodo raiz --> Carta
		 */		
		DOMImplementation domImplement = dbPizzas.getDOMImplementation();
		Document docPizzas = domImplement.createDocument(null, Carta, null);
		docPizzas.setXmlVersion("1.0");		
	}
	
	public void PizzasXML(Pizzas pizza) {
		//Creamos el elemento de nodo
		Element objPizzas = docPizzas.createElement("pizzas");
		//Lo agregamos como hijo de Carta
		docPizzas.getDocumentElement().appendChild(objPizzas);
		//Creamos el nodo Pizza
		Element eNodePizza = docPizzas.createElement("pizza");
		//Lo agregamos como hijo de Pizzas
		objPizzas.appendChild(eNodePizza);
		//Creamos el nodo Name
		Element eNodeName = docPizzas.createElement("name");
		//Creamos el valor de elemento name
		Text txtNode = docPizzas.createElement(Pizzas.);
		//Enlazamos el valor con el elemento 
		eNodeName.appendChild(txtNode);
		//Enlazamos el elemento hijo con su padre
		eNodePizza.appendChild(eNodeName);
		//Creamos el nodo Name
		Element eNodeName = docPizzas.createElement("id");
		//Creamos el valor de elemento name
		Text txtNode = docPizzas.createElement("1234");
		//Enlazamos el valor con el elemento 
		eNodeName.appendChild(txtNode);
		//Enlazamos el elemento hijo con su padre
		eNodePizza.appendChild(eNodeName);
		//Creamos el nodo Name
		Element eNodeName = docPizzas.createElement("price");
		//Creamos el valor de elemento name
		Text txtNode = docPizzas.createElement("24,10");
		//Enlazamos el valor con el elemento 
		eNodeName.appendChild(txtNode);
		//Enlazamos el elemento hijo con su padre
		eNodePizza.appendChild(eNodeName);		
	}
	
	public void closeXML(String stPath,String stName) {
		/* 
		 * cierra documento
		 * 1 Crea el source()
		 * 2 crea el result()
		 * 3 crea transform()
		 * 4 realiza la transformación 
		 */
		Source srcPizzas = new DOMSource(docPizzas);
		Result resultFile = new StreamResult(new File(stPath+stName));
		Transformer transfPizzas = TrasformerFactory.newInstance().newTransformer();
		transfPizzas.transform(srcPizzas, resultFile);
	}
}
