package by.it.voinilo.jd01.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    List<String> peoples = new ArrayList<>();
    List<String> peoples2 = new LinkedList<>();
    static int buff = 0;
    static int buff2 = 0;

    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        if (peoples.size() == 1) {buff=0; return peoples.get(0);}
        if (buff == 0) {
            while (iterator.hasNext()) {
                iterator.next();
                buff = 1;
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    buff = 0;
                }
            }
            if (peoples.size() != 1) {
                process(peoples);
            }
            if (peoples.size() == 1) {buff=0; return peoples.get(0);}

        } else if (buff == 1) {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                buff = 0;
                if (iterator.hasNext()) {
                    iterator.next();
                    buff = 1;
                }
            }
            if (peoples.size() != 1) {
                process(peoples);
            }
            if (peoples.size() == 1) {buff=0; return peoples.get(0);}
        }
        buff=0;
        return peoples.get(0);

    }


    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        if (peoples.size() == 1) {buff2=0;return peoples.get(0);}
        if (buff2== 0) {
            while (iterator.hasNext()) {
                iterator.next();
                buff2 = 1;
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    buff2 = 0;
                }
            }
            if (peoples.size() != 1) {
                process(peoples);
            }
            if (peoples.size() == 1) {buff2=0;return peoples.get(0);}


        } else if (buff2 == 1) {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                buff2 = 0;
                if (iterator.hasNext()) {
                    iterator.next();
                    buff2 = 1;
                }
            }
            if (peoples.size() != 1) {
                process(peoples);
            }

        }
        buff2=0;
        return peoples.get(0);
    }


    public static void main(String[] args) {
        TaskB2 tasker = new TaskB2();
        tasker.peoples.add("Oleg");//
        tasker.peoples.add("Anna");//
        tasker.peoples.add("Sasha");//
        tasker.peoples.add("Yra");//


        System.out.println(process((ArrayList<String>) tasker.peoples));

        tasker.peoples2.add("Oleg");//
        tasker.peoples2.add("Anna");//
        tasker.peoples2.add("Sasha");//
        tasker.peoples2.add("Yra");//

        System.out.println(process((LinkedList<String>) tasker.peoples2));
    }

}
