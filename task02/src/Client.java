import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int argsLength = args.length;
        int port = 0;
        String server = "";
        switch (argsLength) {
            case 0: server = "localhost"; port = 3000; break;
            case 1: server = "localhost"; port = Integer.parseInt(args[0]); break;
            case 2: server = args[0]; port = Integer.parseInt(args[1]); break;
        }
        try (Socket socket = new Socket(server, port)) {
            System.out.println("Connected to server");
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}