package com.javarush.task.task21.task2107;

import java.util.*;


/* 
Глубокое клонирование карты
Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            //if (solution.equals(clone)) System.out.println("True"); else System.out.println("False");
            //if (solution==clone.users) System.out.println("True"); else System.out.println("False");
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);


        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }

    }

    protected Map<String, User> users = new LinkedHashMap();

    public Solution clone() throws CloneNotSupportedException {
        Solution s = new Solution();
        Map<String, User> usr = new LinkedHashMap();
        for (Map.Entry<String,User> entry: this.users.entrySet()) {
            String key =  entry.getKey();
            User value =  entry.getValue();
            usr.put(key,value.clone());
        }
        s.users.putAll(usr);

        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof Solution)) return false;
        Solution sol = (Solution) o;
        return users != null ? users.equals(sol.users) : sol.users == null;
    }
    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }

    public static class User implements Cloneable  {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public User clone() throws CloneNotSupportedException {
            return new User(this.age, this.name);
        }

        @Override
        public int hashCode() {
            int result = 31*age;
            result += (name != null ? name.hashCode() : 0);
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof User)) return false;
            if (obj == this) return true;
            User u = (User) obj;
            if (u.name.equals(name))
                if (u.age==age)
            //if (name != null ? name.equals(u.name) : u.name != null) return false;
            return true;
            return false;
        }
    }
}
