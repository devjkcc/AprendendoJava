

public class Arrays {
    
    public class User{
    
        private String firstname;
        private String lastname;

    
     public void setfirstname(String firstname){
      this.firstname = firstname.toUpperCase();

    }
    
    public String getfirstname(){
        return firstname;
    }
    }
    
    public static void main(String[] args) {
        User[] users = new User[10];

    for(int i = 0; i < users.length; i ++){
        User atual = new Arrays(). new User();
        atual.setfirstname("Nome" + i);
        users[i] = atual;
    }

    for (User user : users) {
        System.out.println(user.getfirstname());
    }

    }

}
