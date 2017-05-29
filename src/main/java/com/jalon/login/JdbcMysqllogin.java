package com.jalon.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by JinQiu on 2017/5/28.
 */
public class JdbcMysqllogin {
    @Override
    public String toString() {
        return super.toString();
    }

    public static void sysHello() {
        System.out.println("Hello");
    }

    public void login(String username, String password) {

        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化 SecurityManager
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);

        try {
            currentUser.login(token);
            // 6.判断是否成功登录
            System.out.println("登录成功！！"+currentUser.isAuthenticated());
            // 7.注销用户
            currentUser.logout();
        } catch (IncorrectCredentialsException e) {
            System.out.println("登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.");
        } catch (ExcessiveAttemptsException e) {
            System.out.println("登录失败次数过多");
        } catch (LockedAccountException e) {
            System.out.println("帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.");
        } catch (DisabledAccountException e) {
            System.out.println("帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.");
        } catch (ExpiredCredentialsException e) {
            System.out.println("帐号已过期. the account for username " + token.getPrincipal() + "  was expired.");
        } catch (UnknownAccountException e) {
            System.out.println("帐号不存在. There is no user with username of " + token.getPrincipal());
        }
    }



    public static void main(String[] args) {
        sysHello();
        JdbcMysqllogin login = new JdbcMysqllogin();
        login.login("zhoujl", "zhoujl");
        login.login("zhang", "123345");
    }


}
