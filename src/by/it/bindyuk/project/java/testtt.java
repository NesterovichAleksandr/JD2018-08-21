package by.it.bindyuk.project.java;

import org.apache.commons.codec.digest.DigestUtils;

public class testtt {
    public static void main(String[] args) {
        String pass = "dfsdfssd";
        String pass2 = "dfsdfssd";
        String s = DigestUtils.md5Hex(pass);
        String s2 = DigestUtils.md5Hex(pass2);
        System.out.println(s + "\n" + s2);
    }
}
