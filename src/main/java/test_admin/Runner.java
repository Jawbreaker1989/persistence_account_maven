package test_admin;

import persistence.FileAccount;
import java.io.IOException;
import java.util.List;

import logic.Account;

public class Runner {
    public static void main(String[] args) throws IOException {

        FileAccount fileAccount = new FileAccount();
        fileAccount.setPathFile("src\\main\\java\\resource\\"); 
        fileAccount.setNameFile("accounts.csv");
        fileAccount.setSeparator(',');
        fileAccount.openFileWithPath();

        List<Account> list = List.of(
                new Account(235,"Carlos","fcarlos@gmail.com",(double)434234.45,false),
                new Account(435,"Cesar","cesarc@gmail.com",(double) 4566753.34,false)
        );

        fileAccount.saveAccounts(list);

        System.out.println("********END SUCCESS********");
    }
}