


class UserAccount{
    private String username;
    private static int totalUsers = 0;

    UserAccount(String username){
        this.username = username;
        totalUsers++;
    }

    public String getUsername() {
        return username;
    }
    public static int getTotalUsers(){
        return totalUsers;
    }
}



public class StaticExample {
    public static void main(String[] args){

        System.out.println("Initial user count: " + UserAccount.getTotalUsers());

        UserAccount user1 = new UserAccount("AJAY");
        UserAccount user2 = new UserAccount("MAYUR");
        UserAccount user3 = new UserAccount("RAJ");

        System.out.println("UserName: " + user1.getUsername());
        System.out.println("UserName: " + user2.getUsername());
        System.out.println("UserName: " + user3.getUsername());

        System.out.println("Initial user count: " + UserAccount.getTotalUsers());


    }
}
