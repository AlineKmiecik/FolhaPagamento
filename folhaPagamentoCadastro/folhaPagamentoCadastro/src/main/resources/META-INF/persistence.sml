<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
 http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
             version="2.1">
    <persistence-unit name="SistemaCursos" transaction-type="RESOURCE_LOCAL">
    	<!-- TODAS AS CLASSES DEVEM ESTAR MAPEADAS AQUI -->
    	<class> com.folhaPagamentoCadastro.folhaPagamentoCadastro.models </class>
    	<class> com.folhaPagamentoCadastro.folhaPagamentoCadastro.models </class>
    	
    	
		<properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Drive" />
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/folhaspagamento" />
			<property name="javax.persistence.jdbc.user" value="root" />
			<property name="javax.persistence.jdbc.password" value="admin" />
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />
			<property name="hibernate.show_sql" value="true"/>
		</properties>
	</persistence-unit>
</persistence>
