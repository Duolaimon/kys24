package com.duol.shop.test;

import com.duol.shop.service.StorageProperties;

/**
 * @author Duolaimon
 *         17-5-12 下午8:41
 */
public class Test {
    @org.junit.Test
    public void test() {
        StorageProperties s = new StorageProperties();
        System.out.println(s.getClass().getClassLoader().getResource("/").getPath());
    }
}
