package com.example.demo;

import java.io.*;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/9/11
 **/
public class ReadFileTest {
    public static void main(String[] args) {
        //获取要读取的文件
        File readFile=new File("/Users/yiche/Desktop/1.txt");
        //输入IO流声明
        InputStream in=null;
        InputStreamReader ir=null;
        BufferedReader br=null;
        try {
            //用流读取文件
            in=new BufferedInputStream(new FileInputStream(readFile));
            //如果你文件已utf-8编码的就按这个编码来读取，不然又中文会读取到乱码
            ir=new InputStreamReader(in,"utf-8");
            //字符输入流中读取文本,这样可以一行一行读取
            br= new BufferedReader(ir);
            String line="";
            //一行一行读取
            Long totalCount = 0l;
            while((line=br.readLine())!=null){
                totalCount++;
                System.out.println(line);
            }
            System.out.println("总用户数:"+totalCount);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //一定要关闭流,倒序关闭
            try {
                if(br!=null){
                    br.close();
                }
                if(ir!=null){
                    ir.close();
                }
                if(in!=null){
                    in.close();
                }
            } catch (Exception e2) {
            }
        }
    }
    }
