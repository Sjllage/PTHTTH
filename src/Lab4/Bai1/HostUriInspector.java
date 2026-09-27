import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URI;

public class HostUriInspector {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage:");
            System.out.println("java HostUriInspector <hostname-or-uri>");
            return;
        }

        String input = args[0];

        try {
            URI uri = new URI(input);

            String host = uri.getHost();

            if (host == null) {
                host = input;
            }

            System.out.println("Input: " + input);
            System.out.println("Host: " + host);

            InetAddress[] addresses = InetAddress.getAllByName(host);

            System.out.println("Addresses:");

            for (InetAddress address : addresses) {

                String type;

                if (address instanceof Inet4Address) {
                    type = "IPv4";
                } else if (address instanceof Inet6Address) {
                    type = "IPv6";
                } else {
                    type = "Unknown";
                }

                System.out.println(
                        "  " + address.getHostAddress()
                        + " (" + type + ")"
                );

                if (address.isLoopbackAddress()) {
                    System.out.println("    Loopback address");
                }

                if (address.isSiteLocalAddress()) {
                    System.out.println("    Site-local address");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}