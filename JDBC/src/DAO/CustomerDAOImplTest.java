package DAO;

import bean.Customer;
import file.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

class CustomerDAOImplTest {

    private CustomerDaoImpl dao = new CustomerDaoImpl();

    @Test
    void insert(){
        Connection conn = null;
        try {
            conn =  JDBCUtils.getConnection();
            Customer cust = new Customer(1,"赵越","1975686676@qq.com",new Date(42554635L));
            dao.insert(conn,cust);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    void deleteById() {
        Connection conn = null;
        try {
            conn =  JDBCUtils.getConnection();
            dao.deleteById(conn,13);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    void update() {
        Connection conn = null;
        try {
            conn =  JDBCUtils.getConnection();
            Customer cust = new Customer(18,"贝多芬","beiduofen@qq.com",new Date(0x1b14_efb3L));
            dao.update(conn,cust);
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    void getCustomerById() {
        Connection conn = null;
        try {
            conn =  JDBCUtils.getConnection();
            Customer cust = dao.getCustomerById(conn,19);
            System.out.println(cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    void getAll() {
        Connection conn = null;
        try {
            conn =  JDBCUtils.getConnection();
            List<Customer> list = dao.getAll(conn);
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    void getCount() {
        Connection conn = null;
        try {
            conn =  JDBCUtils.getConnection();
            Long count =  dao.getCount(conn);
            System.out.println("表中的数据一共"+count+"条");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    void getMaxBirth() {
        Connection conn = null;
        try {
            conn =  JDBCUtils.getConnection();
            Date maxBirth =  dao.getMaxBirth(conn);
            System.out.println("最大的生日为:"+maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}