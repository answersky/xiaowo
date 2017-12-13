package com.xiaowo.dao;

import com.xiaowo.Department;

import java.util.List;

/**
 * @author answer
 *         2017/11/27
 */
public interface DepartmentDao {
    /**
     * 查询所有的部门
     *
     * @return
     */
    List<Department> findDepartments();
}
