import java.util.*;

public class Jira {

    public Map<Integer, User> users = new HashMap<>();
    Sprint sprint = new Sprint();

    public static void main(String[] args) {
        Jira  j = new Jira();
        j.test();
    }
    public void test() {
        createUser("soumya");
        createUser("rohan");
        createUser("shishir");
        Task task1 = new Task(1);
        Task task2 = new Task(2);
        Task task3 = new Task(3);
        task1.setTaskStatus(false);
        task1.setTaskId(1);
        task2.setTaskStatus(false);
        task2.setTaskId(2);
        task3.setTaskStatus(false);
        task3.setTaskId(3);
        Sprint sprint1 = new Sprint();
        Sprint sprint2 = new Sprint();
        sprint1.addTask(task1);
        sprint1.addTask(task2);
        sprint2.addTask(task3);
//        Task bug = new Task();
        System.out.println(sprint1.getTasks());
        System.out.println(sprint2.getTasks());
        System.out.println(users.get(1).getTasksAssigned());


    }
    public void createUser(String name) {
        Set userIds = users.keySet();
        int maxId = 0;
        if(!userIds.isEmpty())
            maxId = (int) userIds.stream().max(Comparator.naturalOrder()).get();
        User user = new User(name,maxId+1);
        users.put(maxId+1,user);
    }
    class Task {
        int taskId;
        String taskAssignee;

        public boolean isTaskStatus() {
            return taskStatus;
        }

        public void setTaskStatus(boolean taskStatus) {
            this.taskStatus = taskStatus;
        }

        boolean taskStatus;
        String taskType = "default";
        Task(int userId) {
            User user =null;
            if(users.get(userId) != null) {
                user = users.get(userId);
            }
            else {
                System.out.println("No user exist");
            }
            taskAssignee = user.userName;
            user.addTask(this);
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public String getTaskAssignee() {
            return taskAssignee;
        }

        public void setTaskAssignee(String taskAssignee) {
            this.taskAssignee = taskAssignee;
        }
    }
//    class Bug extends Jira.Task {
//        Bug() {
//            super.taskType = "Bug";
//        }
//
//    }
//    class Feature extends Jira.Task {
//        Feature() {
//            super.taskType="Feature";
//        }
//
//    }
//    class Story extends Jira.Task {
//        public Story() {
//            super.taskType = "Story";
//        }
//
//    }
}
class User {
    String userName;
    int userId;
    List<Jira.Task>tasksAssigned;
    User(String userName, int userId) {
        this.userId = userId;
        this.userName = userName;
        tasksAssigned= new ArrayList<>();
    }
    public void addTask(Jira.Task task) {
        tasksAssigned.add(task);
    }
    public List<Jira.Task> getTasksAssigned() {
        return tasksAssigned;
    }
}


class Sprint {
    List<Jira.Task> tasks;
    public Sprint(){
        tasks= new ArrayList<>();
    }
    public List<Jira.Task> getTasks() {
        return tasks;
    }

    public void addTask(Jira.Task task) {
         tasks.add(task);
    }
}