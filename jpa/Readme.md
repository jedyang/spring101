## spring-data-jpa的使用
### JPA
JPA的全称是Java Persistence API。这是一个Spring在数据持久化方面的接口标准。并非是一个实现。目的在于统一目前的ORM开发框架。
使用spring-data-jpa,开发的感觉就是爽，不需要写一行sql，就可以满足绝大部分的业务开发。
按照约定好的【方法命名规则】写dao层接口，就可以在不写接口实现的情况下，实现对数据库的访问和操作。同时提供了很多除了CRUD之外的功能，如分页、排序、复杂查询等等。

### 使用 

spring.jpa.hibernate.ddl-auto，其属性值作用区别:

    create：
    每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。

    create-drop ：
    每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。

    update：
    最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据 model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等 应用第一次运行起来后才会。

    validate ：
    每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。

