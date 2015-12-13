package cn.codepub.patterns.core;

import java.io.*;
import java.util.Hashtable;

/**
 * <p>
 * Created with IntelliJ IDEA. 2015/11/8 21:43
 * </p>
 * <p>
 * ClassName:DeepClone
 * </p>
 * <p>
 * Description:implements a deep clone for yourself
 * </P>
 *
 * @author Wang Xu
 * @version V1.0.0
 * @since V1.0.0
 */
public class DeepClone {
    public static void main(String[] args) {
        MyPerson son = new MyPerson("son", 1);
        MyPerson myPerson = new MyPerson("father", 11);
        myPerson.son = son;
        try {
            MyPerson deepClone = (MyPerson) myPerson.deepClone();
            //修改原值
            myPerson.son.name = "newSon";
            //可以看到完成了深拷贝，拷贝的引用变量son的name属性并未更改
            System.out.println(deepClone.son.name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

class MyPerson implements Cloneable, Serializable {
    public String name;
    public int age;
    public MyPerson son;

    public MyPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyPerson(String name, int age, MyPerson son) {
        this(name, age);
        this.son = son;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }

    Hashtable hashtable = new Hashtable();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyPerson myPerson = null;
        try {
            myPerson = (MyPerson) super.clone();
            myPerson.son = (MyPerson) son.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return myPerson;
    }
}
