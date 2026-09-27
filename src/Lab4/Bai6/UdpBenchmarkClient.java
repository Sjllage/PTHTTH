import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpBenchmarkClient {

    private static final String HOST = "localhost";
    private static final int PORT = 5001;

    private static final int PACKET_SIZE = 1400;
    private static final int PACKET_COUNT = 10000;

    public static void main(String[] args) {

        try (DatagramSocket socket = new DatagramSocket()) {

            InetAddress address = InetAddress.getByName(HOST);

            byte[] data = new byte[PACKET_SIZE];

            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) (i % 256);
            }

            byte[] receiveBuffer = new byte[PACKET_SIZE];

            long start = System.nanoTime();

            int received = 0;

            for (int i = 0; i < PACKET_COUNT; i++) {

                DatagramPacket packet =
                        new DatagramPacket(
                                data,
                                data.length,
                                address,
                                PORT
                        );

                socket.send(packet);

                DatagramPacket response =
                        new DatagramPacket(
                                receiveBuffer,
                                receiveBuffer.length
                        );

                socket.receive(response);

                received++;
            }

            long end = System.nanoTime();

            double seconds =
                    (end - start) / 1_000_000_000.0;

            double totalMB =
                    (PACKET_SIZE * PACKET_COUNT)
                            / (1024.0 * 1024.0);

            double speed = totalMB / seconds;

            System.out.println("UDP Benchmark");
            System.out.println("Packets sent: " + PACKET_COUNT);
            System.out.println("Packets received: " + received);
            System.out.println("Data: " + totalMB + " MB");
            System.out.println("Time: " + seconds + " seconds");
            System.out.println("Speed: " + speed + " MB/s");

        } catch (Exception e) {
            System.out.println("Loi Client: " + e.getMessage());
        }
    }
}