package com.design_parttern.structural;

public class FacadeTest {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.invoke();
    }
}

interface Service {
    void service();
}

class ServiceImpl implements Service {
    @Override
    public void service() {
        System.out.println("实现类");
    }
}

class Controller {
    public void invoke() {
        Service service = new ServiceImpl();
        service.service();
    }
}
