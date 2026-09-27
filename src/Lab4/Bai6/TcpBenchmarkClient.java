import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpBenchmarkClient {

    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    private static final int DATA_SIZE = 10 * 1024 * 1024;

    public static void main(String[] args) {

        byte[] data = new byte[DATA_SIZE];

        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (i % 256);
        }

        try (Socket socket = new Socket(HOST, PORT)) {

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            byte[] buffer = new byte[8192];

            long start = System.nanoTime();

            out.write(data);
            socket.shutdownOutput();

            int totalReceived = 0;
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                totalReceived += bytesRead;
            }

            long end = System.nanoTime();

            double seconds = (end - start) / 1_000_000_000.0;

            double mb = DATA_SIZE / (1024.0 * 1024.0);

            double speed = mb / seconds;

            System.out.println("TCP Benchmark");
            System.out.println("Data sent: " + mb + " MB");
            System.out.println("Data received: "
                    + totalReceived / (1024.0 * 1024.0) + " MB");
            System.out.println("Time: " + seconds + " seconds");
            System.out.println("Speed: " + speed + " MB/s");

        } catch (Exception e) {
            System.out.println("Loi Client: " + e.getMessage());
        }
    }
}