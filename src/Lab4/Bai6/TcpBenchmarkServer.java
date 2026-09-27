import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpBenchmarkServer {

    private static final int PORT = 5000;

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT)) {

            System.out.println("TCP Server dang chay tai port " + PORT);

            try (Socket socket = server.accept()) {

                System.out.println("Client da ket noi!");

                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                byte[] buffer = new byte[8192];

                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                    out.flush();
                }
            }

        } catch (Exception e) {
            System.out.println("Loi Server: " + e.getMessage());
        }
    }
}