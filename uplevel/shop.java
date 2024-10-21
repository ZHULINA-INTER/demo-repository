package uplevel;
import java.util.ArrayList;
import java.util.Scanner;

public class shop {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        method sth = new method();
        list.add("1");                  //刚会这种方法...
        list.add("2");                  //想把原本的数量加多
        list.add("3");
        method chose = new method();
        Scanner sc = new Scanner(System.in);
        System.out.println(list);
        System.out.println("请选择你的方法");
        while (true) {
            int num = sc.nextInt();             //解释说明多一点
            chose.setNum(num);
            switch (chose.getNum()) {
                case 1: {
                    System.out.println("增加");
                    String newThing = sc.next();
                    list.add(newThing);
                    System.out.println(list);
                break;
                }                                   //这些方法太草率了,希望变得更加泛用
                case 2: {
                    System.out.println("删除");
                    String newThing = sc.next();
                    list.remove(newThing);
                    System.out.println(list);
                    break;
                }
                case 3: {
                    System.out.println("更改");
                    int lis = sc.nextInt();
                    String newThing = sc.next();
                    list.set(lis+1, newThing);
                    System.out.println(list);
                break;
                }
                case 4: {
                    System.out.println("查询");
                    int lis = sc.nextInt();
                    list.get(lis);
                    System.out.println(list.get(lis+1));
                    System.out.println(list);
            break;
                }
        }
    }
    }
}