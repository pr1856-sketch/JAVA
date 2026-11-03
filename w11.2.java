import java.net.*;

class WeatherServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] data = new byte[1024];

        System.out.println("Server waiting...");

        while (true) {
            DatagramPacket dp = new DatagramPacket(data, data.length);
            ds.receive(dp);

            String temp = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Temperature: " + temp + "°C");
        }
    }
}