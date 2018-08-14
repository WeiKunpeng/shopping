
import com.tangz.shoppingmall.dao.UserDao;
import com.tangz.shoppingmall.meta.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

/**
 * Created by weikunpeng on 2018/8/9.
 */



public class DaoTest {


    Logger logger=Logger.getLogger(this.getClass());


    @Test
    public void daotest(){



        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:spring-mybatis.xml");


        UserDao userDao= (UserDao) classPathXmlApplicationContext.getBean("userDao");


       // User user=userDao.findById(1);

        logger.debug(userDao);

        System.out.println(userDao.addOne("guohongbin","123",0));

        //System.out.println(userDao.findByName("buyer"));

       // System.out.println(user);

    }




}
