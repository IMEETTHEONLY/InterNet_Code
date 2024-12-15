package a06tcptest.Test06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//利用线程池来处理线程
public class Server {
    //使用多线程去循环接收来自客户端的文件


    public static void main(String[] args) throws IOException {
        //创建服务器socket对象
        ServerSocket ss=new ServerSocket(9999);


        //由于频繁的去创建和销毁线程，会造成资源的浪费，所以说可以用线程池来装载线程
        ThreadPoolExecutor pool=new ThreadPoolExecutor(
                3,  //核心线程数
                6,  //最大核心线程数
                60, //存活时间
                TimeUnit.SECONDS,  //时间的单位
                new ArrayBlockingQueue<>(2),  //阻塞队列,当线程数不够了就会在阻塞队列里面
                Executors.defaultThreadFactory(),   //线程工厂
                new ThreadPoolExecutor.AbortPolicy()  //阻塞处理策略
        );


        while (true){

            //与客户端建立通道
            Socket socket = ss.accept();

            //开启多个线程去执行
            //new Thread(new MyRunable(socket)).start();
            //交给线程池去处理
            pool.submit(new MyRunable(socket));
        }


    }
}
