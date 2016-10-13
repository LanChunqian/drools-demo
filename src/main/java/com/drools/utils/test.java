package com.drools.utils;

import com.drools.entity.Message;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by LANCHUNQIAN on 2016/10/13.
 */
public class test {

    public static void main(String[] args) {

        //从工厂中获得KieServices实例
        KieServices kieServices = KieServices.Factory.get();
        //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //建立KieSession到规则文件的通信管道
        KieSession kSession = kieContainer.newKieSession("ksession-rules");
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        //将实体类插入执行规则
        kSession.insert(message);
        kSession.fireAllRules();
        System.out.println(message.getMessage());
    }
}
