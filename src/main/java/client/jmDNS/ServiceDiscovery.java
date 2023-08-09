package client.jmDNS;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;

public class ServiceDiscovery {
    public static class AppServiceListener implements ServiceListener {
        // Properties
        private int port;
        private ServiceInfo serviceInfo;

        // Getters & Setters
        public int getPort() { return port; }
        public void setPort(int port) { this.port = port; }
        public ServiceInfo getServiceInfo() { return serviceInfo; }
        public void setServiceInfo(ServiceInfo serviceInfo) { this.serviceInfo = serviceInfo; }

        // Discover added service
        @Override
        public void serviceAdded(ServiceEvent event) {
            System.out.println("Service " + event.getInfo().getName() + " successfully added!!");
            // Setting properties values
            this.setServiceInfo(event.getInfo());
            this.setPort(event.getInfo().getPort());
        }
        // Discover removed services
        @Override
        public void serviceRemoved(ServiceEvent event) {
            System.out.println("Service " + event.getInfo().getName() + " successfully removed!!");
        }
        // Discover resolved services
        @Override
        public void serviceResolved(ServiceEvent event) {
            System.out.println("Service " + event.getInfo().getName() + " successfully resolved!!");
            // Setting properties values
            this.setServiceInfo(event.getInfo());
            this.setPort(event.getInfo().getPort());
        }
    }

    public ServiceInfo discover(String serviceType) {
        int port = 0;
        ServiceInfo serviceInfo = null;
        try {
            // Create an instance of JmDNS
            InetAddress address = InetAddress.getLocalHost();
            JmDNS jmdns = JmDNS.create(address, InetAddress.getByName(address.getHostName()).toString());
            // Listening for service type
            AppServiceListener listener = new AppServiceListener();
            jmdns.addServiceListener(serviceType, listener);
            // Send to sleep for 4 seconds
            Thread.sleep(4000L);
            // Get service info
            serviceInfo = listener.getServiceInfo();
            port = listener.getPort();
            System.out.println("Listening to port " + port);
            // Close JmDNS
            jmdns.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return serviceInfo;
    }
}
