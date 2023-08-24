package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TodoApp {

    private final Menu menu = new SimpleMenu();

    public static final ActionDelegate DEFAULT_ACTION = () -> System.out.println("Some action");

    private final String appMenu = "Выберите нужное действие:\n"
            + "1. Добавить элемент в корень меню\n"
            + "2. Добавить элемент к родительскому элементу\n"
            + "3. Вызвать действие, привязанное к пункту меню (действие можно сделать константой\n"
            + "4. Вывести меню в консоль\n"
            + "5. Выход из программы";

    public void runAppMenu() {
        boolean run = true;
        while (run) {
            System.out.println(appMenu);
            int num = scan();
            if (!check(num)) {
                continue;
            }
            switch (num) {
                case 1:
                    addRootMenuItem();
                    break;
                case 2:
                    addMenuItem();
                    break;
                case 3:
                    getAction();
                    break;
                case 4:
                    printSimpleMenu();
                    break;
                case 5:
                    run = false;
                default:
                    break;
            }
        }
    }

    private void addRootMenuItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для добавления пункта в меню введите:\n"
                + "Новый корневой пункт меню:");
        String current = scanner.next();
        menu.add(Menu.ROOT, current, DEFAULT_ACTION);
    }

    private void addMenuItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для добавления пункта в меню введите каждый раз с новой строки:\n"
                + "Имя предка, новый пункт меню:\n");
        String parent = scanner.next();
        String current = scanner.next();
        menu.add(parent, current, DEFAULT_ACTION);
    }

    private void getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название пункта меню для которого Вы хотите вызвать действие:\n ");
        String name = scanner.next();
        menu.select(name).get().getActionDelegate().delegate();
    }

    private void printSimpleMenu() {
        new MenuSimplePrint().print(menu);
    }

    public int scan() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }

    public boolean check(int num) {
        boolean res = num > 0 && num < 6;
        if (!res) {
            System.out.println("Неверный ввод.\n");
        }
        return  res;
    }

    public static void main(String[] args) {
        TodoApp todo = new TodoApp();
        todo.runAppMenu();
    }
}
