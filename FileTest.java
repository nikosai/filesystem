package filesystem;
public class FileTest{
    public static void main(String[] args){
        Directory root = new Directory("root");
        Directory home = root.mkdir("home");
        System.out.println(home.getName());
        System.out.println(home.pwd());
    }
}