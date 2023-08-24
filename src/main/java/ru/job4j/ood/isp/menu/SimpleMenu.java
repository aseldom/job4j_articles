package ru.job4j.ood.isp.menu;

import java.util.*;

public class SimpleMenu implements Menu {

    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        boolean res = false;
        if (parentName == null) {
            rootElements.add(new SimpleMenuItem(childName, actionDelegate));
            res = true;
        } else {
            Optional<ItemInfo> itemInfo = findItem(parentName);
            if (itemInfo.isPresent() && !childName.equals(itemInfo.get().menuItem.getName())) {
                itemInfo.get().menuItem.getChildren().add(new SimpleMenuItem(childName, actionDelegate));
                res = true;
            }
        }
        return res;
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        MenuItemInfo menuItemInfo = null;
        if (findItem(itemName).isPresent()) {
            ItemInfo itemInfo = findItem(itemName).get();
            menuItemInfo = new MenuItemInfo(itemInfo.menuItem, itemInfo.number);
        }
        return Optional.of(menuItemInfo);
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        DFSIterator dfsIterator = new DFSIterator();
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return dfsIterator.hasNext();
            }

            @Override
            public MenuItemInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ItemInfo itemInfo = dfsIterator.next();
                return new MenuItemInfo(itemInfo.menuItem, itemInfo.number);
            }
        };
    }

    private Optional<ItemInfo> findItem(String name) {
        DFSIterator dfsIterator = new DFSIterator();
        Optional<ItemInfo> res = null;
        while (!dfsIterator.stack.isEmpty()) {
            var temp = dfsIterator.next();
            if (name.equals(temp.menuItem.getName())) {
                res = Optional.of(temp);
                break;
            }
        }
        return res;
    }

    private static class SimpleMenuItem implements MenuItem {

        private final String name;
        private final List<MenuItem> children = new ArrayList<>();
        private final ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious();) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
            }
            return new ItemInfo(current, lastNumber);
        }

    }

    private class ItemInfo {

        MenuItem menuItem;
        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }

}