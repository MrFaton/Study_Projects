package net.mr_faton.Different_Things;

import java.util.logging.Logger;

public class ClassNameInStaticContext {
    private static final Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    public static void main(String[] args) {
        System.out.println(logger.getName());
    }
}
