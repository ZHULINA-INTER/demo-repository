public class Person {
    public int id;
    public String name;
    public int age;
    public String area;
    public Person(int id, String name, int age, String area) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.area = area;
    }
    public int get_id(){
        return id;
    }
    public String get_name(){
        return name;
    }
    public int get_age(){
        return age;
    }
    public String get_area(){
        return area;
    }
    public void set_Area(String area){
        this.area = area;
    }
    public void set_id(int id){
        this.id = id;
    }
    public void set_name(String name){
        this.name = name;
    }
    public void set_age(int age){
        this.age = age;
    }
}

class Member extends Person {

    public Member(int id, String name, int age, String area) {
        super(id, name, age, area);
    }

}