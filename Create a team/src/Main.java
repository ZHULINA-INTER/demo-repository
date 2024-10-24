import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static ArrayList<Person> persons=new ArrayList<>();
    public static ArrayList<Member> members=new ArrayList<>();
    public static boolean flag=true;
    public static Person[]ps;
    public static void main(String[] args) {
        create_personList();
        app_menu();
    }
    //创建公司总成员列表
    public static void create_personList() {
        Person p1=new Person(20240801, "max   ", 18, "java");
        Person p2= new Person(20240802, "john  ", 32, "C++ ");
        Person p3= new Person(20240803, "helen ", 26, "java");
        Person p4= new Person(20240804, "nathan", 19, "java");
        Person p5= new Person(20240805, "mike  ", 20, "vue ");
        Person p6=new Person(20240806, "james ", 38, "C++ ");
        Person p7=new Person(20240807, "alex  ", 22, "java");
        Person p8=new Person(20240808, "rachel", 18, "C   ");
        Person p9=new Person(20240809, "ryan  ", 19, "js  ");
        Person p10=new Person(20240810, "ryan  ", 19, "js  ");
        Person p11=new Person(20240811, "max   ", 18, "java");
        Person p12=new Person(20240812, "john  ", 32, "C++ ");
        Person p13=new Person(20240813, "helen ", 26, "java");
        Person p14=new Person(20240814, "nathan", 19, "java");
        Person p15=new Person(20240815, "mike  ", 20, "vue ");
        Person p16=new Person(20240816, "james ", 38, "C++ ");
        Person p17=new Person(20240817, "alex  ", 22, "java");
        Person p18=new Person(20240818, "rachel", 18, "C   ");
        Person p19=new Person(20240819, "ryan  ", 19, "js  ");
        Person p20=new Person(20240820, "ryan  ", 19, "js  ");
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);
        persons.add(p7);
        persons.add(p8);
        persons.add(p9);
        persons.add(p10);
        persons.add(p11);
        persons.add(p12);
        persons.add(p13);
        persons.add(p14);
        persons.add(p15);
        persons.add(p16);
        persons.add(p17);
        persons.add(p18);
        persons.add(p19);
        persons.add(p20);

    }
    //创建APP Menu
    public static void app_menu(){
        while(flag) {
            System.out.println("-----------------------app menu------------------------");
            System.out.println("1:print total person");
            System.out.println("2:add team member for four members");
            System.out.println("3:print team member");
            System.out.println("4:change team member");
            System.out.println("5:change member detail");
            System.out.println("6:clear team");
            System.out.println("7:");
            System.out.println("8:exit");
            System.out.println("-------------------------------------------------------");
            System.out.print("Your choice: ");
            int choice = get_scanner();
            System.out.print("\n");
            switch (choice) {
                case 1:
                    print_personList(persons);
                    break;
                case 2:
                    if(members.size()<4) {
                        print_personList(persons);
                        add_member();
                        print_memberList(members);
                    }
                    break;
                case 3:
                    if (members.isEmpty()) {
                        System.out.println("there are no team members,please create a team first");
                        System.out.println(" ");
                    } else {
                        print_memberList(members);
                    }
                    break;
                case 4:
                    if (members.isEmpty()) {
                        System.out.println("there are no team members,please create a team first");
                        System.out.println(" ");
                    } else {
                        print_personList(persons);
                        print_memberList(members);
                        change_member();
                        print_memberList(members);
                    }
                    break;
                case 5:
                    if (members.isEmpty()) {
                        System.out.println("there are no team members,please create a team first");
                        System.out.println(" ");
                    } else {
                        print_memberList(members);
                        change_detail();
                        print_memberList(members);
                    }
                    break;
                case 6:
                    if (members.isEmpty()) {
                        System.out.println("there are no team members,please create a team first");
                        System.out.println(" ");
                    } else {
                        clear();
                        System.out.println("cleared!");
                    }
                    break;
                case 8:
                    flag = false;
                    break;
            }
        }
    }
    //清除成员
    public static void clear(){
        System.out.println("1:clear whole team");
        System.out.println("2:remove one member");
        System.out.print("your choice is: ");
        int choice=get_scanner();
        switch (choice) {
            case 1:
                members.clear();
                break;
            case 2:
                int choice_id = get_scanner() - 1;
                members.remove(choice_id);
                break;
        }
    }
    //创建成员输入
    public static int get_scanner(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }

    //打印公司总成员列表
    public static void print_personList(ArrayList<Person> persons){
        System.out.println("-----------------------person list---------------------");
        for(Person p:persons){

                System.out.print("Id: " + p.get_id());
                System.out.print(" | Name: " + p.get_name());
                System.out.print(" | Age: " + p.get_age());
                System.out.println(" | Area: " + p.get_area());

        }
        System.out.println("-------------------------------------------------------");
        System.out.print("\n");
    }
    //添加小组成员
    public static void add_member(){
            for (int i = 1; i < 5; i++) {
                if(members.size()<4) {
                    System.out.print("choose the " + num(i) + " member: ");
                    int choice_id = get_scanner() - 1;
                    Person p = persons.get(choice_id);
                    members.add(new Member(p.get_id(), p.get_name(), p.get_age(), p.get_area()));
                }
        }
    }
    public static String num(int x) {
        return switch (x) {
            case 1 -> "first";
            case 2 -> "second";
            case 3 -> "third";
            case 4 -> "fourth";
            default -> null;
        };
    }
    //打印成员列表
    public static void print_memberList(ArrayList<Member> members){
        System.out.println("----------------------member list----------------------");

        for(Member m:members){
            System.out.print("Id: "+m.get_id());
            System.out.print(" | Name: "+m.get_name());
            System.out.print(" | Age: "+m.get_age());
            System.out.println(" | Area: "+m.get_area());
        }
        System.out.println("-------------------------------------------------------");
        System.out.print("\n");
    }
    //更改小组成员
    public static void change_member() {
            System.out.println("choose the person: ");
            int choice_id1 = get_scanner() - 1;
            Person p = persons.get(choice_id1);
            System.out.println("choose the member you want to change: ");
            int choice_id2 = get_scanner() - 1;
            members.set(choice_id2, new Member(choice_id2 + 1, p.get_name(), p.get_age(), p.get_area()));
    }
    //更改成员detail
    public static void change_detail(){
        System.out.println("your choice is: ");
        System.out.println("1:change name");
        System.out.println("2:change age");
        System.out.println("3:change area");
        int choice = get_scanner();
        switch (choice) {
            case 1:
                change_name();
                break;
            case 2:
                change_age();
                break;
            case 3:
                change_area();
                break;
        }
    }
    public static void change_area(){
        System.out.println("choose the member you want to change his area: ");
        int choice_id1 = get_scanner() - 1;
        Member p = members.get(choice_id1);
        System.out.println("write the area");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        p.set_Area(s);

    }
    public static void change_name(){
        System.out.println("choose the member you want to change his name: ");
        int choice_id1 = get_scanner() - 1;
        Member p = members.get(choice_id1);
        System.out.println("write the name");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        p.set_name(s);
    }
    public static void change_age(){
        System.out.println("choose the member you want to change his age: ");
        int choice_id1 = get_scanner() - 1;
        Member p = members.get(choice_id1);
        System.out.println("write the age");
        Scanner scanner=new Scanner(System.in);
        int s=scanner.nextInt();
        p.set_age(s);
    }

}