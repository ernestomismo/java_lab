package networking.net_interface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import static java.lang.System.out;

public class NetInterfacesMain {

	public static void main(String[] args) {

		Enumeration<NetworkInterface> nifs;
		try {
			nifs = NetworkInterface.getNetworkInterfaces();
			
			while(nifs.hasMoreElements()){
				NetworkInterface nif = nifs.nextElement();
				out.println("network: " + nif.toString());
				displaySubInterfaces(nif);
				out.println("**********************************************");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}

	}
	
	static void displaySubInterfaces(NetworkInterface netIf) throws SocketException {
		
		Enumeration<InetAddress> ias = netIf.getInetAddresses();
		while(ias.hasMoreElements()){
			InetAddress ia = ias.nextElement();
			out.printf("\tHost address: %s\n", ia.getHostAddress());
            out.printf("\tHost Name: %s\n", ia.getHostName());
		}
	}

}