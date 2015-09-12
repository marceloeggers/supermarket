
package sucursal.servicio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sucursal.servicio package. 
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

    private final static QName _BorrarXMLPedidoResponse_QNAME = new QName("http://webService/", "borrarXMLPedidoResponse");
    private final static QName _ActualizarPedido_QNAME = new QName("http://webService/", "actualizarPedido");
    private final static QName _DevolverPedido_QNAME = new QName("http://webService/", "devolverPedido");
    private final static QName _RegistrarVentaResponse_QNAME = new QName("http://webService/", "registrarVentaResponse");
    private final static QName _DevolverPedidoResponse_QNAME = new QName("http://webService/", "devolverPedidoResponse");
    private final static QName _DevolverVenta_QNAME = new QName("http://webService/", "devolverVenta");
    private final static QName _ActualizarPedidoResponse_QNAME = new QName("http://webService/", "actualizarPedidoResponse");
    private final static QName _NuevoPedido_QNAME = new QName("http://webService/", "nuevoPedido");
    private final static QName _Hello_QNAME = new QName("http://webService/", "hello");
    private final static QName _BorrarXMLPedido_QNAME = new QName("http://webService/", "borrarXMLPedido");
    private final static QName _HelloResponse_QNAME = new QName("http://webService/", "helloResponse");
    private final static QName _DevolverVentaResponse_QNAME = new QName("http://webService/", "devolverVentaResponse");
    private final static QName _RegistrarVenta_QNAME = new QName("http://webService/", "registrarVenta");
    private final static QName _NuevoPedidoResponse_QNAME = new QName("http://webService/", "nuevoPedidoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sucursal.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BorrarXMLPedido }
     * 
     */
    public BorrarXMLPedido createBorrarXMLPedido() {
        return new BorrarXMLPedido();
    }

    /**
     * Create an instance of {@link RegistrarVenta }
     * 
     */
    public RegistrarVenta createRegistrarVenta() {
        return new RegistrarVenta();
    }

    /**
     * Create an instance of {@link DevolverVenta }
     * 
     */
    public DevolverVenta createDevolverVenta() {
        return new DevolverVenta();
    }

    /**
     * Create an instance of {@link ActualizarPedido }
     * 
     */
    public ActualizarPedido createActualizarPedido() {
        return new ActualizarPedido();
    }

    /**
     * Create an instance of {@link ActualizarPedidoResponse }
     * 
     */
    public ActualizarPedidoResponse createActualizarPedidoResponse() {
        return new ActualizarPedidoResponse();
    }

    /**
     * Create an instance of {@link NuevoPedidoResponse }
     * 
     */
    public NuevoPedidoResponse createNuevoPedidoResponse() {
        return new NuevoPedidoResponse();
    }

    /**
     * Create an instance of {@link NuevoPedido }
     * 
     */
    public NuevoPedido createNuevoPedido() {
        return new NuevoPedido();
    }

    /**
     * Create an instance of {@link Pedido }
     * 
     */
    public Pedido createPedido() {
        return new Pedido();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link DevolverVentaResponse }
     * 
     */
    public DevolverVentaResponse createDevolverVentaResponse() {
        return new DevolverVentaResponse();
    }

    /**
     * Create an instance of {@link RegistrarVentaResponse }
     * 
     */
    public RegistrarVentaResponse createRegistrarVentaResponse() {
        return new RegistrarVentaResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Venta }
     * 
     */
    public Venta createVenta() {
        return new Venta();
    }

    /**
     * Create an instance of {@link BorrarXMLPedidoResponse }
     * 
     */
    public BorrarXMLPedidoResponse createBorrarXMLPedidoResponse() {
        return new BorrarXMLPedidoResponse();
    }

    /**
     * Create an instance of {@link DevolverPedido }
     * 
     */
    public DevolverPedido createDevolverPedido() {
        return new DevolverPedido();
    }

    /**
     * Create an instance of {@link DevolverPedidoResponse }
     * 
     */
    public DevolverPedidoResponse createDevolverPedidoResponse() {
        return new DevolverPedidoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BorrarXMLPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "borrarXMLPedidoResponse")
    public JAXBElement<BorrarXMLPedidoResponse> createBorrarXMLPedidoResponse(BorrarXMLPedidoResponse value) {
        return new JAXBElement<BorrarXMLPedidoResponse>(_BorrarXMLPedidoResponse_QNAME, BorrarXMLPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "actualizarPedido")
    public JAXBElement<ActualizarPedido> createActualizarPedido(ActualizarPedido value) {
        return new JAXBElement<ActualizarPedido>(_ActualizarPedido_QNAME, ActualizarPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DevolverPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "devolverPedido")
    public JAXBElement<DevolverPedido> createDevolverPedido(DevolverPedido value) {
        return new JAXBElement<DevolverPedido>(_DevolverPedido_QNAME, DevolverPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarVentaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "registrarVentaResponse")
    public JAXBElement<RegistrarVentaResponse> createRegistrarVentaResponse(RegistrarVentaResponse value) {
        return new JAXBElement<RegistrarVentaResponse>(_RegistrarVentaResponse_QNAME, RegistrarVentaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DevolverPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "devolverPedidoResponse")
    public JAXBElement<DevolverPedidoResponse> createDevolverPedidoResponse(DevolverPedidoResponse value) {
        return new JAXBElement<DevolverPedidoResponse>(_DevolverPedidoResponse_QNAME, DevolverPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DevolverVenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "devolverVenta")
    public JAXBElement<DevolverVenta> createDevolverVenta(DevolverVenta value) {
        return new JAXBElement<DevolverVenta>(_DevolverVenta_QNAME, DevolverVenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "actualizarPedidoResponse")
    public JAXBElement<ActualizarPedidoResponse> createActualizarPedidoResponse(ActualizarPedidoResponse value) {
        return new JAXBElement<ActualizarPedidoResponse>(_ActualizarPedidoResponse_QNAME, ActualizarPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NuevoPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "nuevoPedido")
    public JAXBElement<NuevoPedido> createNuevoPedido(NuevoPedido value) {
        return new JAXBElement<NuevoPedido>(_NuevoPedido_QNAME, NuevoPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BorrarXMLPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "borrarXMLPedido")
    public JAXBElement<BorrarXMLPedido> createBorrarXMLPedido(BorrarXMLPedido value) {
        return new JAXBElement<BorrarXMLPedido>(_BorrarXMLPedido_QNAME, BorrarXMLPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DevolverVentaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "devolverVentaResponse")
    public JAXBElement<DevolverVentaResponse> createDevolverVentaResponse(DevolverVentaResponse value) {
        return new JAXBElement<DevolverVentaResponse>(_DevolverVentaResponse_QNAME, DevolverVentaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarVenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "registrarVenta")
    public JAXBElement<RegistrarVenta> createRegistrarVenta(RegistrarVenta value) {
        return new JAXBElement<RegistrarVenta>(_RegistrarVenta_QNAME, RegistrarVenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NuevoPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "nuevoPedidoResponse")
    public JAXBElement<NuevoPedidoResponse> createNuevoPedidoResponse(NuevoPedidoResponse value) {
        return new JAXBElement<NuevoPedidoResponse>(_NuevoPedidoResponse_QNAME, NuevoPedidoResponse.class, null, value);
    }

}
