package filesystem;

public abstract class AbstFile{
    
    private String name = null;
    
    public AbstFile(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof AbstFile)){
            return false;
        }
        AbstFile o = (AbstFile) obj;
        return o.getName().equals(this.getName());
    }
}

class AbstFileComparator implements java.util.Comparator<AbstFile> {
	public int compare(AbstFile s, AbstFile t) {
		//               + (x > y)
		// compare x y = 0 (x = y)
		//               - (x < y)
        if (s instanceof Directory){
            if (t instanceof Directory){
                return ((Directory) s).getName().compareTo(((Directory) t).getName());
            } else {
                return -1;
            }
        } else {
            if (t instanceof Directory){
                return 1;
            } else {
                return ((File) s).getName().compareTo(((File) t).getName());
            }
        }
	}
}