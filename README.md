# WSR
# 入门Springboot例子

## software version 
* java1.8se， 
* maven-3.5.4，

* eclipse marketplace install the Spinh Toold plug-in 
> + eclipse Version: Oxygen.1a Release (4.7.1a) 
> > - "Spring Tools 3 Add-On 3.9.5 RELEASE"         TEST OK
> + eclipse Version: 2018-09 (4.9.0)    
> > - "Sptinh Toold 4 4.4.0.0.RELEASE"               TEST OK
* 后台db数据库使用mysql5
[db]: https://github.com/kingsir25/WSR/blob/master/dbinstall/create.txt "dbinstall/create.txt"
> 参照[db]文件，导入数据.

1. 浏览器URL输入：http://localhost:9090/demo/hi/say?id=1
>> 显示“id: 1”

2. 浏览器URL输入：http://localhost:9090/demo/Resources
>> 显示如下mysql中Resource表的内容。
>> [{"id":100,"name":"XXYYZZ","sex":"male","level":"AM","comeDate":0},{"id":1,"name":"jaek","sex":"male","level":"AM","comeDate":0},{"id":2,"name":"meinv","sex":"female","level":"sse","comeDate":0},{"id":3,"name":"laoda","sex":"male","level":"M","comeDate":0}]

3. 如果有依赖冲突的时候，可以尝试命令行“mvn clean install”
>> 显示结果如下：
>>> #### Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

>>> #### [INFO]
>>> #### [INFO] --- maven-jar-plugin:2.6:jar (default-jar) @ demo ---
>>> #### [INFO] Building jar: D:\eclipse-workspace\WSR\target\demo-0.0.1-SNAPSHOT.jar
>>> #### [INFO]
>>> #### [INFO] --- spring-boot-maven-plugin:1.5.14.RELEASE:repackage (default) @ demo ---
>>> #### [INFO]
>>> #### [INFO] --- maven-install-plugin:2.5.2:install (default-install) @ demo ---
>>> #### [INFO] Installing D:\eclipse-workspace\WSR\target\demo-0.0.1-SNAPSHOT.jar to C:\Users\Administrator\.m2\repository\com\example\demo\0.0.1-SN
>>> #### APSHOT\demo-0.0.1-SNAPSHOT.jar
>>> #### [INFO] Installing D:\eclipse-workspace\WSR\pom.xml to C:\Users\Administrator\.m2\repository\com\example\demo\0.0.1-SNAPSHOT\demo-0.0.1-SNAPS
>>> #### HOT.pom
>>> #### [INFO] ------------------------------------------------------------------------
>>> #### [INFO] BUILD SUCCESS
>>> #### [INFO] ------------------------------------------------------------------------
>>> #### [INFO] Total time: 15.722 s
>>> #### [INFO] Finished at: 2018-09-30T19:33:20+08:00
>>> #### [INFO] ------------------------------------------------------------------------

## 常见错误解决办法
1. 错误: 找不到或无法加载主类 com.example.demo.DemoApplication

2. junit-4.12.jar时出错; invalid CEN header (bad signature)
解决方法：pom.xml里添加dependency

3. maven提示invalid LOC header (bad signature)的解决办法
解决的办法是把提示的文件删掉让maven重新下载就解决了。

	<dependency>   
	 <groupId>org.apache.maven.plugins</groupId>    
	 <artifactId>maven-resources-plugin</artifactId>    
	 <version>2.6</version>
	 </dependency>
<!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>1.10.19</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
