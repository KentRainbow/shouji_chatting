package test;

public class Contacts {
    private String display_name;
    private String gender;
    private String mobile;
    private String email;
    private String addr;
    private String adding;

    public String getDissplay(){
        return display_name;
    }
    public void setDisplay_name(String name){
        this.display_name=name;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile=mobile;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getAddr(){
        return addr;
    }
    public void setAddr(String addr){
        this.addr=addr;
    }
    public void setAdding(String adding){
        this.adding=adding;
    }
    public String getAdding(){
        return this.adding;
    }
}
