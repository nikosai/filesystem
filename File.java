package filesystem;
public class File extends AbstFile{
    private String content = null;

    public File(String name){
        super(name);
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}

