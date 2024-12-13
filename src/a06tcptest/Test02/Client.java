package a06tcptest.Test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    /*客户端发送一条数据，接收服务端反馈的信息并打印*/
    /*通道只有一个，切记不能开启多个通道*/
    public static void main(String[] args) throws IOException {


        //首先建立socket
        Socket socket=new Socket("127.0.0.1",9998);

        //从socket对象当中获取输出流
        OutputStream outputStream = socket.getOutputStream();

        //向服务端发送数据
        outputStream.write("你好你好呀!".getBytes());



        //写出结束标志，表述输出流结束
        socket.shutdownOutput();

        //接收来自于服务器的数据
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //循环打印出接收的数据即可
        int b;
        while ((b=br.read())!=-1){
            System.out.println((char) b);
        }

        //关闭资源
        socket.close();
    }
}
