package ua.nure.garmash.Practice8;

import ua.nure.garmash.Practice8.entity.Group;
import ua.nure.garmash.Practice8.entity.User;

import java.util.List;

public class Demo {

    private static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element + " ");
        }
    }

    public static void main(String[] args) {
        // users  ==> [ivanov]; groups ==> [teamA]

        DBManager dbManager = DBManager.getInstance();

        System.out.println("===========================");

        // Part 1

//        dbManager.insertUser(User.createUser("petrov"));
        // Warning! User.createUser just create new user instance with given login

//        dbManager.insertUser(User.createUser("obama"));
        printList(dbManager.findAllUsers());
//         users  ==> [ivanov, petrov, obama]

        System.out.println("Part 2 =========================");
//        dbManager.insertGroup(Group.createGroup("teamB"));
//        dbManager.insertGroup(Group.createGroup("teamC"));
//        printList(dbManager.findAllGroups());
        User userPetrov = dbManager.getUser("petrov");
        User userIvanov = dbManager.getUser("ivanov");
        User userObama = dbManager.getUser("obama");
        Group teamA = dbManager.getGroup("teamA");
        Group teamB = dbManager.getGroup("teamB");
        Group teamC = dbManager.getGroup("teamC");
        System.out.println();
//        dbManager.setGroupsForUsers(userIvanov, teamA);
//        dbManager.setGroupsForUsers(userPetrov, teamA, teamB);
//        dbManager.setGroupsForUsers(userObama, teamA, teamB, teamC);

        for (User user : dbManager.findAllUsers()) {
            printList(dbManager.getUserGroups(user));
            System.out.println("~~~~~");
        }

        dbManager.deleteGroup(teamA);
        teamC.setName("teamX");
        dbManager.updateGroup(teamC);
    }
}
