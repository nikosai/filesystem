package filesystem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FileSystem{
    public static Directory curdir = null;
    public static Directory home = null;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
        home = new Directory("home");
        curdir = home;
        println("Welcome!");
        
        while (true){
            printPrompt();
            String s = br.readLine();
            String[] cmds = s.split("[\\s]+");
            String cmd = cmds[0].toLowerCase();
            boolean exitFlag = false;

            switch(cmd){
                case "exit":
                    exitFlag = true;
                    break;
                case "mkdir":
                    if (cmds.length < 2){
                        println("Usage: mkdir foldername");
                    } else {
                        curdir.mkdir(cmds[1]);
                    }
                    break;
                case "pwd":
                    println(curdir.pwd());
                    break;
                case "cd":
                    if (cmds.length < 2){
                        curdir = home;
                    } else {
                        Directory dist = curdir.getDir(cmds[1]);
                        if (dist == null){
                            println(cmds[1] + ": そのようなディレクトリは存在しません。");
                        } else {
                            curdir = dist;
                        }
                    }
                    break;
                case "ls":
                    println(curdir.ls());
                case "":
                    break;
                default:
                    println(cmd + ": このコマンドは実装されていません。");
                    break;
            }
            
            if (exitFlag) break;
        }
    }

    private static void println(String str){
        System.out.println(str);
        System.out.flush();
    }

    private static void print(String str){
        System.out.print(str);
        System.out.flush();
    }

    private static void printPrompt(){
        print("[user@PC]:" + curdir.getName() + "$ ");
    }
}