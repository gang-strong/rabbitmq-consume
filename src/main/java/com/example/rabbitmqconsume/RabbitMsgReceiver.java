package com.example.rabbitmqconsume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.utils.common.User;

@Component
public class RabbitMsgReceiver {
	
	@RabbitListener(queues = {"datequeue","hello2"})
    public void processDate(String str) {
		Object obj = new Object();
        System.out.println("rabbitmq-consume ====== >>" + str);
    }

    @RabbitListener(queues = "objectQueue")
    public void processObj(User user) {
        System.out.println("rabbitmq-consume  Receiver ==================: " + user);
        System.out.println("rabbitmq-consume  Receiver ==================: " + user.getName());
        System.out.println("rabbitmq-consume  Receiver ==================: " + user.getAddress());
    }
    
    @RabbitListener(queues = "jsonQueue")
    public void processJson(JSONObject json) {
    	System.out.println("jsonobject =======>>" + json.getObject("key", User.class));
    	User user = json.getObject("key", User.class);
    	System.out.println("name ==" + user.getName() + " age ==" + user.getAge() + " address ==" + user.getAddress());
    }
 
}
