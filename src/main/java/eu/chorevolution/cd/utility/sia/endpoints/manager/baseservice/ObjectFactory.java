
package eu.chorevolution.cd.utility.sia.endpoints.manager.baseservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.chorevolution.cd.utility.sia.endpoints.manager.baseservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SetInvocationAddress_QNAME = new QName("http://services.chorevolution.eu/", "setInvocationAddress");
    private final static QName _SetInvocationAddressResponse_QNAME = new QName("http://services.chorevolution.eu/", "setInvocationAddressResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.chorevolution.cd.utility.sia.endpoints.manager.baseservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetInvocationAddress }
     * 
     */
    public SetInvocationAddress createSetInvocationAddress() {
        return new SetInvocationAddress();
    }

    /**
     * Create an instance of {@link SetInvocationAddressResponse }
     * 
     */
    public SetInvocationAddressResponse createSetInvocationAddressResponse() {
        return new SetInvocationAddressResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetInvocationAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.chorevolution.eu/", name = "setInvocationAddress")
    public JAXBElement<SetInvocationAddress> createSetInvocationAddress(SetInvocationAddress value) {
        return new JAXBElement<SetInvocationAddress>(_SetInvocationAddress_QNAME, SetInvocationAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetInvocationAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.chorevolution.eu/", name = "setInvocationAddressResponse")
    public JAXBElement<SetInvocationAddressResponse> createSetInvocationAddressResponse(SetInvocationAddressResponse value) {
        return new JAXBElement<SetInvocationAddressResponse>(_SetInvocationAddressResponse_QNAME, SetInvocationAddressResponse.class, null, value);
    }

}
