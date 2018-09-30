"# WSR" 
入门Springboot例子

mysql5
maven-3.5.4
eclipse marketplace install the plug-in "Spring Tools 3 Add-On 3.9.5 RELEASE"


1.浏览器URL输入：http://localhost:9090/demo/hi/say?id=1
显示“id: 1”

2.浏览器URL输入：http://localhost:9090/demo/Resources
显示如下mysql Resource表内容。
[{"id":100,"name":"XXYYZZ","sex":"male","level":"AM","comeDate":0},{"id":1,"name":"jaek","sex":"male","level":"AM","comeDate":0},{"id":2,"name":"meinv","sex":"female","level":"sse","comeDate":0},{"id":3,"name":"laoda","sex":"male","level":"M","comeDate":0}]

常见错误
1.
错误: 找不到或无法加载主类 com.example.demo.DemoApplication

	<dependency>   
	 <groupId>org.apache.maven.plugins</groupId>    
	 <artifactId>maven-resources-plugin</artifactId>    
	 <version>2.6</version>
	 </dependency>
   
2.
junit-4.12.jar时出错; invalid CEN header (bad signature)
解决方法：pom.xml里添加
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
3.
maven提示invalid LOC header (bad signature)的解决办法
解决的办法是把提示的文件删掉让maven重新下载就解决了。
