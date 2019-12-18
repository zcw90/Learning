package zcw.com.dp.chain;

/**
 * Created by 朱城委 on 2019/8/23.<br><br>
 */
public class Test {
    public static void main(String[] args) {
        GroupHandler groupHandler = new GroupHandler();
        ProjectManagerHandler projectManagerHandler = new ProjectManagerHandler();
        DepartmentManagerHandler departmentManagerHandler = new DepartmentManagerHandler();
        ManagerHandler managerHandler = new ManagerHandler();

        groupHandler.setSuccessor(projectManagerHandler);
        projectManagerHandler.setSuccessor(departmentManagerHandler);
        departmentManagerHandler.setSuccessor(managerHandler);

        groupHandler.handle(-2);
        System.out.println("====================\n");

        groupHandler.handle(678);
        System.out.println("====================\n");

        groupHandler.handle(4578);
        System.out.println("====================\n");

        groupHandler.handle(7968);
        System.out.println("====================\n");

        groupHandler.handle(16759);
        System.out.println("====================\n");

        groupHandler.handle(34654);
        System.out.println("====================\n");
    }
}
