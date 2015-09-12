
package webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SupermercadoWS", targetNamespace = "http://webService/", wsdlLocation = "http://localhost:8080/ServidorWeb/SupermercadoWS?WSDL")
public class SupermercadoWS_Service
    extends Service
{

    private final static URL SUPERMERCADOWS_WSDL_LOCATION;
    private final static WebServiceException SUPERMERCADOWS_EXCEPTION;
    private final static QName SUPERMERCADOWS_QNAME = new QName("http://webService/", "SupermercadoWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ServidorWeb/SupermercadoWS?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SUPERMERCADOWS_WSDL_LOCATION = url;
        SUPERMERCADOWS_EXCEPTION = e;
    }

    public SupermercadoWS_Service() {
        super(__getWsdlLocation(), SUPERMERCADOWS_QNAME);
    }

    public SupermercadoWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SUPERMERCADOWS_QNAME, features);
    }

    public SupermercadoWS_Service(URL wsdlLocation) {
        super(wsdlLocation, SUPERMERCADOWS_QNAME);
    }

    public SupermercadoWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SUPERMERCADOWS_QNAME, features);
    }

    public SupermercadoWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SupermercadoWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SupermercadoWS
     */
    @WebEndpoint(name = "SupermercadoWSPort")
    public SupermercadoWS getSupermercadoWSPort() {
        return super.getPort(new QName("http://webService/", "SupermercadoWSPort"), SupermercadoWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SupermercadoWS
     */
    @WebEndpoint(name = "SupermercadoWSPort")
    public SupermercadoWS getSupermercadoWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webService/", "SupermercadoWSPort"), SupermercadoWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SUPERMERCADOWS_EXCEPTION!= null) {
            throw SUPERMERCADOWS_EXCEPTION;
        }
        return SUPERMERCADOWS_WSDL_LOCATION;
    }

}