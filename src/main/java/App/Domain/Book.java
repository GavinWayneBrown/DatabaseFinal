package App.Domain;

public class Book {
    private String isbn;
    private String date_published;
    private String description;
    private int availability;
    private String title;
    private String author_first;
    private String author_last;
    private int author_age;

    public void setisbn(String isbn ){
        this.isbn = isbn;
    }
    public void setdate_published(String date_published){
        this.date_published = date_published;
    }
    public void setdescription(String description){
        this.description = description;;
    }
    public void setavailability(int availability){
        this.availability = availability;
    }
    public void settitle(String title){
        this.title = title;
    }
    public void setauthor_first(String author_first){
        this.author_first = author_first;
    }
    public void setauthor_last(String author_last){
        this.author_last = author_last;
    }
    public void setauthor_age(int author_age){
        this.author_age = author_age;
    }
    
    public  String getisbn(){return this.isbn;}
    public String getdate_published(){return this.date_published;}
    public  String getdescription(){return this.description;}
    public  int getavailability(){return this.availability;}
    public  String gettitle(){return this.title;}
    public  String getauthor_first(){return this.author_first;}
    public  String getauthor_last(){return this.author_last;}
    public  int getauthor_age(){return this.author_age;}
}
