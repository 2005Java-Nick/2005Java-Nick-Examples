package com.revature.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2020-06-18T18:06:58.576-04:00
 * Generated source version: 3.1.6
 * 
 */
@WebServiceClient(name = "messageGenService", 
                  wsdlLocation = "http://localhost:8080/SOAPGreeting/greetingservice?wsdl",
                  targetNamespace = "http://ws.revature.com/") 
public class MessageGenService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.revature.com/", "messageGenService");
    public final static QName MessageGenImplPort = new QName("http://ws.revature.com/", "MessageGenImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/SOAPGreeting/greetingservice?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MessageGenService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/SOAPGreeting/greetingservice?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MessageGenService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MessageGenService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MessageGenService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public MessageGenService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public MessageGenService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public MessageGenService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns MessageGen
     */
    @WebEndpoint(name = "MessageGenImplPort")
    public MessageGen getMessageGenImplPort() {
        return super.getPort(MessageGenImplPort, MessageGen.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MessageGen
     */
    @WebEndpoint(name = "MessageGenImplPort")
    public MessageGen getMessageGenImplPort(WebServiceFeature... features) {
        return super.getPort(MessageGenImplPort, MessageGen.class, features);
    }

}
