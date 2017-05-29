package com.jalon.login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by JinQiu on 2017/5/28.
 */
public class JdbcMysqlloginTest {
    @Before
    public void setUp() throws Exception {
        assertTrue(true);
    }

    @After
    public void tearDown() throws Exception {
        assertTrue(true);
    }

    @Test
    public void sysHello() throws Exception {
        JdbcMysqllogin.sysHello();
    }

}