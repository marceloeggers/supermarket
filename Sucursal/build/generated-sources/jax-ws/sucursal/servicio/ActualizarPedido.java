
package sucursal.servicio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actualizarPedido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actualizarPedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idSucursal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarPedido", propOrder = {
    "idSucursal",
    "idProducto"
})
public class ActualizarPedido {

    protected String idSucursal;
    protected String idProducto;

    /**
     * Gets the value of the idSucursal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSucursal() {
        return idSucursal;
    }

    /**
     * Sets the value of the idSucursal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSucursal(String value) {
        this.idSucursal = value;
    }

    /**
     * Gets the value of the idProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the value of the idProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProducto(String value) {
        this.idProducto = value;
    }

}
