package zcw.com.lib_rx_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱城委 on 2019/3/7.<br><br>
 */
public class Student {

    private String name;
    private int age;

    private List<Course> courses;

    public Student() {
        init();
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

        init();
    }

    private void init() {
        courses = new ArrayList<>();
        courses.add(new Course("Android"));
        courses.add(new Course("IOS"));
        courses.add(new Course("Math"));
        courses.add(new Course("Music"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}
