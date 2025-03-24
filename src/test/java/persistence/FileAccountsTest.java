package persistence;

import org.junit.jupiter.api.Test;

import errors.MyException;
import logic.Account;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileAccountsTest {

    private FileAccount fa;


    void setup() {
        fa= new FileAccount();
        String basePath = "src/main/java/resource/";
        String fileName = "accounts.csv";
        fa.setPathFile(basePath);
        fa.setNameFile(fileName);
        fa.openFile();
        fa.openFileWithPath();
    }

    @Test
    void readAccounts() throws IOException  {
        setup();
        try {
            List<Account> accounts = fa.readAccounts();
            assertEquals(5,accounts.size());


            assertFalse(accounts.get(1).isActive());
            assertFalse(accounts.get(2).isActive());
            assertTrue(accounts.get(3).isActive());
            assertTrue(accounts.get(4).isActive());







        } catch (MyException e) {
            System.out.println("Se lanza " + e.getMessage());
        }
    }   }