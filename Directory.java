package filesystem;
import java.util.*;

public class Directory extends AbstFile{
    private List<AbstFile> list = null;
    private Directory parent = null;

    public Directory(String name){
        super(name);
        list = new ArrayList<AbstFile>();
    }

    public Directory(String name, Directory parent){
        super(name);
        list = new ArrayList<AbstFile>();
        this.parent = parent;
    }

    public Directory mkdir(String name){
        Directory newdir = new Directory(name, this);
        list.add(newdir);
        sort();
        return newdir;
    }

    public void rmdir(String name){
        list.remove(new Directory(name));
        sort();
    }
    
    public File addFile(String name){
        File newfile = new File(name);
        list.add(newfile);
        sort();
        return newfile;
    }

    public File getFile(String name){
        int i = list.indexOf(new File(name));
        if (i < 0) return null;
        else return (File) list.get(i);
    }

    public Directory getDir(String name){
        int i = list.indexOf(new Directory(name));
        if (i < 0) return null;
        else return (Directory) list.get(i);
    }

    public String pwd(){
        Directory root = this;
        String str = this.getName();
        while (root.hasParent()){
            root = root.getParent();
            str = root.getName()+ "/" + str;
        }
        return str;
    }

    public String ls(){
        String str = "";
        for (AbstFile af: list){
            if (af instanceof Directory){
                str += "{" + af.getName() + "}";
            } else {
                str += af.getName();
            }
            str += "\t";
        }
        return str;
    }

    public Directory getParent(){
        return parent;
    }

    public boolean hasParent(){
        return (parent != null);
    }

    private void sort(){
        Collections.sort(list, new AbstFileComparator());
    }
}