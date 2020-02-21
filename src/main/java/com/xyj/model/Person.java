package com.xyj.model;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj instanceof Person){
        Person obj1 = (Person) obj;
        if(this.age == ((Person) obj).age && this.name.equals(obj1.name)){
            return true;
        }
        }
        return false;
    }
    //销毁这个类的对象，时候会执行这个代码
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("person 被销毁");
    }
}
