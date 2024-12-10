package a02udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveMessageDemo {
    /*
    *   创建DatagramSocket对象
    *   //细节:
    *   在接受的时候要绑定端口,并且这个端口要和发送的端口保持一致
    * */

    public static void main(String[] args) throws IOException {

        //1.先创建公司对象   要指定好接收端口(即发送端指定的端口)
        DatagramSocket ds=new DatagramSocket(10086);

        //2.收取数据包:需要用一个容器来接受
        byte[] bytes= new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
        ds.receive(dp);

        //3.解析数据包
        byte[] data = dp.getData();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        int length = dp.getLength();

        System.out.println("接收到的数据为:"+new String(data,0,length));
        System.out.println("从地址"+address+"的"+port+"发送过来的");

        //释放资源
        ds.close();


    }
}
