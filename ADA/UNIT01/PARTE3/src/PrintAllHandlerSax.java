import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

public class PrintAllHandlerSax extends DefaultHandler {
	
	private StringBuilder sbCurrentValue = new StringBuilder();
	
	@Override
	public void startDocument() {
		System.out.println("Start Document");
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("End Document");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		//reset the tag value
		sbCurrentValue.setLength(0);
		System.out.printf(" Start Element: %s%n", qName);
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//handle the value based on to which element it belongs
		//estructura del XML
		if (qName.equalsIgnoreCase("name")) {
			System.out.printf(" name : %s%n", sbCurrentValue.toString());
		}
		if (qName.equalsIgnoreCase("price")) {
			System.out.printf(" price : %s%n", sbCurrentValue.toString());
		}
		if (qName.equalsIgnoreCase("id")) {
			System.out.printf(" id : %s%n", sbCurrentValue.toString());
		}
		System.out.printf(" End Element: %s%n", qName);
	}
	/*
	 * This will be called everytime parser encounter a value node
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// The characters() method can be called multiple times for a single text node.
		// Some values may missing if assign to a new string
		sbCurrentValue.append(ch, start, length);
	}
}
