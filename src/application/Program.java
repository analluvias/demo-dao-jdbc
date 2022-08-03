package application;

import model.entities.Department;

public class Program {
    public static void main(String[] args) {
        var obj = new Department(1, "Books");
        System.out.print(obj);
    }
}
