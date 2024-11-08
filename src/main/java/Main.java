import com.supermap.data.Workspace;

public class Main {
    public static void main(String[] args) {
        System.out.println("验证iObject环境");
        Workspace workspace = new Workspace();
        workspace.dispose();
        System.out.println("gis-supermap!");
    }
}
