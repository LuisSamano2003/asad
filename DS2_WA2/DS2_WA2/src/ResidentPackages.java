import java.util.ArrayList;

/*
 * WARNING: This is given to you, DO NOT CHANGE or you might get a 0!!!!
 */

public class ResidentPackages {
    public final String resident_key;
    private ArrayList<MailPackage> packages;

    public ResidentPackages(String resident_key){
        this.resident_key = resident_key;
        this.packages = new ArrayList<>();
    }

    public boolean AddPackage(MailPackage mail_package){
        if (mail_package.getResidentKey().equals(this.resident_key)){
            // accept the package....
            this.packages.add(mail_package);
            return true;
        } else {
            // reject the package
            System.out.println("Warning: Package for " + mail_package.getResidentKey() + " rejected at " + this.resident_key);
            return false;
        }
    }

    public int getPackageCount(){
        return this.packages.size();
    }

}
