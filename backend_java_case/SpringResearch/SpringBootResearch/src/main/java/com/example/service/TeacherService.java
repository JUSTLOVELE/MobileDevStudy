package com.example.service;

public interface TeacherService {

    /**
     * 分页
     */
    public void queryPagin();

    /**
     * 保存对象
     * @param opId
     * @param name
     */
    public void saveTeacher(String opId, String name);

    /**
     * 更新名字
     * @param opId
     * @param name
     */
    public void updateName(String opId, String name);

    /**
     * 根据名字查询实体
     * @param name
     */
    public void queryWithName(String name);

    /**
     * 根据名字查询实体转换为list
     * @param name
     */
    public void queryWithNameList(String name);

    /**
     * 保存出抛出异常测试是否回滚
     */
    public void saveWithException();
}
