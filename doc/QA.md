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
module层级没有依赖对，按照依赖关系一层一层的去排查。  
依赖关系应该如下:
```
mall_web_manager -> mall_common_web -> mall_common -> mall_parent
```

## autowired的作用是什么？

## tomcat7 运行出错: could not resolve dependencies for project ...
#### [ 描述 ]
```
[ERROR] Failed to execute goal on project mall_web_manager: 
Could not resolve dependencies for project com.mall.web_manager:mall_web_manager:war:0.0.1-SNAPSHOT: 
The following artifacts could not be resolved: 
com.mall:mall_interface:jar:0.0.1-SNAPSHOT, com.mall:mall_common_service:jar:0.0.1-SNAPSHOT: 
Could not find artifact com.mall:mall_interface:jar:0.0.1-SNAPSHOT -> [Help 1]
```

#### [ 解决方案 ]
到根pom去执行clean和install

#### [ 原因分析 ]
```
执行clean - install后发现报错： webxml attribute is required
排查后发现mall_service_googs没有加webapp/WEB-INF/web.xml文件
```

## mall_service_googs 和 mall_web_manager都具有`web.xml`文件，他们之间有什么区别呢？
```
mall_service_googs: 用于启动后端
mall_web_manager: 用于启动前端
```

## 访问后端路由报错：`No mapping found for HTTP request with URI ...`

#### [ 描述 ]
```
11:36:17,684 DEBUG DispatcherServlet:891 - DispatcherServlet with name 'springmvc' processing GET request for [/brand/findAll.do]
11:36:17,684 DEBUG RequestMappingHandlerMapping:312 - Looking up handler method for path /brand/findAll.do
11:36:17,685 DEBUG RequestMappingHandlerMapping:322 - Did not find handler method for [/brand/findAll.do]
11:36:17,685  WARN PageNotFound:1205 - No mapping found for HTTP request with URI [/brand/findAll.do] in DispatcherServlet with name 'springmvc'
11:36:17,685 DEBUG DispatcherServlet:1000 - Successfully completed request
```

#### [ 解决方案 ]
```
缺少applicationContext-*.xml文件，并且文件里面需要开启注解。

最主要原因是：依赖了错误的模块，而这个模块的xml文件里面是空的，没有开启注解，导致了404.
```