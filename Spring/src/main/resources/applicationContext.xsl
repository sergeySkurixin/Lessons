<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-4.2.xsd
   http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-4.2.xsd
   http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop-4.2.xsd">

    <!--<bean id="helloWorld" class="spring.HelloWorld">-->
        <!--<property name="name" value="Andrey"/>-->
    <!--</bean>-->

    <!--&lt;!&ndash;<bean id="customerService" class="spring.customer.CustomerService">&ndash;&gt;-->
        <!--&lt;!&ndash;<property name="customerDao" ref="customerDaoID"/>&ndash;&gt;-->
    <!--&lt;!&ndash;</bean>&ndash;&gt;-->

    <!--<bean id="customerService" class="spring.customer.CustomerService" scope="prototype" init-method="init" destroy-method="destroy">-->
        <!--<constructor-arg ref="customerDao"/>-->
        <!--<constructor-arg value="service name"/>-->
    <!--</bean>-->

    <!--<bean id="customerDaoID" class="spring.customer.dao.CustomerJdbcDao">-->
    <!--</bean>-->

    <!---->
    <context:annotation-config></context:annotation-config>
    <context:component-scan base-package="spring"/>
    <aop:aspectj-autoproxy/>
</beans>