import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OSI_Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;
        try (Socket socket = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
        {
            while (true){
                String mes = in.readLine();
                System.out.println("Введите сообщение: " + mes);
                if (mes.equals("end")) break;
                out.println(mes);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
