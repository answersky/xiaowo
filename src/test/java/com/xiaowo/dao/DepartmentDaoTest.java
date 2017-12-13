package com.xiaowo.dao;

import com.xiaowo.BaseTest;
import com.xiaowo.Department;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public class DepartmentDaoTest extends BaseTest {
    @Resource
    private DepartmentDao departmentDao;

    @Test
    public void findDepartments() throws Exception {
        List<Department> departments = departmentDao.findDepartments();
        System.out.println(departments);
    }

}