import method.AdminFunction;
import models.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Admin> admins = new ArrayList<>();
        //admins.add(new Admin("zhyar","1","a@b.c","1234","11123"));
        //admins.add(new Admin("darya","2","a@b.c","1234","11123"));
        //admins.add(new Admin("zaynab","3","a@b.c","1234","11123"));
        //admins.add(new Admin("ajer","4","a@b.c","1234","11123"));
        //admins.add(new Admin("lana","5","a@b.c","1234","11123"));
        //admins.add(new Admin("shadya","6","a@b.c","1234","11123"));
        //admins.add(new Admin("ahuz","7","a@b.c","1234","11123"));

        AdminFunction adminFunction = new AdminFunction();
        //adminFunction.saveListToFile(admins);
        admins = adminFunction.openAdminList();
        for (Admin admin: admins) {
            System.out.println(admin.getFullname());
        }

    }
}
