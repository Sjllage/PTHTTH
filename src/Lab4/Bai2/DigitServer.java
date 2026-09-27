import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class DigitServer {

    private static final int PORT = 5000;

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT)) {

            System.out.println("Server running in port " + PORT);

            // 
            try (Socket socket = server.accept()) {

                System.out.println("Client connected!");

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

                // 
                while ((request = in.readLine()) != null) {

                    // 
                    if (request.equalsIgnoreCase("QUIT")) {
                        out.println("OK BYE");
                        break;
                    }

                    String response = convertDigit(request);

                    out.println(response);
                }
            }

        } catch (IOException e) {
            System.out.println("error Server: " + e.getMessage());
        }
    }

    // Chuyển chữ số thành chữ
    private static String convertDigit(String request) {

        switch (request) {

            case "0":
                return "khong";

            case "1":
                return "mot";

            case "2":
                return "hai";

            case "3":
                return "ba";

            case "4":
                return "bon";

            case "5":
                return "nam";

            case "6":
                return "sau";

            case "7":
                return "bay";

            case "8":
                return "tam";

            case "chin":
                return "9";

            default:
                return "ERR INVALID_DIGIT";
        }
    }
}