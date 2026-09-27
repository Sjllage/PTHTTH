import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClient {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 5000;

        try (
                Socket socket = new Socket(host, port);

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
                )
        ) {

            System.out.println("Da ket noi Server.");
            System.out.println("Bat dau chat.");
            System.out.println("Nhap QUIT de thoat.");

            Thread receiveThread = new Thread(() -> {

                try {
                    String message;

                    while ((message = in.readLine()) != null) {

                        System.out.println("\nServer: " + message);
                        System.out.print("Client: ");

                        if (message.equalsIgnoreCase("QUIT")) {
                            break;
                        }
                    }

                } catch (IOException e) {
                    System.out.println("Server da ngat ket noi.");
                }
            });

            receiveThread.start();

            String message;

            System.out.print("Client: ");

            while ((message = console.readLine()) != null) {

                out.println(message);

                if (message.equalsIgnoreCase("QUIT")) {
                    break;
                }

                System.out.print("Client: ");
            }

        } catch (IOException e) {
            System.out.println("Loi Client: " + e.getMessage());
        }
    }
}