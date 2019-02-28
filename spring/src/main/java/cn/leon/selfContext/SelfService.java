package cn.leon.selfContext;


public class SelfService {
    /**
     * 测试循环依赖引用
     */
    public User user;
    private String name;
    private String age;

    public void showHelloWorld(){
        System.out.println(name+":"+age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }
}
