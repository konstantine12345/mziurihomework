package davaleba2;

import java.io.*;

class Student implements Serializable{
    String id;
    String name;
    int age;
    Student(String id,String name,int age){
        this.age = age;
        this.name = name;
        this.id = id;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        //1
        Student[] students = sampledata();
        FileOutputStream fileOutputStream = new FileOutputStream("out.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(students);

        objectOutputStream.close();
        fileOutputStream.close();
        //2
        FileInputStream fileInputStream = new FileInputStream("out.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student deserialization = (Student) objectInputStream.readObject();
        fileOutputStream.close();
        objectInputStream.close();



    }
    public static Student[] sampledata() {
        return new Student[] {
                new Student("123", "vinme", 85),
                new Student("456", "vinme2", 92),
                new Student("88", "vinme3", 78),
                new Student("666", "vinme4", 89),
                new Student("333", "vinme5", 91)
        };
    }
}
