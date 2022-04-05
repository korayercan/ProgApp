
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="a")
@RequestScoped
public class NewClass {
    private int first,second;
    private String first_s;
    private String second_s;
    private String process;
    private String[] nameSelected;
    private String[] names;
    
    public String[] getNameSelected(){
        return nameSelected;
    }
    public void setNameSelected(String[] nameSelected){
        this.nameSelected=nameSelected;
    }
    public String[] getNames(){
        
        names = new String[2];
        names[0] = "koray";
        names[1] = "süleyman";
        return names;
    }
    public String nameSelectedInString(){
        return Arrays.toString(nameSelected);
    }
    
    public String getFirst_s(){
        return first_s;
    }
    public void setFirst_s(String first_s ){
        this.first_s = first_s;
    }
    
    public String getSecond_s(){
        return second_s;
    }
    public void setSecond_s( String second_s ){
        this.second_s = second_s;
    }
    public String getProcess(){
        return process;
    }
    public void setProcess(String process){
        this.process=process;
    }
    public int response(){
        if(first_s != null && second_s != null){
            first = Integer.parseInt(first_s);
            second = Integer.parseInt(second_s);
            if(null != process) switch (process) {
                case "plus":
                    return first + second;
                case "negative":
                    return first - second;
                case "multi":
                    return first * second;
                case "divison":
                    return first / second;
                default:
                    break;
            }
        }
        return 0;
    }
}
