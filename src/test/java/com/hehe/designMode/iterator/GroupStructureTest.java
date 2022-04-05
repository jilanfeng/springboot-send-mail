package com.hehe.designMode.iterator;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 刘伟锋
 * @date 2022/02/16
 **/
@SpringBootTest
class GroupStructureTest {
    private Logger logger = LoggerFactory.getLogger(GroupStructureTest.class);
    @Test
    public void test_iterator() {
        //数据填充
        GroupStructure groupStructure = new GroupStructure("1","小福哥");

        //雇员信息
        groupStructure.add(new Employee("2","范逸臣","二级部门"));
        groupStructure.add(new Employee("3","华晨宇","二级部门"));
        groupStructure.add(new Employee("4","邱心志","三级部门"));
        groupStructure.add(new Employee("5","马天宇","三级部门"));
        groupStructure.add(new Employee("6","萧敬腾","四级部门"));
        groupStructure.add(new Employee("7","杨洋","四级部门"));
        groupStructure.add(new Employee("8","乔治","四级部门"));


        // 节点关系 1-》（1，2) 2->(4,5)

        groupStructure.addLink("1",new Link("1","2"));
        groupStructure.addLink("1",new Link("1","3"));
        groupStructure.addLink("2",new Link("2","4"));
        groupStructure.addLink("2",new Link("2","5"));
        groupStructure.addLink("5",new Link("5","6"));
        groupStructure.addLink("5",new Link("5","7"));
        groupStructure.addLink("5",new Link("5","8"));


        Iterator<Employee>  iterator = groupStructure.iterator();
        while(iterator.hasNext()) {
            Employee emp = iterator.next();
            logger.info("{},雇员 ID:{} Name :{}",emp.getDesc(),emp.getuId(),emp.getName());
        }
    }


}