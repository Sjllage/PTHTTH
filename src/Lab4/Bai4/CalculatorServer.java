import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CalculatorServer {

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

                    if (request.equalsIgnoreCase("QUIT")) {
                        out.println("OK BYE");
                        break;
                    }

                    try {

                        double result = calculate(request);

                        out.println("OK " + result);

                    } catch (Exception e) {

                        out.println("ERR INVALID_EXPRESSION");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Loi Server: " + e.getMessage());
        }
    }

    private static double calculate(String expression) {

        expression = expression.trim();

        if (expression.contains("+")) {

            String[] parts = expression.split("\\+");

            double a = Double.parseDouble(parts[0].trim());
            double b = Double.parseDouble(parts[1].trim());

            return a + b;

        } else if (expression.contains("-")) {

            String[] parts = expression.split("-");

            double a = Double.parseDouble(parts[0].trim());
            double b = Double.parseDouble(parts[1].trim());

            return a - b;

        } else if (expression.contains("*")) {

            String[] parts = expression.split("\\*");

            double a = Double.parseDouble(parts[0].trim());
            double b = Double.parseDouble(parts[1].trim());

            return a * b;

        } else if (expression.contains("/")) {

            String[] parts = expression.split("/");

            double a = Double.parseDouble(parts[0].trim());
            double b = Double.parseDouble(parts[1].trim());

            if (b == 0) {
                throw new ArithmeticException();
            }

            return a / b;
        }

        throw new IllegalArgumentException();
    }
}