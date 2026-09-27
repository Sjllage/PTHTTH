import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class DigitClient {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 5000;

        try (
                Socket socket = new Socket(host, port);

                BufferedReader console = new BufferedReader(
                        new InputStreamReader(
                                System.in,
                                StandardCharsets.UTF_8
                        )
                );

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
                )
        ) {

            System.out.println("connected.");
            System.out.println("Nhap 0-9 or QUIT:");

            String request;

            while ((request = console.readLine()) != null) {

                // Gửi dữ liệu cho Server
                out.println(request);

                // Nhận kết quả
                String response = in.readLine();

                System.out.println("Server: " + response);

                // Kết thúc
                if (request.equalsIgnoreCase("QUIT")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Lỗi Client: " + e.getMessage());
        }
    }
}