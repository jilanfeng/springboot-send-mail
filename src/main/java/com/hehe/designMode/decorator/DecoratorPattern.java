package com.hehe.designMode.decorator;

/**
 * @author 刘伟锋
 * @date 2021/01/02
 **/

/**
 * 装饰模式包含下面角色：
 * Component：抽象构件
 * ConcreteComponent：具体构件
 * Decorator:抽象装饰类
 * ConcreteDecorator:具体装饰类
 *
 *
 *
 *
 *
 *
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Compoent compoent = new ConcreteComponent();
        compoent.operation();
        System.out.println("-----------------------------");

    }
}


interface Compoent{
    public void operation();
}

class ConcreteComponent implements  Compoent {

    public ConcreteComponent() {
        System.out.println("创建具体的角色");
    }
    @Override
    public void operation() {
        System.out.println("调用具体构件角色的方法operation（）");
    }

}

class Decorator implements Compoent {

    private Compoent compoent;
    public Decorator(Compoent compoent) {
        this.compoent = compoent;
    }
    @Override
    public void operation() {
        compoent.operation();
    }
}


class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Compoent compoent) {
        super(compoent);
    }
    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }
    public void addBehavior() {
        System.out.println("为具体构件角色增加额外的功能addBehavior()");
    }
}