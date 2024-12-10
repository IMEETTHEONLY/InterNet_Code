package a03udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveMessageDemo {

    public static void main(String[] args) throws IOException {
        //循环接收数据

        //创建接收的对象(公司)
        DatagramSocket ds=new DatagramSocket(10086);  //指定接收数据的端口

        //死循环接收
        while (true){
            //创建容器对象
            byte[] bytes=new byte[1024];
            //接受数据的容器
            DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
            //接收数据
            ds.receive(dp);

            //解析数
            byte[] data = dp.getData();//数据
            String ip = dp.getAddress().getHostAddress();//ip
            String name = dp.getAddress().getHostName();//主机名字
            int port = dp.getPort();
            int length = dp.getLength();
            System.out.println("从"+ip+"主机名字为"+name+"端口为"+port+"接收的数据为"+new String(data,0,length));
        }

    }
}
