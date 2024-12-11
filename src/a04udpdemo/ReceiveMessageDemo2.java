package a04udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveMessageDemo2 {

    public static void main(String[] args) throws IOException {
        //创建接收对象  从10086接收数据
        MulticastSocket ms=new MulticastSocket(10086);

        //要将次接收端加入到组播地址当中才能接收到组播数据,指定ip
        InetAddress address1 = InetAddress.getByName("244.0.0.1");
        ms.joinGroup(address1);


        //2.收取数据包:需要用一个容器来接受
        byte[] bytes= new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
        ms.receive(dp);

        //3.解析数据包
        byte[] data = dp.getData();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        int length = dp.getLength();

        System.out.println("接收到的数据为:"+new String(data,0,length));
        System.out.println("从地址"+address+"的"+port+"发送过来的");

        //释放资源
        ms.close();

    }
}
