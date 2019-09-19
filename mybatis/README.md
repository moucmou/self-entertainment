xml被解析然后被注入到knownMappers 的数据结构
Map<Class<?>, MapperProxyFactory<?>>
```
addMapper:61, MapperRegistry (org.apache.ibatis.binding)
/**
mapperRegistry里面有knownMappers这种数据结构来存class跟mapperproxyfactory这种数据结构
*/
addMapper:759, Configuration (org.apache.ibatis.session)
/**
根据namespace找到对应的class,如果还没有被放入到knownMappers，就开始添加
*/
bindMapperForNamespace:441, XMLMapperBuilder (org.apache.ibatis.builder.xml)
/**
将resource路径String，就是加入到loadedResources,在这其中会根据resource的路径去到对应的xml下解析各种标签,然后根据namespace绑定对应的mapper
*/

parse:96, XMLMapperBuilder (org.apache.ibatis.builder.xml)
/**
处理<mapper>里面的内容class、url、resource只能有一个
*/
mapperElement:373, XMLConfigBuilder (org.apache.ibatis.builder.xml)
parseConfiguration:119, XMLConfigBuilder (org.apache.ibatis.builder.xml)
/**
解析xml中的各种标签，从/configuration开始，然后mappers，plugins等等
*/
parse:98, XMLConfigBuilder (org.apache.ibatis.builder.xml)
build:78, SqlSessionFactoryBuilder (org.apache.ibatis.session)
build:64, SqlSessionFactoryBuilder (org.apache.ibatis.session)
main:17, TestMybatis (com.self.entertainment.mybatis.sharding)
```
mybatis到这的mapper映射就已经完事了、然后创建一个sqlsession，sqlsession.getmapper()为这个class
生成代理类

spring会扫描跟目录下的class或者是mapperscan指定的类，来把所有@mapper的dao接口注册成beandifinition，其类型为mapperfactorybean，初始化的时候就会调用其getobject来进行初始化，就完成了mapperproxy（这个类本身就是invocationhandler的实现类）的代理生成 ，就能完成sql的调用了、MappedStatement  就是xml中方法的id和接口中的方法名称对应起来，完成映射来执行对应的sql

四大插件接口  StatementHandler、ParameterHandler、ResultSetHandler、Executor为他们进行代理对象