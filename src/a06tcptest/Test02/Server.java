package a06tcptest.Test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /*接收数据并打印，再给客户端反馈消息并打印*/
    public static void main(String[] args) throws IOException {
        //首先从客户端接受数据
        ServerSocket ss=new ServerSocket(9998);

        //卡死等待客户端连接socket通道
        Socket accept = ss.accept();

        //从通道中获取输入流
        BufferedReader br=new BufferedReader(new InputStreamReader(accept.getInputStream()));

        //循环打印获取到的数据
        //网络编程不像从文件当中读取数据，它没有结束标志，所以说需要在客户端那边传递一个结束标志才能让输入流结束
        int b;
        while ((b=br.read())!=-1){
            System.out.println((char) b);
        }




        //回写
        //将确认收到数据返回给客户端
        OutputStream outputStream = accept.getOutputStream();
        //写出数据
        outputStream.write("我已经收到数据!谢谢!".getBytes());
        //写出结束标志
        accept.shutdownOutput();

        //关闭通道
        accept.close();
        //关闭服务器
        ss.close();


    }
}
