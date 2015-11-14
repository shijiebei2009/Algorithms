public class TestClone {

    /**
     * @param args
     */

    public static void main(String[] args) {
        try {
            new TestClone().cloneObject();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cloneObject() throws CloneNotSupportedException {
        Person p = new Person();
        Man man = new Man();
        man.setSalory("111123");
        p.setName("zhangfei");
        p.setMan(man);
        //man.setSalory("122335");//(1)
        Person pp = p.getClonePerson(p);
        man.setSalory("122335");//(2)
        pp.setName("aa");
        System.out.println("pp.getName()= " + pp.getName() + " pp.man.getSalory()= " + pp.getMan().getSalory());
        System.out.println("p.getName()=" + p.getName() + " p.man.getSalory()= " + p.getMan().getSalory());
        System.out.println(pp.getMan() == p.getMan());
    }
}

class Person implements Cloneable {
    private String name = "";
    private Man man;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Person getClonePerson(Person p) throws CloneNotSupportedException {
        Person pp = (Person) p.clone();
        return pp;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.man = this.getMan().getCloneMan(this.getMan());
        return p;
    }
}

class Man implements Cloneable {
    private String salory = "";

    public String getSalory() {
        return salory;
    }

    public void setSalory(String salory) {
        this.salory = salory;
    }

    public Man getCloneMan(Man man) throws CloneNotSupportedException {
        Man ma = (Man) man.clone();
        System.out.println((ma == man) + "jfdkl");
        return ma;
    }
}