package a06tcptest.Test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        /*
        *   TCP接收多次数据，并打印
        * */

        //创建socket对象与客户端建立连接
        ServerSocket ss=new ServerSocket(9999);
        //死循环即可，一直等客户端发送消息

        //死等客户端发送消息过来，就开启通道
        Socket accept = ss.accept();
       while (true){


           //开启通道后就可以获取输入流,封装为缓冲流
           BufferedReader br=new BufferedReader(new InputStreamReader(accept.getInputStream()));
           int b ;
           //循环从流中读取数据打印即可
           while ((b=br.read())!=-1){
               System.out.print((char)b);
           }
       }



    }
}
