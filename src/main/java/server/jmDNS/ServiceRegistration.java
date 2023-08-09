package server.jmDNS;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class ServiceRegistration {
    public void register(int servicePort, String serviceType, String serviceName, String serviceDescription) {
        try {
            // Create jmDNS instance
            InetAddress address = InetAddress.getLocalHost();
            JmDNS jmdns = JmDNS.create(address, InetAddress.getByName(address.getHostName()).toString());
            System.out.println("Registering service...");
            // Create ServiceInfo instance
            ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, servicePort, serviceDescription);
            // Register the service
            jmdns.registerService(serviceInfo);
            System.out.printf(
                    "Service successfully registered!! 🥳\n Type: %s\n Name: %s\n Port: %d",
                    serviceType, serviceName, servicePort);
            // Send to sleep for 4 seconds
            Thread.sleep(4000);
        }
        catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
