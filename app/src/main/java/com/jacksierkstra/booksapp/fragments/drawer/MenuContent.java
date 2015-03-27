package com.jacksierkstra.booksapp.fragments.drawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class MenuContent {

    public static final int VIEW_BOOKS = 1;
    public static final int ADD_BOOK = 2;
    /**
     * An array of sample (dummy) items.
     */
    public static List<MenuItem> ITEMS = new ArrayList<MenuItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<Integer, MenuItem> ITEM_MAP = new HashMap<Integer, MenuItem>();

    static {
        // Add 3 sample items.
        addItem(new MenuItem(VIEW_BOOKS, "View books"));
        addItem(new MenuItem(ADD_BOOK, "Add new book"));
    }

    private static void addItem(MenuItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class MenuItem {
        public int id;
        public String content;

        public MenuItem(int id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
