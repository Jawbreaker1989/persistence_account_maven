package persistence;

import errors.MyException;
import logic.Account;
import logic.ServiceAccount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class FileAccount extends FileUtils {
    public ServiceAccount reader() {
        return null;
    }

    public void writer(ServiceAccount serviceAccount) {
    }

    public void pushJson(List<Account> dishes) {
    }

    public List<Account> pullJson() {
        return null;
    }

    public void pushXML(List<Account> dishes) {
    }

    public List<Account> pullXML() {
        return null;
    }



    public void saveAccounts(List<Account> accounts) throws IOException {
        StringBuilder sb = new StringBuilder();
        char sp = separator;
        for (Account account : accounts) {
            String id = String.valueOf(account.getId());
            String username = account.getUsername();
            String email = account.getEmail();
            String balance = String.valueOf(account.getBalance());
            String isActive = account.isActive() ? "1" : "0";
            sb.append(id + sp + username + sp + email + sp + balance + sp + isActive + "\n");
        }
        openFileWithPath(); // Ensure the path is set correctly
        writeFile(sb.toString());
    }
    public List<Account> readAccounts() throws IOException, MyException {

        List<Account> accounts = new ArrayList<>();
        String contentFile = readFile();
        StringTokenizer st = new StringTokenizer(contentFile, "\n");


        while (st.hasMoreTokens()) {
            String line = st.nextToken();
            StringTokenizer fields = new StringTokenizer(line,String.valueOf(separator));

            while (fields.hasMoreTokens()) {
                try {
                    int id = Integer.parseInt(fields.nextToken());
                    String username = fields.nextToken();
                    String email = fields.nextToken();

                    double balance = Double.parseDouble(fields.nextToken());
                    boolean isActive = fields.nextToken().equals("0")? false : true;

                    accounts.add (new Account(id, username, email, balance, isActive));

                } catch (NumberFormatException e) {
                    throw new MyException("Formato Numerico no valido");
                } catch (NoSuchElementException e) {
                    throw new MyException("Error en la secuencia de Tokens");
                }
            }
        }

        return accounts;
    }

    public List<Account> readAccount() {
        return null;
    }
}