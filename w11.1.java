import java.net.*;
import java.io.*;

class ResultServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting...");

        Socket s = ss.accept();

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String reg = in.readUTF();

        String result;
        if (reg.equals("101"))
            result = "Pass - 85%";
        else if (reg.equals("102"))
            result = "Pass - 90%";
        else if (reg.equals("103"))
            result = "Pass - 78%";
        else
            result = "Result not found";

        out.writeUTF(result);

        s.close();
        ss.close();
    }
}