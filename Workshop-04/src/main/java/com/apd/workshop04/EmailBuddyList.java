package com.apd.workshop04;

// ===== EMAIL BUDDY LIST MODEL CLASS =====
public class EmailBuddyList {
    public final int MAXIMUM_SIZE = 100;
    private final EmailBuddy[] buddies;
    private int size;

    public EmailBuddyList() {
        buddies = new EmailBuddy[MAXIMUM_SIZE];
        size = 0;
    }

    // Return the number of buddies in the whole list
    public int getSize() {
        return size;
    }

    // Return all the buddies
    public EmailBuddy[] getEmailBuddies() {
        return buddies;
    }

    // Get a particular buddy from the list, given the index
    public EmailBuddy getBuddy(int i) {
        return buddies[i];
    }

    // Add an email buddy to the list unless it has reached its capacity
    public void add(EmailBuddy buddy) {
        // Make sure that we do not go past the limit
        if (size < MAXIMUM_SIZE) buddies[size++] = buddy;
    }

    // Remove the buddy with the given index from the list
    public void remove(int index) {
        // Make sure that the given index is valid
        if ((index >= 0) && (index < size)) {
            // Move every item after the deleted one up in the list
            for (int i = index; i < size - 1; i++)
                buddies[i] = buddies[i + 1];
            size--; // Reduce the list size by 1
        }
    }

    // Return the number of buddies on the hot list
    public int getHotListSize() {
        int count = 0;
        for (int i = 0; i < size; i++)
            if (buddies[i].onHotList()) count++;
        return count;
    }

    // Get a particular "hot" buddy from the list, given the hot list index
    public EmailBuddy getHotListBuddy(int i) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            if (buddies[j].onHotList()) {
                if (count == i)
                    return buddies[j];
                count++;
            }
        }
        return null;
    }
}
