package cn.leon.service;

public class User {
    private String name;

    public SelfService selfService;

    public void showUser(){
        System.out.println(name);
    }

    public void setSelfService(SelfService selfService) {
        this.selfService = selfService;
    }

    public SelfService getSelfService() {
        return selfService;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
