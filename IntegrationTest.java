public class IntegrationTest {
    public static void main(String[] args) {
        DB.deleteTable("user");
        Integration ig = new Integration();
        ig.process();
    }
}
