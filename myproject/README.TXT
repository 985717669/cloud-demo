一个spring cloud 项目的初步模型
应用了 gateway 和zuul 两种网关模型
逆向工程

# spring cloud 和 bus-amqp版本冲突  参考  https://blog.csdn.net/liubenlong007/article/details/87193286
#https://start.spring.io/actuator/info
继续整合kafka
调用service-hi中的/stu接口， 发送一条消息给kafka-coumue  需要启动kafka



#所有的feign调用统一放在common-feign-api中， 谁需要直接依赖common-feign-api

端口
eureka 8761
config 8888
zuul  9999
gateway 9998
service-hi 8762
service-say 8763