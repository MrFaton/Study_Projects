package net.Junior.spring.app02_spring_dependency_injection_complex;

import net.Junior.spring.app02_spring_dependency_injection_complex.bean.Slave_Bean;

/**
 * Created by root on 30.04.2015.
 */
public class App02_Start {
    public static void main(String[] args) {
        //гпуппка для запуска только класса предка
//        Master_Bean master_bean = new Master_Bean();
//        master_bean.injectDependency();//инъекцируем зависимость
//        master_bean.printWorkerBean_FromMasterBean();


        //группка для запуска ксласса потомка и пердка
        Slave_Bean slave_bean = new Slave_Bean();
        slave_bean.injectDependency();//инъекцируем зависимость
        slave_bean.printWorkerBean_FromSlaveBean_BeanTypeA1();
//        slave_bean.printWorkerBean_FromSlaveBean_BeanTypeA2();
//        slave_bean.printMasterBean();
    }
}
