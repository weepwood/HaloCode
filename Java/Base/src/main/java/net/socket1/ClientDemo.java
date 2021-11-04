package net.socket1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 目标：完成Socket网络编程入门案例的客户端开发，实现1发1收。
 */
public class ClientDemo {
    public static void main(String[] args) {
        try {
            System.out.println("==== 客户端启动 ===");

            // 1、创建 Socket 通信管道请求有服务端的连接
            // public Socket(String host, int port)
            // 参数一：服务端的 IP 地址
            // 参数二：服务端的端口
            Socket socket = new Socket("127.0.0.1", 7777);

            // 2、从 socket 通信管道中得到一个字节输出流 负责发送数据
            OutputStream os = socket.getOutputStream();

            // 3、把低级的字节流包装成打印流
            PrintStream ps = new PrintStream(os);

            // 4、发送消息
            ps.println("我是 TCP 的客户端，我已经与你对接，并发出邀请");
            ps.flush();

            // 关闭资源。
            // socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
