package net.mr_faton.exceptions;

/**
 * Created by root on 11.09.2014.
 */
public class App15 {
    public static void main(String[] args) {
        try (App14_Ok x = new App14_Ok("xxx"); FailCreate y = new FailCreate("yyy")) {
            System.err.println("body");
        }
    }
}
//ломаемся в конструкторе "ФэилКриэйт", и видом что, "х" открыли и закрыли, а вот "у" только попытались открыли, но не закрываем,
// потому что закрывать нечего, т.к. не получилось ничего открыть, в таком случае до тела try мы не доходим, т.к. не удалось
// выделить все ресурсы.