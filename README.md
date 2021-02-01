Cars
==========

* databáze H2, připojení definované v context.xml jako:

```xml
 <Resource name="jdbc/carsdb" auth="Container"
        type="javax.sql.DataSource"
        driverClassName="org.h2.Driver"
        url="jdbc:h2:tcp://localhost/~/test"
        username="sa" password=""
        maxActive="20" maxIdle="10" maxWait="-1"
        description="Datasource for cars database" />
```
