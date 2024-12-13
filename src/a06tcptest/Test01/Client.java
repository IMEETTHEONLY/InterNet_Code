package a06tcptest.Test01;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        /*TCP发送多次数据*/

        //1.首先是建立与服务器的通道
        Socket socket=new Socket("127.0.0.1",9999);

        //2.让用户多次输入数据,直到用户输入886
        Scanner sc=new Scanner(System.in);

        while (true){
            System.out.println("请输入您要发送的内容，886结束");
            String str=sc.nextLine();

            //如果说输入886结束循环
            if(str.equals("886")){
                break;
            }

            //否则就向服务器发送数据

            //从socket对象当中获取输出流
            OutputStream outputStream = socket.getOutputStream();
            //将输入的str写出
            outputStream.write(str.getBytes());
        }

        //结束程序关闭通道即可   流在socket里面会自动关闭
        socket.close();


    }
}
