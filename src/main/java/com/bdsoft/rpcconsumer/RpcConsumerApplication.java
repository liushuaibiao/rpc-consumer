package com.bdsoft.rpcconsumer;

import com.bdsoft.rpcaio.API.HelloService;
import com.bdsoft.rpcaio.API.Result;
import com.bdsoft.rpcaio.API.StudentInfo;
import com.bdsoft.rpcaio.API.StudentServiceApi;
import com.bdsoft.rpcaio.remote.RpcProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RpcConsumerApplication {



    public static void main(String[] args) {
        SpringApplication.run(RpcConsumerApplication.class, args);
       /* System.out.println("请输入要查询的名字");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            queryString(scanner.next());
        }*/
        RpcProxyFactory rpcProxyFactory = new RpcProxyFactory();
        StudentServiceApi helloService= (StudentServiceApi) rpcProxyFactory.factoryRemoteInvoker(StudentServiceApi.class);

        StudentInfo bean = new StudentInfo();
        bean.setName("嘿嘿");
        Result<StudentInfo> result = helloService.queryStudent(bean);
        if(result!=null&& result.isSuccess()){
            StudentInfo studentInfo = result.getData();
            System.out.println("打印1："+studentInfo.getName());
            System.out.println("打印2："+studentInfo.getAge());
        }

    }

    public static void queryString(String name){
        RpcProxyFactory rpcProxyFactory = new RpcProxyFactory();
        StudentServiceApi helloService= (StudentServiceApi) rpcProxyFactory.factoryRemoteInvoker(StudentServiceApi.class);

        StudentInfo bean = new StudentInfo();
        bean.setName(name);
        Result<StudentInfo> result = helloService.queryStudent(bean);
        if(result!=null&& result.isSuccess()){
            StudentInfo studentInfo = result.getData();
            System.out.println("打印1："+studentInfo.getName());
            System.out.println("打印2："+studentInfo.getAge());
        }

    }


}
