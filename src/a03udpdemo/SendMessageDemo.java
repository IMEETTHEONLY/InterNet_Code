package a03udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class SendMessageDemo {
    /*
    *   UDP:发送数据，数据来自于键盘录入
    *   UDP:接收数据，因为不知道发送端合适停止所以说一直接收
    * */

    public static void main(String[] args) throws IOException {
        //1.先创建发送对象  不指定端口，随机一个空闲端口
        DatagramSocket ds=new DatagramSocket();

        //键盘录入数据
        Scanner sc=new Scanner(System.in);

        //死循环录入
        while (true){
            System.out.println("请输入你要发送的数据:");
            String message = sc.nextLine();
            if(message.equals("886")){
                break;
            }
            byte[] bytes = message.getBytes();
            //通过哪个端口发送和接收
            int port=10086;
            //发送到的ip
            InetAddress byName = InetAddress.getByName("127.0.0.1");
            //创建发送包
            DatagramPacket dp=new DatagramPacket(bytes,bytes.length,byName,port);

            //发送即可
            ds.send(dp);

            //释放资源
        }

    }
}
