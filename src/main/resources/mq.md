mq优点；解耦，削峰，数据分发
缺点：系统复杂度提高

FileZilia NPPFTP


启动RocketMq
1.启动NameServer
nohup sh bin/mqnamesrv &
tail -f ~/logs/rocketmqlogs/namesrv.log
2.启动Broker
nohup sh bin/mqbroker -n localhost:9876 &
tail -f ~/logs/rocketmqlogs/broker.log

通过JPS查看进程是否启动成功

rocketMq 默认的虚拟内存较大


关闭NameServer
sh bin/mqshutdown namesrv
关闭broker
sh bin/mqshutdown broker

发送消息
设置环境变量
export NAMESERV_ADDR=localhost:9876
2.
接受消息 一直监听
export NAMESERV_ADDR=localhost:9876
2.

Broker:暂存和传输消息
NameServer： 管理broker
topic:区分消息的种类，一个发送者可以发送消息给一个或者多个Topic;一个消息的接收者可以订阅一个或者多个topic消息

Message QUeue:相当于topic的分区；用于并行发送和接收消息
                  

producer集群      BrokerMaster1                                   consumer集群
                  brokerMaster2    brokerSlave2


NameServer  无状态  集群之间没有同步  broker 会逐一上传各个Name server
boker Master 主要时写操作 producer    slave 读操作  cunsunmer

broker name 区分统一为主从
一个master可以对应多个slave
broker id 为 0 主节点 ，非0 表示slave  

producer 会与NameServer 建立长链接  获取broker信息定期从NameServer获取topic路由信息    定时向Master发送心跳检测
Cunsumer 会与NameServer 建立长链接  获取broker信息定期从NameServer获取topic路由信息    定时向NameServer发送心跳检测





开启本地consul consul agent -dev -client=0.0.0.0   dev代表的时开发者模式启动，-client=0.0.0.0代表所有Ip都能访问到当前服务


二、在服务器上面下载与安装
1、在linux虚拟中下载consul服务

## 从官网下载最新版本的Consul服务
wget https://releases.hashicorp.com/consul/1.5.3/consul_1.5.3_linux_amd64.zip 
##使用unzip命令解压
unzip consul_1.5.3_linux_amd64.zip 
##将解压好的consul可执行命令拷贝到/usr/local/bin目录下
cp consul /usr/local/bin
##测试一下
consul
1
2
3
4
5
6
7
8
2、启动consul服务，使用命令：consul agent -dev -client=0.0.0.0

##已开发者模式快速启动，-client指定客户端可以访问的ip地址 
[root@node01 ~]# consul agent -dev -client=0.0.0.0 
==> Starting Consul agent...
Version: 'v1.5.3'
Node ID: '49ed9aa0-380b-3772-a0b6-b0c6ad561dc5' Node name: 'node01'
        Datacenter: 'dc1' (Segment: '<all>')
            Server: true (Bootstrap: false)
Client Addr: [127.0.0.1] (HTTP: 8500, HTTPS: -1, gRPC: 8502, DNS: 8600) Cluster Addr: 127.0.0.1 (LAN: 8301, WAN: 8302)
Encrypt: Gossip: false, TLS-Outgoing: false, TLS-Incoming: false, Auto-Encrypt-TLS: false