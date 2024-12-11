package a04udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SendMessageDemo {
    /*
    *
    *   组播,将一个信息发送到一组当中去
    * */


    public static void main(String[] args) throws IOException {
        //1.找发送数据的对象
        //由于是组播所以说创建组播的对象
        MulticastSocket ms=new MulticastSocket();

        //2.打包数据

        //要发送的数据
        String str="你好你好";
        byte[] bytes = str.getBytes();
        //指定ip对象，发送给组播地址
        InetAddress byName = InetAddress.getByName("224.0.0.1");
        //这里是发到10086这个端口
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length,byName,10086);

        //发送数据
        ms.send(dp);

        //释放资源
        ms.close();



    }
}
