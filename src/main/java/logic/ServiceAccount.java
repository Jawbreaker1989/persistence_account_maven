package logic;

import java.util.List;

public class ServiceAccount {
    public static final byte TO_CSV = 0;
    public static final byte TO_JSON = 1;
    public static final byte TO_XML = 2;

    public Account findById(Integer id) {
        return null;
    }

    public List<Account> findByUsername(String username) {
        return null;
    }

    public boolean addAccount(Account account) {
        return false;
    }

    public Account deleteAccount(Integer id) {
        return null;
    }

    public Account updateAccount(Integer id, Account account) {
        return null;
    }

    public int load(String file, byte format) {
        return 0;
    }

    public List<Account> toString(String file, byte format) {
        return null;
    }
}