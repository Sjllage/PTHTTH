import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeServer {

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

                String request;

                while ((request = in.readLine()) != null) {

                    if (request.equalsIgnoreCase("TIME")) {

                        LocalDateTime now = LocalDateTime.now();

                        DateTimeFormatter formatter =
                                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                        out.println(now.format(formatter));

                    } else if (request.equalsIgnoreCase("QUIT")) {

                        out.println("OK BYE");
                        break;

                    } else {

                        out.println("ERR UNKNOWN_COMMAND");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Loi Server: " + e.getMessage());
        }
    }
}