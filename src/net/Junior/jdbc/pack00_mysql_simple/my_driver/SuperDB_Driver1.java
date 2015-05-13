package net.Junior.jdbc.pack00_mysql_simple.my_driver;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Mr_Faton on 09.05.2015.
 */
public class SuperDB_Driver1 extends SuperDB_Driver0 {
    static {
        try {
            DriverManager.registerDriver(new SuperDB_Driver1());
        } catch (SQLException ex) {
            throw new RuntimeException("Can't register driver");
        }
    }
}
/*
Наследуемся от драйвера0 только для того, чтобы не создавать новый драйвер с нуля. Смысл этого драйвер в том, что у
него есть статическая секция инициализации, в которой он добавляется к драйвер менеджеру
 */