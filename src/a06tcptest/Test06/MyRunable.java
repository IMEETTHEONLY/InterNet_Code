package a06tcptest.Test06;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunable implements Runnable{
    //这里因为每个线程都要去连接一个通道，所以说要传进socket对象


    Socket socket;
    public MyRunable(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            //接收来自客户端的文件
            //接收图片的化就只有字节
            BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
            //获取UUID，作为文件名,这样下载的文件名就不会重复了
            String name = UUID.randomUUID().toString().replace("-","");
            //与本地文件建立连接
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("D:\\java_code\\InterNet_Code\\serverdir\\"+name+".png"));

            //边读边写
            byte[] bytes=new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                //向文件当中写入
                bos.write(bytes);
            }

            //这里要关闭文件流   这里关闭了流相当于就刷新了缓冲数组了，那么数据就都写进文件了
            bos.close();


            //向客户端发送文件已接受的信号
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("上传文件成功".getBytes());


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            try {
                //当通道对象不为空的时候才释放,因为这是在多线程环境下的
                if(socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
