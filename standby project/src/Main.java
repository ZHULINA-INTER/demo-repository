import java.util.ArrayList;
import java.util.Arrays;
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
        Person[] ps= {
                new Person(20240801, "max   ", 18, "java"),
                new Person(20240802, "john  ", 32, "C++ "),
                new Person(20240803, "helen ", 26, "java"),
                new Person(20240804, "nathan", 19, "java"),
                new Person(20240805, "mike  ", 20, "vue "),
                new Person(20240806, "james ", 38, "C++ "),
                new Person(20240807, "alex  ", 22, "java"),
                new Person(20240808, "rachel", 18, "C   "),
                new Person(20240809, "ryan  ", 19, "js  "),
                new Person(20240810, "wilson", 29, "js  "),
                new Person(20240811, "aef   ", 38, "java"),
                new Person(20240812, "john  ", 22, "C++ "),
                new Person(20240813, "alex  ", 26, "C   "),
                new Person(20240814, "mike  ", 39, "java"),
                new Person(20240815, "ron   ", 20, "vue "),
                new Person(20240816, "bel   ", 18, "C++ "),
                new Person(20240817, "dolph ", 22, "java"),
                new Person(20240818, "lbn   ", 28, "C   "),
                new Person(20240819, "mos   ", 25, "vue "),
                new Person(20240820, "john  ", 36, "js  ")
        };
        persons.addAll(Arrays.asList(ps));

    }
    //创建APP Menu
    public static void app_menu(){
        while(flag) {
            System.out.println("-----------------------app menu------------------------");
            System.out.println("1:print total person");
            System.out.println("2:add team member for four members");
            System.out.println("3:print team member");
            System.out.println("4:replace team member");
            System.out.println("5:change member detail");
            System.out.println("6:remove members");
            System.out.println("7:---to be continued---");
            System.out.println("8:exit");
            System.out.println("-------------------------------------------------------");
            System.out.print(">>>input your choice: ");
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
                        System.out.println("!!there are no team members,please create a team first!!");
                        System.out.println(" ");
                    } else {
                        print_memberList(members);
                    }
                    break;
                case 4:
                    if (members.isEmpty()) {
                        System.out.println("!!there are no team members,please create a team first!!");
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
                        System.out.println("!!there are no team members,please create a team first!!");
                        System.out.println(" ");
                    } else {
                        print_memberList(members);
                        change_detail();
                        print_memberList(members);
                    }
                    break;
                case 6:
                    if (members.isEmpty()) {
                        System.out.println("!!there are no team members,please create a team first!!");
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
        System.out.println("=======================");
        System.out.println("1:remove the whole team");
        System.out.println("2:remove one member");
        System.out.println("=======================");

        System.out.print(">>>input your choice: ");
        int choice=get_scanner();
        switch (choice) {
            case 1:
                members.clear();
                break;
            case 2:
                System.out.print(">>>select the member you want to remove:");
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
                    System.out.print(">>>choose the " + num(i) + " member: ");
                    int choice_id = get_scanner() - 1;
                    Person p = persons.get(choice_id);
                    members.add(new Member(p.get_id(), p.get_name(), p.get_age(), p.get_area()));
                }
        }
        System.out.println(" ");
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
            System.out.print(">>>select the member you want to replace: ");
            int choice_id1 = get_scanner() - 1;
            System.out.print(">>>replace with: ");
            int choice_id2 = get_scanner() - 1;
            Person p = persons.get(choice_id2);
            members.set(choice_id1, new Member(p.get_id(), p.get_name(), p.get_age(), p.get_area()));
    }
    //更改成员detail
    public static void change_detail(){
        System.out.println("=======================");
        System.out.println("1:change the name");
        System.out.println("2:change the age");
        System.out.println("3:change the area");
        System.out.println("=======================");

        System.out.print(">>>input your choice: ");
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
        System.out.print(">>>select the member whose information you want to change: ");
        int choice_id1 = get_scanner() - 1;
        Member p = members.get(choice_id1);
        System.out.print(">>>write the area:");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        p.set_Area(s);

    }
    public static void change_name(){
        System.out.print(">>>choose the member you want to change his name: ");
        int choice_id1 = get_scanner() - 1;
        Member p = members.get(choice_id1);
        System.out.print(">>>write the name:");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        p.set_name(s);
    }
    public static void change_age(){
        System.out.print(">>>choose the member you want to change his age: ");
        int choice_id1 = get_scanner() - 1;
        Member p = members.get(choice_id1);
        System.out.print(">>>write the age:");
        Scanner scanner=new Scanner(System.in);
        int s=scanner.nextInt();
        p.set_age(s);
    }

}