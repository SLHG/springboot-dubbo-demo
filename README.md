## springboot-dubbo-demo练习项目简介
- 项目主要为本人练习使用,同时记录笔记方便以后翻阅
- 项目由springboot2,dubbo-spring-boot-starter2.7组成,分为controller层和serviceImpl层
- 项目的service层,dao层和beans层以依赖的形式整合
- 目前项目为双配置文件,方便本地开发和生产部署,集成了redis lettuce,使用druid集成的双数据源,集成了druid的configFilter



### 以下为项目笔记记录

##### 1.项目结构

![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/%E9%A1%B9%E7%9B%AE%E7%BB%93%E6%9E%84.png)

##### 2.配置文件中@符号说明

![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/maven%E9%85%8D%E7%BD%AE%E8%AF%B4%E6%98%8E.png)

  由于项目继承自spring-parent项目

![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/%E9%A1%B9%E7%9B%AE%E7%BB%A7%E6%89%BF%E8%87%AAspring-parent.png)

  自然就继承了其POM配置文件,其中定义了替换符为@

![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/%E5%AE%9A%E4%B9%89%E4%BA%86%40%E7%AC%A6%E5%8F%B7.png)
##### 3.在父项目的POM文件中使用module
module标签用来定义其他模块为此父项目的子模块

![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/POM%E4%B8%ADmobules%E4%BD%BF%E7%94%A8.png)

##### 4.父项目中使用dependencyManagement标签说明
  此标签实际为管理整个项目的依赖,和依赖的版本号,之后只需要在相应模块中使用依赖就可以,不用再指定版本号

![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/dependencyManagement%E8%AF%B4%E6%98%8E.png)

##### 5. 配置文件分环境说明
  在父项目POM中使用标签指定项目分包情况,之后在不同环境中使用
  'mvn compile install -Pdev
   mvn compile install -Pprd
  '
  进行maven打包处理,就可以使用不同的配置进行分环境管理
  
  ![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E5%88%86%E5%8C%85%E8%AF%B4%E6%98%8E.png)
 
  同时需要使用build标签配合,在其中定义配置文件路径和是否开启根据配置文件中的@符号替换功能
  
  ![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/controller%E5%B1%82build%E8%AF%B4%E6%98%8E.png)
  
##### 6.双mysql数据源和使用druid加密功能配置说明

  首先是在配置文件中定义双数据源的配置
  
 ![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/%E5%8F%8C%E6%95%B0%E6%8D%AE%E6%BA%90%E9%85%8D%E7%BD%AE.png)
 
  文件说明
  
  ![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/%E5%8F%8C%E6%95%B0%E6%8D%AE%E6%BA%90%E6%96%87%E4%BB%B6%E8%AF%B4%E6%98%8E.png)
  
  自定义配置将数据源注入spring中
  
  ![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/%E5%B0%86%E9%85%8D%E7%BD%AE%E6%B3%A8%E5%85%A5spring%E8%AF%B4%E6%98%8E.png)
  
  然后根据方法上的注解在对应方法执行前,切入进行数据源更换
  
  ![image](https://github.com/SLHG/springboot-dubbo-demo/blob/master/images/AOP%E5%88%87%E6%8D%A2%E6%95%B0%E6%8D%AE%E6%BA%90.png)
