## pojo 是什么？
POJO（Plain Old Java Objects）简单的Java对象，实际就是普通JavaBeans，是为了避免和EJB混淆所创造的简称。

## dao是什么？
dao层是数据访问接口，用于访问数据库

## plugin not found 如何解决？
#### [ 描述 ]
```
Plugin 'org.apache.tomcat.maven:tomcat7-maven-plugin:' not found
``` 
#### [ 解决方案 ]
加了`<version>2.2</version>`就好了。。
```
<plugins>
    <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
            <!-- 指定端口 -->
            <port>9101</port>
            <!-- 请求路径 -->
            <path>/</path>
        </configuration>
    </plugin>
</plugins>
```

## src/main/webapp/WEB-INF/web.xml是什么？
web.xml文件是Java web项目中的一个配置文件，主要用于配置欢迎页、Filter、Listener、Servlet等。
但并不是必须的，一个java web项目没有web.xml文件照样能跑起来。
> https://segmentfault.com/a/1190000011404088

## web.xml里面filter-class报错： xxx not found
#### [ 描述 ]
```
<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
```

#### [ 解决方案 ]
module层级没有依赖对，依赖关系应该如下:
```
mall_web_manager -> mall_common_web -> mall_common -> mall_parent
```
