package utils;

import config.BaseConfig;

import java.io.File;

public class helpUtills {

    public static File getFile(String filename) {
        ClassLoader classLoader = BaseConfig.class.getClassLoader();
        return new File(classLoader.getResource("files/images/" + filename).getFile());
    }
}
