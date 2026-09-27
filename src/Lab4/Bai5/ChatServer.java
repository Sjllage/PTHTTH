import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatServer {

    private static final int PORT = 5000;

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT)) {

            System.out.println("Server dang chay tai port " + PORT);

            try (Socket socket = server.accept()) {

                System.out.println("Client da ket noi!");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream(),
                                StandardCharsets.UTF_8
                        )
                );

                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream(),
                                StandardCharsets.UTF_8
                        ),
                        true
                );

                BufferedReader console = new BufferedReader(
                        new InputStreamReader(
                                System.in,
                                StandardCharsets.UTF_8
                        )
                );

                Thread receiveThread = new Thread(() -> {

                    try {
                        String message;

                        while ((message = in.readLine()) != null) {

                            System.out.println("\nClient: " + message);

                            if (message.equalsIgnoreCase("QUIT")) {
                                break;
                            }

                            System.out.print("Server: ");
                        }

                    } catch (IOException e) {
                        System.out.println("Client da ngat ket noi.");
                    }
                });

                receiveThread.start();

                String message;

                while ((message = console.readLine()) != null) {

                    out.println(message);

                    if (message.equalsIgnoreCase("QUIT")) {
                        break;
                    }

                    System.out.print("Server: ");
                }
            }

        } catch (IOException e) {
            System.out.println("Loi Server: " + e.getMessage());
        }
    }
}