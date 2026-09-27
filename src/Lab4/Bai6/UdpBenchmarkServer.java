import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpBenchmarkServer {

    private static final int PORT = 5001;

    public static void main(String[] args) {

        try (DatagramSocket socket = new DatagramSocket(PORT)) {

            System.out.println("UDP Server dang chay tai port " + PORT);

            byte[] buffer = new byte[65507];

            while (true) {

                DatagramPacket packet =
                        new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);

                DatagramPacket response =
                        new DatagramPacket(
                                packet.getData(),
                                packet.getLength(),
                                packet.getAddress(),
                                packet.getPort()
                        );

                socket.send(response);
            }

        } catch (Exception e) {
            System.out.println("Loi UDP Server: " + e.getMessage());
        }
    }
}